package beans;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;

public class Reimbursement {

	public Reimbursement(int reimbursementId, int employeeId, String type, String description, Blob image,
			double amount, Date dateSubmitted, Date dateApproved) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.type = type;
		this.description = description;
		this.image = image;
		this.amount = amount;
		this.dateSubmitted = dateSubmitted;
		this.dateApproved = dateApproved;
	}

	private int reimbursementId;
	private int employeeId;
	private String type;
	private String description;
	private Blob image;
	private double amount;
	private Date dateSubmitted;
	private Date dateApproved;

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Date getDateApproved() {
		return dateApproved;
	}

	public void setDateApproved(Date dateApproved) {
		this.dateApproved = dateApproved;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", employeeId=" + employeeId + ", type=" + type
				+ ", description=" + description + ", image=" + image + ", amount=" + amount + ", dateSubmitted="
				+ dateSubmitted + ", dateApproved=" + dateApproved + "]";
	}

}
