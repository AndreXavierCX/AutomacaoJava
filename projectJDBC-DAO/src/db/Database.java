package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
	// Classe Databaase sera classe que fará a conexão com BO postgreSQL
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn == null) {
			Properties props = loadProperties();
			// recupera a propriedade BDURL do arquivo db.properties
			String url = props.getProperty("dburl");
			try {
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return conn;
	}
	
	private static Properties loadProperties() {
		// importa a classe FileInputStream (java.io)
		try(FileInputStream fs = new FileInputStream("db.Properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}

		return null;
	}
}
