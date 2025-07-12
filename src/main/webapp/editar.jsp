<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar contato</title>
</head>
<body>
	<h1>Editar contato</h1>
	<form name="frmContato" action="insert">
		
		<label for="idcontato">ID:</label>
		<input type="number" name="idcontato" readonly="readonly" class="caixa1"
			value="<%out.print(request.getAttribute("idcontato"));%>" >
		
	
		<label for="nome">Nome:</label>
		<input type="text" name="nome"
			placeholder="Nome" onpaste="return false"
			ondrop="return false" class="caixa1" 
			value="<%out.print(request.getAttribute("nome"));%>" >
			
		<label for="telefone">Telefone:</label>
		<input type="tel" name="telefone" placeholder="Telefone"
			class="caixa2" maxlength="11" inputmode="numeric"
			id="telefone" pattern="[0-9]{10,11}"
			title="Digite apenas números com DDD (10 ou 11 dígitos)"
			value="<%out.print(request.getAttribute("telefone"));%>">
			 
		<label for="email">E-mail:</label>
		<input type="email" name="email"
			placeholder="E-mail"
			title="Por favor, insira um e-mail válido." class="caixa1"
			value="<%out.print(request.getAttribute("email"));%>">
		
		<input type="button" value="Salvar" class="botao1" onclick="validar()">
	
	</form>

	<!-- SCRIPT PARA EXECUÇÃO DO VALIDOR.JS -->
	<script src="./scripts/validador.js"></script>

	<!-- SCRIPT PARA verificação do telefone.js -->
	<script src="./scripts/telefone.js"></script>
	
</body>
</html>