package pontoDeControle.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	   private final String host = "";
	   private final String user = "";
	   private final String password = "";
	   private final String dataBase = "";
		
	   public PreparedStatement stmt;
	   public ResultSet rs;	
		
	    public Connection getConnection() {
	        try {
	        	String url = "jdbc:sqlserver://" + host + ";databaseName=" + dataBase +";user=" + user + ";password=" + password + ";";
	            return DriverManager.getConnection(url);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	}

