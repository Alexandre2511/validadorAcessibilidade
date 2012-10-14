package org.validador.modelo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ConectaURL {
	String url;
	Document doc = null;
	String result = "";

	public ConectaURL(String url) {
		this.url = url;
		trataURL();
	}

	public String getUrl() {
		return url;
	}

	public String getResult() {
		return result;
	}

	public String trataURL() {

		String search = "https";
		String sub = "http";

		if (!getUrl().contains("http://") && !getUrl().contains("https://")) {
			result = "http://" + url;
		} else if (url.contains("https://")) {
			int i;
			do {
				i = url.indexOf(search);
				if (i != -1) {
					result = getUrl().substring(0, i);
					result = result + sub;
					result = result + getUrl().substring(i + search.length());
					url = result;
				}
			} while (i != -1);
		} else {
			result = getUrl();
		}
		return result;
	}

	public Document capturaCodigoFonte() {
		try {
			doc = Jsoup.connect(this.getResult()).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

	//public static void main(String[] args) {

		// ConectaURL c1 = new ConectaURL(
		// "https://www.balaodainformatica.com.br/site/index.asp?pagina=erro&err=1");
		// System.out.println(c1.getResult());
		//
	//}
}
