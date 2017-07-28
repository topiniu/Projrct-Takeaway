package com.topiniu.takeaway.operator.action;

import com.opensymphony.xwork2.ActionSupport;
import com.topiniu.takeaway.manager.serviceInter.OperatorServiceInter;
import com.topiniu.takeaway.manager.serviceInter.UserServiceInter;
import com.topiniu.takeaway.serviceImpl.OperatorServiceImpl;

public class OperatorBaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	protected OperatorServiceInter operatorService;

	protected UserServiceInter userService;

	public void setOperatorService(OperatorServiceInter operatorService) {
		this.operatorService = operatorService;
	}

	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}
	
	
}
