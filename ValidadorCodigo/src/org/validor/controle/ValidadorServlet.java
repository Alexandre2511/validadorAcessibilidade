package org.validor.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.validador.modelo.ConectaURL;
import org.validador.modelo.recomendacao.Recomendacao;
import org.validador.modelo.recomendacao.RecomendacaoExecutor;
import org.validador.modelo.recomendacao.impl.RecomendacaoDepreciados;
import org.validador.modelo.recomendacao.impl.RecomendacaoForm;
import org.validador.modelo.recomendacao.impl.RecomendacaoH1;
import org.validador.modelo.recomendacao.impl.RecomendacaoImageButton;
import org.validador.modelo.recomendacao.impl.RecomendacaoImagem;
import org.validador.modelo.recomendacao.impl.RecomendacaoLang;
import org.validador.modelo.recomendacao.impl.RecomendacaoMultiH1;
import org.validador.modelo.recomendacao.impl.RecomendacaoNoscript;
import org.validador.modelo.recomendacao.impl.RecomendacaoRefresh;
import org.validador.modelo.recomendacao.impl.RecomendacaoRefreshURL;
import org.validador.modelo.recomendacao.impl.RecomendacaoTabela;
import org.validador.modelo.recomendacao.impl.RecomendacaoTabindex;
import org.validador.modelo.recomendacao.impl.RecomendacaoTarget;
import org.validador.modelo.recomendacao.impl.RecomendacaoTitulo;
import org.validador.modelo.sugestao.GerenciadorSugestao;

import com.sun.xml.internal.ws.util.StringUtils;

public class ValidadorServlet extends HttpServlet {

	@SuppressWarnings("null")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String url = req.getParameter("url");
		ConectaURL conexao = new ConectaURL(url);
		String siteavaliado = conexao.getResult();
		req.setAttribute("site", siteavaliado);
		Document doc = conexao.capturaCodigoFonte();
		
		
		// recomendacoes
		RecomendacaoExecutor exec = new RecomendacaoExecutor();
		Map<Recomendacao, Object> results = exec.executar(doc);

		req.setAttribute("resultados", results);

		// sugestoes
		GerenciadorSugestao ger = new GerenciadorSugestao();
		Properties prop = ger.lerSugestoes();

		req.setAttribute("sugestoes", prop);
//
		RequestDispatcher rd = req.getRequestDispatcher("resultado.jsp");
		rd.forward(req, resp);
	}
}
