<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.JavaBeans"%>
    <%@ page import="java.util.ArrayList"%>
    <%
    	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
    	
    %>
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="./imagens/addressbook.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de contatos</h1>
	<a href="adicionarContato.html" class="botao1">Novo contato</a>
	
	<table id="tabela">
		<caption> <!-- título da tabela. -->
			Tabela de Contatos
			</caption>
		<thead> <!-- cabeçalho da tabela. -->
		
			<tr> <!-- linha da tabela. -->
			
				<th>ID</th> <!-- Célula de cabeçalho (negrito e centralizada por padrão). -->
				<th>Nome</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>Opções</th>
			</tr>
			
		</thead>
		
		<tbody> <!-- corpo da tabela. -->
			<%for(int i = 0; i < lista.size(); i++){ %>
				<tr>
					<td><%=lista.get(i).getIdContato()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getTelefone()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><a href="select?idContato=<%=lista.get(i).getIdContato()%>" 
					class="botao1">Editar</a></td>
				</tr>
			
			
			<%} %>
		</tbody>
    </table>
</body>
</html>