package com.firstWebApplication.springboot.myfirstWebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedInUsername());
		return "welcome";
	}

	private String getLoggedInUsername() {
		// 로그인된 사용자 이름을 Spring Security를 통해 받을 것
		// Spring Security에 존재하는 SecurityContextHolder
		Authentication authentication

				= SecurityContextHolder.getContext().getAuthentication();

		return authentication.getName();
	}
}
