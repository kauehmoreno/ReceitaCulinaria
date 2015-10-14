package br.com.rkj.culinaria.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rkj.culinaria.Receita;
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
		Receita culinaria = new Receita();
		List<Receita> receitas = new ArrayList<>();

		String search = request.getParameter("q");

		if (search != null) {
			request.setAttribute("q", search);
			try {
				conectar.conexao();
				culinaria = conectar.search(search);

			} catch (ClassNotFoundException e) {
				logger.warning("Ocorreu um erro ao se conectar " + e);
			}
		} else {
			
			request.setAttribute("q", "");
			receitas = conectar.listarTodos();
		}

		conectar.desconectar();
		
		if(culinaria.getTituloReceita() != null){
			
			String fotoNome [] = culinaria.getFotoReceita().split("/");
			
			request.setAttribute("titulo", culinaria.getTituloReceita());
			request.setAttribute("descricao", culinaria.getDescricacaoReceita());
			request.setAttribute("imagem",fotoNome[9]);
			request.setAttribute("dataPub", culinaria.getDataPub());
			
			request.setAttribute("receita", culinaria);
			
			request.getRequestDispatcher("listaReceita.jsp").forward(request, response);
		}
			request.setAttribute("titulo", culinaria.getTituloReceita() == null ? "" : culinaria.getTituloReceita());
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
