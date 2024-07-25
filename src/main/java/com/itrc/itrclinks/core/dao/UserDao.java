package com.itrc.itrclinks.core.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.itrc.itrclinks.core.domain.User;

@Component
public interface UserDao {

	public User getUserId(int id);
	public List<User> getAllUsers();
}
