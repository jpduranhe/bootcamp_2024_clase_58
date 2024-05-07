package cl.clase_58.shared.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

	private Connection conn;
	private ResultSet resultSet;
	private Statement stmt;
	
	
	protected void conectarDb() {
		try {
			if(conn==null || conn.isClosed()) {
				
				Class.forName("com.mysql.jdbc.Driver");
				String stringConection="jdbc:mysql://localhost:3306/personadb";
				String user="tester";
				String pass="Prueba1234";
				conn = DriverManager.getConnection(stringConection,user,pass);
				System.out.println("Conectado a la Base de Datos");
			}
			
		}catch(ClassNotFoundException ex) {
			System.out.println("Error:Driver no encontrado");
		}catch(SQLException ex) {
			System.out.println("Fallo:");
			System.out.println("SQLException:"+ ex.getMessage());
			System.out.println("SQLState:"+ ex.getSQLState());
			System.out.println("VendorError:"+ ex.getErrorCode());
		}
		
	}
	
	protected ResultSet consultar(String sql) {
		try {
			conectarDb();
			this.stmt= conn.createStatement();
			resultSet = stmt.executeQuery(sql);
			close();
			return resultSet;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}
	protected int ejecutarSql(String sql) {
		try {
			conectarDb();
			this.stmt= conn.createStatement();
			int regModificiados = stmt.executeUpdate(sql);
			
			close();
			return regModificiados;
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return 0;
		}
	}
	protected void close() {		
		try {
			
			if(stmt!=null) {
				stmt.close();
			}
			if(resultSet!=null) {
				resultSet.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.print("Error Cerrando"+e.getMessage());
		}
		
	}
	
	
}
