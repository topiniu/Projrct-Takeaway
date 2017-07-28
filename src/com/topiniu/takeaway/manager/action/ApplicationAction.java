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
		System.out.println(">>>>>>>>>>>>>����" + atr + ":\t" + str + "\t<<<<<<<<<<<<");
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
		//����application״̬
		app.setSchedule("�����ͨ��");
		app.setStatus(1);
		
		//���¶�Ӧ��identity��Ϣ
		app.getIdentityInfo().setIsTrue(1);
		
		//���¶�Ӧ��User��Ϣ
		app.getUser().setIdentity(app.getIdentityInfo());
		app.getUser().setIsCCStore(1);
		
		managerService.updateApplication(app);
		managerService.addNotice("���Ŀ���������ͨ��", app.getUser().getId());
		return "toMainPage";
	}

	public int getPassId() {
		return passId;
	}

	public void setPassId(int passId) {
		this.passId = passId;
	}
}
