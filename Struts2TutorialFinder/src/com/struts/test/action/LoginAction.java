package com.struts.test.action;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.test.model.User;
import com.struts.test.service.LoginService;

public class LoginAction extends ActionSupport implements ModelDriven<User> /*implements Action*/ {

//	private String userId;
//	private String password;
	private User user = new User();
	
//	private static String SUCCESS = "success";
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void validate() {
		if (StringUtils.isEmpty(user.getUserId())) {
			// User Id blank
			addFieldError("userId", "User ID cannot be blank");
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			// Password blank
			addFieldError("password", "Password cannot be blank");
		}
	}
	
	public String execute() {
		LoginService loginService = new LoginService();
//		user = new User();
//		user.setUserId(userId);
//		user.setPassword(password);
// set in login.jsp
		
		if (loginService.verifyLogin(user)) {
			return SUCCESS;
		}
		return LOGIN;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
}
