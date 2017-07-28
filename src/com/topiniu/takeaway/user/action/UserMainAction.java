package com.topiniu.takeaway.user.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.topiniu.takeaway.entity.Notices;
import com.topiniu.takeaway.entity.User;

public class UserMainAction extends UserBaseAction {
	private int pageNo;
	
	private String msg;
	private List<Notices> noticesList;
	
	//已阅读的notice
	private int noticeId;
	public String getNewNotices(){
		System.out.println("********进入UserMainAtion的getNewNotices方法*********");
		int userId = ((User)ActionContext.getContext().getSession().get("Logined_user")).getId();
		noticesList = userService.getNewNotices(pageNo, userId);
		System.out.println("*******UserMainAction的getNewNotices方法：noticesList=" + noticesList.size()+"***********");
		if(noticesList==null)
			msg="no new notice";
		return SUCCESS;
	}

	public String upNotice(){
		System.out.println("********UserMainAction:upNotice:noticeid="+noticeId+"********");
		userService.upNotice(noticeId);
		return SUCCESS;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("********UserMainAction--execute********");
		return INPUT;
	}
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Notices> getNoticesList() {
		return noticesList;
	}

	public void setNoticesList(List<Notices> noticesList) {
		this.noticesList = noticesList;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	
	public String getOldNotices(){
		int userId = ((User)ActionContext.getContext().getSession().get("Logined_user")).getId();
		noticesList = userService.getOldNotices(pageNo, userId);
		System.out.println("*******UserMainAction的getOldNotices方法：noticesList=" + noticesList.size()+"***********");
		if(noticesList==null)
			msg="no old notice";
		return SUCCESS;
	}
	
}