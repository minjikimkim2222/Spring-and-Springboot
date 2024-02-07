package com.firstWebApplication.springboot.myfirstWebapp.login;

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
		model.put("name", "minjiki2");
		return "welcome";
	}

}
