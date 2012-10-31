package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoCodigo;

public class RecomendacaoTarget implements RecomendacaoCodigo {

	@Override
	public String getNome() {
		return "Target blank encontrada nas tags.";
	}

	@Override
	public String getDescricao() {
		return "O site não pode abrir outras páginas que não sejam solicitadas pelo usuário.";
	}

	@Override
	public String executa(Document doc) {
		String elementoTarget = "";
		Elements targetBlank = doc.select("a[target=_blank");
			for (Element element : targetBlank) {
				elementoTarget += "\n" + element;
			}

		Elements targetNew = doc.select("a[target=_new");
			for (Element element : targetNew) {
				elementoTarget += "\n" + element ;
			}

		Element execucaoAutomatica = doc.select("body").first();
		String linkHref = execucaoAutomatica.attr("onload");
		if (!linkHref.isEmpty()) {
			elementoTarget += "\n"+ linkHref;
		}

		return elementoTarget;
	}

	@Override
	public String getRecomendacao() {
		return "09";
	}
	
	@Override
	public String getExemplo() {
		return "<a hre=\"#\" target=\"_blank\">Nova aba</a>";
	}

}
