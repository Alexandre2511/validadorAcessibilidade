package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoBoolean;

public class RecomendacaoTitulo implements RecomendacaoBoolean{

	@Override
	public String getNome() {
		return "Não há um título na página.";
	}

	@Override
	public String getDescricao() {
		return "A página deve possuir um titulo que descreva o site, para " +
				"auxiliar o usuário que utiliza um leitor de tela situar-se no site, " +
				"tendo em vista que esta será a primeira informação lida assim que acessar o sitio.";
	}

	@Override
	public Boolean executa(Document doc) {
		boolean elementoTitulo = false;
		Elements title = doc.select("title");
		if (title.isEmpty()) {
			elementoTitulo = true;
		}
		return elementoTitulo;
	}

	@Override
	public String getRecomendacao() {
		return "17";
		
	}
	
	@Override
	public String getExemplo() {
		return "< title >Titulo para o site < /title >";
	}
}
