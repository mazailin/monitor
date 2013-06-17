package com.ruyicai.systemmanage.dao.impl;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ruyicai.common.dao.impl.BaseDaoImpl;
import com.ruyicai.systemmanage.dao.RoleDao;
import com.ruyicai.systemmanage.domain.SysRoleBean;

@Repository("roleDao")
@Transactional
public class RoleDaoImpl extends BaseDaoImpl<SysRoleBean> implements RoleDao {
	  public List<SysRoleBean> find(String sql,int start, int limit){
		    return this.getSession().createSQLQuery(sql).setResultTransformer(
								Transformers.aliasToBean(SysRoleBean.class))
						.setFirstResult(start).setMaxResults(limit).list();
		    }
		     public List<SysRoleBean> find(String sql){
		    return this.getSession().createSQLQuery(sql).setResultTransformer(
								Transformers.aliasToBean(SysRoleBean.class)).list();
		    }
		    public  int findCount(String sql){
		         Object o= this.getSession().createSQLQuery(sql).uniqueResult();
				 return (o==null)?0:((BigInteger)o).intValue();
		    }
	@SuppressWarnings("unchecked")
	public void deleteByIds(final Long[] ids) {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.createQuery("delete from Role where id in :ids")
						.setParameterList("ids", ids).executeUpdate();
				session.createQuery(
						"delete from RoleResource where role_id in :ids")
						.setParameterList("ids", ids).executeUpdate();
				return null;
			}
		});
	}

	@Override
	@SuppressWarnings("unchecked")
	public SysRoleBean findRoleByName(String name) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SysRoleBean.class);
		criteria.add(Restrictions.eq("name", name));
		List<SysRoleBean> list = (List<SysRoleBean>) this.getHibernateTemplate()
				.findByCriteria(criteria);
		if (null != list && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SysRoleBean> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(SysRoleBean.class);
		criteria.add(Restrictions.gt("id", new Long(1)));
		List<SysRoleBean> list = (List<SysRoleBean>) this.getHibernateTemplate()
				.findByCriteria(criteria);
		if (null == list)
			list = new ArrayList<SysRoleBean>();
		return list;
	}

	public List<String> getResourceIds(String rolename, String roleid) {
		String sql = "select rs.resource_id as resourceId from sys_role_resource  rs ,sys_role r where r.id=rs.role_id ";
		if (rolename != null && !"".equals(rolename)) {
			sql += " and r.name= '" + rolename + "' ";
		}
		if (roleid != null && !"".equals(roleid)) {
			sql += " and r.id= '" + roleid + "' ";
		}
		return this.getSession().createSQLQuery(sql).list();
	}

	@Override
	public void deleteRoleAndRole_Resource(String ids) {
		this.deleteByIds(ids);
		String sql = "delete from sys_role_resource where role_id in (" + ids + ")";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}
	@Override
	 @Transactional(readOnly = false)
	public void allocpermission(final String[] roleIds,final String[] permissionIds) {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String delids = "";
				for (int j = 0; j < roleIds.length; j++) {
					if (j == 0)
						delids += roleIds[j];
					else
						delids += "," + roleIds[j];
				}
				String delsql="delete from sys_role_resource where role_id in ("+delids+")";
				session.createSQLQuery(delsql).executeUpdate();
				for (String  roleid: roleIds) {
				for (int i = 0; i < permissionIds.length; i++) {
					String sql = "insert into sys_role_resource(role_id,resource_id) values('"
							+ roleid + "','" + permissionIds[i] + "')";
					session.createSQLQuery(sql).executeUpdate();
				}
				}
				return null;
			}
		});
		
	}
	@Override
	public void removeRolePermission(final String roleId,final String permissionIds) {
		this.getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				String delsql="delete from sys_role_resource where role_id='"+roleId+"'";
				if(permissionIds!=null)delsql+=" and resource_id='"+permissionIds+"'";
				session.createSQLQuery(delsql).executeUpdate();
				
				return null;
			}
		});
		
	}

}
