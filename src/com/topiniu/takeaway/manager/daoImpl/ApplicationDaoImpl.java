package com.topiniu.takeaway.manager.daoImpl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.topiniu.takeaway.entity.Application;
import com.topiniu.takeaway.manager.daoInter.ApplicationDaoInter;


@Transactional(isolation=Isolation.DEFAULT,
		propagation=Propagation.REQUIRES_NEW,timeout=6)
public class ApplicationDaoImpl extends BaseDaoImpl<Application> implements
		ApplicationDaoInter {

}
