package henu.rjxy.service;

import java.util.ArrayList;

import henu.rjxy.bean.Admin;
import henu.rjxy.bean.User;

public interface AdminService {
	public Admin searchAdmin(Admin admin);
	public ArrayList<User> searchAllUsers(int currentPage);
	 public int searchAllUserNum();
	 public User searchUserById(int userId);
	 public int updateUser(User user);
	 public int deleteUser(int userId);
	  public ArrayList<User> searchUserByName(String username);
}
