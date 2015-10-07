/**
 * 
 */
package br.com.rkj.culinaria;


import java.io.Serializable;


/**
 * @author kaueh
 *
 */
public class Receita implements Serializable{
	
	/**
	 *  caso seja usado num servidor usar o serializable 
	 */
	private static final long serialVersionUID = 7385245333447873280L;
	private int id;
	private String fotoId;
	private String tituloReceita;
	private String descricacaoReceita;
	private String fotoReceita;
	private String  dataPub;
	
	//construtores
	public Receita(){
		
	}
	public Receita(int id,String fotoId,String tituloReceita, String descricacaoReceita, String fotoReceita,String data) {
		this.tituloReceita = tituloReceita;
		this.descricacaoReceita = descricacaoReceita;
		this.fotoReceita = fotoReceita;
		this.fotoId = fotoId;
		this.id = id;
		this.dataPub = data;
	}


	//getters and setters
	
	/**
	 * @return the dataPub
	 */
	public String getDataPub() {
		return dataPub;
	}
	/**
	 * @param dataPub the dataPub to set
	 */
	public void setDataPub(String dataPub) {
		this.dataPub = dataPub;
	}
	/**
	 * @return the fotoId
	 */
	public String getFotoId() {
		return fotoId;
	}
	/**
	 * @param fotoId the fotoId to set
	 */
	public void setFotoId(String fotoId) {
		this.fotoId = fotoId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTituloReceita() {
		return tituloReceita;
	}
	public void setTituloReceita(String tituloReceita) {
		this.tituloReceita = tituloReceita;
	}
	public String getDescricacaoReceita() {
		return descricacaoReceita;
	}
	public void setDescricacaoReceita(String descricacaoReceita) {
		this.descricacaoReceita = descricacaoReceita;
	}
	public String getFotoReceita() {
		return fotoReceita;
	}
	public void setFotoReceita(String fotoReceita) {
		this.fotoReceita = fotoReceita;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receita other = (Receita) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
