package com.firstWebApplication.springboot.myfirstWebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

	private AuthenticationService authenticationService;

	@Autowired
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String gotoLoginPage() {

		return "login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

		if (authenticationService.authenticate(name, password)) {
			model.put("name", name);

			return "welcome";
		}
		String errorMsg = "admin login is failed! Please try again";
		model.put("error", errorMsg);
		return "login";
	}
}
