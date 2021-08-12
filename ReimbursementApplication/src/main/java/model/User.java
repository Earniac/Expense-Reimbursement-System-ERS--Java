package model;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String fname;
	private String mname;
	private String lname;
	private String email;
	private int role;
	
	////////////////////////////////////////////////////////Constructor\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public User() {
		super();
	}


	public User(int id, String username, String password, String fname, String mname, String lname, String email,
			int role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.email = email;
		this.role = role;
	}


	public User(String username, String password, String fname, String mname, String lname, String email, int role) {
		super();
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.email = email;
		this.role = role;
	}


	public User(String username, String password, String fname, String lname, String email, int role) {
		super();
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.role = role;
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public User(String fname, String mname, String lname) {
		super();
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	////////////////////////////////////////////////////////Getters and Setters\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}

	
	////////////////////////////////////////////////////////ToString()\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", fname=" + fname + ", mname="
				+ mname + ", lname=" + lname + ", email=" + email + ", role=" + role + "]";
	}
	
	

}
