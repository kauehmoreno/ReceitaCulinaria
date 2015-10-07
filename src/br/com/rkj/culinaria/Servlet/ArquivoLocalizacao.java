/**
 * 
 */
package br.com.rkj.culinaria.Servlet;

import java.io.File;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.rkj.culinaria.utils.ReceitaSaving;

/**
 * @author kaueh
 *
 */
@WebListener
public class ArquivoLocalizacao implements ServletContextListener {

	private static final Logger logger = Logger.getLogger(ReceitaSaving.class.getName());
	private static final String DIRETORIO_PROJETO = "/developer/EclipseProjects/";
	private static final String DIRETORIO_INTO_PROJETO = "ReceitaCulinaria/WebContent/WEB-INF";
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		//String caminhoRoot = System.getProperty("catalina.home");
		
		String caminhoRoot = System.getProperty("user.dir");

		ServletContext contextoServlet = servletContextEvent.getServletContext();

		String caminhoRelativo = contextoServlet.getInitParameter("tempfile.dir");
		
		String contexto = servletContextEvent.getServletContext().getRealPath("/");
		
		System.out.println("contexto" + contexto);
		
		logger.info("caminhoroot --> " + caminhoRoot);
		logger.info("caminho relativo " + caminhoRelativo);
		logger.info("caminho contextServlet " + contextoServlet);
		File file = new File(caminhoRoot + DIRETORIO_PROJETO + DIRETORIO_INTO_PROJETO + File.separator  +  caminhoRelativo);

		if (!file.exists())
			file.mkdir();

		logger.info("Diretorio do arquivo criado para ser usado ao salvar arquivos");

		contextoServlet.setAttribute("FILES_DIR_FILE", file);
		
		logger.info("arquivo file " +file);

		contextoServlet.setAttribute("FILES_DIR",  DIRETORIO_PROJETO + DIRETORIO_INTO_PROJETO + File.separator  +  caminhoRelativo);
		
		logger.info("ContextServlet " + DIRETORIO_PROJETO + DIRETORIO_INTO_PROJETO + File.separator  +  caminhoRelativo);
		
		logger.info("Servlet Context is initialized....");
		 
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		 System.out.println("Servlet Context is destroyed....");		
	}

}
