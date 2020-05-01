package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/cadastro.do")
public class RealNewsCadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pDescricao = request.getParameter("descricao");
		String pTitulo = request.getParameter("titulo");
		String pTexto = request.getParameter("texto");
		
		//instanciar o javabean
		Noticia noticia = new Noticia();
		noticia.setDescricao(pDescricao);
		noticia.setTitulo(pTitulo);
		noticia.setTexto(pTexto);
			
		//instanciar o service
		NoticiaService cs = new NoticiaService();
		cs.criar(noticia);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cadastro</title></head><body>");
		out.println("<h1>Real News</h1>");
		out.println("<hr> ");
		out.println("<h1>Cadastro Realizado com sucesso</h1><br>");
		out.println("<hr>");
	    out.println("</body></html>");
		
	}

}
