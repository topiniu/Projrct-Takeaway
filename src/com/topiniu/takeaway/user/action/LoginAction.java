package com.topiniu.takeaway.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.topiniu.takeaway.entity.User;

public class LoginAction extends UserBaseAction {

	private String userName;
	private String password;
	
	private String msg;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login(){
		out("userloginAction","login:" + userName + "---" + password);
		User u = userService.getUserByName(userName);
		if(u!=null)
		{
			if(password.equals(u.getPassword())){
				ActionContext.getContext().getSession().put("Logined_user", u);
				msg="LOGINPASS";
			}else{
				msg="�û��������벻ƥ��";
			}
		}else{
			msg="δ�ҵ����û�";
		}
		System.out.println("****************" + msg + "**********************");
		return SUCCESS;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	private void out(String atr,String str)
	{
		System.out.println(">>>>>>>>>>>>>����" + atr + ":\t" + str + "\t<<<<<<<<<<<<");
	}
	
}
