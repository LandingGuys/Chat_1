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

/**
 * Servlet implementation class AddArticleServlet
 */
@WebServlet("/AddArticleServlet")
public class AddArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  ArticleService articleservice=new ArticleServiceImpl();
	    UserService userservice=new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SmartUpload su =new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		su.setAllowedFilesList("jpg,jpeg,png,bmp,gif,JPEG,JPG,PNG,BMP,GIF");
		su.setMaxFileSize(1024*1024*10);
		su.setTotalMaxFileSize(1024*1024*50);
		try {
			su.upload();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Files files=su.getFiles();
		File file=files.getFile(0);
		Date date =new Date();
		long time=date.getTime();
		String filename=time+"."+file.getFileExt();	
		try {
			file.saveAs("F:/upload/images/"+filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Request req = su.getRequest();
		String user_id=req.getParameter("user_id");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		Article article=new Article();
		article.setArticle_title(title);
		article.setArticle_content(content);
		if(file.getFileExt()!="") {
			article.setArticle_images(filename);
		}
		article.setUser_id(Integer.parseInt(user_id));
		int n=articleservice.insertArticle(article);
		if(n>0){
			request.setAttribute("result", "修改成功");
		}else{
			request.setAttribute("result", "修改失败");
		}
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
