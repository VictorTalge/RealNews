package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/listar.do")
public class RealNewsListarController extends HttpServlet {
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
	
		//instanciar o javabean
		Noticia noticia = new Noticia();
		
		
		//instanciar o service
		NoticiaService cs = new NoticiaService();
		noticia = cs.carregar(noticia.getId());		

		
		request.setAttribute("noticia", noticia);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("listar.jsp");
        view.forward(request, response);
				
	}
}