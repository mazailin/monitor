package com.ruyicai.systemmanage.service;

import java.util.List;

import com.ruyicai.systemmanage.vo.CheckedResourceVo;
import com.ruyicai.systemmanage.vo.ResourceVo;

public interface ResourceService {
	public List<ResourceVo> findAll();

	public List<CheckedResourceVo> findCheckedAll();
}
