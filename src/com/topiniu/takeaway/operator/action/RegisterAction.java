package com.topiniu.takeaway.operator.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.topiniu.takeaway.entity.Application;
import com.topiniu.takeaway.entity.IdentityInformation;
import com.topiniu.takeaway.entity.User;
import com.topiniu.takeaway.manager.serviceInter.OperatorServiceInter;
import com.topiniu.takeaway.manager.serviceInter.UserServiceInter;

public class RegisterAction extends OperatorBaseAction {

	private static final long serialVersionUID = 1L;

	private File img;
	private String imgContentType;
	private String imgFileName;
	
	private Application app;
	private IdentityInformation identity;
	private User user;
	
	private String msg;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public File getImg() {
		return img;
	}
	public void setImg(File img) {
		this.img = img;
	}
	public String getImgContentType() {
		return imgContentType;
	}
	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	
	public Application getApp() {
		return app;
	}
	public void setApp(Application app) throws IOException {
		this.app = app;
	}
	
	public IdentityInformation getIdentity() {
		return identity;
	}
	public void setIdentity(IdentityInformation identity) {
		this.identity = identity;
	}
	
	public String createApplication() throws IOException, ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		out("RegisterAction","start createApplication:\nidentity information info:"+
				identity.getName()+
				"birthDate:" + identity.getBirthDate());
		/*
		 * ��װidentityInformation
		 */
		this.identity.setphoto(savePhoto());
		this.identity.setIsTrue(0);
		
		/*
		 * ��װUser
		 */
		this.user.setIsCCStore(0);
		
		/*
		 * ��װapplcation
		 */
		this.app.setIdentityInfo(identity);//���������˵������Ϣ
		out("RegisterAction",
				"start createApplication:\nidentity information info:"+
				"birthDate:" + identity.getBirthDate());
		this.app.setCreateDate(sdf.format(new Date()));
		this.app.setUser(user);//���������˵���ͨ�˺�
		this.app.setSchedule("�ȴ����");
		this.app.setStatus(0);
		
		/*
		 * �ȱ���User���ٱ���identity����creatApplication��������У�
		 *����ٱ���Application
		 *
		 *�����¡��Ѿ����Ĺ������ƣ�cascade=all�������ڿ���ֱ�ӱ��棬hibernate��
		 *�Զ������ʵ����б���
		 */
		if(operatorService.createApplication(app))
			msg="Application created,we will check it in 24 hours.Now use " + 
				user.getName() + "sign into topiniu's takeaway website.";
		else
			msg="Application create failed.To index page now.";
		return SUCCESS;
	}

	private String savePhoto() throws IOException{
		//411522199501243312_�ܿ�_identityPhoto.jpg
		String imgName = identity.getIdentityNumber() + "_" + 
							identity.getName() + 
							"_identityPhoto.jpg";
		String savePath = ServletActionContext.getServletContext()
				.getRealPath("/IdentityPhoto/" + imgName);
		
		out("ReistreAction","savePath:" + savePath);
		FileInputStream fis = new FileInputStream(img);
		FileOutputStream fos = new FileOutputStream(savePath);
		
		IOUtils.copy(fis, fos);
		
		fos.flush();
		fos.close();
		fis.close();
		out("RegisterAction","savePhoto:Photo saved");
		return imgName;
	}
	
	private void out(String atr,String str)
	{
		System.out.println(">>>>>>>>>>>>>����\t" + atr + ":\t" + str + "\t<<<<<<<<<<<<");
	}
}
