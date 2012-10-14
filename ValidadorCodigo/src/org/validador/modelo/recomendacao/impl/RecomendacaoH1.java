package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoBoolean;

public class RecomendacaoH1 implements RecomendacaoBoolean{

	@Override
	public String getNome() {
		return "H1 não existente na página.";
	}

	@Override
	public String getDescricao() {
		return "Deve ser colocado um elemento do h1.";
	}

	@Override
	public Boolean executa(Document doc) {
		boolean elemH1 = false;
		Elements h1 = doc.select("h1");
		if (h1.isEmpty()){
			elemH1 = true;
		}
		return elemH1;
	}

	@Override
	public String getRecomendacao() {
		return "03";
	}

}
