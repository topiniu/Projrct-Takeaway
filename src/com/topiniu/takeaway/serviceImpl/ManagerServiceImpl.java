package com.topiniu.takeaway.serviceImpl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.topiniu.takeaway.entity.Application;
import com.topiniu.takeaway.entity.Manager;
import com.topiniu.takeaway.entity.Notices;
import com.topiniu.takeaway.entity.User;
import com.topiniu.takeaway.manager.daoImpl.AllDao;
import com.topiniu.takeaway.manager.serviceInter.ManagerServiceInter;


@Transactional(isolation=Isolation.DEFAULT,
		propagation=Propagation.REQUIRES_NEW,timeout=6)
public class ManagerServiceImpl implements ManagerServiceInter {
	private AllDao allDao;

	public AllDao getAllDao() {
		return allDao;
	}

	public void setAllDao(AllDao allDao) {
		this.allDao = allDao;
	}

	@Override
	public Manager getManager(int id) {
		out("ManagerServiceImpl","getmanager:id=" + id);
		return allDao.getManagerDao().get(Manager.class, id);
	} 

	@Override
	public boolean addManager(Manager addManager) {
		try {
			allDao.getManagerDao().save(addManager);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delManager(Manager delManager) {
		try {
			allDao.getManagerDao().delete(delManager);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateManage(Manager upManager) {
		try {
			allDao.getManagerDao().update(upManager);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Application> getApplicationList(int mgr_id,int pageNo,int pageSize) {
		
			String hql="from Application a where manager_id=" + mgr_id + "and status=0";
			List<Application> app = allDao.getApplicationDao().findByPage(hql, pageNo, pageSize);
			out("ManagerServiceImpl","getApplicaionList:applist.lenght=" + app.size());
			return app;
	}

	@Override
	public Application getApplication(int id) {
		return allDao.getApplicationDao().get(Application.class, id);
	}

	@Override
	public boolean updateApplication(Application upApplication) {
		try {
			allDao.getApplicationDao().update(upApplication);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addNotice(String content,int u_id) {
		try{
			//封装一个新的notice
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Notices n = new Notices(content, u_id, sdf.format(new Date()), 0);
			allDao.getNoticesDao().save(n);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	private void out(String atr,String str)
	{
		System.out.println(">>>>>>>>>>>>>来自" + atr + ":\t" + str + "\t<<<<<<<<<<<<");
	}

	@Override
	public User getUser(int id) {
		User u = allDao.getUserDao().get(User.class, id);
		return u;
	}

}
