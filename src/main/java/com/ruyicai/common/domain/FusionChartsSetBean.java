package com.ruyicai.common.domain;

import java.io.Serializable;

public class FusionChartsSetBean implements Serializable{
	private String label;
	private String value;
	private String isSliced;
	
	public FusionChartsSetBean() {
		super();
	}
	public FusionChartsSetBean(String label, String value, String isSliced) {
		super();
		this.label = label;
		this.value = value;
		this.isSliced = isSliced;
	}
	public String getLabel() {
		if(label==null){
			return "";
		}
		return "label='"+label+"' ";
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		if(value==null){
			return "";
		}
		return "value='"+value+"' ";
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getIsSliced() {
		if(isSliced==null){
			return "";
		}
		return "isSliced='"+isSliced+"' ";
	}
	public void setIsSliced(String isSliced) {
		this.isSliced = isSliced;
	}
	@Override
	public String toString() {
		return getLabel()+getValue()+getIsSliced();
	}
	
	
}
