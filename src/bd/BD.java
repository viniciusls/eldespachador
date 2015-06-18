package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BD {

	public Connection con = null;
	public PreparedStatement st = null;
	public ResultSet rs= null;
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	/////BANCO
	private final String DB = "eldespachador";
	
	////Login e Senha
	private final String URL = "jdbc:sqlserver://localhost:1433;databaseName="+DB;
	private final String LOGIN= "sa";
	private final String SENHA = "vini";
	
	public boolean getConnection(){
		try{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			System.out.println("Conectou...");
			return true;
		}catch(ClassNotFoundException e){
			System.out.println("Driver não encontrado");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.out.println("Falha ao requisitar conexão");
			e.printStackTrace();
			return false;
		}
	}
	public void close(){
		try{
			if(rs!=null) rs.close();
		}catch(SQLException erro){}
		
		try{
			if(st!=null)st.close();
			System.out.println("Desconectou....");
			
		}catch(SQLException erro){}

		try{
			if(con!=null)con.close();
			System.out.println("Desconectou...");
		}
		catch(SQLException erro){}
	}
	public static void main (String []args){
		BD bd = new BD();
		bd.getConnection();
	}

}


