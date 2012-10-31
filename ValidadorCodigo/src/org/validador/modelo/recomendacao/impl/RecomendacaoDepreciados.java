package org.validador.modelo.recomendacao.impl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.validador.modelo.recomendacao.RecomendacaoCodigo;

public class RecomendacaoDepreciados implements RecomendacaoCodigo {

	@Override
	public String getNome() {
		return "Elementos descontinuados pela W3C";
	}

	@Override
	public String getDescricao() {
		return "Estes elementos foram descontinuados segundo a W3C";
	}

	@Override
	public String executa(Document doc) {
		String elementoDescontinuado = "";
		Elements frame = doc.select("frame");
		Elements applet = doc.select("applet");
		Elements blink = doc.select("blink");
		Elements marquee = doc.select("marquee");
		Elements basefont = doc.select("basefont");
		Elements center = doc.select("center");
		Elements dir = doc.select("dir");
		Elements align = doc.select("align");
		Elements font = doc.select("font");
		Elements isindex = doc.select("isindex");
		Elements menu = doc.select("menu");
		Elements strike = doc.select("strike");
		Elements u = doc.select("u");
		if (!frame.isEmpty() || !applet.isEmpty() || !blink.isEmpty()
				|| !marquee.isEmpty() || !basefont.isEmpty()
				|| !center.isEmpty() || !dir.isEmpty() || !align.isEmpty()
				|| !font.isEmpty() || !isindex.isEmpty() || !menu.isEmpty()
				|| !strike.isEmpty() || !u.isEmpty()) {
			elementoDescontinuado += "\n"+ frame.toString() + "\n" + applet.toString() + "\n"
					+ blink.toString() + "\n" + marquee.toString() + "\n"
					+ basefont.toString() + "\n" + center.toString() + "\n"
					+ dir.toString() + "\n" + align.toString() + "\n"
					+ font.toString() + "\n" + isindex.toString() + "\n"
					+ menu.toString() + "\n" + strike.toString() + "\n"
					+ u.toString();
		}

		return elementoDescontinuado;
	}

	@Override
	public String getRecomendacao() {
		return "Descontinuados";
	}
	
	@Override
	public String getExemplo() {
		return "Não utilizar elementos descontinuados";
	}
}
