package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO; // IMPORTANTO CLASSE DAO PARA EXECUTAR O TESTE DE CONEXAO.
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update" }) // AS REQUISIÇÕES SÃO RECEBIDAS ATRAVÉS DE URLs (CAMINHOS
														// DEFINIDOS EM FORMULARIOS, BOTÕES ETC), CONFIGURADAS NESTA
														// LINHA.
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// INSTANCIANDO E CRIANDO UM OBJETO PARA REALIZAR O TESTE DE CONEXÃO:
	DAO dao = new DAO();
	
	JavaBeans contato = new JavaBeans();
	

	public Controller() {
		super();
		
	}

	// metodo principal do servlet:

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* REDIRECIONANDO AS REQUISIÇÕES CRIADAS NA LINHA 11 PARA METODOS ESPECIFICOS: */
		// String action; VARIAVEL QUE ARMAZENARÁ O CAMINHO DA REQUISIÇÃO.
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) { // SE O CONTEUDO DE ACTION FOR IGUAL A /MAIN
			// SE O METODO TOGET RECEBER A REQUISIÇÃO /MAIN, REDIRECIONE PARA O MÉTODO contato()
			contatos(request, response);

		} else if(action.equals("/insert")) { // SE O CONTEUDO DE ACTION FOR IGUAL A /INSERT
			// SE O METODO TOGET RECEBER A REQUISIÇÃO /INSERT, REDIRECIONE PARA O MÉTODO novoContato()
			novoContato(request, response);
		} else if(action.equals("/select")) { // SE O CONTEUDO DE ACTION FOR IGUAL A /select
			// SE O METODO TOGET RECEBER A REQUISIÇÃO /select, REDIRECIONE PARA O MÉTODO listarContato()
			listarContato(request, response);
		}
		else if(action.equals("/update")) { // SE O CONTEUDO DE ACTION FOR IGUAL A /update
			// SE O METODO TOGET RECEBER A REQUISIÇÃO /update, REDIRECIONE PARA O MÉTODO editarContato()
			editarContato(request, response);
		}
		else {
			response.sendRedirect("index.html");
		}

	}

	// LISTAR CONTATOS:
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Criando um objeto que irá receber os dados JavaBeans:
		ArrayList<JavaBeans> lista = dao.listarContatos();
		
		// Encaminhar a lista ao documento agenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}
	
	// NOVO CONTATO:
		protected void novoContato(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				
		// request.getParameter é usado para obter o valor de um campo de um formulário HTML que foi enviado para o servidor.

				// SETANDO AS VARIÁVEIS JAVABEANS
				
				contato.setNome(request.getParameter("nome"));  // "Pegue o valor digitado no campo nome do formulário e coloque dentro do objeto contato."
				contato.setTelefone(request.getParameter("telefone"));
				contato.setEmail(request.getParameter("email"));
				
				// INVOCAR O MÉTODO inserirContato PASSANDO O OBJETO CONTATO
				dao.inserirContato(contato);
				
				// REDIRECIONAR PARA O DOCUMENTO AGENDA.JSP
				response.sendRedirect("main");
				
		}
		
	// EDITAR CONTATO: 1º lista o contato que será alterado:
		protected void listarContato(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			// Recebimento do id do contato que será editado:
			int idContato = Integer.parseInt(request.getParameter("idContato"));
			
			// SETANDO A VARIAVEL JavaBeans:
			contato.setIdContato(idContato);
			
			// EXECUTAR O METODO SELECIONAR CONTATO:
			dao.selecionarContato(contato);
			
			// Setar os atributos do formulário com o conteúdo JavaBeans:
			
			request.setAttribute("idcontato", contato.getIdContato());
			request.setAttribute("nome", contato.getNome());
			request.setAttribute("telefone", contato.getTelefone());
			request.setAttribute("email", contato.getEmail());
			
			RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
			rd.forward(request, response);
		}

	// EDITAR CONTATO: 2º Realiza a edição do contato:
		protected void editarContato(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			// SETANDO AS VARIAVEIS JavaBeans:
			contato.setIdContato(request.getParameter("idcontato"));
			contato.setNome(request.getParameter("nome"));
			contato.setTelefone(request.getParameter("telefone"));
			contato.setEmail(request.getParameter("email"));
			
			// EXECUTAR O METODO SELECIONAR CONTATO:
			dao.selecionarContato(contato);
			
			// Setar os atributos do formulário com o conteúdo JavaBeans:
			
			request.setAttribute("idcontato", contato.getIdContato());
			request.setAttribute("nome", contato.getNome());
			request.setAttribute("telefone", contato.getTelefone());
			request.setAttribute("email", contato.getEmail());
			
			RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
			rd.forward(request, response);
		}

}