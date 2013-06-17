package com.ruyicai.systemmanage.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResourceVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String text;
	private String description;
	private String path;
	private boolean expanded;
	private boolean leaf;
	private String iconCls = "no-node-icon";
	private String params;
	 private String target;
	   private String rel;
	 
	   private String reloadFlag;
	   private String external;
	   private String width;
	   private String height;
	private List<ResourceVo> children = new ArrayList<ResourceVo>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}


	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public List<ResourceVo> getChildren() {
		return children;
	}

	public void setChildren(List<ResourceVo> children) {
		this.children = children;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getReloadFlag() {
		return reloadFlag;
	}

	public void setReloadFlag(String reloadFlag) {
		this.reloadFlag = reloadFlag;
	}

	public String getExternal() {
		return external;
	}

	public void setExternal(String external) {
		this.external = external;
	}


	public void setWidth(String width) {
		this.width = width;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public String getHeight() {
		return height;
	}

	
}