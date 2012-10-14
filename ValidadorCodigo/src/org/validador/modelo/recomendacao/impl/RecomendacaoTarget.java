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
		return "O site não pode abrir outras páginas.";
	}

	@Override
	public String executa(Document doc) {
		String elemTarget = "";
		Elements targetBlank = doc.select("a[target=_blank");
		if (!targetBlank.isEmpty()) {
			for (Element element : targetBlank) {
				elemTarget += "\n" + element;
			}
		}

		Elements targetNew = doc.select("a[target=_new");
		if (!targetNew.isEmpty()) {
			for (Element element : targetNew) {
				elemTarget += "\n" + element ;
			}
		}

		Element execucaoAutomatica = doc.select("body").first();
		String linkHref = execucaoAutomatica.attr("onload");
		if (!linkHref.isEmpty()) {
			elemTarget += "\n"+ linkHref;
		}

		return elemTarget;
	}

	@Override
	public String getRecomendacao() {
		return "09";
	}

}
