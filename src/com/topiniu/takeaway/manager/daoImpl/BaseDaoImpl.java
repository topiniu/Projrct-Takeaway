package com.topiniu.takeaway.manager.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.topiniu.takeaway.manager.daoInter.BaseDaoInter;


@Transactional(isolation=Isolation.DEFAULT,
		propagation=Propagation.REQUIRES_NEW,timeout=6)
public class BaseDaoImpl<T> implements BaseDaoInter<T> {

	//sessionFactory��������springע��
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	//springע������ķ���
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//��ȡָ��ʵ��--����id
	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		return (T)sessionFactory.getCurrentSession().get(entityClazz, id);
	}

	//����ʵ��
	@Override
	public void save(T entityClazz) {
		sessionFactory.getCurrentSession().save(entityClazz);
	}

	//ɾ��ʵ��
	@Override
	public void delete(T entityClazz) {
		sessionFactory.getCurrentSession().delete(entityClazz);
	}

	//ɾ��ʵ��--����id
	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		sessionFactory.getCurrentSession()
			.createQuery("delete" + entityClazz.getSimpleName() 
				+ "en where en.id=?")
			.setParameter(0, id)
			.executeUpdate();
	}

	//����ʵ��
	@Override
	public void update(T entityClazz) {
		System.out.println("*******BaseDaoImpl:updateINFO*******");
		sessionFactory.getCurrentSession().update(entityClazz);
	}

	//��ȡȫ��ʵ��
	@Override
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from" + entityClazz.getSimpleName() + "en");
	}

	//��ȡʵ������
	@Override
	public long findCount(Class<T> entityClazz) {
		List<?> l = find("select count(*) from" 
							+ entityClazz.getSimpleName()
							+"en");
		if(l != null && l.size() == 1)
		{
			return (Long)l.get(0);
		}
		return 0;
	}
	
	/**
	 * �����Զ����hql��ѯʵ��
	 * @param hql--�Զ����hql���
	 * @return ���ز�ѯ���
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql) {
		return sessionFactory.getCurrentSession()
				.createQuery(hql)
				.list();
	}
	
	/**
	 * ���ݴ��������Զ���hql����ѯ����ʵ��
	 * @param hql--�Զ����hql���
	 * @param params--�����б�
	 * @return ��������������ʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql,Object...params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		for(int i=0;i<params.length;i++)
		{
			query.setParameter(i, params[i]);
		}
		
		return (List<T>)query.list();
	}
	
	/**
	 * ʹ���Զ���hql�����з�ҳ��ѯ
	 * @param hql--�Զ����hql���
	 * @param pageNo--ҳ��
	 * @param pageSize--ÿҳ��ʾ��¼
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByPage(String hql,int pageNo,int pageSize) {
		try {
			return sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setFirstResult((pageNo-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ʹ���Զ���hql�����з�ҳ��ѯ
	 * @param hql--�Զ����hql���
	 * @param pageNo--ҳ��
	 * @param pageSize--ÿҳ��¼��
	 * @param params--��ѯ�Ĳ���
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByPage(String hql,int pageNo,int pageSize,Object...params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		for(int i=0;i<params.length;i++)
		{
			query.setParameter(i, params[i]);
		}
		
		return query.setFirstResult((pageNo-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
	}
}
