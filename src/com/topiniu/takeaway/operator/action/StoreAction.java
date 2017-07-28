package com.topiniu.takeaway.operator.action;

import com.opensymphony.xwork2.ActionContext;
import com.topiniu.takeaway.entity.User;

public class StoreAction extends OperatorBaseAction {

	private static final long serialVersionUID = 1L;
	
	private String storeName;
	private int CCStore;
		
	
	public String isCCStore(){
		System.out.println("****进入StoreAction的isCCStore方法****");
		setCCStore(((User)ActionContext.getContext().getSession().get("Logined_user")).getIsCCStore());
		
		return SUCCESS;
	}
	public String createStore(){
		System.out.println("****  StoreAction---createStore--storeName=  " + storeName + "  ****");
		int userId = ((User)ActionContext.getContext().getSession().get("Logined_user")).getId();
		userService.creatStore(storeName,userId);
		
		return "storeCreated";
	}
	public int getCCStore() {
		return CCStore;
	}
	public void setCCStore(int cCStore) {
		CCStore = cCStore;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	
}
