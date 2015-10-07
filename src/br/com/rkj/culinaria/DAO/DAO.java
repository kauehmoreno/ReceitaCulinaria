/**
 * 
 */
package br.com.rkj.culinaria.DAO;

import java.util.HashMap;
import java.util.List;

import br.com.rkj.culinaria.Receita;




/**
 * @author kaueh
 *
 */
public interface DAO<E>{
	
	
	public HashMap<String,Object> recuperarPorId(Object id);
	public void salvar(String titulo, String descricao, String fotoId);
	public void excluir(Object id);
	public List<Receita>listarTodos();
	public Receita search(String search);

}
