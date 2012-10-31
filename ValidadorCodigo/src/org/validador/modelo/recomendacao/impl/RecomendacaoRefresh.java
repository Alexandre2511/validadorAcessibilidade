package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoBoolean;

public class RecomendacaoRefresh implements RecomendacaoBoolean{

	@Override
	public String getNome() {
		return "Atualização automática da página.";
	}

	@Override
	public String getDescricao() {
		return "Atualizações periodicas nas páginas podem prejudicar a usabildiade daquele usuário" +
				" que utiliza de leitores de tela para navegação, pois necessitaram de um período de readaptação ao site.";
				
	}

	@Override
	public Boolean executa(Document doc) {
		boolean atualizacaoAutomatica = false;
		Elements refresh = doc.select("meta[http-equiv=refresh]");
		if (!refresh.isEmpty()) {
			atualizacaoAutomatica = true;
		}
		return atualizacaoAutomatica;
	}

	@Override
	public String getRecomendacao() {
		return "11";
	}
	
	@Override
	public String getExemplo() {
		return "<META HTTP-EQUIV=\"Refresh\" CONTENT=\"20\">";
	}
}
