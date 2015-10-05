package br.com.rkj.culinaria.test;

import br.com.rkj.culinaria.Receita;
import br.com.rkj.culinaria.DAO.ConexaoArquivo;

public class UploadTest {

	public static void main(String[] args) {
		
		ConexaoArquivo<Receita> conectar = new ConexaoArquivo<>();
		
		try {
			System.out.println("Abrindo conexao com banco de dados");
			conectar.conexao();
			System.out.println("Salvando dados no banco de dados, chamadado metodo que ira inserir os dados");
			conectar.salvar("/temp/kaueh","24b2c327f00c9d902b2ba7940e9faf1099a63986");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Apos inserir dados, desconectando a conexao com o banco de dados");
		conectar.desconectar();
		System.out.println("Estou desconectado ? " + conectar.estaConectado());
		System.out.println(conectar.estaConectado());
	}

}
