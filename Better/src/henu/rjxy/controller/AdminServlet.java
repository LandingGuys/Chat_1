package henu.rjxy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import henu.rjxy.bean.Admin;
import henu.rjxy.bean.PageModel;
import henu.rjxy.bean.User;
import henu.rjxy.service.AdminService;
import henu.rjxy.service.UserService;
import henu.rjxy.service.impl.AdminServiceImpl;
import henu.rjxy.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdminService ad=new AdminServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//0 获取method
		String method = request.getParameter("method");
		if("login".equals(method)){
			//登录
			login(request,response);
		}else if("toadmin".equals(method)) {
			toadmin(request,response);
		}else if("toupdateUser".equals(method)) {
			toupdateUser(request,response);
		}else if("updateUser".equals(method)) {
			updateUser(request,response);
		}else if("deleteUser".equals(method)) {
			deleteUser(request,response);
		}else if("SerachByName".equals(method)) {
			SerachByName(request,response);
		}
			
			
			
			
			
			
	}

	private void SerachByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchname=request.getParameter("searchname");
		ArrayList<User> searchNameUser=ad.searchUserByName(searchname);
		request.setAttribute("userList",searchNameUser);
		request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		int n=ad.deleteUser(Integer.parseInt(userId));
		if(n>0){
			request.setAttribute("result", "删除成功");
		}else{
			request.setAttribute("result", "删除失败");
		}
		toadmin(request,response);
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String psw = request.getParameter("psw");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String userId = request.getParameter("userId");
		String age=request.getParameter("age");
		String occupation=request.getParameter("occupation");
		String target=request.getParameter("target");
		
		User user = new User();
		user.setAddress(address);
		user.setPsw(psw);
		user.setTel(tel);
		user.setEmail(email);
		user.setUsername(username);
		user.setUserId(Integer.parseInt(userId));
		user.setAge(Integer.parseInt(age));
		user.setOccupation(occupation);
		user.setTarget(target);
		//数据的更新
		//在控制层中调用业务逻辑成
		int n = ad.updateUser(user);
		if(n>0){
			request.setAttribute("result", "修改成功");
		}else{
			request.setAttribute("result", "修改失败");
		}
		toadmin(request,response);
		
	}

	private void toupdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		String currentPage=request.getParameter("currentPage");
		User user=ad.searchUserById(Integer.parseInt(userId));
		request.setAttribute("user", user);
		request.setAttribute("currentPage", currentPage);
		
		request.getRequestDispatcher("/admin/updateUser.jsp").forward(request, response);
	}

	private void toadmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cp = request.getParameter("currentPage");
		if(cp!=null&&cp!=""){
		int currentPage = Integer.parseInt(cp);
		int total = ad.searchAllUserNum();
		PageModel pageModel = new PageModel();
		pageModel.setTotal(total);
		if(currentPage<0){
			currentPage=1;
		}else if(currentPage>pageModel.getTotalPage()){
			currentPage=pageModel.getTotalPage();
		}
		pageModel.setCurrentPage(currentPage);
		pageModel.getPrePage();
		pageModel.getNextPage();
		pageModel.getTotalPage();
		request.setAttribute("pageModel", pageModel);
		ArrayList<User> searchAllUsers=ad.searchAllUsers(currentPage);
		request.setAttribute("userList", searchAllUsers);
		request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
		}
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String adminName=request.getParameter("adminName");
		String adminpassword=request.getParameter("adminpassWord");
		Admin admin=new Admin();
		admin.setAname(adminName);
		admin.setApsw(adminpassword);
		Admin serachAdmin=ad.searchAdmin(admin);
		if(serachAdmin!=null) {
			System.out.println("登录成功");
			String cp = request.getParameter("currentPage");
			if(cp!=null&&cp!=""){
			int currentPage = Integer.parseInt(cp);
			int total = ad.searchAllUserNum();
			PageModel pageModel = new PageModel();
			pageModel.setTotal(total);
			if(currentPage<0){
				currentPage=1;
			}else if(currentPage>pageModel.getTotalPage()){
				currentPage=pageModel.getTotalPage();
			}
			pageModel.setCurrentPage(currentPage);
			pageModel.getPrePage();
			pageModel.getNextPage();
			pageModel.getTotalPage();
			request.setAttribute("pageModel", pageModel);
			ArrayList<User> searchAllUsers=ad.searchAllUsers(currentPage);
			request.setAttribute("userList", searchAllUsers);
			request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
			return;
		}else {
			request.setAttribute("error", "用户名或者密码错误");
			request.getRequestDispatcher("/admin/adminLogin.jsp").forward(request, response);
			return;
		}
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
