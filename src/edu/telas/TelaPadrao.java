package edu.telas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import edu.utils.CarregarConfig;

public class TelaPadrao extends JFrame {
	private static final long serialVersionUID = 1L;
	protected JPanel panel;
	protected JButton btnX;
	protected JButton btn_;
	protected JLabel lblTitle;
	protected JPanel panel_1;
	protected JLabel lblLogos;

	public TelaPadrao() {
		initComponents();
	}

	private void initComponents() {
		
		setSize(800,600);
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(0, 153, 255));
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 800, 600);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnX = new JButton("X");
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBackground(new Color(51, 51, 51));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnX.setFont(new Font("Microsoft Tai Le", Font.BOLD, 9));
		btnX.setBounds(755, 3, 43, 40);
		panel.add(btnX);
		
		btn_ = new JButton("-");
		btn_.setForeground(new Color(255, 255, 255));
		btn_.setBackground(new Color(51, 51, 51));
		btn_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		btn_.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		btn_.setBounds(715, 3, 43, 40);
		panel.add(btn_);
		
		lblTitle = new JLabel("Gerenciador de Notas");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Candara", Font.BOLD, 26));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 3, 798, 40);
		panel.add(lblTitle);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 45, 780, 544);
		panel.add(panel_1);
		panel_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(102, 102, 102)));
		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setLayout(null);
		
		lblLogos = new JLabel("");
		lblLogos.setBounds(10, 393, 760, 140);
		lblLogos.setIcon(new ImageIcon(CarregarConfig.ImagensURL + "logolojas.png"));
		panel_1.add(lblLogos);
		setUndecorated(true);
		setVisible(true);
	}
}
