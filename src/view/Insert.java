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

public class Insert {

	private JFrame frame;
	private JTextField tbId;
	private JTextField tbNome;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert window = new Insert();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Insert() {
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
		tbId.setBounds(76, 106, 86, 20);
		frame.getContentPane().add(tbId);
		tbId.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(51, 109, 15, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(33, 140, 40, 14);
		frame.getContentPane().add(lblNome);
		
		tbNome = new JTextField();
		tbNome.setColumns(10);
		tbNome.setBounds(76, 137, 86, 20);
		frame.getContentPane().add(tbNome);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tbId.getText());
				String nome = tbNome.getText();
				conex.botaPessoa(id, nome);
			}
		});
		btnNewButton.setBounds(213, 105, 143, 49);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblAdicionarPessoasAo = new JLabel("Adicionar pessoas ao banco de dados");
		lblAdicionarPessoasAo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAdicionarPessoasAo.setBounds(62, 23, 294, 38);
		frame.getContentPane().add(lblAdicionarPessoasAo);
	}
}
