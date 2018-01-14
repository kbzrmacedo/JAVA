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


@WebServlet("/add")
// Servlet por estar na versão 3.0, não é mais preciso definir no web.xml esse parametros.
public class ServletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
			HttpServletResponse	response)
					throws IOException, ServletException {

		//pegando parametros do request
		String produto = request.getParameter("produto");
		String preco = request.getParameter("valor");
		Double taxa = Double.parseDouble(request.getParameter("taxa"));
		String tipo = request.getParameter("tipo");

		String precoFinal = preco.replace(".", "");
		Double valor = Double.parseDouble(precoFinal);
		
		// monta objeto dados
		Dado dado = new Dado();
		dado.setProduto(produto);
		dado.setValor(valor);
		dado.setTaxa(taxa);
		dado.setTipo(tipo);

		// salva os dados
		DadoDao dao = new DadoDao();
		dao.adiciona(dado);
		
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
		
	}
}
