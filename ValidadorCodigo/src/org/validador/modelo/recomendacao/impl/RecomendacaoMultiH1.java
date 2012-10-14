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
		return "Uma página não pode conter mais de um elemento do tipo H1.";
	}

	@Override
	public String executa(Document doc) {
		String elemH1 = "";
		Elements h1 = doc.select("h1");
		if (h1.size() > 1){
			for (Element eh1 : h1) {
				elemH1 += "\n" + eh1;
			}
		}
		return elemH1;
	}

	@Override
	public String getRecomendacao() {
		return "03";
	}

}
