package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController 
{

	@RequestMapping("/Login")
	public String showLogin(Model m)
	{
		m.addAttribute("pageinfo", "Login");
		return "Login";
	}
	@RequestMapping("/Home")
	public String showHome(Model m)
	{
		m.addAttribute("pageinfo", "Home");
		return "index";
	}
	@RequestMapping("/Register")
	public String showRegister(Model m)
	{
m.addAttribute("pageinfo", "Register");
		return "Register";
	}
	@RequestMapping("/AboutUs")
	public String showAboutUs(Model m)
	{
		m.addAttribute("pageinfo", "AboutUs");
		return "AboutUs";
	}
	@RequestMapping("/ContactUs")
	public String showContactUs(Model m)
	{
		m.addAttribute("pageinfo", "ContactUs");
		return "ContactUs";
	}
}




