package com.topiniu.takeaway.manager.daoImpl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.topiniu.takeaway.entity.Waiter;
import com.topiniu.takeaway.manager.daoInter.WaiterDaoInter;


@Transactional(isolation=Isolation.DEFAULT,
		propagation=Propagation.REQUIRES_NEW,timeout=6)
public class WaiterDaoImpl extends BaseDaoImpl<Waiter> implements WaiterDaoInter {

}
