package edu.telas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import edu.dao.MarcaDAO;
import edu.model.Marca;
import edu.utils.CarregarConfig;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class CadastroMarcas extends JFrame {
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private JPanel panel;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JLabel lblCancelar;
	private static JTextField txtMarca;

	public CadastroMarcas() {
		InitComponents();
	}

	private void InitComponents() {
		getContentPane().setBackground(new Color(128, 128, 128));
		
		setSize(400, 350);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 35, 380, 304);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(txtMarca.getText().equals("") || txtMarca.getText().equals(null))) {
					Marca m = new Marca(txtMarca.getText());
					MarcaDAO.CadastraMarca(m);
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(CarregarConfig.ImagensURL + "icone_btnsalvar.png"));
		btnSalvar.setBackground(new Color(192, 192, 192));
		btnSalvar.setBounds(82, 224, 60, 50);
		btnSalvar.setBorder(null);
		
		panel.add(btnSalvar);
		
		btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBackground(new Color(192, 192, 192));
		btnCancelar.setBounds(230, 224, 60, 50);
		btnCancelar.setBorder(null);
		btnCancelar.setIcon(new ImageIcon(CarregarConfig.ImagensURL + "icone_btnsair.png"));
		panel.add(btnCancelar);
		
		lblCancelar = new JLabel("Cancelar");
		lblCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setBounds(230, 279, 60, 14);
		panel.add(lblCancelar);
		
		JLabel lblSalvar = new JLabel("Salvar");
		lblSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalvar.setBounds(82, 279, 56, 14);
		panel.add(lblSalvar);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Microsoft Tai Le", Font.BOLD, 23));
		txtMarca.setHorizontalAlignment(SwingConstants.CENTER);
		txtMarca.setBounds(34, 77, 305, 60);
		panel.add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblMarca = new JLabel("Digite a Marca que deseja cadastrar");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setBounds(34, 60, 305, 14);
		panel.add(lblMarca);
		
		JLabel lblCadastroDeMarcas = new JLabel("CADASTRO DE MARCAS");
		lblCadastroDeMarcas.setBounds(0, 0, 400, 40);
		getContentPane().add(lblCadastroDeMarcas);
		lblCadastroDeMarcas.setFont(new Font("Microsoft Tai Le", Font.BOLD, 22));
		lblCadastroDeMarcas.setHorizontalAlignment(SwingConstants.CENTER);
		setUndecorated(true);
		
		setVisible(true);
	}
	public static void Cadastrado() {
		txtMarca.setText(null);
	}
}