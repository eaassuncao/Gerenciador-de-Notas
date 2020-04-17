package edu.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ConexaoDB {

	public static Connection connect;
	public static Statement stm;
	public ResultSet result;

	public ConexaoDB() {
		ConexaoDB.connect = getConnection();
	}
	public Connection getConnection() {
		if (connect == null) {
			try {
				Properties props = CarregarPropriedades();
				String url = props.getProperty("dburl");
				connect = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao se Conectar ao Banco de Dados:\n" + e.getMessage());
			}
		}
		return connect;
	}
	public void ConsultaSQL(String sql) {
		try {
			stm = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			result = stm.executeQuery(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Executar.\n" + e.getMessage());
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
