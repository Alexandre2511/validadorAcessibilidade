package org.validador.modelo.recomendacao;

import org.jsoup.nodes.Document;

public interface Recomendacao<R> {
	
	String getRecomendacao();

	String getNome();

	String getDescricao();
	
	String getExemplo();

	R executa(Document doc);

}
