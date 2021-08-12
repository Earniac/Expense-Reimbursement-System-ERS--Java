package service;

import dao.UserDao;
import dao.UserDaoInterface;
import model.User;

public class UserService implements UserServiceInterface{

	UserDaoInterface dao = new UserDao();

	//logs a user into an existing account
	@Override
	public boolean login(User user) {
		return dao.login(user);
	}

	//determines the type of employee logging into an account
	@Override
	public int employeeType(String username) {
		return dao.employeeType(username);
	}

}
