package com.ways.live.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ways.live.model.User;
import com.ways.live.service.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	
	
	@RequestMapping(value = "/loginApp",method = RequestMethod.GET)
	public String login(@RequestParam String userName, @RequestParam String password, HttpServletRequest request, Model model) {
		User currentUser = (User)request.getSession().getAttribute("currentUser");
		if(currentUser != null)
		{
			return "home";
		}
		
		User user = userService.getUser(userName, password);
		if(user != null)
		{
			request.getSession().setAttribute("currentUser", user);
			return "home";
		}

		model.addAttribute("message", "invalid user name or password");
		return "index";
	}

}
