package henu.blog.service.impl;


import henu.blog.bean.User;
import henu.blog.dao.UserDao;
import henu.blog.dao.impl.UserDaoImpl;
import henu.blog.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}
	@Override
	public boolean searchUserName(String user_name) {
		// TODO Auto-generated method stub
		return userDao.searchUserName(user_name);
	}
	@Override
	public User searchUser(User user) {
		// TODO Auto-generated method stub
		return userDao.searchUser(user);
	}
	@Override
	public User showUser(int user_id) {
		// TODO Auto-generated method stub
		return userDao.showUser(user_id);
	}
	@Override
	public int updateImage(User user) {
		// TODO Auto-generated method stub
		return userDao.updateImage(user);
	}
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}
}
