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
<link type="text/css" rel="stylesheet" href="static/syntaxhighlighter/styles/shCoreDefault.css"/>
<script type="text/javascript">SyntaxHighlighter.all();</script>

<script type="text/javascript" src="static/js/jquery.js"></script>
<script type="text/javascript"> 
jQuery.fn.toggleText = function(a,b) {
	return   this.html(this.html().replace(new RegExp("("+a+"|"+b+")"),function(x){return(x==a)?b:a;}));
}
$(document).ready(function(){
	$('.tgl').before('<span id="moscod">Mostrar Conteúdo</span>');
	$('.tgl').css('display', 'none')
	$('span', '#box-toggle').click(function() {
	$(this).next().slideToggle('slow')
	.siblings('.tgl:visible').slideToggle('fast');
	// aqui começa o funcionamento do plugin
		$(this).toggleText('Mostrar','Ocultar')
			.siblings('span').next('.tgl:visible').prev()
			.toggleText('Mostrar','Ocultar')
		});
})
</script>
</head>

<body>
<div id="teste">
<jsp:include page="validacao.jsp"></jsp:include>
</div>
<br><br>
<div id="main-content">
	<!-- Mostra o conteudo do request -->
	<%-- <c:forEach items="${requestScope.resultados}" var="rec"> --%>
	<%-- 	<br><c:out value="${rec}"></c:out> --%>
	<%-- </c:forEach> --%>
	
	<div id="box-toggle">
		<%
			String site = (String) request.getAttribute("site");
		%>
		<h2 id="resrec">Site avaliado:  <%=site %></h2>
		
		<h2 id="resrec">Recomendações</h2>
		<%
			Map<Recomendacao, String> results = (Map<Recomendacao, String>) request.getAttribute("resultados");
		
			for (Recomendacao r : results.keySet()) {
		%>
			<p>
			<div id="titrec">
				Recomendacao <%=r.getRecomendacao() %>: <%=r.getNome()%> :
			
				<div class="tgl">
				<p><%=r.getDescricao()%></p><br>
				<% if (!results.get(r).equals(Boolean.TRUE.toString())){
					%>
							<pre class="brush: java;"><%=results.get(r)%></pre>
					<%
					}
				 %>
				 
				 </div>
			</div>
			</p>	 	
		<%
			}
		%>

		<h2 id="resrec">Sugestões</h2>
		<%
		Properties prop = (Properties) request.getAttribute("sugestoes");
		int i=0;
		for (Object s : prop.keySet()) {
		%>
		<p>
		<div id="titrec">
			Sugestão <%=i++ %>: <%=prop.get(s)%>
			<div class="tgl"><br>
				Aqui virá a descrição da sugestão
			</div>
		</div>
		</p>
		
		<%
		}
		%>
		
	</div>
		
</div>
<br><br>
<div id="rodape">
Direitos Reservados Alexandre Cotta 2012.
</div>
</body>
</html>