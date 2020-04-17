package edu.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private String Usuario;
	private String Senha;
	private String URL;
	public ConnectionFactory() {
		Properties props = CarregarPropriedades();
		URL = props.getProperty("dburl");
		Usuario = props.getProperty("user");
		Senha = props.getProperty("password");
	}
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, Usuario, Senha);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}
	}

	private static Properties CarregarPropriedades() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DBException(e.getMessage());
		}
	}
}
