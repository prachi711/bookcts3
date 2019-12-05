package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.Entity.User;
import com.cts.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="index")//by default it is GET method
	private String indexPage() {
		return "index";
	}
	@RequestMapping(value="login")//by default it is GET method
	private String welcomePage() {
		return "login";
	}
	
	
	@RequestMapping(value="registerpage")
	private String registerPage() {
		return "register";
	}
	
	@RequestMapping(value="registeruser",method=RequestMethod.POST)
	private String register(@ModelAttribute("user") User user)
	{
		//User user=new User(userName,password,DOB,address,name);
		
		userService.registerUser(user);
		
		return "viewBook";
		
			 /*String result = userService.registerUser(user);
		
		System.out.println(result);
		ModelAndView mv=new ModelAndView();
		
			mv.setViewName("login");
			return mv;
		*/
		
		
	}
	
	
	
	
	
	@RequestMapping(value="loginuser",method=RequestMethod.POST)//frontend to backend
	private ModelAndView loginUser(@RequestParam("uname")String userName,@RequestParam("pname")String password) throws Exception
	{
		User user=new User(userName,password);
		
		
		
			 String result = userService.loginUser(user);
		
		System.out.println(result);
		ModelAndView mv=new ModelAndView();
		
			mv.setViewName("books");
			return mv;
		
		
		
	}

}
