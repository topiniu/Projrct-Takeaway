package com.topiniu.takeaway.manager.daoImpl;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.topiniu.takeaway.entity.GoodType;
import com.topiniu.takeaway.manager.daoInter.GoodTypeDaoInter;


@Transactional(isolation=Isolation.DEFAULT,
		propagation=Propagation.REQUIRES_NEW,timeout=6)
public class GoodTypeDaoImpl extends BaseDaoImpl<GoodType> implements GoodTypeDaoInter {

}
