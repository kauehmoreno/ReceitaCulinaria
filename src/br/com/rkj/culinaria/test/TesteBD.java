package br.com.rkj.culinaria.test;



import java.util.logging.Logger;

import br.com.rkj.culinaria.Receita;
import br.com.rkj.culinaria.DAO.ConexaoBd;

public class TesteBD {
	

	public static void main(String[] args) {
		
		ConexaoBd<Receita> conectar = new ConexaoBd<>();
		
		try {
			System.out.println("Abrindo conexao com banco de dados");
			conectar.conexao();
			System.out.println("Salvando dados no banco de dados, chamadado metodo que ira inserir os dados");
			conectar.salvar("kaueh", "kauehlindo","dearw243323241");
		} catch (ClassNotFoundException e) {
			Logger.getLogger("erro ao conectar-se ao banco ", e.getMessage());
		}
		System.out.println("Apos inserir dados, desconectando a conexao com o banco de dados");
		conectar.desconectar();
		System.out.println("Estou desconectado ? " + conectar.estaConectado());
		System.out.println(conectar.estaConectado());
	
	}
		
}
