package br.com.rkj.culinaria.utils;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.rkj.culinaria.Receita;
import br.com.rkj.culinaria.DAO.ConexaoBd;

/**
 * executar query para lista objetos Servlet implementation class ReceitaSaving
 */
@WebServlet("/Receita")
public class ReceitaSaving extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ReceitaSaving.class.getName());
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("eu estou no metodo doget");


		//request.getRequestDispatcher("listaReceita.jsp").forward(request, response);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				HashMap<String, String> receita = new HashMap<>();
				
				Receita receitaCulinaria = new Receita();
				
				String fotoid = null;
				
				receita.put("titulo", request.getParameter("tituloReceita"));
				receita.put("descricacao", request.getParameter("receita"));
				
				String titulo =receita.get("titulo"); 
				String descricao = receita.get("descricacao");
				
				receitaCulinaria.setTituloReceita(titulo);
				receitaCulinaria.setDescricacaoReceita(descricao);
				
				
				ConexaoBd<Receita> conexao = new ConexaoBd<>();
				try {
					logger.info("Conectando...");
					conexao.conexao();
					logger.info("conexao feita com sucesso");
					logger.info("gerando foto id");
					fotoid = conexao.generatingPhotoId();
					receitaCulinaria.setFotoId(fotoid);
					logger.info("id gerada com sucesso");
					logger.info("salvando dados: "+titulo+"/"+descricao+"/"+fotoid+"...");
					conexao.salvar(receitaCulinaria.getTituloReceita(), receitaCulinaria.getDescricacaoReceita(),
							receitaCulinaria.getFotoId());
					logger.info("salvo com sucesso");
					logger.info("desconectando...");
					conexao.desconectar();	
				} catch (ClassNotFoundException | NoSuchAlgorithmException e) {
					
					System.out.println("Ocorreu um excessao :" + e);
					Logger.getLogger(String.format("Ocorreu um erro ao conectar-se ao BD", e.getMessage()));
				}
				
				request.getSession().setAttribute("fotoIDGerada", fotoid);
		
		response.sendRedirect("uploadArquivo.jsp");
	}



}
