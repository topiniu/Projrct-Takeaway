package com.topiniu.takeaway.serviceImpl;

import java.util.Date;
import java.util.List;

import com.topiniu.takeaway.entity.Notices;
import com.topiniu.takeaway.entity.Store;
import com.topiniu.takeaway.entity.User;
import com.topiniu.takeaway.manager.daoImpl.AllDao;
import com.topiniu.takeaway.manager.serviceInter.UserServiceInter;

public class UserServiceImpl implements UserServiceInter {

	private AllDao allDao;

	public AllDao getAllDao() {
		return allDao;
	}

	public void setAllDao(AllDao allDao) {
		this.allDao = allDao;
	}

	@Override
	public boolean createUser(User user) {
		try {
			allDao.getUserDao().save(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUserByName(String userName) {
		String hql = "from User u where u.name='"+userName+"'";
		List<User> uList = allDao.getUserDao().find(hql);
		/*
		 * 优化方法：
		 * 1，增加返回实体类的find方法
		 * 2，在注册service上增加username唯一性验证
		 */
		if(uList.size()!=0)
			return (User)uList.get(0);
		else
			return null;
	}

	@Override
	public List<Notices> getNewNotices(int pageNo,int id) {
		String hql = "from Notices n where n.user_id ="
				+ id + " and n.status=0";
		//每页10个
		return (List<Notices>)allDao.getNoticesDao().findByPage(hql, pageNo, 10);
	}

	private void out(String atr,String str)
	{
		System.out.println(">>>>>>>>>>>>>来自" + atr + ":\t" + str + "\t<<<<<<<<<<<<");
	}

	@Override
	public List<Notices> getOldNotices(int pageNo, int id) {
		String hql = "from Notices n where n.user_id ="
				+ id + " and n.status=1";
		//每页10个
		return (List<Notices>)allDao.getNoticesDao().findByPage(hql, pageNo, 10);

	}

	@Override
	public boolean upNotice(int noticeId) {
		try{
			System.out.println("*******UsrServiceImpl notice********");
			Notices n = allDao.getNoticesDao().get(Notices.class, noticeId);
			System.out.println("*****UserServiceImpl upNotice:noticeContent=" + n.getContent()+"********");
			n.setStatus(1);
			System.out.println("*****UserServiceImpl noticeId=" + n.getId());
			allDao.getNoticesDao().update(n);
			System.out.println("*******UsrServiceImpl notice已更新********");
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creatStore(String storeName,int userId) {
		// TODO Auto-generated method stub
		try {
			Store nStore = new Store(storeName,new Date(),allDao.getUserDao().get(User.class, userId));
			allDao.getStoreDao().save(nStore);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

}
