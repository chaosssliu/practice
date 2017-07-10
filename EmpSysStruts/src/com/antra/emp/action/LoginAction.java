package com.antra.emp.action;

import org.apache.commons.lang3.StringUtils;

import com.antra.emp.entity.User;
import com.antra.emp.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User> {
	
	private User user = new User();
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public void validate() {
		if (StringUtils.isEmpty(user.getUserId())) {
			addFieldError("userId", "User ID cannot be blank");
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			addFieldError("password", "Password cannot be blank");
		}
	}
	
	public String execute() {
		LoginService loginService = new LoginService();
		if (loginService.verifyLogin(user)) {
			return "success";
		}
		return "login";
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	
}
