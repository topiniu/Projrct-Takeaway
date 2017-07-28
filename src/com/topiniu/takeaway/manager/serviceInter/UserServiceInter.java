package com.topiniu.takeaway.manager.serviceInter;

import java.util.List;

import com.topiniu.takeaway.entity.Notices;
import com.topiniu.takeaway.entity.User;

public interface UserServiceInter {
	boolean createUser(User user);
	User getUserByName(String userName);
	
	List<Notices> getNewNotices(int pageNo,int id);
	List<Notices> getOldNotices(int pageNo,int id);

	boolean upNotice(int noticeId);
	
	boolean creatStore(String storeName,int userId);
}
