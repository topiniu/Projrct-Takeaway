package com.topiniu.takeaway.manager.daoImpl;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.topiniu.takeaway.entity.Goods;
import com.topiniu.takeaway.manager.daoInter.GoodsDaoInter;


@Transactional(isolation=Isolation.DEFAULT,
		propagation=Propagation.REQUIRES_NEW,timeout=6)
public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements GoodsDaoInter {

}
