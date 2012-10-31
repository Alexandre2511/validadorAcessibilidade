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
		return "Ao utilizar javascript em uma página, é necessário informar ao usuário caso seu computador não ofereça suporte a esta tecnologia.";
	}

	@Override
	public Boolean executa(Document doc) {
		boolean elementoNoscript = false;
		Elements script = doc.select("script");
		Elements noscript = doc.select("noscript");
		if (script.isEmpty() && noscript.isEmpty()) {
			elementoNoscript = true;
		}
		return elementoNoscript;
	}

	@Override
	public String getRecomendacao() {
		return "10";
	}
	
	@Override
	public String getExemplo() {
		return "<noscript>...</noscript>";
	}
}
