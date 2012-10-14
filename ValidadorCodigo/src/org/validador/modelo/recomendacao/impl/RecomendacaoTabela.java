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
		return "A tabela necessita ter um título e uma descrição.";
	}

	@Override
	public String executa(Document doc) {
		String elemDescicao = "";
		Elements tabelas = doc.select("table");
		if (!tabelas.isEmpty()) {
			for (Element tabela : tabelas)
				if (tabela.attr("summary").isEmpty() || !(tabela.select("caption") != null)) {
					elemDescicao += "\n" + tabela;
				}
		}

		return elemDescicao;
	}

	@Override
	public String getRecomendacao() {
		return "23";
	}

}
