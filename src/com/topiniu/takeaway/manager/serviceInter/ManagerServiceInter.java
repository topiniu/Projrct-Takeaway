package com.topiniu.takeaway.manager.serviceInter;

import java.util.List;

import com.topiniu.takeaway.entity.Application;
import com.topiniu.takeaway.entity.Manager;
import com.topiniu.takeaway.entity.Notices;
import com.topiniu.takeaway.entity.User;

public interface ManagerServiceInter {
	Manager getManager(int id);
	boolean addManager(Manager addManager);
	boolean delManager(Manager delManager);
	boolean updateManage(Manager upManager);
	
	List<Application> getApplicationList(int mgr_id,int pageNo,int pageSize);
	Application getApplication(int id);
	boolean updateApplication(Application upApplication);
	
	User getUser(int id);
	
	boolean addNotice(String content,int u_id);
}
