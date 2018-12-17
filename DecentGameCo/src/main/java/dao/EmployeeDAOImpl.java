package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final String filename = "connection.properties";

	public List<Employee> getEmployees() {
		List<Employee> e1 = new ArrayList<Employee>();
		// try-with-resources.. con will be closed at the end of the block
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			// write a join which unifies Bear, Cave, and BearType into a ResultSet
			// map the ResultSet's entries onto a list of Bear objects
			String sql = "SELECT * FROM EMPLOYEE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int employeeId  = rs.getInt("EMPLOYEEID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String middleInitial = rs.getString("MIDDLEINITIAL");
				String title = rs.getString("TITLE");
				int directManager = rs.getInt("DIRECTMANAGER");
				String birthdate = rs.getString("BIRTHDATE");
				String address = rs.getString("ADDRESS");
				int zipcode = rs.getInt("ZIPCODE");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");

				e1.add(new Employee(employeeId, firstname, lastname, middleInitial, title, directManager, birthdate, address, zipcode, email, phone));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return e1;
	}

	public void addNewEmployee(String firstName, String lastName, String middleInitial, String title, int directManager, String birthdate, String address, int zipcode, String email, String phone) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			// write a join which unifies Bear, Cave, and BearType into a ResultSet
			// map the ResultSet's entries onto a list of Bear objects
			String sql = "INSERT INTO EMPLOYEE E VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, middleInitial);
			stmt.setString(4, title);
			stmt.setInt(5, directManager);
			stmt.setString(6, birthdate);
			stmt.setString(7, address);
			stmt.setInt(8, zipcode);
			stmt.setString(9, email);
			stmt.setString(10, phone);
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployee(String column, String update, int x) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			// write a join which unifies Bear, Cave, and BearType into a ResultSet
			// map the ResultSet's entries onto a list of Bear objects
			String sql = "UPDATE TABLE EMPLOYEE E SET ? = ? WHERE EMPLOYEEID = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, column);
			stmt.setString(2, update);
			stmt.setInt(3, x);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	public void deleteEmployee(int x) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			// write a join which unifies Bear, Cave, and BearType into a ResultSet
			// map the ResultSet's entries onto a list of Bear objects
			String sql = "DELETE * FROM EMPLOYEE WHERE EMPLOYEEID = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, x);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
