package henu.rjxy.util;

import henu.rjxy.bean.User;
import henu.rjxy.bean.sports_list;
import henu.rjxy.bean.study_list;
import henu.rjxy.bean.Admin;
import henu.rjxy.bean.Friend;
import henu.rjxy.bean.Sport;
import henu.rjxy.bean.Study;
import henu.rjxy.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBUtil {
	private static String diverName="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://188.131.189.2:3306/better?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
	private static String root="root";
	private static String psw="5780..an";
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
 //注册
  public int insertUser(User user){
	  int n = 0;
	  Connection conn = null;
		PreparedStatement psmt =null;
		  try {
			conn = getConn();
			 String sql="insert into user(username,psw,email) value(?,?,?)";
			 psmt =conn.prepareStatement(sql);
			  psmt.setString(1, user.getUsername());
			  psmt.setString(2, user.getPsw());
			  psmt.setString(3, user.getEmail());
			  n = psmt.executeUpdate();
			  return n;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,null);
		}
		  return n;
  }
  //查询用户
  public User searchUser(User user){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
	  User searchUser=null;
		  try {
			conn = getConn();
			 String sql="select * from user where username=? and psw=?";
			 psmt =conn.prepareStatement(sql);
			  psmt.setString(1, user.getUsername());
			  psmt.setString(2, user.getPsw());
			  rs = psmt.executeQuery();
			  if(rs.next()){
				  searchUser = new User();
				  searchUser.setUserId(rs.getInt("userId"));
				  searchUser.setUsername(rs.getString("username")); 
				  searchUser.setEmail(rs.getString("email"));
				  searchUser.setAddress(rs.getString("address"));
				  searchUser.setTel(rs.getString("tel"));
				  searchUser.setAge(rs.getInt("age"));
				  searchUser.setOccupation(rs.getString("occupation"));
				  searchUser.setImage(rs.getString("image"));
				  searchUser.setTarget(rs.getString("target"));
				 return searchUser;
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return searchUser;
		  
  }
  public boolean searchUserName(String username){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
		  try {
			conn = getConn();
			 String sql="select * from user where username=?";
			 psmt =conn.prepareStatement(sql);
			  psmt.setString(1, username);
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
  
  public ArrayList<User> searchUserByName(String username){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
	  ArrayList<User> users = new ArrayList<User>();
		  try {
			conn = getConn();
			 String sql="select * from user where username like ?";
			 psmt =conn.prepareStatement(sql);
			  psmt.setString(1, "%"+username+"%");
			  rs = psmt.executeQuery();
			  while(rs.next()){
				 User searchUser = new User();
				 searchUser.setUserId(rs.getInt("userId"));
				 searchUser.setPsw(rs.getString("psw"));
				 searchUser.setUsername(rs.getString("username")); 
				  searchUser.setEmail(rs.getString("email"));
				  searchUser.setAddress(rs.getString("address"));
				  searchUser.setTel(rs.getString("tel"));
				  searchUser.setAge(rs.getInt("age"));
				  searchUser.setOccupation(rs.getString("occupation"));
				  searchUser.setImage(rs.getString("image"));
				  searchUser.setTarget(rs.getString("target"));
				  users.add(searchUser);
			  }
			  return users;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return users;
		  
  }
 
  public int updateUser(User user){
	  Connection conn = null;
	  PreparedStatement psmt =null;
		  try {
			conn = getConn();
			 String sql="update user set username=?,psw=?,email=?,tel=?,address=?,age=?,occupation=?,target=?where userId=?";
			 psmt =conn.prepareStatement(sql);
			 psmt.setString(1, user.getUsername());
			 psmt.setString(2, user.getPsw());
			 psmt.setString(3, user.getEmail());
			 psmt.setString(4, user.getTel());
			 psmt.setString(5, user.getAddress());
			 psmt.setInt(6, user.getAge());
			 psmt.setString(7, user.getOccupation());
			 psmt.setString(8, user.getTarget());
			 psmt.setInt(9, user.getUserId());
			 int n= psmt.executeUpdate();
			 return n;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,null);
		}
		  return 0;
		  
  }
  public int updateTarget(User user){
	  Connection conn = null;
	  PreparedStatement psmt =null;
		  try {
			conn = getConn();
			 String sql="update user set target=?where userId=?";
			 psmt =conn.prepareStatement(sql);
			 psmt.setString(1, user.getTarget());
			 psmt.setInt(2, user.getUserId());
			int n= psmt.executeUpdate();
			 return n;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,null);
		}
		  return 0;
		  
  }
  public int updateImage(User user){
	  Connection conn = null;
	  PreparedStatement psmt =null;
		  try {
			conn = getConn();
			 String sql="update user set image=?where userId=?";
			 psmt =conn.prepareStatement(sql);
			 psmt.setString(1, user.getImage());
			 psmt.setInt(2, user.getUserId());
			int n= psmt.executeUpdate();
			 return n;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,null);
		}
		  return 0;
		  
  }
  //通过id查询user
  public User searchUserById(int userId){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
	  User searchUser = null;
		  try {
			conn = getConn();
			 String sql="select * from user where userId=?";
			 psmt =conn.prepareStatement(sql);
			  psmt.setInt(1, userId);
			  rs = psmt.executeQuery();
			  if(rs.next()){
				 searchUser = new User();
				 searchUser.setUserId(rs.getInt("userId"));
				 searchUser.setPsw(rs.getString("psw"));
				 searchUser.setUsername(rs.getString("username")); 
				  searchUser.setEmail(rs.getString("email"));
				  searchUser.setAddress(rs.getString("address"));
				  searchUser.setTel(rs.getString("tel"));
				  searchUser.setAge(rs.getInt("age"));
				  searchUser.setOccupation(rs.getString("occupation"));
				  searchUser.setImage(rs.getString("image"));
				  searchUser.setTarget(rs.getString("target"));
				  return searchUser;
			  }
			  
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return searchUser;
		  
  }
  public int deleteUser(int userId) {
	  	  Connection conn = null;
		  PreparedStatement psmt =null;
		  try {
			conn = getConn();
			String sql="delete from user where userId=?";
			psmt =conn.prepareStatement(sql);
			psmt.setInt(1, userId);
			int n=psmt.executeUpdate();
			return n;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
			 close(conn,psmt,null);
			}
		   return 0;
	  
	  
	  
  }
  public Sport searchSport(String username) {
	  	
	  	Connection conn = null;
		PreparedStatement psmt =null;
		ResultSet rs=null;
		Sport searchSport=null;
		  try {
			conn = getConn();
			 String sql="select * from sport,user where user.username=? and user.userId=sport.userId";
			 psmt=conn.prepareStatement(sql);
			 psmt.setString(1, username);
			 rs=psmt.executeQuery();
			 if(rs.next()) {
				searchSport=new Sport();
				searchSport.setSid(rs.getInt("sid"));
				searchSport.setUserId(rs.getInt("userId"));
				searchSport.setStep_number(rs.getInt("step_number"));
				searchSport.setEnergy(rs.getString("energy"));
				return searchSport;
			 }
			  
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,null);
		}
		  return searchSport;
		
}
  public int serachRanking(String username) {
		int n=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs = null;
		try {
			conn=getConn();
			String sql="select count(*) from (select * from sport ORDER BY step_number DESC) AS a where\r\n" + 
					"step_number>=(select step_number from sport,user where user.username=? and user.userId=sport.userId)";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,username);
			rs = psmt.executeQuery();
			if(rs.next()) {
				n=rs.getInt(1);
				
				return n;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn,psmt,null);
		}
		return n;
	}
  public Study searchStudy(String username) {
	  	
	  	Connection conn = null;
		PreparedStatement psmt =null;
		ResultSet rs=null;
		Study searchStudy=null;
		  try {
			conn = getConn();
			 String sql="select * from study,user where user.username=? and user.userId=study.userId";
			 psmt=conn.prepareStatement(sql);
			 psmt.setString(1, username);
			 rs=psmt.executeQuery();
			 if(rs.next()) {
				searchStudy=new Study();
				searchStudy.setStid(rs.getInt("stid"));
				searchStudy.setUserId(rs.getInt("userId"));
				searchStudy.setSty_time(rs.getDouble("sty_time"));
				searchStudy.setTest_questions(rs.getString("test_questions"));
				searchStudy.setWord(rs.getString("word"));
				
				return searchStudy;
			 }
			  
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,null);
		}
		  return searchStudy;
		
}
  public User showUser(String username) {
	  	
	  	Connection conn = null;
		PreparedStatement psmt =null;
		ResultSet rs=null;
		User showUser=null;
		  try {
			conn = getConn();
			 String sql="select * from user where username=?";
			 psmt=conn.prepareStatement(sql);
			 psmt.setString(1,username);
			 rs=psmt.executeQuery();
			 if(rs.next()) {
				
				showUser=new User();
				showUser.setUserId(rs.getInt("userId"));
				showUser.setUsername(rs.getString("username"));
				showUser.setEmail(rs.getString("email"));
				showUser.setTel(rs.getString("tel"));
				showUser.setAddress(rs.getString("address"));
				showUser.setAge(rs.getInt("age"));
				showUser.setOccupation(rs.getString("occupation"));
				showUser.setImage(rs.getString("image"));
				showUser.setTarget(rs.getString("target"));
				return showUser;
			 }
			  
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,null);
		}
		  return showUser;	
}
  public ArrayList<henu.rjxy.dto.searchSport> searchAllsport_list(int begin,int pageNum){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
	  henu.rjxy.dto.searchSport searchsport_list=null;
	  ArrayList<henu.rjxy.dto.searchSport> sportList = new ArrayList<henu.rjxy.dto.searchSport>();
		  try {
			conn = getConn();
			 String sql="select username,sport_value,image from sports_list,user where user.userId=sports_list.userId order by sport_value desc limit ?,?";
			 psmt =conn.prepareStatement(sql);
			 psmt.setInt(1, begin);
			 psmt.setInt(2, pageNum);
			 rs = psmt.executeQuery();
			 while(rs.next()){
				 searchsport_list = new henu.rjxy.dto.searchSport();
				  searchsport_list.setUsername(rs.getString("username"));
				  searchsport_list.setSport_value(rs.getInt("sport_value"));
				  searchsport_list.setImage(rs.getString("image"));
				  sportList.add(searchsport_list);
			  }
			 return sportList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return sportList;  
  }
  public ArrayList<henu.rjxy.dto.searchStudy> searchAllstudy_list(int begin,int pageNum){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
	  henu.rjxy.dto.searchStudy searchstudy_list=null;
	  ArrayList<henu.rjxy.dto.searchStudy> studyList = new ArrayList<henu.rjxy.dto.searchStudy>();
		  try {
			conn = getConn();
			 String sql="select username,study_time,image from study_list,user where user.userId=study_list.userId order by study_time desc limit ?,?";
			 psmt =conn.prepareStatement(sql);
			 psmt.setInt(1, begin);
			 psmt.setInt(2, pageNum);
			 rs = psmt.executeQuery();
			 while(rs.next()){
				 searchstudy_list = new  henu.rjxy.dto.searchStudy();
				 searchstudy_list.setUsername(rs.getString("username"));
				  searchstudy_list.setStudy_time(rs.getInt("study_time"));
				  searchstudy_list.setImage(rs.getString("image"));
				  studyList.add(searchstudy_list);
			  }
			 return studyList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return studyList;  
  }
  public ArrayList<henu.rjxy.dto.searchSport> searchSportByName(String username){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
	  henu.rjxy.dto.searchSport searchsport=null;
	  ArrayList<henu.rjxy.dto.searchSport> sport = new ArrayList<henu.rjxy.dto.searchSport>();
		  try {
			conn = getConn();
			 String sql="select username,sport_value from sports_list,user where user.userId=sports_list.userId  and username like ? order by sport_value desc";
			 psmt =conn.prepareStatement(sql);
			  psmt.setString(1, "%"+username+"%");
			  rs = psmt.executeQuery();
			  while(rs.next()){
				  searchsport = new henu.rjxy.dto.searchSport();
				  searchsport.setUsername(rs.getString("username"));
				  searchsport.setSport_value(rs.getInt("sport_value"));
				  sport.add(searchsport);
			  }
			  return sport;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return sport;
  }
  public ArrayList<henu.rjxy.dto.searchStudy> searchStudyByName(String username){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
	  henu.rjxy.dto.searchStudy searchstudy=null;
	  ArrayList<henu.rjxy.dto.searchStudy> study = new ArrayList<henu.rjxy.dto.searchStudy>();
		  try {
			conn = getConn();
			 String sql="select username,study_time from study_list,user where user.userId=study_list.userId  and username like ? order by study_time desc";
			 psmt =conn.prepareStatement(sql);
			  psmt.setString(1, "%"+username+"%");
			  rs = psmt.executeQuery();
			  while(rs.next()){
				  searchstudy = new  henu.rjxy.dto.searchStudy();
				  searchstudy.setUsername(rs.getString("username"));
				  searchstudy.setStudy_time(rs.getInt("study_time"));
				  study.add(searchstudy);
			  }
			  return study;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return study;
  }
  public int searchSportNum(){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
		  try {
			conn = getConn();
			 String sql="select count(*) as total from sports_list";
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
  public int searchStudyNum(){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
		  try {
			conn = getConn();
			 String sql="select count(*) as total from study_list";
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
  
  //管理员登录
  public Admin searchAdmin(Admin admin){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
	  Admin searchAdmin=null;
		  try {
			conn = getConn();
			 String sql="select * from admin where aname=? and apsw=?";
			 psmt =conn.prepareStatement(sql);
			  psmt.setString(1, admin.getAname());
			  psmt.setString(2, admin.getApsw());
			  rs = psmt.executeQuery();
			  if(rs.next()){
				  searchAdmin = new Admin();
				  searchAdmin.setAid(rs.getInt("aid"));
				  searchAdmin.setAname(rs.getString("aname"));
				  searchAdmin.setApsw(rs.getString("apsw"));
				 return searchAdmin;
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return searchAdmin;
  }  
  //查询所有用户分页;
  public ArrayList<User> searchAllUsers(int begin,int pageNum){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
	  User searchUser=null;
	  ArrayList<User> userList = new ArrayList<User>();
		  try {
			conn = getConn();
			 String sql="select * from user order by userId desc limit ?,?";
			 psmt =conn.prepareStatement(sql);
			 psmt.setInt(1, begin);
			 psmt.setInt(2, pageNum);
			 rs = psmt.executeQuery();
			 while(rs.next()){
				  searchUser = new User();
				  searchUser.setUserId(rs.getInt("userId"));
				  searchUser.setUsername(rs.getString("username"));
				  searchUser.setEmail(rs.getString("email"));
				  searchUser.setTel(rs.getString("tel"));
				  searchUser.setAddress(rs.getString("address"));
				  searchUser.setAge(rs.getInt("age"));
				  searchUser.setOccupation(rs.getString("occupation"));
				  searchUser.setImage(rs.getString("image"));
				  searchUser.setTarget(rs.getString("target"));
				  userList.add(searchUser);
			  }
			 return userList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return userList;
  }
  public int searchAllUserNum(){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
		  try {
			conn = getConn();
			 String sql="select count(*) as total from user";
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
  	//查询所有好友
  public ArrayList<User> searchFriends(int userId){
	  Connection conn = null;
	  PreparedStatement psmt =null;
	  ResultSet rs = null;
	  ArrayList<User> users = new ArrayList<User>();
		  try {
			conn = getConn();
			 String sql="select * from user where userid in(select fid from user,friends where `user`.userId=friends.uid and uid=?);";
			  psmt =conn.prepareStatement(sql);
			  psmt.setInt(1, userId);
			  rs = psmt.executeQuery();
			  while(rs.next()){
				 User searchUser = new User();
				 searchUser.setUserId(rs.getInt("userId"));
				 searchUser.setPsw(rs.getString("psw"));
				 searchUser.setUsername(rs.getString("username")); 
				  searchUser.setEmail(rs.getString("email"));
				  searchUser.setAddress(rs.getString("address"));
				  searchUser.setTel(rs.getString("tel"));
				  searchUser.setAge(rs.getInt("age"));
				  searchUser.setOccupation(rs.getString("occupation"));
				  searchUser.setImage(rs.getString("image"));
				  searchUser.setTarget(rs.getString("target"));
				  users.add(searchUser);
			  }
			  return users;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,rs);
		}
		  return users;
		  
  }
  public Friend showFriend(String username) {
	  	
	  	Connection conn = null;
		PreparedStatement psmt =null;
		ResultSet rs=null;
		Friend showFriend=null;
		  try {
			conn = getConn();
			 String sql="select * from user where user.username=?";
			 psmt=conn.prepareStatement(sql);
			 psmt.setString(1,username);
			 rs=psmt.executeQuery();
			 if(rs.next()) {
				
				showFriend=new Friend();
				showFriend.setUserId(rs.getInt("userId"));
				showFriend.setUsername(rs.getString("username"));
				showFriend.setEmail(rs.getString("email"));
				showFriend.setTel(rs.getString("tel"));
				showFriend.setAddress(rs.getString("address"));
				showFriend.setAge(rs.getInt("age"));
				showFriend.setOccupation(rs.getString("occupation"));
				showFriend.setImage(rs.getString("image"));
				showFriend.setTarget(rs.getString("target"));
				return showFriend;
			 }
			  
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		 close(conn,psmt,null);
		}
		  return showFriend;	
}
}
