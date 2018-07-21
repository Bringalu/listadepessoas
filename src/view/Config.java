package view;

import java.awt.EventQueue;
import sqlcon.Conex;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Window.Type;

public class Config {

	private JFrame frame;
	private JTextField tbUrl;
	private JTextField tbUser;
	private JTextField tbSenha;
	private JLabel lblSenha;
	private JButton btnAtualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Config window = new Config();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Config() {
		initialize();
	}
	
	public void pisca() {
		if(frame.isVisible() == true) {
			frame.setVisible(false);
		}else if(frame.isVisible() == false) {
			frame.setVisible(true);
		}
	
	}
	
	Conex conex = new Conex();
	
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 350, 218);
		frame.getContentPane().setLayout(null);
		
		tbUrl = new JTextField();
		tbUrl.setBounds(85, 26, 200, 20);
		frame.getContentPane().add(tbUrl);
		tbUrl.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(50, 29, 30, 14);
		frame.getContentPane().add(lblUrl);
		
		tbUser = new JTextField();
		tbUser.setColumns(10);
		tbUser.setBounds(85, 57, 200, 20);
		frame.getContentPane().add(tbUser);
		
		JLabel lblUser = new JLabel("USER:");
		lblUser.setBounds(45, 60, 30, 14);
		frame.getContentPane().add(lblUser);
		
		tbSenha = new JTextField();
		tbSenha.setColumns(10);
		tbSenha.setBounds(85, 90, 200, 20);
		frame.getContentPane().add(tbSenha);
		
		lblSenha = new JLabel("SENHA:");
		lblSenha.setBounds(39, 93, 47, 14);
		frame.getContentPane().add(lblSenha);
		
		btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conex.URL = "jdbc:mysql://" + tbUrl.getText();
				Conex.USER = tbUser.getText();
				Conex.SENHA = tbSenha.getText();
				conex.conexao();
				conex.fechaConexao();
				pisca();
			}
		});
		btnAtualizar.setBounds(121, 131, 89, 23);
		frame.getContentPane().add(btnAtualizar);
	}

}
