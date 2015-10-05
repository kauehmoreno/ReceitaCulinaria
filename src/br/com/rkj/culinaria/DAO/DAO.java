/**
 * 
 */
package br.com.rkj.culinaria.DAO;

import java.util.HashMap;




/**
 * @author kaueh
 *
 */
public interface DAO<E>{
	
	
	public HashMap<String,Object> recuperarPorId(Object id);
	public void salvar(String titulo, String descricao, String fotoId);
	public void excluir(Object id);
	public HashMap<String,String>listarTodos();
	public HashMap<String,String>search(String search);

}
