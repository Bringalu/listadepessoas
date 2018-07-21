package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import sqlcon.Conex;
import javax.swing.UIManager;
import java.awt.Window.Type;

public class Remove {

	private JFrame frame;
	private JTextField tbId;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Remove window = new Remove();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Remove() {
		initialize();
	}

	Conex conex = new Conex();
	
	public void pisca() {
		if(frame.isVisible() == true) {
			frame.setVisible(false);
		}else if(frame.isVisible() == false) {
			frame.setVisible(true);
		}
	
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 415, 236);
		frame.getContentPane().setLayout(null);
		
		tbId = new JTextField();
		tbId.setBounds(76, 118, 86, 20);
		frame.getContentPane().add(tbId);
		tbId.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(51, 121, 15, 14);
		frame.getContentPane().add(lblId);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tbId.getText());
				conex.tiraPessoa(id);
			}
		});
		btnNewButton.setBounds(213, 104, 143, 49);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblAdicionarPessoasAo = new JLabel("Remover pessoas do banco de dados");
		lblAdicionarPessoasAo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAdicionarPessoasAo.setBounds(62, 23, 294, 38);
		frame.getContentPane().add(lblAdicionarPessoasAo);
	}
}
