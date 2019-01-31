package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.OrderDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.UserDAO;
import com.niit.model.CartItem;
import com.niit.model.OrderDetail;
import com.niit.model.UserDetail;

@Controller
public class PaymentController 
{
	
	@Autowired
	CartDAO cartDAO;


	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
@RequestMapping("/checkout")
public String checkout(Model m,HttpSession session)
{
	
	String username=(String)session.getAttribute("username");	    
    List<CartItem> cartItemList=cartDAO.listCartItem(username);
   
    m.addAttribute("cartItemList", cartItemList);
    m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
	UserDetail userDetail=userDAO.getUser(username);
   String address=userDAO.getUser(username).getCustomerAddr();
    m.addAttribute("addr", address);
    
	return "OrderConfirm";
}

@RequestMapping(value="/updateAddress",method=RequestMethod.POST)
public String updateAddress(@RequestParam("addr")String addr,Model m,HttpSession session )
{

	String username=(String)session.getAttribute("username");	    
    List<CartItem> cartItemList=cartDAO.listCartItem(username);
   
    m.addAttribute("cartItemList", cartItemList);
    m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
    
	UserDetail userDetail=userDAO.getUser(username);
	userDetail.setCustomerAddr(addr);
    userDAO.updateAddress(userDetail);

   String address=userDetail.getCustomerAddr();
   
    m.addAttribute("addr",address);
	
	return "OrderConfirm";
}

@RequestMapping(value="/payment")
public String PaymentPage(Model m,HttpSession session)
{
	
return "Payment";
	
}
	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String generateReceipt(@RequestParam ("Pmode")String Pmode,Model m,HttpSession session) 
	{
		String username=(String)session.getAttribute("username");

		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setShippingAddr(userDAO.getUser(username).getCustomerAddr());
		orderDetail.setTranType(Pmode);
		orderDetail.setUsername(username);
		
		   List<CartItem> cartItemList=cartDAO.listCartItem(username);
		   
		    m.addAttribute("cartItemList", cartItemList);
		    m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		    
			UserDetail userDetail=userDAO.getUser(username);
		
		
		orderDetail.setTotalAmount(this.getGrandTotal(cartItemList));
		
		orderDAO.saveOrder(orderDetail);
		orderDAO.updateCart(username);
		m.addAttribute("orderDetail", orderDetail);
		
		
		
		
		return "Receipt";
	}
	
	
public int getGrandTotal(List<CartItem> cartList)
{
	 int grandTotal=0,count=0;
	 
	 
	 while(count<cartList.size())
	 {
		 grandTotal=grandTotal+(cartList.get(count).getQuantity()*cartList.get(count).getPrice());
		 count++;
	 }
	 
	 return grandTotal; 
}


}
