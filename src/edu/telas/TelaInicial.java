package edu.telas;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.utils.CarregarConfig;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends TelaPadrao {
	private static final long serialVersionUID = 1L;
	private JButton btnMarca;
	private JLabel lblCadastroMarcas;
	private JButton btnLancarNotas;
	private JLabel lblNotas;
	private JButton btnRelatorioNotas;
	private JLabel lblRelatorioNotas;
	private JButton btnAlterarNotas;
	private JLabel lblAlterarNotas;
	private JButton btnAlterarPendencia;
	private JLabel lblAlterarPendencia;

	public TelaInicial() {
		ConfigComponentes();
		AddComponentes();
	}

	private void ConfigComponentes() {
		panel_1.setLayout(null);
		btnMarca = new JButton("");
		btnMarca.setBackground(new Color(204, 204, 204));
		btnMarca.setBounds(51, 30, 150, 150);
		btnMarca.setBorder(null);

		lblCadastroMarcas = new JLabel("Cadastro de Marcas");
		lblCadastroMarcas.setFont(new Font("Microsoft Tai Le", Font.BOLD, 13));
		lblCadastroMarcas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMarcas.setBounds(51, 11, 150, 14);

		btnLancarNotas = new JButton("");
		btnLancarNotas.setBackground(new Color(204, 204, 204));
		btnLancarNotas.setBounds(229, 30, 150, 150);
		btnLancarNotas.setBorder(null);

		lblNotas = new JLabel("Lançamento de Notas");
		lblNotas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotas.setFont(new Font("Microsoft Tai Le", Font.BOLD, 13));
		lblNotas.setBounds(229, 11, 150, 14);
		
		btnRelatorioNotas = new JButton("");
		btnRelatorioNotas.setBackground(new Color(204, 204, 204));
		btnRelatorioNotas.setBounds(406, 30, 150, 150);
		btnRelatorioNotas.setBorder(null);
		
		lblRelatorioNotas = new JLabel("Relatório de Notas");
		lblRelatorioNotas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatorioNotas.setFont(new Font("Microsoft Tai Le", Font.BOLD, 13));
		lblRelatorioNotas.setBounds(406, 11, 150, 14);
		
		btnAlterarNotas = new JButton("");
		btnAlterarNotas.setBackground(new Color(204, 204, 204));
		btnAlterarNotas.setBounds(577, 30, 150, 150);
		btnAlterarNotas.setBorder(null);
		
		lblAlterarNotas = new JLabel("Alterar Notas");
		lblAlterarNotas.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarNotas.setFont(new Font("Microsoft Tai Le", Font.BOLD, 13));
		lblAlterarNotas.setBounds(577, 11, 150, 14);
		
		btnAlterarPendencia = new JButton("");
		btnAlterarPendencia.setBackground(new Color(204, 204, 204));
		btnAlterarPendencia.setBounds(51, 210, 150, 150);
		btnAlterarPendencia.setBorder(null);
		
		lblAlterarPendencia = new JLabel("Alterar Pendência");
		lblAlterarPendencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarPendencia.setFont(new Font("Microsoft Tai Le", Font.BOLD, 13));
		lblAlterarPendencia.setBounds(51, 191, 150, 14);
		
		btnMarca.setIcon(new ImageIcon(CarregarConfig.ImagensURL + "icone_marca.png"));
		btnLancarNotas.setIcon(new ImageIcon(CarregarConfig.ImagensURL + "icone_nota.png"));
		btnRelatorioNotas.setIcon(new ImageIcon(CarregarConfig.ImagensURL + "icone_relatorio.png"));
		btnAlterarNotas.setIcon(new ImageIcon(CarregarConfig.ImagensURL + "icone_alterarnota.png"));
		btnAlterarPendencia.setIcon(new ImageIcon(CarregarConfig.ImagensURL + "icone_alterarpendencia.png"));
		
		btnMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroMarcas();
			}
		});
		btnLancarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRelatorioNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlterarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlterarPendencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	private void AddComponentes() {
		panel_1.add(btnMarca);
		panel_1.add(lblCadastroMarcas);
		panel_1.add(btnLancarNotas);
		panel_1.add(lblNotas);
		
		/* Adiciona o Botão Apenas se o Usuário Tiver Permissão */
		//if (SisNotasMain.Permissao.equals("ADM")) {
			panel_1.add(btnRelatorioNotas);
			panel_1.add(lblRelatorioNotas);
			panel_1.add(btnAlterarNotas);
			panel_1.add(lblAlterarNotas);
			panel_1.add(btnAlterarPendencia);
			panel_1.add(lblAlterarPendencia);
		//}
	}
}
