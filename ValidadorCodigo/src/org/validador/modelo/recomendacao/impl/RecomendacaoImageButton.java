package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoCodigo;

public class RecomendacaoImageButton implements RecomendacaoCodigo{

	@Override
	public String getNome() {
		return "Aus�ncia de atributo alt nos bot�es do tipo image.";
	}

	@Override
	public String getDescricao() {
		return "Quando utilizados bot�es com imagens ou do tipo submit e reset uma descri��o deve ser  colocada.";
	}

	@Override
	public String executa(Document doc) {
		String atrTextual = "";
		Elements botoesImage = doc.select("input[type=image]");
		for (Element imagem : botoesImage) {
			if (imagem.attr("alt").isEmpty()) {
				atrTextual += "\n" + imagem;
			}
		}
		
		/**
		 * Juntar bot�es submit e reset
		 */
		// Bot�o reset
		Elements botoesReset = doc.select("input[type=reset]");
		for (Element reset : botoesReset) {
			if (reset.attr("value").isEmpty()) {
				atrTextual += "\n"+ reset;
			}
		}

		// Bot�o submit
		Elements botoesSubmit = doc.select("input[type=submit]");

		for (Element submit : botoesSubmit) {
			if (submit.attr("value").isEmpty()) {
				atrTextual += "\n"+ submit;
			}
		}
	
		return atrTextual;
	}

	@Override
	public String getRecomendacao() {
		return "38";
	}

}
