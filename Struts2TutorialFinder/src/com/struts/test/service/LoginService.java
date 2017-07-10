package com.struts.test.service;

import com.struts.test.model.User;

public class LoginService {
	
	public boolean verifyLogin(User user) {
		if (user.getUserId().equals("admin") && user.getPassword().equals("1234")) {
			return true;
		}
		return false;
	}

}
