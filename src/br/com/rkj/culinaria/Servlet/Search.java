package br.com.rkj.culinaria.Servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rkj.culinaria.Receita;
import br.com.rkj.culinaria.DAO.ConexaoArquivo;
import br.com.rkj.culinaria.DAO.ConexaoBd;
import br.com.rkj.culinaria.utils.ReceitaSaving;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ReceitaSaving.class.getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ConexaoBd<ReceitaSaving> conectar = new ConexaoBd<>();
		HashMap<String, Receita> receitas = new HashMap<>();

		String search = request.getParameter("q");

		if (search != null) {
			request.setAttribute("q", search);
			try {
				conectar.conexao();
				receitas = conectar.search(search);

			} catch (ClassNotFoundException e) {
				logger.warning("Ocorreu um erro ao se conectar " + e);
			}
		} else {
			
			request.setAttribute("q", "");
			receitas = conectar.listarTodos();
		}

		conectar.desconectar();

		request.setAttribute("titulo", receitas.get("titulo"));
		request.setAttribute("descricao", receitas.get("descricao"));
		request.setAttribute("imagem", receitas.get("imagem"));
		request.setAttribute("dataPub", receitas.get("dataPub"));
		
		request.setAttribute("receitas", receitas);
		
		

		request.getRequestDispatcher("listaReceita.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("oi");
		doGet(request, response);
	}

}
