package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoCodigo;

public class RecomendacaoImagem implements RecomendacaoCodigo {

	@Override
	public String getNome() {
		return "Aus�ncia do atributo alt nas imagens.";
	}

	@Override
	public String getDescricao() {
		return "� necess�rio colocar uma descri��o nas imagens para os usu�rios que utilizam de leitores de tela possam compreender o conte�do transmitido";
	}

	@Override
	public String executa(Document doc) {
		String elemAlt = "";
		Elements img = doc.select("img");

		for (Element imagem : img) {
			if (imagem.attr("alt").isEmpty()) {
				elemAlt += "\n" + imagem;
			}
		}
		return elemAlt;
	}

	@Override
	public String getRecomendacao() {
		return "20";
	}

}
