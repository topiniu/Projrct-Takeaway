package com.topiniu.takeaway.manager.serviceInter;

import java.util.List;

import com.topiniu.takeaway.entity.*;

public interface OperatorServiceInter {
	//����
	boolean createApplication(Application application);
	Store findStoreInfo(int id);
	
	//��Ʒ
	boolean addGood(Goods addGood);
	boolean deleteGood(Goods delGood);
	boolean updateGood(Goods upGood);
	Goods findGoodInfo(int goodId);
	List<Goods> goodList(int storeId);
	
	//�ͷ�
	List<Waiter> waiterList(int storeId);
	Waiter findWaiterInfo(int id);
	boolean addWaiter(Waiter addWaiter);
	boolean deleteWaiter(Waiter delWaiter);
	boolean updateWaiter(Waiter upWaiter);

	//������Ϣ
	User findSelfInfo(int id);
	boolean updateSelfInfo(Operator operator);
	
	//����
}
