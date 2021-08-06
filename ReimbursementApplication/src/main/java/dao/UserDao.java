package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao implements UserDaoInterface {

//	public static void main(String[] args) {
//		
//		UserDao user = new UserDao();
//		
//
//		System.out.println(user.login(new User("test","test")));
//	}

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Static block has failed me");
		}
	}

//	public boolean createAcc(User user) {
//
//		try (Connection conn = CustomConnectionFactory.getConnection()) {
//
//			String sql = "INSERT INTO ers_users (ers_username,ers_password,user_first_name,user_last_name, user_email,user_role_id)\r\n"
//					+ "VALUES (?,?,?,?,?,?);";
//
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, user.getUsername().toLowerCase());
//			ps.setString(2, user.getPassword());
//			ps.setString(3, user.getFname());
//			ps.setString(4, user.getLname());
//			ps.setString(5, user.getEmail());
//			ps.setInt(6, user.getRole());
//
//			ps.executeUpdate();
//
//			System.out.println("Great! An account has been created!");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
////				loggy.error("A SQL exception was thrown: ", e);
//			return false;
//
//		}
//
//		return true;
//	}

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
