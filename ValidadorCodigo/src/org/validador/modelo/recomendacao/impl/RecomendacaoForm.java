package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoCodigo;

public class RecomendacaoForm implements RecomendacaoCodigo {

	@Override
	public String getNome() {
		return "Aus�ncia de fieldset e legenda no formul�rio.";
	}

	@Override
	public String getDescricao() {
		return "Deve ser utilizado fieldset no formul�rio para o " +
				"agrupamento de informa��es e a utiliza��o de legend para descri��o do prop�sito do grupo";
	}

	@Override
	public String executa(Document doc) {
		String elementoFormulario = "";
		Elements forms = doc.select("form");
		for (Element element : forms) {
			Elements fieldset = element.select("fieldset");
			Elements legend = element.select("legend");
			if (fieldset.isEmpty() || legend.isEmpty())
				elementoFormulario += "\n" + element;
		}
		return elementoFormulario;
	}

	@Override
	public String getRecomendacao() {
		return "44";
	}

	@Override
	public String getExemplo() {
		return "<form ...><fieldset><legend>Buscar</legend>...</fieldset></form>";
	}
}
