package com.ruyicai.common.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IBaseDao<T> {
    /**
     * 获得t的类名
     * @return
     */
	String getClassName();
	/**
	 * HQL save
	 * @param obj
	 */
	void save(Object obj);
/**
 * HQL update
 * @param obj
 */
	void update(Object obj);
/**
 * HQL delete
 * @param obj
 */
	void delete(Object obj) ;
	/**
	 * 根据ID删除对象
	 * table 表名      
	 * ids id的字符串 "1,2,3,4"
	 */
	void deleteByIds(String table,String ids);
	void deleteByIds(String ids);
	/**
	 * HQL query by id
	 * @param obj
	 */
	T findById(String id);
	/**
	 * HQL find Criteria
	 * @param obj
	 */
	List<T> getListByConditionPerPage(DetachedCriteria detachedCriteria,int start, int limit) ;
	/**
	 * HQL find count by Criteria
	 * @param obj
	 */
	long getCountByCondition(final DetachedCriteria detachedCriteria);
	/**
	 * HQL find count by HQL SQL
	 * @param obj
	 */
	long getCountByCondition(final String hql);
	/**
	 * HQL find count by HQL SQL
	 * @param obj
	 */
	List<T> getListByConditionPerPage(String hql,int start, int limit) ;
	/**
	 * HQL find all by Criteria
	 * @param obj
	 */
	List<T> findAll();
	
	List<T> findByHQL(String sql,int start, int limit);
	
	List<T> findByHQL(String sql);
	
	int findCountByHQL(String sql);
    void executeHQLSQL(String hql);
    
	void executeJDBCSql(String sql);
	void executeJDBCPro(String proName,String[] params) ; 
	
	void insertList(final List<T> datas) ;
}
