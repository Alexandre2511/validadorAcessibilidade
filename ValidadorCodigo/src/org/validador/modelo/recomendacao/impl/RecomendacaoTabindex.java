package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoCodigo;

public class RecomendacaoTabindex implements RecomendacaoCodigo {

	@Override
	public String getNome() {
		return "Sequ�ncia de tabula��o incorreta valor maior antes do menor";
	}

	@Override
	public String getDescricao() {
		return "Os indices dos atributos tabindex devem seguir uma ordem sem�ntica do menor para o maior.";
	}

	@Override
	public String executa(Document doc) {
		String elemTab = "";
		String elemTemp = "";
		Elements tabindex = doc.select("a[tabindex]");
		int valorInicial = 0;
		if (!tabindex.isEmpty()) {
			for (Element element : tabindex) {
				String valor = element.attr("tabindex");
				int valorInteiro = Integer.parseInt(valor);
				if (valorInicial < valorInteiro) {
					valorInicial = valorInteiro;
					elemTemp += "\n" + element;
				} else {
					elemTemp += "\n" + element;
					elemTab = "\n" + elemTemp;
				}

			}
		}

		return elemTab;
	}

	@Override
	public String getRecomendacao() {
		return "04";
	}

}
