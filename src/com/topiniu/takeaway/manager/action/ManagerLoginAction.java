package com.topiniu.takeaway.manager.action;

import com.opensymphony.xwork2.ActionContext;
import com.topiniu.takeaway.entity.Manager;

public class ManagerLoginAction extends ManagerBaseAction {

	private static final long serialVersionUID = 1L;

	private int id;
	private String pass;
	
	private String msg;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String login(){
		System.out.println("to manager login");
		System.out.println(managerService);
		Manager m = managerService.getManager(id);
		if(m == null)
			msg="No this manager.";
		else if(!m.getPassword().equals(pass))
			msg="Password wrong.";
		else
		{
			msg="LOGINPASS";
			ActionContext.getContext().getSession().put("Logined_mgr", m);
		}
		return SUCCESS;
	}

}
