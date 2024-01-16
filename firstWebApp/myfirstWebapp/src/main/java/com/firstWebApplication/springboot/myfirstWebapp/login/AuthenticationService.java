package com.firstWebApplication.springboot.myfirstWebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String userName, String userPassword) {

		boolean isValidUserName = userName.equalsIgnoreCase("admin");
		boolean isValidUserPassword = userPassword.equalsIgnoreCase("adminPW");

		return isValidUserName && isValidUserPassword;
	}

}
