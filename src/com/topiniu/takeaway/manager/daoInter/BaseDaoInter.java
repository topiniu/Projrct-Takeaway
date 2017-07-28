package com.topiniu.takeaway.manager.daoInter;

import java.io.Serializable;
import java.util.List;

public interface BaseDaoInter<T> {
	//根据Id加载实体
	T get(Class<T> entityClazz,Serializable id);
	
	//保存实体
	void save(T entityClazz);
	
	//删除实体
	void delete(T entityClazz);
	
	//根据Id删除实体
	void delete(Class<T> entityClazz,Serializable id);
	
	//更新实体
	void update(T entityClazz);
	
	//获取所有实体
	List<T> findAll(Class<T> entityClazz);
	
	//获取实体总数
	long findCount(Class<T> entityClazz);
	
//	根据自定义的hql查询实体
	List<T> find(String hql);
	
//	根据带参数的自定义hql语句查询所有实体
	List<T> find(String hql,Object...params);
	
//	使用自定的hql语句进行分页查询
	List<T> findByPage(String hql,int pageNo,int pageSize);

//	使用带参数的自定的hql语句进行分页查询
	List<T> findByPage(String hql,int pageNo,int pageSize,Object...params);
}
