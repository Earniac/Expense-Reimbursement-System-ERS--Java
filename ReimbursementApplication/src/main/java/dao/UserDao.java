package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao implements UserDaoInterface {

	/*
	 * This static method connects to the JDBC driver
	 */
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Static block has failed me");
		}
	}


	/*
	 * logs a user into an account
	 */
	public boolean login(User user) {

		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername().toLowerCase());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User(rs.getString("ers_username"), rs.getString("ers_password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/*
	 * Determines the type of user logging into an account
	 */
	public int employeeType(String username) {
		int id = 0;
		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "SELECT user_role_id FROM ers_users WHERE ers_username = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			System.out.println("dao layer: " + username);
			ps.setString(1, username.toLowerCase());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getInt("user_role_id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

		return id;
	}

}
