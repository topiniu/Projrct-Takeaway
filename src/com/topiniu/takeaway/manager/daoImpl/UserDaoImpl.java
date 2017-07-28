package com.topiniu.takeaway.manager.daoImpl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.topiniu.takeaway.entity.User;
import com.topiniu.takeaway.manager.daoInter.UserDaoInter;

@Transactional(isolation=Isolation.DEFAULT,
	propagation=Propagation.REQUIRES_NEW,timeout=6)
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDaoInter {

}
