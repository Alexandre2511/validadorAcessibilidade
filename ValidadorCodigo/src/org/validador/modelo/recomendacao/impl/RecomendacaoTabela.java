package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoCodigo;

public class RecomendacaoTabela implements RecomendacaoCodigo {

	@Override
	public String getNome() {
		return "Ausência do título e descrição da tabela.";
	}

	@Override
	public String getDescricao() {
		return "A tabela necessita ter um título descrito logo após a " +
				"criação, e uma descrição referente a qual sua finalidade.";
	}

	@Override
	public String executa(Document doc) {
		String elementoDescricao = "";
		Elements tabelas = doc.select("table");
		for (Element tabela : tabelas)
			if (tabela.attr("summary").isEmpty() || !(tabela.select("caption") != null)) {
				elementoDescricao += "\n" + tabela;
			}
		return elementoDescricao;
	}

	@Override
	public String getRecomendacao() {
		return "23";
	}
	
	@Override
	public String getExemplo() {
		return "<table summary=\"descrição tabela\"><caption>Título da tabela</caption></table>";
	}
}
