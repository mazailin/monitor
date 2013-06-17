

package com.ruyicai.monitor.dao;

import java.util.List;


import com.ruyicai.common.dao.IBaseDao;
import com.ruyicai.monitor.domain.TorderBean;
import com.ruyicai.monitor.domainshow.TorderBeanShow;
import com.ruyicai.monitor.domainshow.TorderCountShow;



/**
 * @author tianshangjun
 */
 public interface ITorderBeanDao  extends IBaseDao<TorderBean> {   
    List<TorderBean> find(String sql,int start, int limit);
    List<TorderBean> find(String sql);
    int findCount(String sql);
      List<TorderCountShow> getList(String sql,Class<TorderCountShow> clazz,Integer start, Integer limit);
      List<TorderBeanShow> getList2(String sql,Class<TorderBeanShow> clazz,Integer start, Integer limit);
}
