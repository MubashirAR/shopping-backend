package com.niit.backend.testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.CartDAO;
import com.niit.backend.model.MyCart;

public class CartTestCase {
	
	@Autowired
	private static MyCart myCart;
	
	@Autowired
	private static CartDAO cartDAO;
	
	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
	
		myCart = (MyCart) context.getBean("myCart");

		cartDAO = (CartDAO) context.getBean("cartDAO");
		
		
	}
	
	@Test
	public void createList(){
		
		int size= cartDAO.list("mub").size();
		
		assertEquals("getallProductTestcase", 4, size);
		
	}
	
	//@Test
	 public void createMycartTestcase() {
	
	
	myCart.setUserId("mub");
	myCart.setName("fdfdfdff");
	myCart.setPrice(838383);
	myCart.setStatus('A');
	myCart.setAddedDate(new Date());
	
	
	 boolean flag = cartDAO.save(myCart);
	
	 assertEquals("createMycartTestcase()", true, flag);
	
	 }
		
		
	//@Test
	 public void UpdateMycartTestcase() {
	
	myCart.setId(101l);
	myCart.setUserId("mub");
	myCart.setName("fd");
	myCart.setPrice(838);
	myCart.setStatus('N');
	myCart.setQuantity(1);
	myCart.setAddedDate(new Date());
	
	
	 boolean flag = cartDAO.update(myCart);
	
	 assertEquals("UpdateMycartTestcase()", true, flag);
	
	 }
		
	
	//@Test
	public void deleteByCartTestCase() {

		myCart.setId(102l);

		boolean flag = cartDAO.delete(myCart);
		assertEquals("deleteByCartTestCase", true, flag);

	}

	
	public void listTestCase()
	{
		
	}
	
	
	

}