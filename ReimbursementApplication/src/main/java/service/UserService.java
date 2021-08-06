package service;

import dao.UserDao;
import dao.UserDaoInterface;
import model.User;

public class UserService implements UserServiceInterface{

	UserDaoInterface dao = new UserDao();
//	@Override
//	public boolean createAcc(User user) {
//		return dao.createAcc(user);
//	}

	@Override
	public boolean login(User user) {
		return dao.login(user);
	}

	@Override
	public int employeeType(String username) {
		return dao.employeeType(username);
	}

}
