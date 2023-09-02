package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import model.Department;

public class DepartmentDAO {
	private Connection conn;
	
	public DepartmentDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void insertDepartment(Department dados) {
		PreparedStatement preparedStatement = null;    
		try {
	            // Create SQL INSERT query
	            String insertQuery = "INSERT INTO department (name) VALUES (?)";

	            // Create PreparedStatement
	            preparedStatement = conn.prepareStatement(insertQuery);

	            // Set parameters (if needed)
	            preparedStatement.setString(1, dados.name);

	            // Execute the INSERT query
	            int rowsAffected = preparedStatement.executeUpdate();

	            System.out.println("Rows affected: " + rowsAffected);
	        } catch ( SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            try {
	                if (preparedStatement != null) preparedStatement.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}

	public void updateDepartment(Department dados) {
		PreparedStatement preparedStatement = null; 
		try {
	            // Create SQL INSERT query
	            String insertQuery = "UPDATE department set name=(?) where id = (?)";

	            // Create PreparedStatement
	            preparedStatement = conn.prepareStatement(insertQuery);

	            // Set parameters (if needed)
	            preparedStatement.setString(1, dados.name);
	            preparedStatement.setInt(2, dados.id);

	            // Execute the INSERT query
	            int rowsAffected = preparedStatement.executeUpdate();

	            System.out.println("Rows affected: " + rowsAffected);
	        } catch ( SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            try {
	                if (preparedStatement != null) preparedStatement.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}

	public void deleteDepartment(Department dados) {
		PreparedStatement preparedStatement = null;
		try {

            // Preparar a instrução SQL para a exclusão
        	String sql = "DELETE FROM department WHERE id = ?";
        	preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, dados.id);

            // Executar a instrução de exclusão
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

	public List<Department> selectDepartment(Department dados){
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = Database.getConnection();
        String sql = "Select * from Department where id = ?;";
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, dados.id);

            resultSet = preparedStatement.executeQuery();

            List<Department> result = new ArrayList<Department>();
            while (resultSet.next()) {
            	result.add(new Department(resultSet.getInt("id"), resultSet.getString("name")));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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

	public List<Department> selectAllDepartment() {
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = Database.getConnection();
        String sql = "Select * from Department;";
        
        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            List<Department> result = new ArrayList<Department>();
            while (resultSet.next()) {
            	result.add(new Department(resultSet.getInt("id"), resultSet.getString("name")));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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
}
