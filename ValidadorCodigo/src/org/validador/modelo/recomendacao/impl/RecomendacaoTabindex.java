package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoCodigo;

public class RecomendacaoTabindex implements RecomendacaoCodigo {

	@Override
	public String getNome() {
		return "Sequência de tabulação incorreta valor maior antes do menor";
	}

	@Override
	public String getDescricao() {
		return "Os indices dos atributos tabindex devem seguir uma ordem semântica do menor para o maior.";
	}

	@Override
	public String executa(Document doc) {
		String elementoTabindex = "";
		String elementoTemporario = "";
		Elements tabindex = doc.select("a[tabindex]");
		int valorInicial = 0;
		for (Element element : tabindex) {
			String valor = element.attr("tabindex");
			int valorInteiro = Integer.parseInt(valor);
			if (valorInicial < valorInteiro) {
				valorInicial = valorInteiro;
				elementoTemporario += "\n" + element;
			} else {
				elementoTemporario += "\n" + element;
				elementoTabindex = "\n" + elementoTemporario;
			}
		}
		return elementoTabindex;
	}

	@Override
	public String getRecomendacao() {
		return "04";
	}
	
	@Override
	public String getExemplo() {
		return "<ul><li><a href=\"#\" tabindex=\"1\"></a></li>...<li><a href=\"#\" tabindex=\4\"></a></li></ul>";
	}
}
