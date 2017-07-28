package com.topiniu.takeaway.manager.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.topiniu.takeaway.entity.*;

@SuppressWarnings("serial")
public class ManagerMainAction extends ManagerBaseAction {

	private int pageNo;
	private List<Application> applicationList;
	
	public String findAppList()
	{	
		try {
			
		out("ManagerMainAction","getApplicationList---pageNo=" + pageNo);
		Manager m = (Manager)ActionContext.getContext().getSession().get("Logined_mgr");
		out("ManagerMainAcion","findAppList:mID=" + m.getId());
		int mgr_id = m.getId();
		out("ManagerMainAction","findAppList:mgr_id="+mgr_id);
		//每页10个
		this.setApplicationList(managerService.getApplicationList(mgr_id, pageNo, 10));
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	private void out(String atr,String str)
	{
		System.out.println(">>>>>>>>>>>>>来自" + atr + ":\t" + str + "\t<<<<<<<<<<<<");
	}
	public List<Application> getApplicationList() {
		return applicationList;
	}
	public void setApplicationList(List<Application> applicationList) {
		this.applicationList = applicationList;
	}
	
}
