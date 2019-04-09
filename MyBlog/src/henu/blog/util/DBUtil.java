package henu.blog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import henu.blog.bean.Article;
import henu.blog.bean.User;

public class DBUtil {
	private static String diverName="oracle.jdbc.driver.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:ORCL";
	private static String root="scott";
	private static String psw="tiger";
	static{
		try {
			Class.forName(diverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,root,psw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn,PreparedStatement psmt,ResultSet rs){
	 if(rs!=null){
		 try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 if(psmt!=null){
		 try {
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 if(conn!=null){
		 try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
 }
 	/*注册插入用户*/
 public int insertUser(User user){
	  int n = 0;
	  Connection conn = null;
		PreparedStatement psmt =null;
		  try {
			conn = getConn();
			 String sql="insert into t_user(user_id,user_name,user_password,user_email) values(seq.nextval,?,?,?)";
			 psmt =conn.prepareStatement(sql);
			  psmt.setString(1, user.getUser_name());
			  psmt.setString(2, user.getUser_password());
			  psmt.setString(3, user.getUser_email());
			  n = psmt.executeUpdate();
			  return n;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,null);
		}
		  return n;
 }
 /* 判断用户名唯一性*/
 public boolean searchUserName(String user_name){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
		  try {
			conn = getConn();
			 String sql="select * from t_user where user_name=?";
			 psmt =conn.prepareStatement(sql);
			  psmt.setString(1, user_name);
			  rs = psmt.executeQuery();
			  if(rs.next()){
				 return true;
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return false; 
 }
 /*登录*/
 public User searchUser(User user){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
	  User searchUser=null;
		  try {
			conn = getConn();
			 String sql="select * from t_user where user_name=? and user_password=?";
			 psmt =conn.prepareStatement(sql);
			  psmt.setString(1, user.getUser_name());
			  psmt.setString(2, user.getUser_password());
			  rs = psmt.executeQuery();
			  if(rs.next()){
				  searchUser = new User();
				  searchUser.setUser_id(rs.getInt("user_id"));
				  searchUser.setUser_name(rs.getString("user_name")); 
				  searchUser.setUser_image(rs.getString("user_image"));
				 return searchUser;
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return searchUser;
 }
 	//显示用户个人信息
 	public User showuser(int user_id) {
 		  Connection conn = null;
 		  PreparedStatement psmt =null;
 		  ResultSet rs = null;
 		  User showuser=null;
 		  try {
 			conn = getConn();
 			 String sql="select * from t_user where user_id=?";
 			 psmt =conn.prepareStatement(sql);
 			  psmt.setInt(1, user_id);
 			  rs = psmt.executeQuery();
 			  if(rs.next()){
 				  showuser = new User();
 				  showuser.setUser_id(rs.getInt("user_id"));
 				  showuser.setUser_name(rs.getString("user_name")); 
 				  showuser.setUser_password(rs.getString("user_password"));
 				  showuser.setUser_email(rs.getString("user_email"));
 				  showuser.setUser_image(rs.getString("user_image"));
 				  showuser.setUser_username(rs.getString("user_username"));
 				  showuser.setUser_region(rs.getString("user_region"));
 				  showuser.setUser_industry(rs.getString("user_industry"));
 				  showuser.setUser_position(rs.getString("user_position"));
 				  showuser.setUser_introduction(rs.getString("user_introduction"));
 				 return showuser;
 			  }
 		} catch (Exception e) {
 			e.printStackTrace();
 		}finally{
 		 close(conn,psmt,rs);
 		}
 		  return showuser;
 	}
 	//修改用户头像
 	 public int updateImage(User user){
 		  Connection conn = null;
 		  PreparedStatement psmt =null;
 			  try {
 				conn = getConn();
 				 String sql="update t_user set user_image=?where user_id=?";
 				 psmt =conn.prepareStatement(sql);
 				 psmt.setString(1, user.getUser_image());
 				 psmt.setInt(2, user.getUser_id());
 				int n= psmt.executeUpdate();
 				 return n;
 			} catch (Exception e) {
 				e.printStackTrace();
 			}finally{
 			 close(conn,psmt,null);
 			}
 		  return 0;  
 	  }
 	 //修改用户个人信息
 	 public int updateUser(User user) {
 		 Connection conn=null;
 		 PreparedStatement psmt=null;
 		 try {
 			 conn=getConn();
 	 		 String sql="update t_user set user_name=?,user_password=?,user_email=?,user_username=?,user_region=?,user_industry=?,"
 	 		 		+ "user_position=?,user_introduction=?where user_id=?";
 	 		 psmt=conn.prepareStatement(sql);
 	 		 psmt.setString(1, user.getUser_name());
 	 		 psmt.setString(2, user.getUser_password());
 	 		 psmt.setString(3, user.getUser_email());
 	 		 psmt.setString(4, user.getUser_username());
 	 		 psmt.setString(5, user.getUser_region());
 	 		 psmt.setString(6, user.getUser_industry());
 	 		 psmt.setString(7, user.getUser_position());
 	 		 psmt.setString(8, user.getUser_introduction());
 	 		 psmt.setInt(9, user.getUser_id());
 	 		 int n=psmt.executeUpdate();
 	 		 return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 close(conn,psmt,null);
		}
 		return 0;
 	 }
 	 //查询个人博客所有文章
 	public ArrayList<Article> showArticle(int user_id) {
		  Connection conn = null;
		  PreparedStatement psmt =null;
		  ResultSet rs = null;
		  ArrayList<Article> showArticles = new ArrayList<Article>();
		  try {
			conn = getConn();
			 String sql="select * from t_articles where user_id=? order by article_id DESC ";
			 psmt =conn.prepareStatement(sql);
			  psmt.setInt(1, user_id);
			  rs = psmt.executeQuery();
			  while(rs.next()){
				 Article showArticle = new Article();
				 showArticle.setArticle_id(rs.getInt("article_id"));
				 showArticle.setUser_id(rs.getInt("user_id"));
				 showArticle.setArticle_title(rs.getString("article_title"));
				 showArticle.setArticle_content(rs.getString("article_content"));
				 showArticle.setArticle_images(rs.getString("article_images"));
				 showArticles.add(showArticle);
				
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return  showArticles;
	}
 	//根据有无图片增加博客文章
 	public int insertArticle(Article article){
 		int n = 0;
 		Connection conn = null;
 		PreparedStatement psmt =null;
 			  try {
 				conn = getConn();
 				if(article.getArticle_images()!="") {
 					String sql="insert into t_articles(article_id,user_id,article_title,article_content,article_images) values(seq.nextval,?,?,?,?)";
 					 psmt =conn.prepareStatement(sql);
 	 				  psmt.setInt(1, article.getUser_id());
 	 				  psmt.setString(2, article.getArticle_title());
 	 				  psmt.setString(3, article.getArticle_content());
 	 				  psmt.setString(4, article.getArticle_images());
 	 				  n = psmt.executeUpdate();
 	 				  return n;
 				}else {
 	 				 String sql="insert into t_articles(article_id,user_id,article_title,article_content) values(seq.nextval,?,?,?)";
 	 				 psmt =conn.prepareStatement(sql);
 	 				  psmt.setInt(1, article.getUser_id());
 	 				  psmt.setString(2, article.getArticle_title());
 	 				  psmt.setString(3, article.getArticle_content());
 	 				  n = psmt.executeUpdate();
 	 				  return n;
 				}
 			} catch (Exception e) {
 				e.printStackTrace();
 			}finally{
 			 close(conn,psmt,null);
 			}
 			  return n;
 	 }
 	//删除博客文章
 	 public int deleteArticle(int article_id) {
 		  Connection conn = null;
 		  PreparedStatement psmt =null;
 		  try {
 			conn = getConn();
 			String sql="delete from t_articles where article_id=?";
 			psmt =conn.prepareStatement(sql);
 			psmt.setInt(1, article_id);
 			int n=psmt.executeUpdate();
 			return n;
 			} catch (Exception e) {
 				e.printStackTrace();
 			}finally{
 			 close(conn,psmt,null);
 			}
 		   return 0;
 	 }
 	//查询所有人博客文章分页
 	public ArrayList<Article> showAllArticle(int begin,int end) {
		  Connection conn = null;
		  PreparedStatement psmt =null;
		  ResultSet rs = null;
		  ArrayList<Article> showAllArticles = new ArrayList<Article>();
		  try {
			conn = getConn();
			 String sql=" SELECT *  FROM "
			 		+ "(select rownum rn,article_id,user_id,article_title,article_content,article_images from"
			 		+ "(SELECT * FROM T_ARTICLES  order by ARTICLE_ID desc)) WHERE rn >= ? AND rn <=?";
			 psmt =conn.prepareStatement(sql);
			 psmt.setInt(1, begin);
			 psmt.setInt(2, end);
			 rs = psmt.executeQuery();
			  while(rs.next()){
				 Article showArticle = new Article();
				 showArticle.setArticle_id(rs.getInt("article_id"));
				 showArticle.setUser_id(rs.getInt("user_id"));
				 showArticle.setArticle_title(rs.getString("article_title"));
				 showArticle.setArticle_content(rs.getString("article_content"));
				 showArticle.setArticle_images(rs.getString("article_images"));
				 showAllArticles.add(showArticle);
				
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return  showAllArticles;
	}
 	//查询分页页数
 	public int searchArticleNum(){
 		  Connection conn = null;
 		  PreparedStatement psmt =null;
 		  ResultSet rs = null;
 			  try {
 				conn = getConn();
 				 String sql="select count(*) as total from T_ARTICLES";
 				 psmt =conn.prepareStatement(sql);
 				  rs = psmt.executeQuery();
 				  if(rs.next()){
 					return rs.getInt("total");
 				  }
 			} catch (Exception e) {
 				e.printStackTrace();
 			}finally{
 			 close(conn,psmt,rs);
 			}
 			  return 0;
 			  
 	  }
 	//随机查询所有人博客文章，5个；
 	public ArrayList<Article> showRandomAllArticle() {
		  Connection conn = null;
		  PreparedStatement psmt =null;
		  ResultSet rs = null;
		  ArrayList<Article> showRandomAllArticles = new ArrayList<Article>();
		  try {
			conn = getConn();
			 String sql="select * from (select * from t_articles order by dbms_random.value) where rownum <= 5";
			 psmt =conn.prepareStatement(sql);
			  rs = psmt.executeQuery();
			  while(rs.next()){
				 Article showArticle = new Article();
				 showArticle.setArticle_id(rs.getInt("article_id"));
				 showArticle.setUser_id(rs.getInt("user_id"));
				 showArticle.setArticle_title(rs.getString("article_title"));
				 showArticle.setArticle_content(rs.getString("article_content"));
				 showArticle.setArticle_images(rs.getString("article_images"));
				 showRandomAllArticles.add(showArticle);
				
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return  showRandomAllArticles;
	}
}
