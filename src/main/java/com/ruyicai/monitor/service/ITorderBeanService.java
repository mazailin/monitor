

package com.ruyicai.monitor.service;

import java.util.List;
import java.util.Map;

import com.ruyicai.monitor.domain.TorderBean;
import com.ruyicai.monitor.domainshow.TorderBeanShow;
import com.ruyicai.monitor.domainshow.TorderCountShow;
import com.ruyicai.monitor.jms.Torder;



/**
 * @author tianshangjun
 */
public interface ITorderBeanService {
	  String save(Torder entity);
    String save(TorderBean entity);
    void update(TorderBean entity);
    void delete(TorderBean entity);
    void deleteByIds(String ids);        
    TorderBean findByKey(String pk);   
    /**
 	 * param is key value of entity properties
 	*/ 
    List<TorderBean> find(Map param,Integer start, Integer limit);
    int findCount(Map param);
    int findCount(int type);
    List<TorderBeanShow> findTorderBeanShow(Map param,Integer start, Integer limit) ;
    List<TorderCountShow> findTorderCountShow(Map param,Integer start, Integer limit); 
    List<TorderBeanShow> findTorderExperiod(String orderid,int num);
}
