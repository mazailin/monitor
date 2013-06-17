

package com.ruyicai.monitor.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ruyicai.common.constants.Contants;
import com.ruyicai.monitor.dao.ITorderBeanDao;
import com.ruyicai.monitor.domain.TorderBean;
import com.ruyicai.monitor.domainshow.TorderBeanShow;
import com.ruyicai.monitor.domainshow.TorderCountShow;
import com.ruyicai.monitor.jms.Torder;
import com.ruyicai.monitor.service.ITorderBeanService;


/**
 * @author tianshangjun
 */
 @Service("instanceTorderBeanService")
public class TorderBeanServiceImpl  implements ITorderBeanService {
    @Resource
	public ITorderBeanDao  instanceTorderBeanDao;
    public String save(TorderBean entity) {
        if(entity == null){
            return null;
        }
         instanceTorderBeanDao.save(entity);
          return entity.getId()+"";
    }
    public String save(Torder entity) {
        if(entity == null){
            return null;
        }
        String id=entity.getId();
        TorderBean torderold=  instanceTorderBeanDao.findById(id);
//        System.out.println(id+" find order ="+torderold);
        if(torderold==null){
        	 torderold =new TorderBean();
        	 torderold.setId(id);
        	 entity.copy(torderold);
        	  instanceTorderBeanDao.save(torderold);
        }else{
        	entity.copy(torderold);
     	instanceTorderBeanDao.update(torderold);
        }
       
          return torderold.getId();
    }
    public void update(TorderBean entity) {
        if(entity == null){
            return;
        }
       instanceTorderBeanDao.update(entity);
    }

    public void delete(TorderBean entity) {
        instanceTorderBeanDao.delete(entity);        
    }
    public void deleteByIds(String ids) {
        instanceTorderBeanDao.deleteByIds(ids);        
    }
    public TorderBean findByKey(String pk) {
        return instanceTorderBeanDao.findById(pk);      
    }

	public List<TorderBeanShow> findTorderBeanShow(Map param, Integer start,
			Integer limit) {
		int type = (Integer) param.get("type");
		StringBuilder sql = new StringBuilder();
		if (type == 1)
			sql
					.append("select 1 as type,t.* from torder t where lotno in ('T01007','T01010','T01012','T01014','T01015') and orderstate in ('-1','0') and id like 'BJ%' and lastprinttime>now() order by batchcode desc ");
		if (type == 2) {
			sql.append(" select 2  as type,t.* from torder t");
			sql
					.append(" where lotno in ('F47104','F47103','F47102','T01001','T01002','T01011','T01009','T01013','T01003','T01004','T01005','T01006') and orderstate in ('-1','0')  and   id like 'BJ%' and lastprinttime>now() order by batchcode desc ");
		}
		if (type == 3) {
			sql.append("select 3 as type, t.* from torder t ");
			sql
					.append("where lotno in ('J00001','J00002','J00003','J00004','J00005','J00006','J00007','J00008','J00009','J00010','J00011','J00012') and orderstate in ('-1','0')  and  id like 'BJ%' and lastprinttime>now() order by lastprinttime desc ");
		}
		return instanceTorderBeanDao.getList2(sql.toString(),
				TorderBeanShow.class, start, limit);
	}
    public List<TorderCountShow> findTorderCountShow(Map param,Integer start, Integer limit) {
    	 StringBuilder sql=new StringBuilder("select 1 as type, count(id) as number from torder where lotno in ('T01007','T01010','T01012','T01014','T01015') and orderstate in ('-1','0')  and  id like 'BJ%' and lastprinttime>now() ");
    	 sql.append(" union all ");
    	 sql.append(" select 2  as type, count(id) as number from torder ");
    	 sql.append(" where lotno in ('F47104','F47103','F47102','T01001','T01002','T01011','T01009','T01013','T01003','T01004','T01005','T01006') and orderstate in ('-1','0') and   id like 'BJ%' and lastprinttime>now() ");
    	 sql.append(" union all");
    	 sql.append(" select 3 as type, count(id) as number from torder ");
    	 sql.append(" where lotno in ('J00001','J00002','J00003','J00004','J00005','J00006','J00007','J00008','J00009','J00010','J00011','J00012') and orderstate in ('-1','0')  and  id like 'BJ%' and lastprinttime>now() ");
    

    	return	instanceTorderBeanDao.getList(sql.toString(), TorderCountShow.class, 0,  20);
    }
    public  int findCount(int type){
    	 StringBuilder sql=new StringBuilder();
    	if(type==1) sql.append(" select count(id) as number from torder where lotno in ('T01007','T01010','T01012','T01014','T01015') and orderstate in ('-1','0')  and  id like 'BJ%' and lastprinttime>now() ");
    	
    	if(type==2){ sql.append(" select  count(id) as number from torder ");
    	 sql.append(" where lotno in ('F47104','F47103','F47102','T01001','T01002','T01011','T01009','T01013','T01003','T01004','T01005','T01006') and orderstate in ('-1','0') and   id like 'BJ%' and lastprinttime>now() ");
    	}
    	 if(type==3){ sql.append(" select  count(id) as number from torder ");
    	 sql.append(" where lotno in ('J00001','J00002','J00003','J00004','J00005','J00006','J00007','J00008','J00009','J00010','J00011','J00012') and orderstate in ('-1','0')  and  id like 'BJ%' and lastprinttime>now() ");
    	 }
    	 return	instanceTorderBeanDao.findCount(sql.toString());
    }
    public List<TorderBean> find(Map param,Integer start, Integer limit) {
     StringBuilder sql=new StringBuilder("from TorderBean  where 1=1 ");
     java.util.Iterator it = param.entrySet().iterator();
		while (it.hasNext()) {
			java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
			String key=(String)entry.getKey();
			if(Contants.FIELD_STARTDATE.equals(key)){
				  sql.append(" and   batchcode>='" + entry.getValue() + "' ");
				  continue;
				}
				if(Contants.FIELD_ENDDATE.equals(key)){
					sql.append(" and batchcode<='" + entry.getValue() + "' ");
				 continue;
				}
			sql.append(" and "+ entry.getKey()+"= '"+entry.getValue()+"'");			
		}
		sql.append(" and orderstate in ('-1','0') ");
      if(start==null)return  instanceTorderBeanDao.findByHQL(sql.toString());  
		return  instanceTorderBeanDao.findByHQL(sql.toString(), start,  limit);   
    }
    public int findCount(Map param){
        StringBuilder sql=new StringBuilder("select count(id) from TorderBean  where 1=1 ");
     java.util.Iterator it = param.entrySet().iterator();
		while (it.hasNext()) {
			java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
			String key=(String)entry.getKey();
			if(Contants.FIELD_STARTDATE.equals(key)){
			  sql.append(" and   batchcode>='" + entry.getValue() + "' ");
			  continue;
			}
			if(Contants.FIELD_ENDDATE.equals(key)){
				sql.append(" and batchcode<='" + entry.getValue() + "' ");
			 continue;
			}
			sql.append(" and "+ entry.getKey()+"= '"+entry.getValue()+"'");		
		}
		sql.append(" and orderstate in ('-1','0') ");
		return  instanceTorderBeanDao.findCountByHQL(sql.toString());    
		}
	@Override
	public List<TorderBeanShow> findTorderExperiod(String orderid,int num) {
		StringBuilder sql = new StringBuilder();
			sql.append("select 0 as type,t.* from torder t where  orderstate in ('-1','0')  and lastprinttime<now() and flagvalue<10  ");
			if(null!=orderid&&!"".equals(orderid)){
				sql.append(" and id in ('"+orderid+"') ");
			}else{
				sql.append(" and id like 'BJ%' ");
			}
			sql.append(" order by lastprinttime desc ");
			
			return instanceTorderBeanDao.getList2(sql.toString(),
				TorderBeanShow.class, 0, num);
	}
}

