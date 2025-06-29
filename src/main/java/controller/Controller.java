package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.DAO; // IMPORTANTO CLASSE DAO PARA EXECUTAR O TESTE DE CONEXAO.

@WebServlet(urlPatterns = { "/Controller", "/main" }) // AS REQUISIÇÕES SÃO RECEBIDAS ATRAVÉS DE URLs (CAMINHOS
														// DEFINIDOS EM FORMULARIOS, BOTÕES ETC), CONFIGURADAS NESTA
														// LINHA.
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// INSTANCIANDO E CRIANDO UM OBJETO PARA REALIZAR O TESTE DE CONEXÃO:
	DAO conexaoDAO = new DAO();

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	// metodo principal do servlet:

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// conexaoDAO.testeConexao(); TESTANDO A CONEXÃO COM O DAO.

		/*
		 * REDIRECIONANDO AS REQUISIÇÕES CRIADAS NA LINHA 11 PARA METODOS ESPECIFICOS:
		 */
		// String action; VARIAVEL QUE ARMAZENARÁ O CAMINHO DA REQUISIÇÃO.
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) { // SE O CONTEUDO DE ACTION FOR IGUAL A /MAIN

			// SE O METODO TOGET RECEBER A REQUISIÇÃO /MAIN, REDIRECIONE PARA O MÉTODO QUE
			// VAI TRABALHAR COM ESSA REQUISIÇÃO:
			contatos(request, response);

		}

	}

	// LISTAR CONTATOS:
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// REDIRECIONAR A REQUISIÇÃO AO DOCUMENTO AGENDA.JSP:
		response.sendRedirect("Agenda.jsp");
	}

}
