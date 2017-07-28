package com.topiniu.takeaway.manager.serviceInter;

import java.util.List;

import com.topiniu.takeaway.entity.*;

public interface OperatorServiceInter {
	//店铺
	boolean createApplication(Application application);
	Store findStoreInfo(int id);
	
	//商品
	boolean addGood(Goods addGood);
	boolean deleteGood(Goods delGood);
	boolean updateGood(Goods upGood);
	Goods findGoodInfo(int goodId);
	List<Goods> goodList(int storeId);
	
	//客服
	List<Waiter> waiterList(int storeId);
	Waiter findWaiterInfo(int id);
	boolean addWaiter(Waiter addWaiter);
	boolean deleteWaiter(Waiter delWaiter);
	boolean updateWaiter(Waiter upWaiter);

	//个人信息
	User findSelfInfo(int id);
	boolean updateSelfInfo(Operator operator);
	
	//订单
}
