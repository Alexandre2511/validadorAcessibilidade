package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoBoolean;

public class RecomendacaoRefresh implements RecomendacaoBoolean{

	@Override
	public String getNome() {
		return "Atualiza��o autom�tica da p�gina.";
	}

	@Override
	public String getDescricao() {
		return "A p�gina n�o pode atualizar sem que seja solicitado pelo usu�rio.";
	}

	@Override
	public Boolean executa(Document doc) {
		boolean ref = false;
		Elements refresh = doc.select("meta[http-equiv=refresh]");
		if (!refresh.isEmpty()) {
			ref = true;
		}
		return ref;
	}

	@Override
	public String getRecomendacao() {
		return "11";
	}

}
