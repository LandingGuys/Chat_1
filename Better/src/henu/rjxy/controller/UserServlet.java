package henu.rjxy.controller;

import henu.rjxy.bean.Friend;
import henu.rjxy.bean.PageModel;
import henu.rjxy.bean.Sport;
import henu.rjxy.bean.Study;
import henu.rjxy.bean.User;
import henu.rjxy.bean.study_list;
import henu.rjxy.service.RankService;
import henu.rjxy.service.UserService;
import henu.rjxy.service.impl.RankServiceImpl;
import henu.rjxy.service.impl.UserServiceImpl;
import henu.rjxy.util.DBUtil;
import henu.rjxy.validate.UserFormValidate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	DBUtil dbutil = new DBUtil();
	RankService rankservice=new RankServiceImpl();
	UserService userservice=new UserServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//0 获取method
		String method = request.getParameter("method");
		if("register".equals(method)){
			//执行注册
			register(request,response);
		}else if("login".equals(method)){
			//登录
			login(request, response);
		}else if("checkUsername".equals(method)){
			checkUsername(request,response);
		}else if("createCheckCode".equals(method)){
			//生成验证码，并且绘制验证码图片，最后将图片输出jsp
			createCheckCode(request,response);
		}else if("showUser".equals(method)) {
			showUser(request,response);
		}
		else if("toUpdatePage".equals(method)){
			toUpdatePage(request,response);
		}else if("updateUser".equals(method)){
			updateUser(request,response);	
		}else if("toindex".equals(method)) {
			toindex(request,response);
		}else if("tosport".equals(method)) {
			tosport(request,response);
		}else if("tostudy".equals(method)) {
			tostudy(request,response);
		}else if("searchSportByName".equals(method)) {
			searchSportByName(request,response);
		}else if("searchStudyByName".equals(method)) {
			searchStudyByName(request,response);
		}else if("updateTarget".equals(method)){
			updateTarget(request,response);
		}else if("toshare".equals(method)) {
			toshare(request,response);
		}else if("tofriend".equals(method)) {
			tofriend(request,response);
		}else if("showfriend".equals(method)) {
			showfriend(request,response);
		}
		
	}
	
	private void showfriend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("userId");
		String friendname=request.getParameter("friendname");
		User user = dbutil.searchUserById(Integer.parseInt(userId));
		ArrayList<User> searchFriends=userservice.searchFriends(Integer.parseInt(userId));
		Friend friend=dbutil.showFriend(friendname);
		Sport searchSport=dbutil.searchSport(friendname);
		Study searchStudy=dbutil.searchStudy(friendname);
		request.setAttribute("user", user);
		request.setAttribute("friends", searchFriends);
		request.setAttribute("friend", friend);
		request.setAttribute("sport", searchSport);
		request.setAttribute("study", searchStudy);
		request.getRequestDispatcher("/friend.jsp").forward(request, response);
	}

	private void toshare(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		User user = dbutil.searchUserById(Integer.parseInt(userId));
		
		//页面跳转 :share.jsp
		request.setAttribute("user", user);
		request.getRequestDispatcher("/share.jsp").forward(request, response);
	}
	private void tofriend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		User user = dbutil.searchUserById(Integer.parseInt(userId));
		String username=user.getUsername();
		ArrayList<User> searchFriends=userservice.searchFriends(Integer.parseInt(userId));
		Friend friend=dbutil.showFriend(username);
		Sport searchSport=dbutil.searchSport(username);
		Study searchStudy=dbutil.searchStudy(username);
		//页面跳转 :friend.jsp
		request.setAttribute("user", user);
		request.setAttribute("friends", searchFriends);
		request.setAttribute("friend", friend);
		request.setAttribute("sport", searchSport);
		request.setAttribute("study", searchStudy);
		request.getRequestDispatcher("/friend.jsp").forward(request, response);
	}
	private void searchStudyByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<henu.rjxy.dto.searchStudy> searchStudyByName=dbutil.searchStudyByName(request.getParameter("username"));
		String userId = request.getParameter("userId");
		User user = dbutil.searchUserById(Integer.parseInt(userId));
		//页面跳转 :study.jsp
		request.setAttribute("user", user);
		request.setAttribute("study_list", searchStudyByName);
		request.getRequestDispatcher("/study.jsp").forward(request, response);
		
	}
	private void searchSportByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<henu.rjxy.dto.searchSport> searchSportByName=dbutil.searchSportByName(request.getParameter("username"));
		String userId = request.getParameter("userId");
		User user = dbutil.searchUserById(Integer.parseInt(userId));
		//页面跳转 :sport.jsp
		request.setAttribute("user", user);
		request.setAttribute("sport_list", searchSportByName);
		request.getRequestDispatcher("/sport.jsp").forward(request, response);
		
	}
	private void tostudy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String cp = request.getParameter("currentPage");
		if(cp!=null&&cp!=""){
		int currentPage = Integer.parseInt(cp);
		int total = rankservice.searchStudyNum();
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
		ArrayList<henu.rjxy.dto.searchStudy> searchAllstudy_list=rankservice.searchAllstudy_list(currentPage);
		
		String userId = request.getParameter("userId");
		User user = dbutil.searchUserById(Integer.parseInt(userId));
		//页面跳转 :study.jsp
		request.setAttribute("user", user);
		request.setAttribute("study_list", searchAllstudy_list);
		request.getRequestDispatcher("/study.jsp").forward(request, response);
		}	
	}
	private void tosport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String cp = request.getParameter("currentPage");
		if(cp!=null&&cp!=""){
		int currentPage = Integer.parseInt(cp);
		int total = rankservice.searchSportNum();
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
		ArrayList<henu.rjxy.dto.searchSport> searchAllsport_list=rankservice.searchAllsport_list(currentPage);
		String userId = request.getParameter("userId");
		User user = dbutil.searchUserById(Integer.parseInt(userId));
		//页面跳转 :sport.jsp
		request.setAttribute("user", user);
		request.setAttribute("sport_list", searchAllsport_list);
		request.getRequestDispatcher("/sport.jsp").forward(request, response);
		}
	}
	private void toindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		User user=dbutil.showUser(username);
		Sport searchSport=dbutil.searchSport(username);
		int ranking=dbutil.serachRanking(username);
		Study searchStudy=dbutil.searchStudy(username);
		ArrayList<henu.rjxy.dto.searchSport> searchAllsport_list=rankservice.searchAllsport_list(1);
		request.setAttribute("user", user);
		request.setAttribute("sport", searchSport);
		request.setAttribute("ranking", ranking);
		request.setAttribute("study", searchStudy);
		request.setAttribute("sport_list", searchAllsport_list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	private void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		User showUser = dbutil.searchUserById(Integer.parseInt(userId));
		//页面跳转 :information.jsp
		request.setAttribute("user", showUser);
		request.getRequestDispatcher("/information.jsp").forward(request, response);
		
	}
	private void updateTarget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取参数并进行封装
		String target=request.getParameter("target");
		String userId = request.getParameter("userId");
		User user = new User();
		user.setUserId(Integer.parseInt(userId));
		user.setTarget(target);
		//数据的更新
		//在控制层中调用业务逻辑成
		UserService UserServiceImpl = new UserServiceImpl();
		int n = UserServiceImpl.updateTarget(user);
		if(n>0){
			request.setAttribute("result", "修改成功");
		}else{
			request.setAttribute("result", "修改失败");
		}
		toindex(request,response);
	}
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取参数并进行封装
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
		UserService UserServiceImpl = new UserServiceImpl();
		int n = UserServiceImpl.updateUser(user);
		if(n>0){
			request.setAttribute("result", "修改成功");
		}else{
			request.setAttribute("result", "修改失败");
		}
		user = UserServiceImpl.searchUserById(Integer.parseInt(userId));
		request.setAttribute("user", user);
		request.getRequestDispatcher("/information.jsp").forward(request, response);
	}

	private void toUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String userId = request.getParameter("userId");
		User user = dbutil.searchUserById(Integer.parseInt(userId));
		//页面跳转 :updateUser.jsp
		request.setAttribute("user", user);
		request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
	}
	public void createCheckCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//1、生成验证码：数字+字母，4位
		String code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz123456789";
		String checkCode="";
		Random  random = new Random();
		for(int i=0;i<4;i++){
			int index = random.nextInt(code.length());
			checkCode+=code.charAt(index);
		}
		//将验证码存储在session中
		request.getSession().setAttribute("checkcode", checkCode);
		System.out.println(checkCode);
		//2、生成干扰线
		BufferedImage image = new BufferedImage(150,40,BufferedImage.TYPE_INT_RGB);
		Graphics g =image.getGraphics();
		//绘制背景
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, 200, 50);
		g.setColor(Color.gray);
		for(int i=0;i<10;i++){
			int beginpx=random.nextInt(105);
			int beginpy=random.nextInt(25);
			int endpx=beginpx+random.nextInt(25);
			int endpy=beginpy+random.nextInt(25);
			g.drawLine(beginpx, beginpy, endpx, endpy);
		}
		
		//3、绘制字符串，并将内存中的图片进行输出
		g.setFont(new Font("微软雅黑",Font.ITALIC,25));
		g.setColor(Color.RED);
		MyDrawString(checkCode,25,35,1.3,g);
		ImageIO.write(image, "jpg", response.getOutputStream());
	}
	//设置字体的宽度
	public static void MyDrawString(String str,int x,int y,double rate,Graphics g){  
	    String tempStr=new String();  
	    int orgStringWidth=g.getFontMetrics().stringWidth(str);  
	    int orgStringLength=str.length();  
	    int tempx=x;  
	    int tempy=y;  
	    while(str.length()>0)  
	    {  
	        tempStr=str.substring(0, 1);  
	        str=str.substring(1, str.length());  
	        g.drawString(tempStr, tempx, tempy);  
	        tempx=(int)(tempx+(double)orgStringWidth/(double)orgStringLength*rate);  
	   }  
	}
	public void checkUsername(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
		response.setCharacterEncoding("UTF-8");
		//去数据进行唯一性确认
		if(username!=""){
			boolean b = dbutil.searchUserName(username);
			
			if(b){
				//向前台返回已存在字符串
				response.getWriter().print("已存在");
			}else{
				//如果该名称不存在，就输出"OK"
				response.getWriter().print("");
			}
		}else{
			response.getWriter().print("请输入用户名");
		}
		
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1 接受参数,并封装
		String username = request.getParameter("username");
		String psw = request.getParameter("password");
		String checkcode = request.getParameter("checkcode");
		System.out.println(checkcode);
		System.out.println((String) request.getSession().getAttribute("checkcode"));
		//将用户输入的验证码和session中的验证码进行比较
		if(!checkcode.equalsIgnoreCase((String) request.getSession().getAttribute("checkcode"))){
			//如果验证码输入错误，返回登录页面，并显示“验证码错误”信息
			
			request.setAttribute("error", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			return;
		}
		User user = new User();
		user.setUsername(username);
		user.setPsw(psw);
		User searchUser = dbutil.searchUser(user);
		Sport searchSport=dbutil.searchSport(username);
		int ranking=dbutil.serachRanking(username);
		Study searchStudy=dbutil.searchStudy(username);
		ArrayList<henu.rjxy.dto.searchSport> searchAllsport_list=rankservice.searchAllsport_list(1);
		
		//4 根据查询的结果进行页面跳转
		if(searchUser!=null){
			//跳转到后台主页面
			System.out.println("查询成功");
			request.setAttribute("user", searchUser);
			request.setAttribute("sport", searchSport);
			request.setAttribute("ranking", ranking);
			request.setAttribute("study", searchStudy);
			request.setAttribute("sport_list", searchAllsport_list);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}else{
			request.setAttribute("error", "用户名或者密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
}

	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1、获取数据 :username psw  email,并且封装成User对象
				String username = request.getParameter("username");
				String psw = request.getParameter("password");
				String email = request.getParameter("email");
				//封装数据
				User user = new User();
				user.setEmail(email);
				user.setUsername(username);
				user.setPsw(psw);
				int n = dbutil.insertUser(user);
				if(n>0){
					System.out.println("添加成功");
					//重定向  请求转发
					String path=request.getContextPath()+"/result.jsp";
					response.sendRedirect(path);
				}else{
					System.out.println("添加失败");
					request.setAttribute("errrorMsg", "注册失败，请重新注册");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				}
				//4、根据返回的结果显示相应的JSP页面
	}


}
