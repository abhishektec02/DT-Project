package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.dao.OrderDAO;
import com.niit.model.OrderDetail;

public class OrderUnitTest
{

static OrderDAO orderDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();	
		orderDAO=(OrderDAO)context.getBean("orderDAO");
	}
	
	@Test
	public void saveOrderTest()
	{
		OrderDetail orderDetail=new OrderDetail();
		
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setCartId(101);
		orderDetail.setShippingAddr("Kamla Nagar");
		orderDetail.setTotalAmount(5000);
		orderDetail.setTranType("COD");
		orderDetail.setUsername("rajat");
		
		assertTrue("problem in Saving Order",orderDAO.saveOrder(orderDetail));
	}
	@Test
	public void updateCart()
	{
		assertTrue("problem in Updating Cart",orderDAO.updateCart("rajat"));
		
	}
	
}









