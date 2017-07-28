package com.topiniu.takeaway.manager.daoImpl;

import com.topiniu.takeaway.manager.daoInter.*;


public class AllDao {
	/**
	 * 把所有Dao组件集中在一个类里面，通过spring注入
	 */
	private ApplicationDaoInter applicationDao;
	private GoodsDaoInter goodsDao;
	private GoodTypeDaoInter goodTypeDao;
	private IdentityInformationDaoInter identityInformationDao;
	private ManagerDaoInter managerDao;
	private OperatorDaoInter operatorDao;
	private StoreDaoInter storeDao;
	private WaiterDaoInter waiterDao;
	private UserDaoInter userDao;
	private NoticesDaoInter noticesDao;
	
	public ApplicationDaoInter getApplicationDao() {
		return applicationDao;
	}
	public void setApplicationDao(ApplicationDaoInter applicationDao) {
		this.applicationDao = applicationDao;
	}
	public GoodsDaoInter getGoodsDao() {
		return goodsDao;
	}
	public void setGoodsDao(GoodsDaoInter goodsDao) {
		this.goodsDao = goodsDao;
	}
	public GoodTypeDaoInter getGoodTypeDao() {
		return goodTypeDao;
	}
	public void setGoodTypeDao(GoodTypeDaoInter goodTypeDao) {
		this.goodTypeDao = goodTypeDao;
	}
	public IdentityInformationDaoInter getIdentityInformationDao() {
		return identityInformationDao;
	}
	public void setIdentityInformationDao(
			IdentityInformationDaoInter identityInformationDao) {
		this.identityInformationDao = identityInformationDao;
	}
	public ManagerDaoInter getManagerDao() {
		return managerDao;
	}
	public void setManagerDao(ManagerDaoInter managerDao) {
		this.managerDao = managerDao;
	}
	public OperatorDaoInter getOperatorDao() {
		return operatorDao;
	}
	public void setOperatorDao(OperatorDaoInter operatorDao) {
		this.operatorDao = operatorDao;
	}
	public StoreDaoInter getStoreDao() {
		return storeDao;
	}
	public void setStoreDao(StoreDaoInter storeDao) {
		this.storeDao = storeDao;
	}
	public WaiterDaoInter getWaiterDao() {
		return waiterDao;
	}
	public void setWaiterDao(WaiterDaoInter waiterDao) {
		this.waiterDao = waiterDao;
	}
	public UserDaoInter getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDaoInter userDao) {
		this.userDao = userDao;
	}
	public NoticesDaoInter getNoticesDao() {
		return noticesDao;
	}
	public void setNoticesDao(NoticesDaoInter noticesDao) {
		this.noticesDao = noticesDao;
	}
}
