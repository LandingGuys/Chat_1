package henu.blog.controller;

import java.io.IOException;
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

import henu.blog.bean.User;
import henu.blog.service.UserService;
import henu.blog.service.impl.UserServiceImpl;



/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		User user=new User();
		user.setUser_id(Integer.parseInt(user_id));
		user.setUser_image(filename);
		//数据的更新
		//在控制层中调用业务逻辑成
		UserService UserServiceImpl = new UserServiceImpl();
		int n = UserServiceImpl.updateImage(user);
		if(n>0){
			request.setAttribute("result", "修改成功");
		}else{
			request.setAttribute("result", "修改失败");
		}
		user = UserServiceImpl.showUser(Integer.parseInt(user_id));
		request.setAttribute("user", user);
		request.getRequestDispatcher("/admin/information.jsp").forward(request, response);
	}

}
