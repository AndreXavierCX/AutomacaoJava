package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Database;
import dao.DepartmentDAO;
import model.Department;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		conn = Database.getConnection();
		//conn ja consegue fazer conexão com o banco
		//usando a conexão estabelecida "conn" com o connector jdbc
		//postgreesql
		DepartmentDAO dao = new DepartmentDAO(conn);
		for (Department department : dao.selectAllDepartment()) {
			System.out.println(department.name);
		}
			
	}

}
