package henu.rjxy.dao.impl;

import java.util.ArrayList;

import henu.rjxy.bean.Admin;
import henu.rjxy.bean.PageModel;
import henu.rjxy.bean.User;
import henu.rjxy.dao.AdminDao;
import henu.rjxy.util.DBUtil;

public class AdminDaoImpl implements AdminDao {
	DBUtil dbutil=new DBUtil();
	@Override
	public Admin searchAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return dbutil.searchAdmin(admin);
	}
	@Override
	public ArrayList<User> searchAllUsers(int begin) {
		// TODO Auto-generated method stub
		return dbutil.searchAllUsers(begin,  PageModel.pageNum);
	}
	@Override
	public int searchAllUserNum() {
		// TODO Auto-generated method stub
		return dbutil.searchAllUserNum();
	}
	@Override
	public User searchUserById(int userId) {
		// TODO Auto-generated method stub
		return dbutil.searchUserById(userId);
	}
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return dbutil.updateUser(user);
	}
	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		return dbutil.deleteUser(userId);
	}
	@Override
	public ArrayList<User> searchUserByName(String username) {
		// TODO Auto-generated method stub
		return dbutil.searchUserByName(username);
	}
	

}
