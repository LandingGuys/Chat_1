package henu.blog.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import henu.blog.bean.Article;
import henu.blog.bean.PageModel;
import henu.blog.service.ArticleService;
import henu.blog.service.impl.ArticleServiceImpl;

/**
 * Servlet implementation class FangkeServlet
 */
@WebServlet("/FangkeServlet")
public class FangkeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ArticleService articleservice=new ArticleServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FangkeServlet() {
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
		if("tofangkeindex".equals(method)){
			tofangkeindex(request,response);
		}else if("tofangketotal".equals(method)){
			tofangketotal(request, response);
		}
	}

	private void tofangketotal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		ArrayList<Article> showAllArticle=articleservice.showAllArticle(currentPage);
		
		request.setAttribute("article", showAllArticle);
		request.getRequestDispatcher("/page/total.jsp").forward(request, response);
		}
	}

	private void tofangkeindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Article> showRandomAllArticle=articleservice.showRandomAllArticle();
		request.setAttribute("randomArticle", showRandomAllArticle);
		request.getRequestDispatcher("/page/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
