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
		return "Atualiza��es periodicas nas p�ginas podem prejudicar a usabildiade daquele usu�rio" +
				" que utiliza de leitores de tela para navega��o, pois necessitaram de um per�odo de readapta��o ao site.";
				
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
