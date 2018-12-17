package dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*; 
import beans.Reimbursement;
import util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	private static final String filename = "connection.properties";

	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> e1 = new ArrayList<Reimbursement>();
		// try-with-resources.. con will be closed at the end of the block
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			// write a join which unifies Bear, Cave, and BearType into a ResultSet
			// map the ResultSet's entries onto a list of Bear objects
			String sql = "SELECT * FROM REIMBURSEMENTS";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENTID");
				int employeeId = rs.getInt("EMPLOYEEID");
				String type = rs.getString("TYPE");
				String description = rs.getString("DESCRIPTION");
				Blob image = rs.getBlob("IMAGE");
				double amount = rs.getDouble("AMOUNT");
				Date dateSubmitted = rs.getDate("DATESUBMITTED");
				Date dateApproved = rs.getDate("DATEAPPROVED");

				e1.add(new Reimbursement(reimbursementId, employeeId, type, description, image, amount, dateSubmitted,
						dateApproved));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return e1;
	}

	public Date checkReimbursementStatus(int x) {
		Date r = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT DATEAPPROVED FROM REIMBURSEMENTS WHERE REIMBURSEMENTID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, x);
			ResultSet rs = stmt.executeQuery();
			r = rs.getDate("DATEAPPROVED");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r;
	}

	public void updateReimbursement(String column, String update, int x) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE TABLE REIMBURSEMENTS R SET ? = ? WHERE R.REIMBURSEMENTID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, column);
			stmt.setString(2, update);
			stmt.setInt(3, x);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteReimbursement(int x) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "DELETE * FROM REIMBURSEMENTS R WHERE R.REIMBURSEMENTID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, x);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void approveReimbursement(int x) {
		LocalDate today = LocalDate.now();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE TABLE REIMBURSEMENTS R SET DATEAPPROVED = ? WHERE R.REIMBURSEMENTID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, today);
			stmt.setInt(2, x);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void addNewReimbursement(int employeeId, String type, String description, Blob image, double amount) {
		Date today = new Date(2018);
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "INSERT INTO REIMBURSEMENTS(EMPLOYEEID, TYPE, DESCRIPTION, IMAGE, AMOUNT, DATESUBMITTED) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, employeeId);
			stmt.setString(2, type);
			stmt.setString(3, description);
			stmt.setBlob(4, image);
			stmt.setDouble(5, amount);
			stmt.setDate(6, today);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
