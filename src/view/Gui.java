package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Gui {

	private JFrame frmLista;


	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frmLista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Gui() {
		initialize();
	}

	public static void alertar(String a) {
		JOptionPane.showMessageDialog(null, a);
	}
	
	//Instanciando classes
	Insert insert = new Insert();
	Remove remove = new Remove();
	Config config = new Config();
	Cred cred = new Cred();
	
	private void initialize() {
		frmLista = new JFrame();
		frmLista.setTitle("Lista");
		frmLista.setResizable(false);
		frmLista.setBounds(100, 100, 467, 341);
		frmLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLista.getContentPane().setLayout(null);
		
		JButton btnBota = new JButton("Inserir");
		btnBota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insert.pisca();		//Abre/Fecha janela da classe "insert"
			}
		});
		btnBota.setBounds(94, 160, 89, 82);
		frmLista.getContentPane().add(btnBota);
		
		JButton btnTira = new JButton("Remover");
		btnTira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove.pisca(); 	//Abre/Fecha janela da classe "remove"
			}
		});
		btnTira.setBounds(277, 160, 89, 82);
		frmLista.getContentPane().add(btnTira);
		
		JLabel lblListaDePessoas = new JLabel("LISTA DE PESSOAS");
		lblListaDePessoas.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblListaDePessoas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDePessoas.setBounds(79, 38, 295, 61);
		frmLista.getContentPane().add(lblListaDePessoas);
		
		JLabel lblFeitoPorLucca = new JLabel("Feito por: Lucca B.");
		lblFeitoPorLucca.setForeground(Color.LIGHT_GRAY);
		lblFeitoPorLucca.setBounds(10, 287, 100, 14);
		frmLista.getContentPane().add(lblFeitoPorLucca);
		
		JMenuBar menuBar = new JMenuBar();
		frmLista.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Configura\u00E7\u00F5es");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				config.pisca();		//Abre/Fecha janela da classe "config"
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cr\u00E9ditos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cred.pisca();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
	}
}
