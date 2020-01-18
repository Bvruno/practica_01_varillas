package com.isil.practica01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isil.practica01.model.Auto;
import com.isil.practica01.util.Constants;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table autos in the database.
 * 
 * @author Bruno Varillas
 *
 */
public class AutoDAO {

	public AutoDAO() {
	}


	public void insertAuto(Auto auto) throws SQLException {
		System.out.println(Constants.INSERT_AUTOS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = Conexion.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Constants.INSERT_AUTOS_SQL)) {
			preparedStatement.setString(1, auto.getModelo());
			preparedStatement.setString(2, auto.getColor());
			preparedStatement.setString(3, auto.getMarca());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Auto selectAuto(int id) {
		Auto auto = null;
		// Step 1: Establishing a Connection
		try (Connection connection = Conexion.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(Constants.SELECT_AUTO_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String modelo = rs.getString("modelo");
				String color = rs.getString("color");
				String marca = rs.getString("marca");
				auto = new Auto(id, modelo, color, marca);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return auto;
	}

	public List<Auto> selectAllAutos() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Auto> autos = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = Conexion.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(Constants.SELECT_ALL_AUTOS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String modelo = rs.getString("modelo");
				String color = rs.getString("color");
				String marca = rs.getString("marca");
				autos.add(new Auto(id, modelo, color, marca));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return autos;
	}

	public boolean deleteAuto(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = Conexion.getConnection();
				PreparedStatement statement = connection.prepareStatement(Constants.DELETE_AUTOS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateAuto(Auto auto) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = Conexion.getConnection();
				PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_AUTOS_SQL);) {
			statement.setString(1, auto.getModelo());
			statement.setString(2, auto.getColor());
			statement.setString(3, auto.getMarca());
			statement.setInt(4, auto.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
