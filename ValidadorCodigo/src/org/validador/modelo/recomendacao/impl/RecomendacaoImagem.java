package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoCodigo;

public class RecomendacaoImagem implements RecomendacaoCodigo {

	@Override
	public String getNome() {
		return "Ausência do atributo alt nas imagens.";
	}

	@Override
	public String getDescricao() {
		return "É necessário colocar uma descrição nas imagens para os usuários que utilizam de leitores de tela possam compreender o conteúdo transmitido";
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
