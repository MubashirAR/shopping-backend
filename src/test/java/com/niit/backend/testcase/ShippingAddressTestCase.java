package com.niit.backend.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.ProductDAO;
import com.niit.backend.dao.ShippingAddressDAO;
import com.niit.backend.model.Product;
import com.niit.backend.model.ShippingAddress;

public class ShippingAddressTestCase {
	
	@Autowired
	private static ShippingAddress shippingaddress;
	
	@Autowired
	private static ShippingAddressDAO shippingaddressDAO;
	
	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		shippingaddress = (ShippingAddress) context.getBean("shippingAddress");

		shippingaddressDAO = (ShippingAddressDAO) context.getBean("shippingaddressDAO");
	}
	
	@Test
	public void updateAdressTestCase()
	{
		
		shippingaddress.setId("1");
		shippingaddress.setBno(1);
		shippingaddress.setCity("maf");
		shippingaddress.setCountry("srg");
		shippingaddress.setPin(123);
		shippingaddress.setState("sg");
		shippingaddress.setStreet("srg");
		shippingaddress.setUser_id("mub");
		
		boolean flag = shippingaddressDAO.update(shippingaddress);
		
		 assertEquals("updateAddressTestCase", true, flag);

	}

}
