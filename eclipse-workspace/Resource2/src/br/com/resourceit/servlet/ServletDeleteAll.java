package br.com.resourceit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.resourceit.dao.DadoDao;


/**
 * Servlet implementation class ServletDeleteAll
 */
@WebServlet("/RemoverTodos")
public class ServletDeleteAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
        DadoDao dao = new DadoDao();       
        dao.removerAll();
        dao.alterId();
        
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);

  
	}

}
