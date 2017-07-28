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

	//sessionFactory对象，依赖spring注入
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	//spring注入所需的方法
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//获取指定实体--根据id
	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		return (T)sessionFactory.getCurrentSession().get(entityClazz, id);
	}

	//保存实体
	@Override
	public void save(T entityClazz) {
		sessionFactory.getCurrentSession().save(entityClazz);
	}

	//删除实体
	@Override
	public void delete(T entityClazz) {
		sessionFactory.getCurrentSession().delete(entityClazz);
	}

	//删除实体--根据id
	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		sessionFactory.getCurrentSession()
			.createQuery("delete" + entityClazz.getSimpleName() 
				+ "en where en.id=?")
			.setParameter(0, id)
			.executeUpdate();
	}

	//更新实体
	@Override
	public void update(T entityClazz) {
		System.out.println("*******BaseDaoImpl:updateINFO*******");
		sessionFactory.getCurrentSession().update(entityClazz);
	}

	//获取全部实体
	@Override
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from" + entityClazz.getSimpleName() + "en");
	}

	//获取实体总数
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
	 * 根据自定义的hql查询实体
	 * @param hql--自定义的hql语句
	 * @return 返回查询结果
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql) {
		return sessionFactory.getCurrentSession()
				.createQuery(hql)
				.list();
	}
	
	/**
	 * 根据带参数的自定义hql语句查询所有实体
	 * @param hql--自定义的hql语句
	 * @param params--参数列表
	 * @return 符合条件的所有实体
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
	 * 使用自定的hql语句进行分页查询
	 * @param hql--自定义的hql语句
	 * @param pageNo--页码
	 * @param pageSize--每页显示记录
	 * @return 当前页的所有记录
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
	 * 使用自定的hql语句进行分页查询
	 * @param hql--自定义的hql语句
	 * @param pageNo--页码
	 * @param pageSize--每页记录数
	 * @param params--查询的参数
	 * @return 当前页的所有记录
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
