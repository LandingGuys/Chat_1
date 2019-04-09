package henu.blog.service;

import henu.blog.bean.User;

public interface UserService {
	/*注册*/
	public int insertUser(User user);
	/*判断用户名唯一性*/
	public boolean searchUserName(String user_name);
	/*登录*/
	public User searchUser(User user);
	//显示用户个人信息
	public User showUser(int user_id);
	//修改用户头像
	public int updateImage(User user);
	//修改用户个人信息
	public int updateUser(User user);
	
}
