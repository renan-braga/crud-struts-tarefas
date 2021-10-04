package org.apache.struts.example.crud.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static Conexao conexao = null;
	private static Connection dataSource = null;
	private String url = "jdbc:mysql://localhost:3306/prova_remsoft";
	private String usuario = "renan";
	private String senha = "root";
	
	private Conexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.dataSource = DriverManager.getConnection(url, usuario, senha);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexao() {
		return dataSource;
	}
	
	public static Conexao getInstance() {
		if(conexao == null) {
			conexao = new Conexao();
		}
		return conexao;
	}

}
