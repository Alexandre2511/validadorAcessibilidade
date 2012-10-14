package org.validador.modelo.sugestao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GerenciadorSugestao {

	public Properties lerSugestoes() throws IOException {
		InputStream in = new FileInputStream("C:\\Users\\Alexandre\\Documents\\WorkSpaceTG\\ValidadorCodigo\\sugestoes.properties");
		Properties prop = new Properties();
		prop.load(in);
		return prop;
	}

}
