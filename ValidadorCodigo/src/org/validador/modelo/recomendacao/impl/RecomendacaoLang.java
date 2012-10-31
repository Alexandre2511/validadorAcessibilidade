package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoBoolean;

public class RecomendacaoLang implements RecomendacaoBoolean{

	@Override
	public String getNome() {
		return "Não há elementos que informem o idioma da página.";
	}

	@Override
	public String getDescricao() {
		return "O idioma principal da página deve ser informado.";
	}

	@Override
	public Boolean executa(Document doc) {
		boolean idioma = false;
		Element idiomaPagina = doc.select("html").first();
		String xmlLang = idiomaPagina.attr("xml:lang");
		String lang = idiomaPagina.attr("lang");
		Elements meta = doc
				.select("meta[http-equiv=Content-Language]");

		if (xmlLang.isEmpty() && lang.isEmpty() && meta.isEmpty()) {
			idioma = true;
		}
		return idioma;
	}

	@Override
	public String getRecomendacao() {
		return "16";
	}
	
	@Override
	public String getExemplo() {
		return "xml:lang=pt-BR";
	}
}
