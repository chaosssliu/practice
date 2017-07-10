package com.antra.emp.service;

import com.antra.emp.entity.User;

public class LoginService {

	public boolean verifyLogin(User user) {
		if (user.getUserId().equals("admin") && user.getPassword().equals("1234")) {
			return true;
		}
		return false;
	}
}
