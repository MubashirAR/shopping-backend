package com.niit.backend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.UserDAO;
import com.niit.backend.model.User;

public class UserTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;

	@Autowired
	private static User user;

	@Autowired
	private static UserDAO userDAO;

	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		user = (User) context.getBean("user");

		userDAO = (UserDAO) context.getBean("userDAO");

	}

	

	//@Test
	public void UpdateUserTestCase() {
		user.setId("UR12345");
		user.setName("Hitu");
		user.setPassword("hitu");
		user.setMail("hitu@gmail.com");
		user.setContact("5678700000");

		boolean flag = userDAO.update(user);

		assertEquals("UpdateUserTestCase", true, flag);

	}
	
	//@Test
	public void validateCreationTestCase() {

		boolean flag = userDAO.validate("priti", "priti456");
		assertEquals("validateCreationTestCase", true, flag);

	}

	//@Test
	public void getUserTestCase() 
	{

		user = userDAO.getUser("priti123d");
		assertEquals("getUserTestCase", null, user);

	}
	
	//@Test
	public void getallUserTestCase() {

		int size = userDAO.list().size();

		assertEquals("getallUserTestCase", 3, size);
	}
	
	@Test
	public  void createUserTestCase(){
		
		user = new User();//BECAUSE IT IS GIVING NULL POINTER EXCEPTION.
		
		user.setId("pr1iti02020");
		user.setName("priti456");
		user.setPassword("pritit456");
		user.setMail("priti8@gmail.com");
		user.setContact("30250255");
		user.setRole("Admin");
		
		 boolean flag=userDAO.save(user);
		 
		 assertEquals ("createUserTestcase",true, flag);
		
		
	}

}