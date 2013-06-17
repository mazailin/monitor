package com.ruyicai.systemmanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ruyicai.common.constants.Contants;
import com.ruyicai.common.utils.props.Props;
import com.ruyicai.common.vo.ATag;
import com.ruyicai.common.vo.Accordion;
import com.ruyicai.common.vo.LiTag;
import com.ruyicai.common.vo.UlTag;
import com.ruyicai.systemmanage.service.IClient;
import com.ruyicai.systemmanage.vo.ResourceVo;

@Service("generateResource")
public class GenerateResourceDWZ implements IClient {
	/**
	 * 形成树的字符串
	 * 
	 * @param resources
	 * @return
	 */
	public String createTreeString(List<ResourceVo> resources,boolean isheadmenu) {

		StringBuffer accordions = new StringBuffer();
		if(isheadmenu){
			//<li><a href="${BaseURL}${navMenu.href}"><span>${navMenu.name}</span></a></li>
			//TODO
		}else{
		for (int i = 0; i < resources.size(); i++) {
			// 形成accordions
			ResourceVo vo = resources.get(i);
			String treeMenuId = vo.getId();
			boolean isCheckbox =Props.instance().getServProps().getBoolean(Contants.IS_ATAG_CHECHBOX,false)  ;
			String rootUlStyleClass = Props.instance().getServProps().get(Contants.ROOTURLSTYLECLASS) ;// "tree","tree treeFolder treeCheck"
				accordions.append(new Accordion(vo.getText(),new UlTag(
						rootUlStyleClass, createTree(treeMenuId, isCheckbox,
								vo.getChildren()))).toString());
			}
			
		}
		return accordions.toString();
	}

	private List<LiTag> createTree(String pid, boolean isCheckbox,
			List<ResourceVo> children) {
		List<LiTag> liList = new ArrayList<LiTag>();

		if (children == null) {
			return liList;
		}
		for (ResourceVo child : children) {

			if (isCheckbox) {
				ATag a = new ATag();
				if (child.getChildren().size() == 0) {
					a.setTname("treeMenuIds");
					a.setTvalue(child.getId());
				}

				a.setValue(child.getText());
				liList.add(new LiTag(a, new UlTag("", createTree(child.getId(),
						isCheckbox, child.getChildren()))));
			} else {
				liList.add(new LiTag(new ATag(null, null, false, child
						.getTarget(), child.getWidth() + "", child.getHeight()
						+ "", child.getRel(), child.getExternal(), child
						.getReloadFlag(), child.getPath(), child.getText()),
						new UlTag("", createTree(child.getId(), isCheckbox,
								child.getChildren()))));
			}

		}

		return liList;
	}
}
