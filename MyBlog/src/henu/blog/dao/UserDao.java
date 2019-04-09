package henu.blog.dao;

import henu.blog.bean.User;

public interface UserDao {
	public int insertUser(User user);
	public boolean searchUserName(String user_name);
	public User searchUser(User user);
	public User showUser(int user_id);
	public int updateImage(User user);
	public int updateUser(User user);
}
