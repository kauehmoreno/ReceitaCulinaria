package br.com.rkj.culinaria.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import br.com.rkj.culinaria.Receita;
import br.com.rkj.culinaria.DAO.ConexaoArquivo;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile")
@MultipartConfig
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletFileUpload uploader = null;
	private static final Logger logger = Logger.getLogger(ReceitaSaving.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {

		logger.info("Entrei no init");
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();

		 File filesDir = (File)
		 getServletContext().getAttribute("FILES_DIR_FILE");

		//File filesDir = new File(getServletContext().getRealPath("/"));

		logger.info("Meu novo arquivo instanciado " + filesDir);

		fileFactory.setRepository(filesDir);
		
		getServletContext().setAttribute("FILES_DIR", filesDir);
		
		this.uploader = new ServletFileUpload(fileFactory);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("estou no doGet");
		String fileName = request.getParameter("fileUpload");

		if (fileName == null || fileName.equals("")) {

			throw new ServletException("File Name can't be null or empty");

		}

		File file = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + fileName);

		if (!file.exists()) {

			throw new ServletException("File doesn't exists on server.");

		}

		System.out.println("File location on server::" + file.getAbsolutePath());

		ServletContext ctx = getServletContext();

		InputStream fis = new FileInputStream(file);

		String mimeType = ctx.getMimeType(file.getAbsolutePath());

		response.setContentType(mimeType != null ? mimeType : "application/octet-stream");

		response.setContentLength((int) file.length());

		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

		ServletOutputStream os = response.getOutputStream();

		byte[] bufferData = new byte[1024];

		int read = 0;

		while ((read = fis.read(bufferData)) != -1) {

			os.write(bufferData, 0, read);

		}

		os.flush();

		os.close();

		fis.close();

		System.out.println("File downloaded at client successfully");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		File arquivo = new File("");
		Receita receita = new Receita();
		ConexaoArquivo<ReceitaSaving> conectar = new ConexaoArquivo<>();

		if (!ServletFileUpload.isMultipartContent(request)) {

			throw new ServletException("Content type is not multipart/form-data");

		}

		response.setContentType("text/html");

		try {
			
			Map<String, List<FileItem>> fileItemsList = uploader.parseParameterMap(request);
		
 			boolean elementos = fileItemsList.entrySet().iterator().hasNext();

			while (elementos) {
				
				Set<Entry<String, List<FileItem>>> fileItemsIterator = fileItemsList.entrySet();

				List<FileItem> fileItems = fileItemsIterator.iterator().next().getValue();

				FileItem fileItem = (FileItem) fileItems.get(0);
				
				System.out.println(fileItem);
			
				String item [] = fileItem.toString().split(",");
				
				File arquivoUploader = new File(item[1]);
				
				
				arquivo = new File(
						getServletContext().getAttribute("FILES_DIR") +File.separator + fileItem.getName());
				
				
				arquivoUploader.renameTo(arquivo);
				
				//FileUtils.copyDirectory(fileItem, arquivo);
				
			//	arquivo.delete();
				
			//	if(arquivo.renameTo(cassino)){
					
			//		logger.info("foi");
				//}
				
				arquivo.getAbsolutePath();
				System.out.println("arquivo" + arquivo.getAbsolutePath());

				elementos = false;
			}

		} catch (FileUploadException e) {

			System.out.println("Exception in uploading file." + e);

		} catch (Exception e) {

			System.out.println("Exception in uploading file." + e);

		}

		String fotoid = request.getSession().getAttribute("fotoIDGerada").toString();

		receita.setFotoReceita(arquivo.getAbsolutePath().toString());
		receita.setFotoId(fotoid);


		try {
			logger.info("Conectando...");
			conectar.conexao();
			logger.info("conexao feita com sucesso");
			logger.info("salvando path da foto fileItemsList: " + receita.getFotoReceita() + "..." + receita.getFotoId() + "/");
			logger.info("gerando id da photo");
			conectar.salvar(receita.getFotoReceita(), receita.getFotoId());
			logger.info("salvo com sucesso");
			logger.info("desconectando...");
			conectar.desconectar();
		} catch (ClassNotFoundException e) {

			System.out.println("Ocorreu um erro a conectar-se ao banco" + e);
		}

		request.getRequestDispatcher("listaReceita.jsp").forward(request, response);

	}

}
