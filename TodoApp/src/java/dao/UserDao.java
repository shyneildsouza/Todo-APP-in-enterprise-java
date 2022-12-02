package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;
import dbcon.JDBCUtils;

public class UserDao {

	public int registerUser(User newuser) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO users"
				+ "  (first_name, last_name, username, password) VALUES "
				+ " (?, ?, ?, ?);";

		int result = 0;
		try (Connection connection = JDBCUtils.getConnection();
				
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1,newuser.getFirstName());
			preparedStatement.setString(2, newuser.getLastName());
			preparedStatement.setString(3, newuser.getUsername());
			preparedStatement.setString(4, newuser.getPassword());

			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			
			JDBCUtils.printSQLException(e);
		}
		return result;
	}

}
