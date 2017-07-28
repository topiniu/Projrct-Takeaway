package com.topiniu.takeaway.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.topiniu.takeaway.manager.serviceInter.ManagerServiceInter;
import com.topiniu.takeaway.manager.serviceInter.UserServiceInter;

public class ManagerBaseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	protected ManagerServiceInter managerService;

	protected UserServiceInter userService;

	public void setManagerService(ManagerServiceInter managerService) {
		this.managerService = managerService;
	}

	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}
	
	
}
