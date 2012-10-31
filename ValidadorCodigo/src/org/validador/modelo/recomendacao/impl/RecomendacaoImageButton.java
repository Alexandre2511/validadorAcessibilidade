package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoCodigo;

public class RecomendacaoImageButton implements RecomendacaoCodigo{

	@Override
	public String getNome() {
		return "Ausência de atributo alt nos botões do tipo image.";
	}

	@Override
	public String getDescricao() {
		return "Quando utilizados botões com imagens ou do tipo submit e reset uma descrição deve ser  colocada, para identificação dos leitores de tela.";
	}

	@Override
	public String executa(Document doc) {
		String conteudoTextual = "";
		Elements botoesImage = doc.select("input[type=image]");
		for (Element imagem : botoesImage) {
			if (imagem.attr("alt").isEmpty()) {
				conteudoTextual += "\n" + imagem;
			}
		}
		
		Elements botoesReset = doc.select("input[type=reset]");
		for (Element reset : botoesReset) {
			if (reset.attr("value").isEmpty()) {
				conteudoTextual += "\n"+ reset;
			}
		}

		Elements botoesSubmit = doc.select("input[type=submit]");

		for (Element submit : botoesSubmit) {
			if (submit.attr("value").isEmpty()) {
				conteudoTextual += "\n"+ submit;
			}
		}
	
		return conteudoTextual;
	}

	@Override
	public String getRecomendacao() {
		return "38";
	}
	
	@Override
	public String getExemplo() {
		return "<input type=\"image\" name=\"enviar\" src=\"enviar.jpg\" alt=\"enviar\"/>";
	}
}
