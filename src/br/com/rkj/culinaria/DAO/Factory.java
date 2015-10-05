package br.com.rkj.culinaria.DAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Factory<E> {

	static final String SERVIDOR = "jdbc:mysql://localhost:3306/Culinaria";
	static final String BDNOME = "com.mysql.jdbc.Driver";
	static final String USUARIO = "root";
	static final String SENHA = "Mor&no27*1";
	protected Connection connection = null;
	protected Statement statement = null;
	protected ResultSet resultSet = null;

	public Factory() {
		super();
	}

	public void conexao() throws ClassNotFoundException {

		String url = SERVIDOR;
		String usuario = USUARIO;
		String senha = SENHA;

		try {
			System.out.println("Passando o nome do banco de dados: " + BDNOME);
			Class.forName(BDNOME);
			System.out.println("Conectando passando path, usuario e senha ");
			this.connection = (Connection) DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexao feita com sucesso");
			System.out.println("creating statement para inserir dados na tabela");
			this.statement = (Statement) this.connection.createStatement();
			System.out.println("creatStatement feito com sucesso");
		} catch (Exception e) {
			System.out.println("erro ao conectar se ao banco " + e);
			Logger.getLogger("erro ao conectar-se ao banco ");
		}
	}

	public boolean estaConectado() {
		if (this.connection != null) {

			return true;
		}
		return estaConectado();
	}

	public void desconectar() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			Logger.getLogger(String.format("Nao foi possivel fechar a conexao ", e));
		}
	}

	/*
	 * gerando ID unica para fotos
	 * 
	 */
	public String generatingPhotoId() throws NoSuchAlgorithmException {

		SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
		String randomNum = new Integer(prng.nextInt()).toString();
		byte [] resultado = null;
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			 resultado = sha.digest(randomNum.getBytes());

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hexEncode(resultado);
	}
	/*
	 * metodo que gera id na base 16(hexadecimal)
	 */
	private static String hexEncode(byte[] resutaldo) {

		StringBuilder result = new StringBuilder();

		char[] digitos = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		for (int id = 0; id < resutaldo.length; ++id) {

			byte b = resutaldo[id];

			result.append(digitos[(b & 0xf0) >> 4]);

			result.append(digitos[b & 0x0f]);

		}

		return result.toString();

	}


}