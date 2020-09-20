package com.s.thrillo.dao;

import java.util.List;

import com.s.thrill.DataStore;
import com.s.thrillo.entities.User;

public class UserDao {
 public List<User> getUsers() {
	  return DataStore.getUsers();
 }
}
