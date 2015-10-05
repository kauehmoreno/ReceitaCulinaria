/**
 * 
 */
package br.com.rkj.culinaria.DAO;

import java.util.HashMap;

import br.com.rkj.culinaria.Receita;



/**
 * @author kaueh
 *
 */
public interface DAO<E>{
	
	
	public HashMap<String,Object> recuperarPorId(Object id);
	public void salvar(String titulo, String descricao, String fotoId);
	public void excluir(Object id);
	public HashMap<String,Receita>listarTodos();
	public HashMap<String,Receita>search(String search);

}
