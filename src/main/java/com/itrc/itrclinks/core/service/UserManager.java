package com.itrc.itrclinks.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itrc.itrclinks.core.dao.UserDao;
import com.itrc.itrclinks.core.domain.User;

@Transactional
@Service
public class UserManager {
	
	@Autowired
	private UserDao dao;

	
	public User getUserId(int id) {
		return dao.getUserId(id);
	}
	
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}
	
	public boolean saveUser(User user) {
		dao.saveUser(user);
		return true;
	}
	
	public boolean updateUser(User user) {
		dao.updateUser(user);
		return true;
	}
	
	public boolean deleteUser(User user) {
		dao.deleteUser(user);
		return true;
	}
}
