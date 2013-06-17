

package com.ruyicai.monitor.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ruyicai.common.dao.impl.BaseDaoImpl;
import com.ruyicai.monitor.dao.ITorderBeanDao;
import com.ruyicai.monitor.domain.TorderBean;
import com.ruyicai.monitor.domainshow.TorderBeanShow;
import com.ruyicai.monitor.domainshow.TorderCountShow;


/**
 * @author tianshangjun
 */
 @Repository("instanceTorderBeanDao")
 @Transactional(readOnly = true)
public class TorderBeanDaoImpl extends BaseDaoImpl<TorderBean> implements ITorderBeanDao {
    public List<TorderBean> find(String sql,int start, int limit){
    return this.getSession().createSQLQuery(sql).setResultTransformer(
						Transformers.aliasToBean(TorderBean.class))
				.setFirstResult(start).setMaxResults(limit).list();
    }
    public  List<TorderCountShow> getList(String sql,Class<TorderCountShow> clazz,Integer start, Integer limit){
    return this.getSession().createSQLQuery(sql).setResultTransformer(
						Transformers.aliasToBean(TorderCountShow.class))
						.setFirstResult(start).setMaxResults(limit).list();
    }
    public  List<TorderBeanShow> getList2(String sql,Class<TorderBeanShow> clazz,Integer start, Integer limit){
        return this.getSession().createSQLQuery(sql).setResultTransformer(
    						Transformers.aliasToBean(TorderBeanShow.class))
    						.setFirstResult(start).setMaxResults(limit).list();
        }
    public  int findCount(String sql){
         Object o= this.getSession().createSQLQuery(sql).uniqueResult();
		 return (o==null)?0:((BigInteger)o).intValue();
    }
	@Override
	public List<TorderBean> find(String sql) {
		 return this.getSession().createSQLQuery(sql).setResultTransformer(
					Transformers.aliasToBean(TorderBean.class)).list();
	}
}