package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoBoolean;

public class RecomendacaoRefreshURL implements RecomendacaoBoolean{

	@Override
	public String getNome() {
		return "Redirecionamento automático da página.";
	}

	@Override
	public String getDescricao() {
		return "A página não pode redirecionar para outros dominios sem que seja solicitado pelo usuário.";
	}

	@Override
	public Boolean executa(Document doc) {
		boolean redireciona = false;
		Elements redirecionamentoAutomatico = doc
				.select("meta[content]");
		for (Element element : redirecionamentoAutomatico) {
			String atributo = element.attr("content");
			if(atributo.contains("http"))
				redireciona = true;
		}		
		return redireciona;
	}

	@Override
	public String getRecomendacao() {
		return "12";
	}
	
	@Override
	public String getExemplo() {
		return "<META HTTP-EQUIV=\"Refresh\" CONTENT=\"20;URL=http://testeemag.appspot.com\">";
	}
}
