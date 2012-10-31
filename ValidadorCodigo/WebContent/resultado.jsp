<%@page import="java.util.Properties"%>
<%@page import="org.validador.modelo.recomendacao.Recomendacao"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página resultados</title>
<link rel="stylesheet" type="text/css" href="static/css/estilo.css">
<script type="text/javascript" src="static/syntaxhighlighter/scripts/shCore.js"></script>
<script type="text/javascript" src="static/syntaxhighlighter/scripts/shBrushJava.js"></script>
<script type="text/javascript" src="static/syntaxhighlighter/scripts/shBrushSql.js"></script>
<link type="text/css" rel="stylesheet" href="static/syntaxhighlighter/styles/shCoreDefault.css"/>
<script type="text/javascript">SyntaxHighlighter.all();</script>

<script type="text/javascript" src="static/js/jquery.js"></script>

<script>
        $(document).ready(function(){
        $(this).find(".expandicomprimi").hide();
        $("a.expandi").click(function(event){
        event.preventDefault();
        var div = $(this).parent().prev('div'); // ( 1 )
        if( div.is(':hidden') ) // ( 2 )
        $(this).text( "-" );
        else
        $(this).text( "+" );
        $(div).toggle('slow');
        });
  });
</script>

</head>

<body>
<div id="teste">
	<jsp:include page="validacao.jsp"></jsp:include>
</div>
<br><br>
<div id="main-content">
		<%
			String site = (String) request.getAttribute("site");
		%>
		<div id="siteAvaliado" class="siteavaliado">Site avaliado:  <a href="#" accesskey="1"><%=site %></a></div>
		
		<%
			Map<Recomendacao, String> results = (Map<Recomendacao, String>) request.getAttribute("resultados");
		%>
		<div class="recomencao" id="titulorecomendaco">
			<h2 id="spanrecomendacao">Recomendações Listadas: <span id="spantitulo"><%=results.size() %></span>.</h2>
		</div>
		<%
			for (Recomendacao r : results.keySet()) {
		%>
		
		<br>
		<div id="descricaorecomendacao" class="titrec">
			<span id="spanrecomendacao">Recomendacao <%=r.getRecomendacao() %>: <%=r.getNome()%> :</span> <br>
			<p><span id="titulo">Descrição: <%=r.getDescricao()%></span></p>	
		</div>
		
		<span  id="spanexemplo">Exemplo Recomendação:</span>  <pre class="brush: sql;"><%=r.getExemplo() %></pre>
		
		<span id="spandetalhe">Código encontrado:</span><br>
		<div class="expandicomprimi" id="expandicomprimi">
			<% if (!results.get(r).equals(Boolean.TRUE.toString())){%>				
				<pre class="brush: java;"><%=results.get(r)%></pre>						
			<% } %>	 		
		</div>
		
		<span id="descricaorecomendacao">Detalhes:<a href="#" id="idexpandir" class="expandi">+</a></span>
		
		<hr></hr>
		<% } %>
		
	
		<h2 id="sugestao">Sugestões</h2>
		<%
		Properties prop = (Properties) request.getAttribute("sugestoes");
		int i=0;
		for (Object s : prop.keySet()) {
			
		String propriedade = (String) prop.get(s);
		String[] resultado = propriedade.split(";");
	
		%>
		
		<div id="titulorecomendacao" class="titulorecomendacao">
			<span id="sugestao">Sugestão : <%=resultado[0]%> </span>	
		</div>
		
		<div class="expandicomprimi" id="expandicomprimi">
			<span id="titulo"><%=resultado[1] %></span>	
		</div>
		<span><a href="#" id="idexpandir" class="expandi">+</a></span>
		
		<% } %>
				
</div>		
<br><br>
<div id="rodape">
	<span>Direitos Reservados Alexandre Cotta 2012.</span>
</div>
</body>
</html>