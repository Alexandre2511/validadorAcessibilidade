package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoBoolean;

public class RecomendacaoH1 implements RecomendacaoBoolean{

	@Override
	public String getNome() {
		return "H1 não existente na página.";
	}

	@Override
	public String getDescricao() {
		return "Cada página deve conter um único atributo H1, para fornecer uma navegação semântica através dos niveis de cabeçalhos.";
	}

	@Override
	public Boolean executa(Document doc) {
		boolean elementoH1 = false;
		Elements h1 = doc.select("h1");
		if (h1.isEmpty()){
			elementoH1 = true;
		}
		return elementoH1;
	}

	@Override
	public String getRecomendacao() {
		return "03";
	}

	@Override
	public String getExemplo() {
		return "<h1>Titulo principal da página</h1>";
	}
}
