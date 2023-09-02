package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Database;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		conn = Database.getConnection();
		//conn ja consegue fazer conexão com o banco
		//usando a conexão estabelecida "conn" com o connector jdbc
		//postgreesql
		/////fazer um select 
		//insert(conn, "Software");
		//executeQuery(conn, "Select * from department");
		//updade(conn, "Mecânica", 4);
		//delete(conn, 5);
	}

}
