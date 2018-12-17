package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Credentials;
import beans.Employee;
import util.ConnectionUtil;

public class CredentialsDAOImpl implements CredentialsDAO {

	private static final String filename = "connection.properties";

	public List<Credentials> getCredentials() {
		List<Credentials> cl = new ArrayList<Credentials>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM CREDENTIALS";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int employeeId  = rs.getInt("EMPLOYEEID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				cl.add(new Credentials(username, password, employeeId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cl;
	}


	public List<Credentials> login(String username, String password) {
		List<Credentials> cl = new ArrayList<Credentials>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM CREDENTIALS WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery(sql);
				int employeeId  = rs.getInt("EMPLOYEEID");
				String username1 = rs.getString("USERNAME");
				String password1 = rs.getString("PASSWORD");
				cl.add(new Credentials(username1, password1, employeeId));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cl;
	}

	public void addNewCredentials(String username, String password, int x) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "INSERT INTO CREDENTIALS VALUES (?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setInt(3, x);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteCredentials(int x) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "DELETE * FROM CREDENTIALS C WHERE C.EMPLOYEEID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, x);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void updateCredentials(String column, String update, int x) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE TABLE CREDENTIALS C SET ? = ? WHERE C.EMPLOYEEID = ?";
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


	@Override
	public List<Credentials> getUsernames() {
		List<Credentials> cul = new ArrayList<Credentials>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT C.USERNAME, C.EMPLOYEEID FROM CREDENTIALS C";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int employeeId  = rs.getInt("EMPLOYEEID");
				String username = rs.getString("USERNAME");

				cul.add(new Credentials(username, employeeId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cul;
	}

}
