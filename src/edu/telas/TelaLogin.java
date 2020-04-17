package edu.telas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import edu.SisNotasMain;
import edu.database.ConexaoDB;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JLabel lblUsuario;
	private JButton btnAcessar;
	private JPasswordField passwordField;
	private JLabel lblSenha;

	public TelaLogin() {

		initComponents();
	}

	private void initComponents() {
		setTitle("Login");
		setSize(400, 350);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setUndecorated(true);

		lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(10, 83, 380, 24);
		getContentPane().add(lblUsuario);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);

		txtUsuario = new JTextField();
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUsuario.setText(null);
				passwordField.setText(null);
			}
		});
		txtUsuario.setBounds(10, 108, 380, 35);
		getContentPane().add(txtUsuario);
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setColumns(10);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 154, 380, 24);
		getContentPane().add(lblSenha);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnAcessar = new JButton("Entrar");
		btnAcessar.setBackground(new Color(72, 61, 139));
		btnAcessar.setForeground(new Color(255, 255, 255));
		btnAcessar.setBounds(10, 225, 380, 50);
		btnAcessar.setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().add(btnAcessar);
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IniciaLogin();
			}
		});
		btnAcessar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					IniciaLogin();
				}
			}
		});

		passwordField = new JPasswordField();
		passwordField.setBounds(10, 179, 380, 35);
		getContentPane().add(passwordField);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 127));
		panel.setBounds(0, 0, 400, 72);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblLoginDeAcesso = new JLabel("Login de Acesso");
		lblLoginDeAcesso.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblLoginDeAcesso.setForeground(new Color(255, 255, 255));
		lblLoginDeAcesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginDeAcesso.setBounds(10, 11, 380, 56);
		panel.add(lblLoginDeAcesso);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSair.setBackground(new Color(250, 128, 114));
		btnSair.setBounds(10, 289, 380, 50);
		getContentPane().add(btnSair);

		setVisible(true);
	}

	@SuppressWarnings("deprecation")
	private void IniciaLogin() {
		if (txtUsuario.getText().equals("") || passwordField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o Usuário e Senha!");
			return;
		}
		ConexaoDB con = new ConexaoDB();
		try {
			con.ConsultaSQL("select * from usuario where login = '" + txtUsuario.getText() + "'");
			con.result.first();
			if (con.result.getString("senha").equals(passwordField.getText())) {
				dispose();
				SisNotasMain.Logado = true;
				SisNotasMain.Usuario = txtUsuario.getText();
				int Perm = con.result.getInt("permissao");
				SalvaPermissao(Perm);
				new TelaInicial();
			} else {
				JOptionPane.showMessageDialog(null, "Senha Incorreta!");
			}
		} catch (SQLException b) {
			JOptionPane.showMessageDialog(null, "Usuário NÃO Encontrado!\n");
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Usuário NÃO Encontrado!\n");
		}
	}

	private void SalvaPermissao(int Perm) {
		ConexaoDB con = new ConexaoDB();
		try {
			con.ConsultaSQL("select * from permissaousuario where idPermissaoUsuario = '" + Perm + "'");
			con.result.first();
			SisNotasMain.Permissao = con.result.getString("permissao");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível Verificar sua Permissão:\n" + e.getMessage());
		}
	}
}
