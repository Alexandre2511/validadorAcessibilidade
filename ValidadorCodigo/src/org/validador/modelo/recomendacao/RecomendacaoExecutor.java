package org.validador.modelo.recomendacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
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

public class RecomendacaoExecutor {

	public Map<Recomendacao, Object> executar(Document doc) {
		Map<Recomendacao, Object> map = new HashMap<Recomendacao, Object>();
		List<Recomendacao> recomendacoes = new ArrayList<Recomendacao>();
		recomendacoes.add(new RecomendacaoH1());
		recomendacoes.add(new RecomendacaoRefresh());
		recomendacoes.add(new RecomendacaoRefreshURL());
		recomendacoes.add(new RecomendacaoLang());
		recomendacoes.add(new RecomendacaoTitulo());
		recomendacoes.add(new RecomendacaoNoscript());
		recomendacoes.add(new RecomendacaoMultiH1());
		recomendacoes.add(new RecomendacaoTarget());
		recomendacoes.add(new RecomendacaoImagem());
		recomendacoes.add(new RecomendacaoImageButton());
		recomendacoes.add(new RecomendacaoForm());
		recomendacoes.add(new RecomendacaoTabela());
		recomendacoes.add(new RecomendacaoTabindex());
		recomendacoes.add(new RecomendacaoDepreciados());

		for (Recomendacao rec : recomendacoes) {
			Object r = rec.executa(doc);
			boolean append = true;

			if (r.toString().equals(Boolean.FALSE.toString()))
				append = false;
			
			if (r.toString().equals(""))
				append = false;
			
			if (append)
				map.put(rec, r.toString());

		}

		return map;
	}
}
