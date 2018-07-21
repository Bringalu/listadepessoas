package view;

import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class Cred {

	private JFrame frmCrditos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cred window = new Cred();
					window.frmCrditos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cred() {
		initialize();
	}

	public void pisca() {
		if(frmCrditos.isVisible() == true) {
			frmCrditos.setVisible(false);
		}else if(frmCrditos.isVisible() == false) {
			frmCrditos.setVisible(true);
		}
	}

	private void initialize() {
		frmCrditos = new JFrame();
		frmCrditos.setResizable(false);
		frmCrditos.setType(Type.POPUP);
		frmCrditos.setTitle("Cr\u00E9ditos");
		frmCrditos.setBounds(100, 100, 450, 300);
		frmCrditos.getContentPane().setLayout(null);
		
		JLabel lblCalculadora = new JLabel("Lista de Pessoas");
		lblCalculadora.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblCalculadora.setBounds(95, 11, 266, 55);
		frmCrditos.getContentPane().add(lblCalculadora);
		
		JLabel lblFeitaPorLucca = new JLabel("Feita por: Lucca Bringhenti");
		lblFeitaPorLucca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFeitaPorLucca.setBounds(127, 90, 172, 14);
		frmCrditos.getContentPane().add(lblFeitaPorLucca);
		
		JLabel lblJavaNo = new JLabel("Java 8 no Eclipse");
		lblJavaNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJavaNo.setBounds(155, 115, 116, 14);
		frmCrditos.getContentPane().add(lblJavaNo);
		
		JButton btnCdigofonte = new JButton("C\u00F3digo-Fonte no Git");
		btnCdigofonte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
				    d.browse(new URI("https://github.com/Bringalu/Calculadora"));
				} catch (IOException | URISyntaxException e2) {
				    JOptionPane.showMessageDialog(null, "erro!");
				} 
			}
		});
		btnCdigofonte.setBounds(240, 151, 146, 76);
		frmCrditos.getContentPane().add(btnCdigofonte);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pisca();	
			}
		});
		btnOk.setBounds(47, 151, 146, 76);
		frmCrditos.getContentPane().add(btnOk);
	}

}