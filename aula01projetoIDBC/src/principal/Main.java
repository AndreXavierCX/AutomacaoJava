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
	
	public static boolean delete(Connection connection, int id) {
		PreparedStatement preparedStatement = null;
        try {

            // Preparar a instrução SQL para a exclusão
        	String sql = "DELETE FROM department WHERE id = ?";
        	preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            // Executar a instrução de exclusão
            int linhasAfetadas = preparedStatement.executeUpdate();

            // Verificar se a exclusão foi bem-sucedida
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public static void updade(Connection connection, String name, int id) {
		PreparedStatement preparedStatement = null;    
		try {
	            // Create SQL INSERT query
	            String insertQuery = "UPDATE department set name=(?) where id = (?)";

	            // Create PreparedStatement
	            preparedStatement = connection.prepareStatement(insertQuery);

	            // Set parameters (if needed)
	            preparedStatement.setString(1, name);
	            preparedStatement.setInt(2, id);

	            // Execute the INSERT query
	            int rowsAffected = preparedStatement.executeUpdate();

	            System.out.println("Rows affected: " + rowsAffected);
	        } catch ( SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            try {
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    
	}
	
	public static void insert(Connection connection, String name) {
		PreparedStatement preparedStatement = null;    
		try {
	            // Create SQL INSERT query
	            String insertQuery = "INSERT INTO department (name) VALUES (?)";

	            // Create PreparedStatement
	            preparedStatement = connection.prepareStatement(insertQuery);

	            // Set parameters (if needed)
	            preparedStatement.setString(1, name);

	            // Execute the INSERT query
	            int rowsAffected = preparedStatement.executeUpdate();

	            System.out.println("Rows affected: " + rowsAffected);
	        } catch ( SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            try {
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    
	}
	
	 public static void executeQuery(Connection connection, String sql) {
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            preparedStatement = connection.prepareStatement(sql);

	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                String valorColuna1 = resultSet.getString("id");
	                String valorColuna2 = resultSet.getString("name");

	                System.out.println("id: " + valorColuna1 + ", name: " + valorColuna2);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (resultSet != null) resultSet.close();
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
	/*public static void viewTable(Connection con, String query) throws SQLException {
	    try (Statement stmt = con.createStatement()) {
	      ResultSet rs = stmt.executeQuery(query);
	      while (rs.next()) {
	        String name = rs.getString("Name");
	      }
	    } catch (SQLException e) {
	    	
	    }
	  }*/

}
