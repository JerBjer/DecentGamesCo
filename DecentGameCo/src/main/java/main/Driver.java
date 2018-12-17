package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import beans.*;
import dao.*;
import util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
//		EmployeeDAO listEmployee = new EmployeeDAOImpl();
//		List<Employee> employees = listEmployee.getEmployees();
//		for (Employee e : employees) {
//			System.out.println(e);
//		}
//		CredentialsDAO listCredentials = new CredentialsDAOImpl();
//		List<Credentials> credentials = listCredentials.getCredentials();
//		for (Credentials c : credentials) {
//			System.out.println(c);
//		}
//		CredentialsDAO listUsernameCredentials = new CredentialsDAOImpl();
//		List<Credentials> userCredentials = listUsernameCredentials.getUsernames();
//		for(Credentials c : userCredentials) {
//			System.out.println(c);
//		}
//		ReimbursementDAO listReimbursements = new ReimbursementDAOImpl();
//		List<Reimbursement> reimbursements = listReimbursements.getReimbursements();
//		for(Reimbursement r : reimbursements) {
//			System.out.println(r);
//		}
		ReimbursementDAO insertReimbursement = new ReimbursementDAOImpl();
		insertReimbursement.addNewReimbursement(10022, "Purchase", "I bought Stuff", null, 109.93);
//		ReimbursementDAO checkReimbursement = new ReimbursementDAOImpl();
		
	}

	static void init() {
		try {
			Connection con = ConnectionUtil.getConnection("Connection.Properties");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
