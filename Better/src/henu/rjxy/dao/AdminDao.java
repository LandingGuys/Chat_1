package henu.rjxy.dao;

import java.util.ArrayList;

import henu.rjxy.bean.Admin;
import henu.rjxy.bean.User;

public interface AdminDao {
	public Admin searchAdmin(Admin admin);
	public ArrayList<User> searchAllUsers(int begin);
	 public int searchAllUserNum();
	 public User searchUserById(int userId);
	 public int updateUser(User user);
	 public int deleteUser(int userId);
	  public ArrayList<User> searchUserByName(String username);
}
