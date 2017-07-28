package com.topiniu.takeaway.manager.daoInter;

import java.io.Serializable;
import java.util.List;

public interface BaseDaoInter<T> {
	//����Id����ʵ��
	T get(Class<T> entityClazz,Serializable id);
	
	//����ʵ��
	void save(T entityClazz);
	
	//ɾ��ʵ��
	void delete(T entityClazz);
	
	//����Idɾ��ʵ��
	void delete(Class<T> entityClazz,Serializable id);
	
	//����ʵ��
	void update(T entityClazz);
	
	//��ȡ����ʵ��
	List<T> findAll(Class<T> entityClazz);
	
	//��ȡʵ������
	long findCount(Class<T> entityClazz);
	
//	�����Զ����hql��ѯʵ��
	List<T> find(String hql);
	
//	���ݴ��������Զ���hql����ѯ����ʵ��
	List<T> find(String hql,Object...params);
	
//	ʹ���Զ���hql�����з�ҳ��ѯ
	List<T> findByPage(String hql,int pageNo,int pageSize);

//	ʹ�ô��������Զ���hql�����з�ҳ��ѯ
	List<T> findByPage(String hql,int pageNo,int pageSize,Object...params);
}
