package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoBoolean;

public class RecomendacaoTitulo implements RecomendacaoBoolean{

	@Override
	public String getNome() {
		return "N�o h� um t�tulo na p�gina.";
	}

	@Override
	public String getDescricao() {
		return "A p�gina deve possuir um titulo.";
	}

	@Override
	public Boolean executa(Document doc) {
		boolean elemTit = false;
		Elements title = doc.select("title");
		if (title.isEmpty()) {
			elemTit = true;
		}
		return elemTit;
	}

	@Override
	public String getRecomendacao() {
		return "17";
		
	}

}
