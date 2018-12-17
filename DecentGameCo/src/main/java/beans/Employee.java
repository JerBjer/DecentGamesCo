package beans;

public class Employee {

	public Employee(int employeeId, String firstname, String lastname, String middleInitial, String title,
			int directManager, String birthdate, String address, int zipcode, String email, String phone) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.middleInitial = middleInitial;
		this.title = title;
		this.directManager = directManager;
		this.birthdate = birthdate;
		this.address = address;
		this.zipcode = zipcode;
		this.email = email;
		this.phone = phone;
	}

	private int employeeId;
	private String firstname;
	private String lastname;
	private String middleInitial;
	private String title;
	private int directManager;
	private String birthdate;
	private String address;
	private int zipcode;
	private String email;
	private String phone;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDirectManager() {
		return directManager;
	}

	public void setDirectManager(int directManager) {
		this.directManager = directManager;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", middleInitial=" + middleInitial + ", title=" + title + ", directManager=" + directManager
				+ ", birthdate=" + birthdate + ", address=" + address + ", zipcode=" + zipcode + ", email=" + email
				+ ", phone=" + phone + "]";
	}

}
