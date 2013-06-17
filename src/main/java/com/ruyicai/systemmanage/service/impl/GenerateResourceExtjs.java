package com.ruyicai.systemmanage.service.impl;

import java.util.List;

import com.ruyicai.systemmanage.service.IClient;
import com.ruyicai.systemmanage.vo.ResourceVo;
//@Service("generateResource")
public class GenerateResourceExtjs implements IClient{
	/**
	 * 形成树的字符串
	 * 
	 * @param resources
	 * @return
	 */
	public String createTreeString(List<ResourceVo> resources,boolean isheadmenu) {
		StringBuffer accordions = new StringBuffer("'accordions':[");
		StringBuffer childrenStr = new StringBuffer("");
		for (int i = 0; i < resources.size(); i++) {
			// 形成accordions
			if (i != 0) {
				accordions.append(",");
			}
			ResourceVo vo = resources.get(i);
			accordions.append("{'id':'" + vo.getId() + "'");
			accordions.append(",'title':'" + vo.getText() + "'");
			accordions.append(",'collapsed':false,'autoScroll':true}");
			// 儿子的字符串
			List<ResourceVo> children = vo.getChildren();
			if (i != 0) {
				childrenStr.append(",");
			}
			StringBuffer sonstr = new StringBuffer("'" + vo.getId() + "':[");
			sonstr.append(loopCreateSonStr(children));
			sonstr.append("]");
			childrenStr.append(sonstr.toString());
		}
		accordions.append("]");
		//非标准的json串，某些版本的IE浏览器无法解析,作如下判断
		if(childrenStr.toString().toString().length()>0) return "{" + accordions.toString() + "," + childrenStr.toString() + "}";
		else return "{" + accordions.toString() + "}";
	}
	
	/**
	 * 从第二级以下创建树的str
	 * 
	 * @param children
	 * @return
	 */
	private String loopCreateSonStr(List<ResourceVo> children) {
		StringBuffer sonstr = new StringBuffer("");
		for (int j = 0; j < children.size(); j++) {
			if (j != 0) {
				sonstr.append(",");
			}
			ResourceVo son = children.get(j);
			sonstr.append("{'id':'" + son.getId() + "'");
			sonstr.append(",'moduleId':'" + son.getPath() + "'");
			sonstr.append(",'params':'" + son.getParams() + "'");
			sonstr.append(",'iconCls':'" + son.getIconCls() + "'");
			sonstr.append(",'draggable':false");
			sonstr.append(",'text':'" + son.getText() + "'");
			sonstr.append(",'leaf':" + son.isLeaf() + "");
			if (son.getChildren().size() == 0) {
				sonstr.append(",'children':[]");
			} else {
				sonstr.append(",'children':[");
				List<ResourceVo> children2 = son.getChildren();
				String tempStr = loopCreateSonStr(children2);
				sonstr.append(tempStr);
				sonstr.append("]");
			}
			sonstr.append("}");
		}
		return sonstr.toString();
	}
}
