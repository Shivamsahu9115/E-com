package com.ecomm.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecomm.bean.LoginBean;
import com.ecomm.entity.User;

@Repository
public class UserDao {


	@Autowired
	private SessionFactory sessionFactory;

	public void saveUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
	}

	public User auth(LoginBean user) {
		
		
		 String hql = "select u from User u where u.userName=:userName and u.password =:password";
        return (User) this.sessionFactory.getCurrentSession().createQuery(hql).setParameter("userName", user.getUserName()).setParameter("password", user.getPassword())
                .uniqueResult();
	}
}
