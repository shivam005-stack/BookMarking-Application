package com.s.thrillo.managers;

import java.util.List;

import com.s.thrillo.constants.Gender;
import com.s.thrillo.constants.UserType;
import com.s.thrillo.dao.UserDao;
import com.s.thrillo.entities.User;

public class UserManager {
private static UserManager instance = new UserManager();
private UserDao dao= new UserDao();
private UserManager() {}

public static UserManager getInstance() {
	 return instance;
}
  public User createUser(long id,String email,String password, String firstname, String lastname, Gender gender,UserType userType ) {
	  User user = new User();
	  user.setId(id);
	  user.setEmail(email);
	  user.setPassword(password);
	  user.setFirstname(firstname);
	  user.setLastname(lastname);
	  user.setGender(gender);
	  user.setUserType(userType);
	    return user;
  }
   public List<User> getUsers() {
	   return dao.getUsers();
   }
}
