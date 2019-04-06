package henu.rjxy.service.impl;

import java.util.ArrayList;

import henu.rjxy.bean.User;
import henu.rjxy.dao.UserDao;
import henu.rjxy.dao.impl.UserDaoImpl;
import henu.rjxy.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		//更新数据
		
		return userDao.updateUser(user);
	}

	@Override
	public int updateTarget(User user) {
		// TODO Auto-generated method stub
		return userDao.updateTarget(user);
	}

	@Override
	public int updateImage(User user) {
		// TODO Auto-generated method stub
		return userDao.updateImage(user);
	}

	@Override
	public User searchUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.searchUserById(userId);
	}

	@Override
	public ArrayList<User> searchFriends(int userId) {
		// TODO Auto-generated method stub
		return userDao.searchFriends(userId);
	}

	
}
