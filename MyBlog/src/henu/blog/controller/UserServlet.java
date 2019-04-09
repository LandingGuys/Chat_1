package henu.blog.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import henu.blog.bean.Article;
import henu.blog.bean.User;
import henu.blog.service.ArticleService;
import henu.blog.service.UserService;
import henu.blog.service.impl.ArticleServiceImpl;
import henu.blog.service.impl.UserServiceImpl;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserService userservice=new UserServiceImpl();
    ArticleService articleservice=new ArticleServiceImpl();
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
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
		}else if("toinformation".equals(method)) {
			toinformation(request,response);
		}else if("updateUser".equals(method)) {
			updateUser(request,response);
		}else if("toindex".equals(method)) {
			toindex(request,response);
		}
		
	}

	private void toindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id=request.getParameter("user_id");
		User user=userservice.showUser(Integer.parseInt(user_id));
		ArrayList<Article> showRandomAllArticle=articleservice.showRandomAllArticle();
		request.setAttribute("user", user);
		request.setAttribute("randomArticle", showRandomAllArticle);
		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id=request.getParameter("user_id");
		String user_name=request.getParameter("user_name");
		String user_password=request.getParameter("user_password");
		String user_email=request.getParameter("user_email");
		String user_username=request.getParameter("user_username");
		String user_region=request.getParameter("user_region");
		String user_industry=request.getParameter("user_industry");
		String user_position=request.getParameter("user_position");
		String user_introduction=request.getParameter("user_introduction");
		User user=new User();
		user.setUser_id(Integer.parseInt(user_id));
		user.setUser_name(user_name);
		user.setUser_password(user_password);
		user.setUser_email(user_email);
		user.setUser_username(user_username);
		user.setUser_region(user_region);
		user.setUser_industry(user_industry);
		user.setUser_position(user_position);
		user.setUser_introduction(user_introduction);
		int n=userservice.updateUser(user);
		if(n>0){
			request.setAttribute("result", "修改成功");
		}else{
			request.setAttribute("result", "修改失败");
		}
		user=userservice.showUser(Integer.parseInt(user_id));
		request.setAttribute("user", user);
		request.getRequestDispatcher("/admin/information.jsp").forward(request, response);
		
	}

	private void toinformation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id=request.getParameter("user_id");
		User showuser=userservice.showUser(Integer.parseInt(user_id));
		request.setAttribute("user", showuser);
		request.getRequestDispatcher("/admin/information.jsp").forward(request, response);
		
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String user_name=request.getParameter("user_name");
		String user_email=request.getParameter("user_email");
		String user_password=request.getParameter("user_password");
		User user=new User();
		user.setUser_name(user_name);
		user.setUser_password(user_password);
		user.setUser_email(user_email);
		int n=userservice.insertUser(user);
		if(n>0) {
			System.out.println("添加成功");
			//重定向  请求转发
			String path=request.getContextPath()+"/result.jsp";
			response.sendRedirect(path);
		}else{
			System.out.println("添加失败");
			request.setAttribute("errrorMsg", "注册失败，请重新注册");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_name=request.getParameter("user_name");
		String user_password=request.getParameter("user_password");
		String checkcode = request.getParameter("checkcode");
		//将用户输入的验证码和session中的验证码进行比较
				if(!checkcode.equalsIgnoreCase((String) request.getSession().getAttribute("checkcode"))){
					//如果验证码输入错误，返回登录页面，并显示“验证码错误”信息
					request.setAttribute("error", "验证码错误");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				}
		User user = new User();
		user.setUser_name(user_name);
		user.setUser_password(user_password);	
		User searchUser=userservice.searchUser(user);
		ArrayList<Article> showRandomAllArticle=articleservice.showRandomAllArticle();
		if(searchUser!=null){
			//跳转到主页面
			request.setAttribute("user", searchUser);
			request.setAttribute("randomArticle", showRandomAllArticle);
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
			return;
		}else{
			request.setAttribute("error", "用户名或者密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
	}
	public void checkUsername(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String user_name = request.getParameter("user_name");
		response.setCharacterEncoding("UTF-8");
		//去数据进行唯一性确认
		if(user_name!=""){
			boolean b = userservice.searchUserName(user_name);
			
			if(b){
				//向前台返回已存在字符串
				response.getWriter().print("已存在");
			}else {
				response.getWriter().print("");
			}
		}else{
			response.getWriter().print("请输入用户名");
		}
		
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
		BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
		Graphics g =image.getGraphics();
		//绘制背景
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, 80, 20);
		g.setColor(Color.gray);
		for(int i=0;i<10;i++){
			int beginpx=random.nextInt(70);
			int beginpy=random.nextInt(10);
			int endpx=beginpx+random.nextInt(10);
			int endpy=beginpy+random.nextInt(10);
			g.drawLine(beginpx, beginpy, endpx, endpy);
		}
		
		//3、绘制字符串，并将内存中的图片进行输出
		g.setFont(new Font("微软雅黑",Font.ITALIC,18));
		g.setColor(Color.RED);
		MyDrawString(checkCode,10,15,1.3,g);
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
}