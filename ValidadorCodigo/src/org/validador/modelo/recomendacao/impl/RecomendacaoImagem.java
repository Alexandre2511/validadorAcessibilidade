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
		return "� necess�rio colocar uma descri��o nas imagens possibilitando aos " +
				"leitores de tela interpretar o conte�do e retransmitir ao usu�rio";
	}

	@Override
	public String executa(Document doc) {
		String elementoAlt = "";
		Elements imagens = doc.select("img");

		for (Element imagem : imagens) {
			if (imagem.attr("alt").isEmpty()) {
				elementoAlt += "\n" + imagem;
			}
		}
		return elementoAlt;
	}

	@Override
	public String getRecomendacao() {
		return "20";
	}

	@Override
	public String getExemplo() {
		return "<img src=\"foto\" alt=\"Descricao foto\"/>";
	}
}
