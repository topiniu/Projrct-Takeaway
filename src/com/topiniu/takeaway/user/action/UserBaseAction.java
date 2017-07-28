package com.topiniu.takeaway.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.topiniu.takeaway.manager.serviceInter.OperatorServiceInter;
import com.topiniu.takeaway.manager.serviceInter.UserServiceInter;

public class UserBaseAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	protected UserServiceInter userService;
	protected OperatorServiceInter operatorService;

	public UserServiceInter getUserService() {
		return userService;
	}

	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}

	public OperatorServiceInter getOperatorService() {
		return operatorService;
	}

	public void setOperatorService(OperatorServiceInter operatorService) {
		this.operatorService = operatorService;
	}
	
}
