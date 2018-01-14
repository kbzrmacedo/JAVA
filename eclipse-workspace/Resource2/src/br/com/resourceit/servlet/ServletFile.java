package br.com.resourceit.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.resourceit.dao.DadoDao;
import br.com.resourceit.model.Dado;

/**
 * Servlet implementation class ServletFile
 */
@WebServlet("/upload")
@MultipartConfig (maxFileSize = 1024 * 1024 * 4) //4MB
public class ServletFile extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
			BufferedReader br = null;
			InputStreamReader leitor;

			Part filePart = request.getPart("Importar");
			InputStream arquivo = filePart.getInputStream();

			try {
				leitor = new InputStreamReader(arquivo);
				br = new BufferedReader(leitor);

			} catch (NullPointerException e) {
				e.printStackTrace();
			}

			Dado dado = new Dado();	
			String s = br.readLine();
			s = br.readLine();
			while (s != null) {
				StringTokenizer st = new StringTokenizer(s, ";");
				String produto, cod_prod, tipo;
				Double valor, taxa;
					
				cod_prod = st.nextToken();
				produto = st.nextToken();
				valor = Double.parseDouble(st.nextToken());
				taxa = Double.parseDouble(st.nextToken());
				tipo = st.nextToken();

				dado.setProduto(produto);
				dado.setValor(valor);
				dado.setTaxa(taxa);
				dado.setTipo(tipo);

				DadoDao dao = new DadoDao();
				dao.adiciona(dado);
				s = br.readLine();
			}
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
	}

}
