/**
 * 
 */
package br.com.rkj.culinaria.DAO;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import com.mysql.jdbc.Statement;

import br.com.rkj.culinaria.Receita;
import br.com.rkj.culinaria.utils.ReceitaSaving;



/**
 * @author kaueh
 * @param <E>
 *
 */
public class ConexaoBd<E> extends Factory<E>  implements DAO<E>{

	private static final Logger logger = Logger.getLogger(ReceitaSaving.class.getName());
	/*
 * (non-Javadoc)
 * @see br.com.rkj.culinaria.DAO.DAO#recuperarPorId(java.lang.Object)
 */
	@Override
	public HashMap<String, Object> recuperarPorId(Object id) {
		HashMap<String,Object> receita = new HashMap<String,Object>();
		String query = "SELECT * FROM receita WHERE id ="+id+";";
		
		try {
			this.statement.executeQuery(query);
			
			receita.put("Titulo", this.resultSet.getString("titulo_receita"));
			receita.put("Descricao", this.resultSet.getString("descricao_receita"));
			receita.put("Imagem", this.resultSet.getString("foto_receita"));
			receita.put("DataPub", this.resultSet.getTimestamp("create_time"));
			
		} catch (SQLException e) {
			Logger.getLogger(String.format("Nao foi possivel executar query para trazer objetos por id", e));
		}
		
		return  null;
	}
	/*
	 * (non-Javadoc)
	 * usando executeUpdate para inserir e update de objetos no banco, trata erro de sqlException que o executeQuery pode causar
	 * @see br.com.rkj.culinaria.DAO.DAO#salvar(java.lang.String, java.lang.String)
	 */
	@Override
	public void salvar(String titulo, String descr,String fotoId) {
		
		String query = "INSERT INTO receita "
				+ "(titulo_receita, descricao_receita,id_foto) VALUES "
				+ "('"+titulo+"','"+ descr+"','"+fotoId+"');";
		try {
			System.out.println("Executando query: "+ query);
			this.statement.executeUpdate(query);
			System.out.println("query executada com sucesso");
		} catch (SQLException e) {
			Logger.getLogger(String.format("Nao foi possivel inserir os dados no BD"));
			
			
		}
	}
	@Override
	public void excluir(Object id) {
		String query = "DELETE FROM receita WHERE id =" + id + ";";
		
		try {
			this.statement.executeQuery(query);
		} catch (SQLException e) {
			Logger.getLogger(String.format("Houve um erro ao apagar objeto", e));
			
		}
	}
	/*
	* retornar lista de objetos do banco 
	*/
	@Override
	public List<Receita> listarTodos() {
	
		Receita culinaria = new Receita();
		List<Receita> receitaList = new ArrayList<>();
		String query = "SELECT * FROM receita titulo_receita ORDER BY create_time;";
		try {
			this.resultSet = this.statement.executeQuery(query);
			this.statement = (Statement) this.connection.createStatement();
			
			while(this.resultSet.next()){
				
				culinaria.setTituloReceita(this.resultSet.getString("titulo_receita"));
				culinaria.setDescricacaoReceita(this.resultSet.getString("descricao_receita"));
				culinaria.setFotoReceita(this.resultSet.getString("foto_receita"));
				culinaria.setFotoId(this.resultSet.getString("id_foto"));
				culinaria.setDataPub(this.resultSet.getTimestamp("create_time").toString());

			}
			receitaList.add(culinaria);
		} catch (SQLException e) {
			Logger.getLogger(String.format("Nao foi possivel executar query para listar objetos", e));
		}
		
		
		return receitaList;
	}
	/*
	 * ResultSet retorna uma lista de objetos do banco, o qual temos uma lista de atributos representados 
	 	por um hashmap com key e valeue para facilitar o acesso a esses atributos
	 *
	 */
	@Override
	public Receita search(String search) {
		Receita culinaria = new Receita();
		
		List<Receita> receitaList = new ArrayList<>(); 

		String query = "SELECT * FROM receita WHERE titulo_receita LIKE '%"+search+"%';";
		
		try{
			this.resultSet =this.statement.executeQuery(query);
			this.statement = (Statement) this.connection.createStatement();
			
			while(this.resultSet.next()){
				
				culinaria.setTituloReceita(this.resultSet.getString("titulo_receita"));
				culinaria.setDescricacaoReceita(this.resultSet.getString("descricao_receita"));
				culinaria.setFotoReceita(this.resultSet.getString("foto_receita"));
				culinaria.setFotoId(this.resultSet.getString("id_foto"));
				culinaria.setDataPub(this.resultSet.getTimestamp("create_time").toString());
				
				
			}
			
			
			receitaList.add(culinaria);
		}catch(SQLException e){
			logger.warning("Ouve um erro ao buscar os objetos:" + e);
		}
			
		return checkingemptyObject(culinaria);
	}
	
	public Receita checkingemptyObject(Receita culinaria){
		
		if(culinaria == null){
			return new Receita();
		}
		
		return culinaria;
	}

}
