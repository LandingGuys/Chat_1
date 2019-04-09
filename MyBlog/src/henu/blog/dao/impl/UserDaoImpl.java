package henu.blog.dao.impl;


import henu.blog.bean.User;
import henu.blog.dao.UserDao;
import henu.blog.util.DBUtil;

public class UserDaoImpl implements UserDao {
	DBUtil dbutil=new DBUtil();
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return dbutil.insertUser(user);
	}
	@Override
	public boolean searchUserName(String user_name) {
		// TODO Auto-generated method stub
		return dbutil.searchUserName(user_name);
	}
	@Override
	public User searchUser(User user) {
		// TODO Auto-generated method stub
		return dbutil.searchUser(user);
	}
	@Override
	public User showUser(int user_id) {
		// TODO Auto-generated method stub
		return dbutil.showuser(user_id);
	}
	@Override
	public int updateImage(User user) {
		// TODO Auto-generated method stub
		return dbutil.updateImage(user);
	}
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return dbutil.updateUser(user);
	}
}
