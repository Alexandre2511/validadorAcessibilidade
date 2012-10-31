<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validador de Acessibilidade</title>
<link rel="stylesheet" type="text/css" href="static/css/estilo.css">

<script type="text/javascript" src="static/js/jquery.js"></script>
  
</head>
<body>
<noscript></noscript>
<div id="topo">
	<h1>Validador para desenvolvimento de sites acessíveis.</h1>
	<div id="acessibilidade">
		<ul id="atalhos">
			<li class="barraAcessibilidade"><a href="#teste" >Ir para Conteúdo [1]</a></li>
			<li class="barraAcessibilidade"><a href="#1s">Ir para Menu [2]</a></li>
			<li class="barraAcessibilidade"><a href="#url">Ir para busca [3]</a></li>
			<li class="barraAcessibilidade"><a href="#" id="btnAumentarFonte">Aumentar letra</a></li>
			<li class="barraAcessibilidade"><a href="#" id="btnDiminuirFonte">Diminuir letra</a></li>
			<li class="barraAcessibilidade"><a href="#" id="btnTamanhoFonte">Tamanho normal</a></li>
			<li class="barraAcessibilidade"><a href="#" id="bt_contraste">Alto contraste</a></li>
			<li class="barraAcessibilidade"><a href="acessibilidade.html"> Página de acessibilidade
			</a></li>
		</ul>
	</div>
</div>
<br>
<div id="menu">
	<button accesskey="2" id="btn_1"name="1s">Sobre e-mag</button><br>
	<button id="btn_2">Contato</button><br>
	<button id="btn_3">Ajuda</button><br>
</div>
<div id="conteudo">
	<form action="validar" method="get">
		<input id="inp_url" type="text" name="url" size="100" accesskey="3" title="Digite o site a ser validado."></input><br>
		<input id="inp_env" type="submit" name="enviar" alt="Enviar link para validação" value="Enviar link para validação"></input>
	</form>
</div>
</body>
</html>