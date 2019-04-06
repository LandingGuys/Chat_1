package henu.rjxy.validate;

import henu.rjxy.bean.User;

import java.util.HashMap;
import java.util.regex.Pattern;

public class UserFormValidate {
	private User user;
    public HashMap<String,String> validate(){
		HashMap<String,String> errors = new HashMap<String,String>();
		String usernamePattern="^[a-zA-Z0-9\u4e00-\u9fa5]{2,10}$";
		String pswPattern="^[a-zA-Z0-9]{6,15}$";
		String emialPattern="^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		if(user.getUsername()==null||!Pattern.matches(usernamePattern, user.getUsername())){
			errors.put("username", "用户名格式错误");
		}
		if(user.getPsw()==null||!Pattern.matches(pswPattern, user.getPsw())){
			errors.put("psw", "密码格式错误");
		}
		if(user.getPsw()==null||user.getRepsw()==null||!user.getPsw().equals(user.getRepsw())){
			errors.put("repsw", "确认密码与密码不一致");
		}
		if(user.getEmail()==null||!Pattern.matches(emialPattern, user.getEmail())){
			errors.put("email", "邮箱格式错误");
		}
		return errors;
  }
    public HashMap<String,String> loginvalidate(){
		HashMap<String,String> errors = new HashMap<String,String>();
		String usernamePattern="^[a-zA-Z0-9\u4e00-\u9fa5]{2,10}$";
		String pswPattern="^[a-zA-Z0-9]{6,18}$";
		if(user.getUsername()==null||!Pattern.matches(usernamePattern, user.getUsername())){
			errors.put("username", "用户名格式错误");
		}
		if(user.getPsw()==null||!Pattern.matches(pswPattern, user.getPsw())){
			errors.put("psw", "密码格式错误");
		}
		return errors;
  }
public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
}
