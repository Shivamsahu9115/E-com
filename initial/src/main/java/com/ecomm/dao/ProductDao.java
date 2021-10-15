package com.ecomm.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.bean.LoginBean;
import com.ecomm.entity.Product;
import com.ecomm.entity.User;

@Repository
public class ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	private String SELECT_ALL_SQL_FULL = "select p from Product p";

	public void saveProduct(Product product) {
		this.sessionFactory.getCurrentSession().save(product);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAll() {
		return this.sessionFactory.getCurrentSession().createQuery(SELECT_ALL_SQL_FULL).getResultList();
	}

	public User get(LoginBean user) {

		String hql = "select u from User u where u.userName=:userName and u.password =:password";
		return (User) this.sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("userName", user.getUserName()).setParameter("password", user.getPassword())
				.uniqueResult();
	}
}
