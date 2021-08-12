package dao;


import model.User;

public interface UserDaoInterface {

	//logs a user into an account
	public boolean login(User user);
	
	//determines the kind of employee
	public int employeeType(String username);

}
