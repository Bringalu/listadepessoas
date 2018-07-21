package sqlcon;

import java.sql.*;
import view.Gui;

public class Conex {
	
	
	//Info do banco de dados
	public static String DRIVER = "com.mysql.jdbc.Driver";
	public static String URL = "jdbc:mysql://localhost:3306/bdd";
	public static String USER = "root";
	public static String SENHA = "";
	Connection cone = null;
	Statement state = null;
	
	public void conexao() { 		//Função que conecta ao banco de dados
			try {
				Class.forName(DRIVER);
				cone = DriverManager.getConnection(URL, USER, SENHA);
				Gui.alertar("Conexão bem sucedida");
			} catch (SQLException e) {} catch (ClassNotFoundException e) {	}	
	}
	
	public void fechaConexao() { 	//Função que desconecta o banco de dados
		 try{
	         if(cone!=null) {
	            cone.close();
	            Gui.alertar("Conexão finalizada com sucesso");
	         }
	         }catch(SQLException se){}
}
	
	public void botaPessoa(int id, String nome) { //Funcão que adiciona pessoas ao banco de dados
		conexao();
		try {
			state = cone.createStatement();
			String sql = "INSERT INTO pessoa " + String.format("VALUES (%d, '%s')", id, nome);
			state.executeUpdate(sql);
			Gui.alertar("Pessoa adicionada com sucesso");
		} catch (SQLException e) {
			Gui.alertar("Erro ao adicionar pessoa a tabela");
		}
		fechaConexao();
	}
	
	public void tiraPessoa(int id) { //Funcão que remove pessoas do banco de dados
		conexao();
		try {
			state = cone.createStatement();
			String sql = String.format("DELETE FROM pessoa WHERE id='%d';", id);
			state.executeUpdate(sql);
			Gui.alertar("Pessoa removida com sucesso");
		} catch (SQLException e) {
			Gui.alertar("Erro ao remover pessoa a tabela");
		}
		fechaConexao();
	}
	
}
