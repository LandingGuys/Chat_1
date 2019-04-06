package henu.rjxy.service;

import java.util.ArrayList;

import henu.rjxy.bean.User;

public interface UserService {
  public int updateUser(User user);
  public int updateTarget(User user);
public int updateImage(User user);
 public User searchUserById(int userId);
 public ArrayList<User> searchFriends(int userId);
}
