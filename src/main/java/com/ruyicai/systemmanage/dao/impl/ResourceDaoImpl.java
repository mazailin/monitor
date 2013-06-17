package com.ruyicai.systemmanage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ruyicai.common.dao.impl.BaseDaoImpl;
import com.ruyicai.systemmanage.dao.ResourceDao;
import com.ruyicai.systemmanage.domain.Resource;
import com.ruyicai.systemmanage.vo.CheckedResourceVo;
import com.ruyicai.systemmanage.vo.ResourceVo;

@Repository("resourceDao")
@Transactional
public class ResourceDaoImpl extends BaseDaoImpl<Resource> implements
		ResourceDao {
	public static List<ResourceVo> resourceVoheadmenu = new ArrayList<ResourceVo>();
	public static List<ResourceVo> resourceVolist = new ArrayList<ResourceVo>();
	public static List<CheckedResourceVo> minumumResourceVolist = new ArrayList<CheckedResourceVo>();
	public static List<ResourceVo> resourceVoheadmenuandtree = new ArrayList<ResourceVo>();
	/**
	 * 形成树的list
	 */
	public List<ResourceVo> findAllResourceList() {
		if (resourceVolist.size() <= 0) {
			Criteria criteria = this.getSession().createCriteria(Resource.class);
			criteria.add(Restrictions.eq("parent", "0"));
			criteria.add(Restrictions.eq("headermenu", 0));
			criteria.addOrder(Order.asc("displayorder"));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Resource> resources=(List<Resource>) criteria.list();
			
			resourceVolist = poToVo(resources,"0");
		}
		return resourceVolist;
	}
/**
 * 返回 所有headmenu的结构
 */
	public List<ResourceVo> findAllResource() {
		if (resourceVoheadmenu.size() <= 0) {
			Criteria criteria = this.getSession().createCriteria(Resource.class);
			criteria.add(Restrictions.eq("headermenu", 1));
			criteria.add(Restrictions.eq("parent", "0"));
			criteria.addOrder(Order.asc("displayorder"));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Resource> resources =  (List<Resource>) criteria.list();
			resourceVoheadmenu=poToVo(resources,"0");
		}
		
		return resourceVoheadmenu;
	}

	public List<ResourceVo> getResourceByIds(List<String> resourcesid) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Resource.class);
		if(resourcesid.contains("*")){
//		   if(resourceVoheadmenuandtree.size()<=0) {
//			   
//		   }
			  //TODO

		     return resourceVoheadmenuandtree;
		} else{
			List<ResourceVo> vos = new ArrayList<ResourceVo>();
			if(resourcesid.size()>0){
				criteria.add(Restrictions.in("id",resourcesid ));
				criteria.addOrder(Order.asc("displayorder"));
				List<Resource> list = this.getHibernateTemplate().findByCriteria(
						criteria);
				for (Resource r : list) {
					ResourceVo vo = new ResourceVo();
					vo.setDescription(r.getDescription());
					vo.setIconCls(r.getIconcls());
					vo.setId(r.getId());
					vo.setLeaf(r.isLeaf());
					vo.setPath(r.getPath());
					vo.setText(r.getName());
					vo.setExternal(r.getExternal());
					vo.setHeight(r.getHeight()+"");
					vo.setRel(r.getRel());
					vo.setReloadFlag(r.getReloadflag());
					vo.setTarget(r.getTarget());
					vo.setWidth(r.getWidth()+"");
					vos.add(vo);
				}
			}
			return vos;
		}
	}

	/**
	 * 获取资源的最大的深度
	 */
	private int getResourceDeep() {
		Object obj = this.getSession()
				.createSQLQuery("SELECT MAX(CHAR_LENGTH(id))/3 FROM resource")
				.uniqueResult();
		System.out.println(obj);
		return 0;
	}

	/**
	 * po to vo
	 * 
	 * @param list
	 * @return
	 */
	private List<ResourceVo> poToVo(List<Resource> list,String root) {
		List<ResourceVo> vos = new ArrayList<ResourceVo>();
		for (Resource resource : list) {
			if (root.equals(resource.getParent())) {
				ResourceVo node = new ResourceVo();
				node.setId(resource.getId());
				node.setText(resource.getName());
				node.setPath(resource.getPath());
				node.setDescription(resource.getDescription());
				node.setIconCls(resource.getIconcls());
				node.setLeaf(resource.isLeaf());
				node.setParams(resource.getParams());
				node.setExpanded(true);
				node.setExternal(resource.getExternal());
				node.setHeight(resource.getHeight()+"");
				node.setRel(resource.getRel());
				node.setReloadFlag(resource.getReloadflag());
				node.setTarget(resource.getTarget());
				node.setWidth(resource.getWidth()+"");
				vos.add(node);
				List<Resource> children = resource.getChildren();
				addChildren(node, children);
			}
		}
		return vos;
	}

	/**
	 * 递归添加children
	 */
	private void addChildren(ResourceVo vo, List<Resource> list) {
		for (Resource resource : list) {
			ResourceVo node = new ResourceVo();
			node.setId(resource.getId());
			node.setText(resource.getName());
			node.setPath(resource.getPath());
			node.setDescription(resource.getDescription());
			node.setIconCls(resource.getIconcls());
			node.setLeaf(resource.isLeaf());
			node.setParams(resource.getParams());
			node.setExternal(resource.getExternal());
			node.setHeight(resource.getHeight()+"");
			node.setRel(resource.getRel());
			node.setReloadFlag(resource.getReloadflag());
			node.setTarget(resource.getTarget());
			node.setWidth(resource.getWidth()+"");
			vo.getChildren().add(node);
			List<Resource> children = resource.getChildren();
			if (children.size() != 0) {
				addChildren(node, children);
				node.setExpanded(true);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Resource> findAll() {
		Criteria criteria = this.getSession().createCriteria(Resource.class);
		criteria.add(Restrictions.eq("parent", "0"));
//		criteria.add(Restrictions.eq("headermenu", 0));
		criteria.addOrder(Order.asc("displayorder"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Resource>) criteria.list();
	}

	@Override
	public List<CheckedResourceVo> getMinimumResource() {
		if (minumumResourceVolist.size() > 0) {

		} else {
			DetachedCriteria cri = DetachedCriteria.forClass(Resource.class);
			cri.add(Restrictions.eq("leaf", true));
			cri.addOrder(Order.asc("displayorder"));
			List<Resource> list = (List<Resource>) this.getHibernateTemplate()
					.findByCriteria(cri);
			for (Resource r : list) {
				CheckedResourceVo vo = new CheckedResourceVo();
				vo.setDescription(r.getDescription());
				vo.setIconCls(r.getIconcls());
				vo.setId(r.getId());
				vo.setPath(r.getPath());
				vo.setText(r.getName());
				vo.setExternal(r.getExternal());
				vo.setHeight(r.getHeight()+"");
				vo.setRel(r.getRel());
				vo.setReloadFlag(r.getReloadflag());
				vo.setTarget(r.getTarget());
				vo.setWidth(r.getWidth()+"");
				minumumResourceVolist.add(vo);
			}
			
		}
		return minumumResourceVolist;
	}
	@Override
	public Object findByPathName(String sql) {
		// TODO Auto-generated method stub
		Object o=new Object();
		o=this.getSession().createSQLQuery(sql).uniqueResult();
		return o;
	}
	@Override
	public List<Resource> findByLeaf(String sql) {
		// TODO Auto-generated method stub
		return this.getSession().createSQLQuery(sql).addEntity(Resource.class).list();
	}
}
