package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoBoolean;

public class RecomendacaoH1 implements RecomendacaoBoolean{

	@Override
	public String getNome() {
		return "H1 n�o existente na p�gina.";
	}

	@Override
	public String getDescricao() {
		return "Cada p�gina deve conter um �nico atributo H1, para fornecer uma navega��o sem�ntica atrav�s dos niveis de cabe�alhos.";
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
		return "<h1>Titulo principal da p�gina</h1>";
	}
}
