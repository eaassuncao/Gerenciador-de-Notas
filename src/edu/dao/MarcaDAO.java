package edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import edu.database.ConexaoDB;
import edu.model.Marca;
import edu.telas.CadastroMarcas;

public class MarcaDAO {
	private static Connection connection = ConexaoDB.connect;

	public static void CadastraMarca(Marca m) {
		String Nome = m.getNome_Marca();
		Nome = Nome.substring(0, 1).toUpperCase().concat(Nome.substring(1)); // Primeira Letra fica Maiúscula

		String sql = "INSERT INTO `mydb`.`marcas` (`Nome`) VALUES ('" + Nome + "');";
		PreparedStatement ps;
		if (VerificaCadastro(m) == false) {
			try {
				ps = connection.prepareStatement(sql);
				ps.execute();

				CadastroMarcas.Cadastrado();
				JOptionPane.showMessageDialog(null, "Marca Cadastrada com Sucesso!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao cadastra Marca.\n" + e.getMessage());
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Marca Já Cadastrada.");
		}
	}

	private static boolean VerificaCadastro(Marca m) {
		ConexaoDB cn = new ConexaoDB();
		try {
			cn.ConsultaSQL("select * from marcas where Nome = '" + m.getNome_Marca() + "'");
			cn.result.first();
			if (!cn.result.first()) {
				return false;
			}
			if (cn.result.getString("Nome").toLowerCase().equals(m.getNome_Marca().toLowerCase())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}