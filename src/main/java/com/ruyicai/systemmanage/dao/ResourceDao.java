package com.ruyicai.systemmanage.dao;

import java.util.List;

import com.ruyicai.common.dao.IBaseDao;
import com.ruyicai.systemmanage.domain.Resource;
import com.ruyicai.systemmanage.vo.CheckedResourceVo;
import com.ruyicai.systemmanage.vo.ResourceVo;

public interface ResourceDao extends IBaseDao<Resource> {
	public List<ResourceVo> findAllResource();

	public List<ResourceVo> findAllResourceList();

	public List<ResourceVo> getResourceByIds(List<String> resourcesid);

	public List<CheckedResourceVo> getMinimumResource();

	public Object findByPathName(String operatePath);

	public List<Resource> findByLeaf(String sql);
}
