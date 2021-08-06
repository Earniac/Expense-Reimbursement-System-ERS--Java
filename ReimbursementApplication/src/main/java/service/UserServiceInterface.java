package service;

import model.User;

public interface UserServiceInterface {

	public boolean createAcc(User user);

	public boolean login(User user);
}
