package com.ecomm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.bean.LoginBean;
import com.ecomm.bean.ProductListBean;
import com.ecomm.entity.Product;
import com.ecomm.entity.User;
import com.ecomm.service.ProductService;
import com.ecomm.service.UserService;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String home(@RequestBody Product product) {
		this.service.saveProduct(product);
		return "home";
	}
	
	@PostMapping(value = "get", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Product> login(@Valid @RequestBody ProductListBean bean) {
		return this.service.getAll();
		
	}

}
