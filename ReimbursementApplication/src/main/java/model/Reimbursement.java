package model;

public class Reimbursement {

	private int id;
	private String fname;
	private String mnane;
	private String lname;
	private String username;
	private String email;
	private String role;
	private String reimburseDescrip;
	private int amount;
	private String reimburseType;
	private int typeNum;
	private String status;
	private int statusNum;
	private String resolvedBy;
	private String time_submitted;
	private String resolved_time;
	
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reimbursement(int id, String fname, String mnane, String lname, String username, String email, String role,
			 String reimburseType, String reimburseDescrip, int amount, String status, String resolvedBy,
			String time_submitted, String resolved_time) {
		super();
		this.id = id;
		this.fname = fname;
		this.mnane = mnane;
		this.lname = lname;
		this.username = username;
		this.email = email;
		this.role = role;
		this.reimburseDescrip = reimburseDescrip;
		this.amount = amount;
		this.reimburseType = reimburseType;
		this.status = status;
		this.resolvedBy = resolvedBy;
		this.time_submitted = time_submitted;
		this.resolved_time = resolved_time;
	}
	
	
	public Reimbursement(int id, String fname, String lname, String username, String email, String role,
			 String reimburseType, String reimburseDescrip, int amount, String status, String resolvedBy,
			String time_submitted, String resolved_time) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.email = email;
		this.role = role;
		this.reimburseDescrip = reimburseDescrip;
		this.amount = amount;
		this.reimburseType = reimburseType;
		this.status = status;
		this.resolvedBy = resolvedBy;
		this.time_submitted = time_submitted;
		this.resolved_time = resolved_time;
	}


	public Reimbursement(String fname, String mnane, String lname, String username, String email, String role,
			String reimburseDescrip, int amount, String reimburseType, String status, String resolvedBy,
			String time_submitted, String resolved_time) {
		super();
		this.fname = fname;
		this.mnane = mnane;
		this.lname = lname;
		this.username = username;
		this.email = email;
		this.role = role;
		this.reimburseDescrip = reimburseDescrip;
		this.amount = amount;
		this.reimburseType = reimburseType;
		this.status = status;
		this.resolvedBy = resolvedBy;
		this.time_submitted = time_submitted;
		this.resolved_time = resolved_time;
	}


	public Reimbursement(int amount, String time_submitted, String resolved_time, String reimburseDescrip, String username, String status, String reimburseType) {
		super();
		this.username = username;
		this.reimburseDescrip = reimburseDescrip;
		this.amount = amount;
		this.reimburseType = reimburseType;
		this.status = status;
		this.time_submitted = time_submitted;
		this.resolved_time = resolved_time;

	}
	
	
	public Reimbursement(int amount,String reimburseDescrip, String username, int reimburseType) {
		super();
		this.username = username;
		this.reimburseDescrip = reimburseDescrip;
		this.amount = amount;
		this.typeNum = reimburseType;
	}
	
	public Reimbursement(String username, int status, int id) {
		super();
		this.username = username;
		this.statusNum = status;
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getMnane() {
		return mnane;
	}


	public void setMnane(String mnane) {
		this.mnane = mnane;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getReimburseDescrip() {
		return reimburseDescrip;
	}


	public void setReimburseDescrip(String reimburseDescrip) {
		this.reimburseDescrip = reimburseDescrip;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getReimburseType() {
		return reimburseType;
	}


	public void setReimburseType(String reimburseType) {
		this.reimburseType = reimburseType;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getResolvedBy() {
		return resolvedBy;
	}


	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}


	public String getTime_submitted() {
		return time_submitted;
	}


	public void setTime_submitted(String time_submitted) {
		this.time_submitted = time_submitted;
	}


	public String getResolved_time() {
		return resolved_time;
	}


	public void setResolved_time(String resolved_time) {
		this.resolved_time = resolved_time;
	}


	public int getTypeNum() {
		return typeNum;
	}


	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
	}


	public int getStatusNum() {
		return statusNum;
	}


	public void setStatusNum(int statusNum) {
		this.statusNum = statusNum;
	}


	@Override
	public String toString() {
		return "\nReimbursement [id=" + id + ", fname=" + fname + ", mnane=" + mnane + ", lname=" + lname + ", username="
				+ username + ", email=" + email + ", role=" + role + ", reimburseDescrip=" + reimburseDescrip
				+ ", amount=" + amount + ", reimburseType=" + reimburseType + ", status=" + status + ", resolvedBy="
				+ resolvedBy + ", time_submitted=" + time_submitted + ", resolved_time=" + resolved_time + "]";
	}
	
	
}
