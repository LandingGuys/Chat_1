package henu.rjxy.dao.impl;

import java.util.ArrayList;

import henu.rjxy.bean.User;
import henu.rjxy.dao.UserDao;
import henu.rjxy.util.DBUtil;

public class UserDaoImpl implements UserDao {
	DBUtil dbUtil = new DBUtil();
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		//dbutil
		
		return dbUtil.updateUser(user);
	}

	@Override
	public int updateTarget(User user) {
		// TODO Auto-generated method stub
		return dbUtil.updateTarget(user);
	}

	@Override
	public int updateImage(User user) {
		// TODO Auto-generated method stub
		return dbUtil.updateImage(user);
	}

	@Override
	public User searchUserById(int userId) {
		// TODO Auto-generated method stub
		return dbUtil.searchUserById(userId);
	}

	@Override
	public ArrayList<User> searchFriends(int userId) {
		// TODO Auto-generated method stub
		return dbUtil.searchFriends(userId);
	}


	

}
