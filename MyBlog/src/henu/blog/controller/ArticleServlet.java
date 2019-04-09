package henu.blog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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

import henu.blog.bean.Article;
import henu.blog.bean.User;
import henu.blog.service.ArticleService;
import henu.blog.service.UserService;
import henu.blog.service.impl.ArticleServiceImpl;
import henu.blog.service.impl.UserServiceImpl;
import henu.blog.bean.PageModel;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ArticleService articleservice=new ArticleServiceImpl();
    UserService userservice=new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if("tomy".equals(method)){
			tomy(request,response);
		}else if("total".equals(method)){
			total(request, response);
		}else if("deleteArticle".equals(method)) {
			deleteArticle(request, response);
		}
		
	}
	

	private void deleteArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String article_id=request.getParameter("article_id");
		String user_id=request.getParameter("user_id");
		int n=articleservice.deleteArticle(Integer.parseInt(article_id));
		if(n>0){
			request.setAttribute("result", "删除成功");
		}else{
			request.setAttribute("result", "删除失败");
		}
		ArrayList<Article> showArticle=articleservice.showArticle(Integer.parseInt(user_id));
		User user=userservice.showUser(Integer.parseInt(user_id));
		request.setAttribute("article", showArticle);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/admin/my.jsp").forward(request, response);
	}

	private void total(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cp = request.getParameter("currentPage");
		if(cp!=null&&cp!=""){
		int currentPage = Integer.parseInt(cp);
		int total = articleservice.searchArticleNum();
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
		String user_id=request.getParameter("user_id");
		ArrayList<Article> showAllArticle=articleservice.showAllArticle(currentPage);
		User user=userservice.showUser(Integer.parseInt(user_id));
		request.setAttribute("article", showAllArticle);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/admin/total.jsp").forward(request, response);
		}
		
	}

	private void tomy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id=request.getParameter("user_id");
		ArrayList<Article> showArticle=articleservice.showArticle(Integer.parseInt(user_id));
		User user=userservice.showUser(Integer.parseInt(user_id));
		request.setAttribute("article", showArticle);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/admin/my.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
