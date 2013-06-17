package com.ruyicai.systemmanage.service;

import java.util.List;
import java.util.Map;

import com.ruyicai.systemmanage.domain.SysRoleBean;
import com.ruyicai.systemmanage.vo.CheckedResourceVo;
import com.ruyicai.systemmanage.vo.ResourceVo;
import com.ruyicai.systemmanage.vo.RoleVo;

public interface RoleService {
	 String save(SysRoleBean entity);
	    void update(SysRoleBean entity);
	    void delete(SysRoleBean entity);
	    void deleteByIds(String ids);        
	    SysRoleBean findByKey(String pk);   
	    /**
	 	 * param is key value of entity properties
	 	*/ 
	    List<SysRoleBean> find(Map param,Integer start, Integer limit);
	    int findCount(Map param);
	   void allocpermission(String[] roleIds,String[] permissionIds);
	   void removeRolePermission(String roleId,String permissionIds);


	public SysRoleBean findByName(String name);

	public List<ResourceVo> getResourcesByRoleId(long id);

	public List<String> getResourcesIdsByRoleId(long id);

	public boolean verifyRoleByResource(String roleName, String resourcePath);

	public List<RoleVo> getListByConditionPerPage(String hql, int start,
			int limit);

	public long getCountByCondition(String hql);

	public List<RoleVo> getRoleList();

	public List<CheckedResourceVo> getAllAndCheckedResources(long id);

	public String getTreeResource(String roleName,String roleid,boolean isheadmenu);
	public List<ResourceVo>  getTreeResource();
}
