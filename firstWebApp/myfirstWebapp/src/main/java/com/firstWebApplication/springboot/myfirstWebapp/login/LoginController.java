package com.firstWebApplication.springboot.myfirstWebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(@RequestParam String name, @RequestParam Character gender, @RequestParam int age,
			ModelMap model) {

		model.put("name", name);
		model.put("gender", gender);
		model.put("age", age);

		return "login";
	}
}
