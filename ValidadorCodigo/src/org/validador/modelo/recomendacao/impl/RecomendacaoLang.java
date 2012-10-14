package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoBoolean;

public class RecomendacaoLang implements RecomendacaoBoolean{

	@Override
	public String getNome() {
		return "Não há elementos que informem a linguagem da página.";
	}

	@Override
	public String getDescricao() {
		return "A linguagem da página deve ser informada.";
	}

	@Override
	public Boolean executa(Document doc) {
		boolean lingua = false;
		Element linguagem = doc.select("html").first();
		String xmlLang = linguagem.attr("xml:lang");
		String lang = linguagem.attr("lang");
		Elements meta = doc
				.select("meta[http-equiv=Content-Language]");

		if (xmlLang.isEmpty() && lang.isEmpty() && meta.isEmpty()) {
			lingua = true;
		}
		return lingua;
	}

	@Override
	public String getRecomendacao() {
		return "16";
	}

}
