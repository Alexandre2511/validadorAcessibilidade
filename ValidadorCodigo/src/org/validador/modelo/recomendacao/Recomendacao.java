package org.validador.modelo.recomendacao;

import org.jsoup.nodes.Document;

public interface Recomendacao<R> {
	
	String getRecomendacao();

	String getNome();

	String getDescricao();

	R executa(Document doc);

}
