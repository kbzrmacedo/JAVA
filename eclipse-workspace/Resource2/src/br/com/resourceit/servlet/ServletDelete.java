package br.com.resourceit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.resourceit.dao.DadoDao;
import br.com.resourceit.model.Dado;

/**
 * Servlet incompleta
 */
@WebServlet("/Remover")
public class ServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
 
             // buscando os parametros no request
             Long cod_prod = Long.parseLong(request.getParameter("Delete"));

                    
             // monta um objeto contato
             Dado dado = new Dado();
             dado.setCod_prod(cod_prod);
             
             DadoDao dao = new DadoDao();
             
             dao.remover(dado);
             
     		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
    		view.forward(request, response);

       }
 }
