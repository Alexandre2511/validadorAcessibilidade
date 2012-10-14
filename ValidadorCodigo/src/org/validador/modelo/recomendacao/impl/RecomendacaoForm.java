package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoCodigo;

public class RecomendacaoForm implements RecomendacaoCodigo {

	@Override
	public String getNome() {
		return "Ausência de fieldset e legenda no formulário.";
	}

	@Override
	public String getDescricao() {
		return "Deve ser colocado uma legenda no formulario e a separação por fildsets.";
	}

	@Override
	public String executa(Document doc) {
		String elemForm = "";
		Elements forms = doc.select("form");
		// Elements fieldset = form.select("fieldset");
		// Elements legend = form.select("legend");
		if (!forms.isEmpty()) {
			for (Element element : forms) {
				 Elements fieldset = element.select("fieldset");
				 Elements legend = element.select("legend");
//				if (!(element.select("fieldset") != null)
//						|| !(element.select("legend") != null))
				 if(fieldset.isEmpty() || legend.isEmpty())
					elemForm += "\n" + element;
			}
		}
		return elemForm;
	}

	@Override
	public String getRecomendacao() {
		return "44";
	}
}
