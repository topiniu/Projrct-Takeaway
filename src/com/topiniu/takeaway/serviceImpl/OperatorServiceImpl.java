package com.topiniu.takeaway.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.topiniu.takeaway.entity.Application;
import com.topiniu.takeaway.entity.Goods;
import com.topiniu.takeaway.entity.Manager;
import com.topiniu.takeaway.entity.Operator;
import com.topiniu.takeaway.entity.Store;
import com.topiniu.takeaway.entity.User;
import com.topiniu.takeaway.entity.Waiter;
import com.topiniu.takeaway.manager.daoImpl.AllDao;
import com.topiniu.takeaway.manager.serviceInter.OperatorServiceInter;


@Transactional(isolation=Isolation.DEFAULT,
		propagation=Propagation.REQUIRES_NEW,timeout=6)

public class OperatorServiceImpl implements OperatorServiceInter {
	private AllDao allDao;
	
	public AllDao getAllDao() {
		return allDao;
	}

	public void setAllDao(AllDao allDao) {
		this.allDao = allDao;
	}
	
	@Override
	public boolean createApplication(Application application) {
		try {
			//设置application的处理人员（有待完善）
			/*
			 * 设定申请表分配机制
			 * 先保存身份
			 */
		//	allDao.getIdentityInformationDao().save(application.getIdentityInfo());
			application.setManager(allDao.getManagerDao().get(Manager.class,2015001));
			
			out("OperatorServiceImpl","createApplication:application information:" + 
					application.getIdentityInfo().getName());
			allDao.getApplicationDao().save(application);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Store findStoreInfo(int id) {
		return allDao.getStoreDao().get(Store.class, id);
	}

	@Override
	public boolean addGood(Goods addGood) {
		try {
			allDao.getGoodsDao().save(addGood);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteGood(Goods delGood) {
		try {
			allDao.getGoodsDao().delete(delGood);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateGood(Goods upGood) {
		try {
			allDao.getGoodsDao().update(upGood);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Goods findGoodInfo(int goodId) {
		return allDao.getGoodsDao().get(Goods.class, goodId);
	}

	@Override
	public List<Goods> goodList(int storeId) {
		return allDao.getStoreDao().get(Store.class, storeId).getGoodList();
	}

	@Override
	public List<Waiter> waiterList(int storeId) {
		return allDao.getStoreDao().get(Store.class, storeId).getWaiterList();
	}

	@Override
	public Waiter findWaiterInfo(int id) {
		return allDao.getWaiterDao().get(Waiter.class, id);
	}

	@Override
	public boolean addWaiter(Waiter addWaiter) {
		try {
			allDao.getWaiterDao().save(addWaiter);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteWaiter(Waiter delWaiter) {
		try {
			allDao.getWaiterDao().delete(delWaiter);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateWaiter(Waiter upWaiter) {
		try {
			allDao.getWaiterDao().update(upWaiter);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User findSelfInfo(int id) {
		return allDao.getStoreDao().get(Store.class, id).getUser();
	}

	@Override
	public boolean updateSelfInfo(Operator operator) {
		try {
			allDao.getOperatorDao().update(operator);;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	private void out(String atr,String str)
	{
		System.out.println(">>>>>>>>>>>>>来自\t" + atr + ":\t" + str + "\t<<<<<<<<<<<<");
	}
}
