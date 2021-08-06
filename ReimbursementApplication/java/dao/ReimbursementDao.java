package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reimbursement;

public class ReimbursementDao implements ReimbursementDaoInterface{

//	public static void main(String[] args) {
//		
//		ReimbursementDao dao = new ReimbursementDao();
//		
//		System.out.println(dao.createReim(new Reimbursement(2500,"testing","earniac",2)));
//	}
	
	static { 
	      try {
	          Class.forName("org.postgresql.Driver");
	      }catch(ClassNotFoundException e) {
	          e.printStackTrace();
	          System.out.println("Static block has failed me");
	      }
	}
	
	public boolean createReim(Reimbursement reim) {

		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "INSERT INTO ers_reimbursement (reimb_amount,reimb_submitted,reimb_description,reimb_author,reimb_status_id,reimb_type_id)\r\n"
					+ "VALUES (?,current_timestamp,?,?,1,?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reim.getAmount());
			ps.setString(2, reim.getReimburseDescrip());
			ps.setString(3, reim.getUsername());
			ps.setInt(4, reim.getTypeNum());

			ps.executeUpdate();

			System.out.println("Great! A reimbursement has been created!");

		} catch (SQLException e) {
			e.printStackTrace();
//			loggy.error("A SQL exception was thrown: ", e);
			return false;

		}

		return true;
	}

	public boolean updateReim(Reimbursement reim) {

		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "UPDATE ers_reimbursement \r\n"
					+ "SET reimb_resolved = current_timestamp, reimb_resolver = ?, reimb_status_id = ?\r\n"
					+ "WHERE reimb_id = ? AND reimb_status_id = 1;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, reim.getUsername());
			ps.setInt(2, reim.getStatusNum());
			ps.setInt(3, reim.getId());

			ps.executeUpdate();

			System.out.println("Great! A reimbursement has been updated!");

		} catch (SQLException e) {
			e.printStackTrace();
//		loggy.error("A SQL exception was thrown: ", e);
			return false;

		}

		return true;
	}

	public List<Reimbursement> allPending() {

		List<Reimbursement> list = new ArrayList<>();

		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "SELECT * FROM view_reimbursement WHERE \"status\" = 'Pending';";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Reimbursement(rs.getInt("Case ID"), rs.getString("First Name"), rs.getString("Last Name"),
						rs.getString("Username"), rs.getString("E-Mail"), rs.getString("Employee Role"),
						rs.getString("Reimbursement Type"), rs.getString("Reimbursement Description"),
						rs.getInt("Reimbursement Amount"), rs.getString("status"), rs.getString("Resolved By"),
						rs.getString("Time Submitted"), rs.getString("Resolved Time")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return list;
	}

	public List<Reimbursement> allAccepted() {

		List<Reimbursement> list = new ArrayList<>();

		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "SELECT * FROM view_reimbursement WHERE \"status\" = 'Accepted';";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Reimbursement(rs.getInt("Case ID"), rs.getString("First Name"), rs.getString("Last Name"),
						rs.getString("Username"), rs.getString("E-Mail"), rs.getString("Employee Role"),
						rs.getString("Reimbursement Type"), rs.getString("Reimbursement Description"),
						rs.getInt("Reimbursement Amount"), rs.getString("status"), rs.getString("Resolved By"),
						rs.getString("Time Submitted"), rs.getString("Resolved Time")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return list;
	}

	public List<Reimbursement> allDeclined() {

		List<Reimbursement> list = new ArrayList<>();

		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "SELECT * FROM view_reimbursement WHERE \"status\" = 'Declined';";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Reimbursement(rs.getInt("Case ID"), rs.getString("First Name"), rs.getString("Last Name"),
						rs.getString("Username"), rs.getString("E-Mail"), rs.getString("Employee Role"),
						rs.getString("Reimbursement Type"), rs.getString("Reimbursement Description"),
						rs.getInt("Reimbursement Amount"), rs.getString("status"), rs.getString("Resolved By"),
						rs.getString("Time Submitted"), rs.getString("Resolved Time")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return list;
	}
	
	
public List<Reimbursement> allReimbursement() {
		
		List<Reimbursement> list = new ArrayList<>();

		
		try (Connection conn = CustomConnectionFactory.getConnection()) {

			String sql = "SELECT * FROM view_reimbursement;";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery(); 

			while(rs.next()) {
				list.add(new Reimbursement(rs.getInt("Case ID"),rs.getString("First Name"),rs.getString("Last Name"),rs.getString("Username"),
						rs.getString("E-Mail"),rs.getString("Employee Role"),rs.getString("Reimbursement Type"),rs.getString("Reimbursement Description"),
						rs.getInt("Reimbursement Amount"),rs.getString("status"),rs.getString("Resolved By"),
						rs.getString("Time Submitted"),rs.getString("Resolved Time")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return list;
	}


public List<Reimbursement> userReimbursement(String name) {
	
	List<Reimbursement> list = new ArrayList<>();

	
	try (Connection conn = CustomConnectionFactory.getConnection()) {

		String sql = "SELECT * FROM view_reimbursement WHERE \"Username\" = ?;";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);


		ResultSet rs = ps.executeQuery(); 

		while(rs.next()) {
			list.add(new Reimbursement(rs.getInt("Case ID"),rs.getString("First Name"),rs.getString("Last Name"),rs.getString("Username"),
					rs.getString("E-Mail"),rs.getString("Employee Role"),rs.getString("Reimbursement Type"),rs.getString("Reimbursement Description"),
					rs.getInt("Reimbursement Amount"),rs.getString("status"),rs.getString("Resolved By"),
					rs.getString("Time Submitted"),rs.getString("Resolved Time")));
		}

	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	
	return list;
}

}
