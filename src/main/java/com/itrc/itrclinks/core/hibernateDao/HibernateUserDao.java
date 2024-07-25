package com.itrc.itrclinks.core.hibernateDao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.itrc.itrclinks.core.dao.UserDao;
import com.itrc.itrclinks.core.domain.User;

@Repository
public class HibernateUserDao implements UserDao {

	@Autowired
	@Qualifier(value="sessionFactory")
	SessionFactory sf;

	public User getUserId(int id) {
		try {
			return (User) sf.getCurrentSession().get(User.class, id);
		} catch (Exception e) {
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return sf.getCurrentSession().createQuery("FROM User ORDER BY fullName ASC").list();
	}


	public void saveUser(User user) {
		sf.getCurrentSession().save(user);
	}


	public void updateUser(User user) {
		sf.getCurrentSession().merge(user);
	}


	public void deleteUser(User user) {
		sf.getCurrentSession().delete(user);
	}
}
