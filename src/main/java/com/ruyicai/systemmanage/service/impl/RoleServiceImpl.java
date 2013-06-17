package com.ruyicai.systemmanage.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruyicai.common.constants.Contants;
import com.ruyicai.common.utils.DeepCopyUtil;
import com.ruyicai.systemmanage.dao.ResourceDao;
import com.ruyicai.systemmanage.dao.RoleDao;
import com.ruyicai.systemmanage.dao.UserDao;
import com.ruyicai.systemmanage.domain.SysRoleBean;
import com.ruyicai.systemmanage.service.IClient;
import com.ruyicai.systemmanage.service.RoleService;
import com.ruyicai.systemmanage.vo.CheckedResourceVo;
import com.ruyicai.systemmanage.vo.ResourceVo;
import com.ruyicai.systemmanage.vo.RoleVo;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	@Resource
	private UserDao userDao;

	@Resource
	private ResourceDao resourceDao;
	
	@Resource
	private IClient generateResource;
	
	    public String save(SysRoleBean entity) {
	        if(entity == null){
	            return null;
	        }
	        roleDao.save(entity);
	          return entity.getId()+"";
	    }

	    public void update(SysRoleBean entity) {
	        if(entity == null){
	            return;
	        }
	        roleDao.update(entity);
	    }

	    public void delete(SysRoleBean entity) {
	    	roleDao.delete(entity);        
	    }
	    public void deleteByIds(String ids) {
	    	roleDao.deleteByIds(ids);        
	    }
	    public SysRoleBean findByKey(String pk) {
	        return roleDao.findById(pk);      
	    }

	    public List<SysRoleBean> find(Map param,Integer start, Integer limit) {
	     StringBuilder sql=new StringBuilder("from SysRoleBean  where 1=1 ");
	     java.util.Iterator it = param.entrySet().iterator();
			while (it.hasNext()) {
				java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
				String key=(String)entry.getKey();
				if(Contants.FIELD_STARTDATE.equals(key)){
				  sql.append(" and   id>1");
				  continue;
				}
				
				sql.append(" and "+ entry.getKey()+"= '"+entry.getValue()+"'");			
			}
	      if(start==null)return  roleDao.findByHQL(sql.toString());  
			return  roleDao.findByHQL(sql.toString(), start,  limit);   
	    }
	    public int findCount(Map param){
	        StringBuilder sql=new StringBuilder("select count(id) from SysRoleBean  where 1=1 ");
	     java.util.Iterator it = param.entrySet().iterator();
			while (it.hasNext()) {
				java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
				String key=(String)entry.getKey();
				if(Contants.FIELD_STARTDATE.equals(key)){
					sql.append(" and   id>1");
				  continue;
				}
				sql.append(" and "+ entry.getKey()+"= '"+entry.getValue()+"'");		
			}

			return  roleDao.findCountByHQL(sql.toString());    
			}

		@Override
		public void allocpermission(String[] roleIds, String[] permissionIds) {
			roleDao.allocpermission(roleIds, permissionIds);
			
		}

		@Override
		public void removeRolePermission(String roleId, String permissionIds) {
			roleDao.removeRolePermission(roleId, permissionIds);
			
		}


	public SysRoleBean findByName(String name) {
		return roleDao.findRoleByName(name);
	}

	@Transactional(readOnly = false)
	public boolean verifyRoleByResource(String roleName, String resourcePath) {
		SysRoleBean role = roleDao.findRoleByName(roleName);
		if (null != role) {
			List<String> resourcesid = roleDao.getResourceIds(roleName, null);
			List<ResourceVo> resources = resourceDao
					.getResourceByIds(resourcesid);
			for (ResourceVo resource : resources) {
				if (resource.getPath().equalsIgnoreCase(resourcePath)) {
					return true;
				}
			}
		}
		return false;
	}

	public List<RoleVo> getRoleList() {
		List<SysRoleBean> sources = roleDao.findAll();
		List<RoleVo> roleVos = new ArrayList<RoleVo>();
		for (SysRoleBean role : sources) {
			RoleVo roleVo = new RoleVo();
			roleVo.setId(role.getId());
			roleVo.setName(role.getName());
			roleVo.setDescription(role.getDescription());
			roleVos.add(roleVo);
		}
		return roleVos;
	}

	@Transactional(readOnly = false)
	public List<RoleVo> getListByConditionPerPage(String hql, int start,
			int limit) {
		List<RoleVo> roles = new ArrayList<RoleVo>();
		List<SysRoleBean> sources = roleDao.getListByConditionPerPage(hql, start,
				limit);
		for (SysRoleBean role : sources) {
			RoleVo roleVo = new RoleVo();
			roleVo.setId(role.getId());
			roleVo.setName(role.getName());
			roleVo.setDescription(role.getDescription());
			roles.add(roleVo);
		}
		return roles;
	}

	@Transactional(readOnly = false)
	public long getCountByCondition(String hql) {
		return roleDao.getCountByCondition(hql);
	}

	@Override
	@Transactional
	public List<ResourceVo> getResourcesByRoleId(long id) {
		List<String> resourcesid = roleDao.getResourceIds(null, id+"");
		List<ResourceVo> resources = resourceDao.getResourceByIds(resourcesid);

		return resources;
	}

	@Override
	public List<String> getResourcesIdsByRoleId(long id) {
		return roleDao.getResourceIds(null, id+"");
	}

	@Transactional(readOnly = false)
	public List<CheckedResourceVo> getAllAndCheckedResources(long id) {
		List<ResourceVo> checkedVos = this.getResourcesByRoleId(id);
		List<CheckedResourceVo> allVos_src = resourceDao.getMinimumResource();
		List<CheckedResourceVo> allVos = (List<CheckedResourceVo>) DeepCopyUtil
				.deepCopy(allVos_src);
		for (CheckedResourceVo vo1 : allVos) {
			for (ResourceVo vo2 : checkedVos) {
				if (vo1.getId().equals(vo2.getId())) {
					vo1.setChecked(true);
				}
			}
		}
		return allVos;
	}


	/**
	 * 根据整棵树treeResourceVos_desc和树中所需要的末梢的ids resourcesid，获取显示的权限树
	 * 
	 * @param resourcesVos
	 *            整个权限树，包含所有
	 * @param resourcesid
	 *            用户拥有的权限的ids
	 * @return
	 */
	private List<ResourceVo> getAuthorityTrees(List<ResourceVo> resourcesVos,
			List<String> resourcesid) {
		loopDelChilds(resourcesVos, resourcesid);
		loopDeepEmptyDir(resourcesVos);
		return resourcesVos;
	}

	/**
	 * 循环删除末梢
	 * 
	 * @param resourcesVos
	 *            整个权限树，包含所有
	 * @param resourcesid
	 *            用户拥有的权限的ids
	 */
	private void loopDelChilds(List<ResourceVo> resourcesVos,
			List<String> resourcesid) {
		if (resourcesid.contains("*"))
			return;
		Iterator<ResourceVo> ite = resourcesVos.iterator();
		while (ite.hasNext()) {
			ResourceVo vo = ite.next();
			if (vo.getChildren().size() > 0) {// 有儿子，继续循环
				List<ResourceVo> childen = vo.getChildren();
				loopDelChilds(childen, resourcesid);
			} else {// 没有儿子，判断是否是权限，是保留，不是删除自己
				boolean flag = false;// 不是
				for (String id : resourcesid) {
					if (id.equals(vo.getId())) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					ite.remove();
				}
			}
		}
	}

	/**
	 * 循环删除空目录
	 * 
	 * @param resourcesVos
	 */
	private void loopDeepEmptyDir(List<ResourceVo> resourcesVos) {
		Iterator<ResourceVo> ite = resourcesVos.iterator();
		while (ite.hasNext()) {
			ResourceVo vo = ite.next();
			if (vo.getChildren().size() <= 0 && vo.isLeaf()) {// 末梢，跳过
				continue;
			} else if (vo.getChildren().size() > 0) {// 获取儿子，循环
				List<ResourceVo> children = vo.getChildren();
				loopDeepEmptyDir(children);
			}
			if (vo.getChildren().size() <= 0 && !vo.isLeaf()) {// 空目录删除自己
				ite.remove();
			}
			// 如果一个vo的所有的子目录都是空的，那么删除子目录后他也是空的，应该删除
			/*
			 * if(vo!=null && vo.getChildren().size()<=0 && !vo.isLeaf()){
			 * ite.remove(); }
			 */
		}
	}

	public List<ResourceVo>  getTreeResource() {		
		// 获取整棵树的List<ResourceVo>
		List<ResourceVo> treeResourceVos_src = resourceDao.findAllResourceList();
		// 深拷贝List<ResourceVo>
		return (List<ResourceVo>) DeepCopyUtil
				.deepCopy(treeResourceVos_src);
		
	}
	
    /**
     * support jquery dwz and extjs4 tree
     */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public String getTreeResource(String roleName,String roleid,boolean isheadmenu) {
		List<String> resourcesid = roleDao.getResourceIds(roleName, roleid);
		// 获取整棵树的List<ResourceVo>
		List<ResourceVo> treeResourceVos_src=null;
		if(isheadmenu)
			treeResourceVos_src = resourceDao.findAllResource();
			
		else
			treeResourceVos_src = resourceDao.findAllResourceList();
		// 深拷贝List<ResourceVo>
		List<ResourceVo> treeResourceVos_desc = (List<ResourceVo>) DeepCopyUtil
				.deepCopy(treeResourceVos_src);
		// 根据整棵树treeResourceVos_desc和树中所需要的末梢的ids resourcesid，获取显示的权限树
		List<ResourceVo> resources = getAuthorityTrees(treeResourceVos_desc,
				resourcesid);
		/**
		 * {
		 * 'accordions':[{'id':'001','title':'数据维护','collapsed':false,'autoScroll':true}
		 * , {'id':'002','title':'版本管理','collapsed':false,'autoScroll':true},
		 * {'id':'003','title':'设备节点管理','collapsed':false,'autoScroll':true},
		 * {'id':'011','title':'系统管理','collapsed':false,'autoScroll':true}],
		 * '001':[{'id':'001001','moduleId':'dataManage.rules','params':'','iconCls':'no-node-icon','draggable':false,'text':'规则管理','leaf':false
		 * ,
		 * 'children':[{'id':'001001001','moduleId':'dataManage.rules.RulesFilesUpload','params':'','iconCls':'no-node-icon','draggable':false,'text':'规则文件上传','leaf':true,'children':[]}]}
		 * ] ,'002':
		 * 
		 * <div class="accordionHeader">
		 *<h2><span>Folder</span>业务功能</h2>
		 *</div>
		 *<div class="accordionContent">
		 *<ul class="tree">
		 *<li><a href="newPage1.html" target="dialog" rel="dlg_page">黑名单</a></li>
		 *<li><a href="newPage1.html" target="dialog" rel="dlg_page2">外呼管理</a></li>
		 *</ul>
		 *</div>
		 */
		String str = generateResource.createTreeString(resources,isheadmenu);
		return str;

	}

}
