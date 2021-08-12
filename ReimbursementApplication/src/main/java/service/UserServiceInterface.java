package service;

import model.User;

public interface UserServiceInterface {


	//logs a user into an existing account
	public boolean login(User user);
	
	//determines the type of employee logging into an account
	public int employeeType(String username);
}
