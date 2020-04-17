package edu.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CarregarConfig {
	public final static String ImagensURL = Buscar("url_imagens");
	public static String Buscar(String cmd) {
		String resultado = null;
		try {
			Properties props = CarregarPropriedades();
			resultado = props.getProperty(cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	private static Properties CarregarPropriedades() {
		try (FileInputStream fs = new FileInputStream("Config.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}