package com.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.dao.ProductDao;
import com.ecomm.dao.UserDao;
import com.ecomm.entity.Product;
import com.ecomm.entity.User;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductDao dao;

	public void saveProduct(Product product) {

		this.dao.saveProduct(product);
	}

	public List<Product> getAll() {

		return this.dao.getAll();
	}
}
