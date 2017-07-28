package com.topiniu.takeaway.manager.daoImpl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.topiniu.takeaway.entity.Notices;
import com.topiniu.takeaway.manager.daoInter.NoticesDaoInter;


@Transactional(isolation=Isolation.DEFAULT,
		propagation=Propagation.REQUIRES_NEW,timeout=6)
public class NoticesDaoImpl extends BaseDaoImpl<Notices> implements NoticesDaoInter {


}
