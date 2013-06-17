package com.ruyicai.systemmanage.dao;

import java.util.List;

import com.ruyicai.common.dao.IBaseDao;
import com.ruyicai.systemmanage.domain.SysRoleBean;

public interface RoleDao extends IBaseDao<SysRoleBean> {
	public SysRoleBean findRoleByName(String name);

	List<SysRoleBean> find(String sql, int start, int limit);

	List<SysRoleBean> find(String sql);

	int findCount(String sql);

	void allocpermission(String[] roleIds, String[] permissionIds);

	void removeRolePermission(String roleId, String permissionIds);

	public List<String> getResourceIds(String rolename, String roleid);

	void deleteRoleAndRole_Resource(String ids);

}
