package com.topiniu.takeaway.manager.action;

import com.topiniu.takeaway.entity.Application;
import com.topiniu.takeaway.entity.User;

public class ApplicationAction extends ManagerBaseAction {

	private int id;
	private Application app;
	private String imgName;
	
	private int passId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}
	

	private void out(String atr,String str)
	{
		System.out.println(">>>>>>>>>>>>>来自" + atr + ":\t" + str + "\t<<<<<<<<<<<<");
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	public String findAppDetail(){
		out("ApplictionAction","findAppDetail:id=" + id);
		this.setApp(managerService.getApplication(id));
		out("ApplicationAction","findAppDetail:photo=" + app.getIdentityInfo().getphoto());
		setImgName(app.getIdentityInfo().getphoto());
		return SUCCESS;
	}

	public String pass(){
		Application app = managerService.getApplication(passId);
		//更新application状态
		app.setSchedule("审核已通过");
		app.setStatus(1);
		
		//更新对应的identity信息
		app.getIdentityInfo().setIsTrue(1);
		
		//更新对应的User信息
		app.getUser().setIdentity(app.getIdentityInfo());
		app.getUser().setIsCCStore(1);
		
		managerService.updateApplication(app);
		managerService.addNotice("您的开店申请已通过", app.getUser().getId());
		return "toMainPage";
	}

	public int getPassId() {
		return passId;
	}

	public void setPassId(int passId) {
		this.passId = passId;
	}
}
