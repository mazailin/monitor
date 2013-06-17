package com.ruyicai.common.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.ruyicai.common.dao.IBaseDao;
import com.ruyicai.common.utils.GenericsUtils;
import com.ruyicai.common.utils.Utils;
@Transactional(readOnly = true)
public abstract class BaseDaoImpl<T>  extends HibernateDaoSupport  implements IBaseDao<T>{
	protected final Log log = LogFactory.getLog(this.getClass());
	protected JdbcTemplate jdbcTemple;
	@Resource(name = "sessionFactory")
	public void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	@Resource(name = "jdbcTemplate")
	public void setJDBCT(JdbcTemplate jdbcTemple) {
		 this.jdbcTemple=jdbcTemple;
	}
	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		entityClass = GenericsUtils.getSuperClassGenricType(getClass());
	}

    @Override
    public String getClassName() { 
    	return this.entityClass.getSimpleName();
    }

	@Transactional(readOnly = false)
	public void save(Object obj) {
		this.getHibernateTemplate().save(obj);
	}

	@Transactional(readOnly = false)
	public void update(Object obj) {
		this.getHibernateTemplate().update(obj);
	}

	@Transactional(readOnly = false)
	public void delete(Object obj) {
		this.getHibernateTemplate().delete(obj);
	}
	@Override
	@Transactional(readOnly = false)
	public void deleteByIds(String ids) {
		String sql="delete from "+entityClass.getName() +" where id in ("+ids+") ";
		this.getSession().createQuery(sql).executeUpdate();
	}
	/**
	 * 根据ID删除对象
	 * table 表名      
	 * ids id的字符串 "1,2,3,4"
	 */

	@Transactional(readOnly = false)
	public void deleteByIds(String table,String ids) {
		String sql="delete from "+table+" where id in ("+ids+") ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}
	public T findById(String id) {
//		return (T) this.getHibernateTemplate().get(entityClass, id);
		 List<T> l=this.getHibernateTemplate().find("from "+entityClass.getSimpleName()+" where id='"+id+"'");
		 if(Utils.listIsNull(l))return null;
		 else  return l.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<T> getListByConditionPerPage(final String hql,
			final int start, final int limit) {
		List<T> list = (List<T>) getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

			@Override
			public List<T> doInHibernate(Session session) throws HibernateException,
					SQLException {
				return (List<T>)session.createQuery(hql).setFirstResult(start).setMaxResults(limit).list();
			}
		});
				
		return list;
	}

	public long getCountByCondition(final String hql) {
		return (long)this.getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				return (Long)session.createQuery(hql).uniqueResult();
			}
		});


	}

	
	@SuppressWarnings("unchecked")
	public List<T> getListByConditionPerPage(DetachedCriteria detachedCriteria,
			int start, int limit) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(
				detachedCriteria, start, limit);
		return list;
	}

	public long getCountByCondition(final DetachedCriteria detachedCriteria) {
		return (long) this.getHibernateTemplate().execute(
				new HibernateCallback<Long>() {

					@Override
					public Long doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = detachedCriteria
								.getExecutableCriteria(session);
						long totalCount = ((Long) criteria.setProjection(
								Projections.rowCount()).uniqueResult())
								.longValue();

						return totalCount;
					}
				});

	}
	@Override
	public List<T> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		return (List<T>)this.getHibernateTemplate().findByCriteria(criteria);
	}
	@Override
	public List<T> findByHQL(String sql, int start,
			int limit) {
		 return this.getSession().createQuery(sql)
					.setFirstResult(start).setMaxResults(limit).list();
	}
	@Override
	public List<T> findByHQL(String sql) {
		return this.getSession().createQuery(sql).list();
	}
	@Override
	public int findCountByHQL(String sql) {
		Object o= this.getSession().createQuery(sql).uniqueResult();
		 return (o==null)?0:((java.lang.Long)o).intValue();
	}
	@Override
	@Transactional(readOnly = false)
	public void executeHQLSQL(String hql) {
		this.getSession().createQuery(hql).executeUpdate();
		
	}
	@Override
	@Transactional(readOnly = false)
	public void executeJDBCSql(String sql) {
		jdbcTemple.execute(sql); 
		
	}
	@Override
	@Transactional(readOnly = false)
	public void executeJDBCPro(String proName,final String[] params) {
		final StringBuffer callStr = new StringBuffer();
		List<SqlParameter> params_list = new ArrayList<SqlParameter>();
		
		if(params == null || params.length == 0){
			 callStr.append("{call " + proName + "}");
		}else{
			String wen = "";
			for(int i=0;i<params.length;i++){
				wen += "?,"; 
				params_list.add(new SqlParameter(params[i], Types.VARCHAR));
			}
			wen = wen.substring(0, wen.length()-1);
			wen = "{call " + proName + "("+wen+")}";
			callStr.append(wen) ;
		}
		jdbcTemple.call(new CallableStatementCreator(){ 
			@Override
			public CallableStatement createCallableStatement(Connection conn)
					throws SQLException { 
				CallableStatement cstat = conn.prepareCall(callStr.toString()); 
				for(int i=0;i<params.length;i++)
				cstat.setString((i+1), params[i]);  
				return cstat;
			}
			
		},params_list);
		
	} 
	@Transactional(readOnly = false)
	public void insertList(final List<T> datas) {
		if(Utils.listIsNull(datas))return;
		List<T> list = (List<T>) getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

			@Override
			public List<T> doInHibernate(Session session) throws HibernateException,
					SQLException {
				for(int i=0;i<datas.size();i++){
					session.save((T)datas.get(i));
					if(i%50==0){
						session.flush();
						session.clear();
					}
				}
				return null;
			}
		});
	}
}
