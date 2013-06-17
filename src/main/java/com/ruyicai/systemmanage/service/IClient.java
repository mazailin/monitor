package com.ruyicai.systemmanage.service;

import java.util.List;

import com.ruyicai.systemmanage.vo.ResourceVo;

public interface IClient {
	public String createTreeString(List<ResourceVo> resources,boolean isheadmenu);
}
