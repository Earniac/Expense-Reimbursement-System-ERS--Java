package dao;


import model.User;

public interface UserDaoInterface {

//	public boolean createAcc(User user);

	public boolean login(User user);
	
	public int employeeType(String username);

}
