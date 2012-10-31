package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoCodigo;

public class RecomendacaoMultiH1 implements RecomendacaoCodigo{

	@Override
	public String getNome() {
		return "Múltiplos elementos H1.";
	}

	@Override
	public String getDescricao() {
		return "Uma página não pode conter mais de um elemento do tipo H1, para não prejudicar a " +
				"navegação por cabeçãlhos que alguns leitores de tela possibilitam aos usuarios";
	}

	@Override
	public String executa(Document doc) {
		String elementoH1 = "";
		Elements h1 = doc.select("h1");
		if (h1.size() > 1){
			for (Element eh1 : h1) {
				elementoH1 += "\n" + eh1;
			}
		}
		return elementoH1;
	}

	@Override
	public String getRecomendacao() {
		return "03";
	}
	
	@Override
	public String getExemplo() {
		return "<h1>Titulo</h1>";
	}
}
