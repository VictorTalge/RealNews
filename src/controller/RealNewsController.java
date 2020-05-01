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

import model.Comentario;
import service.ComentarioService;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/noticia.do")
public class RealNewsController extends HttpServlet {
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
		int pId = Integer.parseInt(request.getParameter("id"));
		
		String pNome = request.getParameter("nome");
		String pTexto1 = request.getParameter("Texto");
				
		//instanciar o javabean
		Noticia noticia = new Noticia();
		
		Comentario comentario = new Comentario();
		comentario.setNome(pNome);
		comentario.setTexto(pTexto1);
		comentario.setFkId(pId);
		
		//instanciar o service
		NoticiaService cs = new NoticiaService();
		cs.carregar(pId);		

		ComentarioService cs2 = new ComentarioService();
		cs2.criar(comentario);
		comentario = cs2.carregar(comentario.getId());		
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Noticia</title></head><body>");
		out.println(	noticia.getTitulo()+"<br>");
		out.println(	noticia.getDescricao()+"<br>");
		out.println(	noticia.getTexto()+"<br>");
		out.println(	"hr>");
		out.println(	comentario.getNome()+"<br>");
		out.println(	comentario.getTexto()+"<br>");
		out.println(	comentario.getTexto()+"<br>");
		out.println(	"hr>");
		out.println(	comentario.getNome()+"<br>");
		out.println(	comentario.getTexto()+"<br>");
		out.println(	"hr>");
		out.println(	"<form action=noticia.do method=post>");
		out.println(	"<table>");
		out.println(	"<tr><td><input type=submit>Comentario Novo<td><tr>");
		out.println(	"Nome: <input type=\"text\" name=\"nome\"><br>");
		out.println(	"Texto: <textarea name=\"area\"> Texto</textarea><br>");
		out.println(	"<input type=\"submit\">");
		out.println(	"</table>");
		out.println(	"</form>");	
	    out.println("</body></html>");	
	}

}

