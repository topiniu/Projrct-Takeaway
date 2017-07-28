package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.topiniu.takeaway.entity.Application;
import com.topiniu.takeaway.entity.IdentityInformation;
import com.topiniu.takeaway.entity.User;
import com.topiniu.takeaway.manager.action.ManagerBaseAction;
import com.topiniu.takeaway.manager.serviceInter.OperatorServiceInter;
import com.topiniu.takeaway.manager.serviceInter.UserServiceInter;

public class register extends ManagerBaseAction {

	private File img;
	private String imgContentType;
	private String imgFileName;
	private IdentityInformation iden;
	private Application app;
	

	private OperatorServiceInter operatorSer;
	private UserServiceInter userSer;
	
	public Application getApp() {
		return app;
	}


	public void setApp(Application app) {
		this.app = app;
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


	private String msg;
	private User user;

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String info() throws IOException
	{
		System.out.println("test register");
		System.out.println(msg);
		System.out.println(user.getName() + user.getPassword());
		System.out.println(imgFileName);
		System.out.println(iden.getName());
		System.out.println(userSer);
		return SUCCESS;
	}

	private String savePhoto() throws IOException{
		//20150816001_ÐÜ¿µ_identityPhoto.jpg
		String imgName = app.getId() + "_" + 
							app.getIdentityInfo().getName() + 
							"_identityPhoto.jpg";
		String savePath = ServletActionContext.getServletContext()
				.getRealPath("/IdentityPhoto/" + imgName);
		
		FileInputStream fis = new FileInputStream(img);
		FileOutputStream fos = new FileOutputStream(savePath);
		
		IOUtils.copy(fis, fos);
		
		fos.flush();
		fos.close();
		fis.close();
		
		return savePath;
	}
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public IdentityInformation getIden() {
		return iden;
	}


	public void setIden(IdentityInformation iden) {
		this.iden = iden;
	}


	public OperatorServiceInter getOperatorSer() {
		return operatorSer;
	}


	public void setOperatorSer(OperatorServiceInter operatorSer) {
		this.operatorSer = operatorSer;
	}


	public UserServiceInter getUserSer() {
		return userSer;
	}


	public void setUserSer(UserServiceInter userSer) {
		this.userSer = userSer;
	}
}
