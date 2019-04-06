package henu.rjxy.service.impl;

import java.util.ArrayList;

import henu.rjxy.bean.Admin;
import henu.rjxy.bean.PageModel;
import henu.rjxy.bean.User;
import henu.rjxy.dao.AdminDao;
import henu.rjxy.dao.impl.AdminDaoImpl;
import henu.rjxy.service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDao admindao=new AdminDaoImpl();
	@Override
	public Admin searchAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return admindao.searchAdmin(admin);
	}
	@Override
	public ArrayList<User> searchAllUsers(int currentPage) {
		// TODO Auto-generated method stub
		int begin=(currentPage-1)*PageModel.pageNum;
		return admindao.searchAllUsers(begin);
	}
	@Override
	public int searchAllUserNum() {
		// TODO Auto-generated method stub
		return admindao.searchAllUserNum();
	}
	@Override
	public User searchUserById(int userId) {
		// TODO Auto-generated method stub
		return admindao.searchUserById(userId);
	}
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return admindao.updateUser(user);
	}
	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		return admindao.deleteUser(userId);
	}
	@Override
	public ArrayList<User> searchUserByName(String username) {
		// TODO Auto-generated method stub
		return admindao.searchUserByName(username);
	}

}
