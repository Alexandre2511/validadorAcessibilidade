package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoBoolean;

public class RecomendacaoNoscript implements RecomendacaoBoolean {

	@Override
	public String getNome() {
		return "Não existe o elemento noscript.";
	}

	@Override
	public String getDescricao() {
		return "Quando utiliza-se de javascript o usuário necessita ser informado caso seu computador não ofereça suporte a esta tecnologia.";
	}

	@Override
	public Boolean executa(Document doc) {
		boolean elemNoscript = false;
		Elements script = doc.select("script");
		Elements noscript = doc.select("noscript");
		if (script.isEmpty() && noscript.isEmpty()) {
			elemNoscript = true;
		}
		return elemNoscript;
	}

	@Override
	public String getRecomendacao() {
		return "10";
	}

}
