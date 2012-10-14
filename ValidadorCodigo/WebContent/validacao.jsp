<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validador de Acessibilidade</title>
<link rel="stylesheet" type="text/css" href="static/css/estilo.css">
</head>
<body>
<div id="topo">
	<h1>Validador para desenvolvimento de sites acessiveis.</h1>
	<div id="acessibilidade">
		<ul id="atalhos">
			<li><a href="#iniciodoconteudo">Ir para Conteúdo [1]</a></li>
			<li><a href="#iniciodomenu">Ir para Menu [2]</a></li>
			<li><a href="#buscaurl">Ir para busca [3]</a></li>
		</ul>
		<ul id="botoes">
			<li><a href="#" id="btnAumentarFonte">aumentar letra</a></li>
			<li><a href="#" id="btnDiminuirFonte">diminuir letra</a></li>
			<li><a href="#" id="btnTamanhoFonte">tamanho normal</a></li>
			<li><a href="#" id="bt_contraste">alto contraste</a></li>
			<li><a href="acessibilidade.html"> Página de acessibilidade
			</a></li>
		</ul>
	</div>
</div>
<br>
<div id="menu">
	<button accesskey="2" id="btn_1">Home</button><br>
	<button id="btn_2">Sobre e-MAG</button><br>
	<button id="btn_3">Contato</button><br>
</div>
<div id="conteudo">
	<form action="validar" method="get">
		<input id="inp_url" type="text" name="url" size="100" accesskey="3" title="Digite o site a ser validado."></input><br>
		<input id="inp_env" type="submit" name="enviar" alt="Enviar link para validação"></input>
	</form>
</div>
</body>
</html>