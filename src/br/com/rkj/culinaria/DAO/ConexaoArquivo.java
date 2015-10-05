/**
 * 
 */
package br.com.rkj.culinaria.DAO;

import java.sql.SQLException;
import java.util.logging.Logger;

import br.com.rkj.culinaria.utils.ReceitaSaving;

/**
 * @author kaueh
 * @param <E>
 *
 */
public class ConexaoArquivo<E> extends Factory<E> implements UploadFileDAO{
	private static final Logger logger = Logger.getLogger(ReceitaSaving.class.getName());

	@Override
	public void salvar(String fotoPath, String fotoid) {
		System.out.println("estou motando a query:"+fotoPath +"/"+ fotoid);
		String query = "UPDATE receita SET foto_receita = '"+fotoPath+"' WHERE id_foto = '"+fotoid+"';";
		try {
			this.statement.executeUpdate(query);
		} catch (SQLException e) {
			logger.warning("Ocorreu um erro com a query --> " + e);
			
		}
		
	}

	
}
