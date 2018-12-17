package dao;

import java.util.List;

import beans.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployees();
	public void addNewEmployee(String firstName, String lastName, String middleInitial, String title, int directManager, String birthdate, String address, int zipcode, String email, String phone);
	public void updateEmployee(String column, String update, int x);
	public void deleteEmployee(int x);

}
