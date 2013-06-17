package com.ruyicai.common.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FusionChartsBean implements Serializable{
	private String palette;
	private String showBorder;
	
//	private String isSliced;
	
	private String caption;
	private String xAxisName;
	private String yAxisName;
	private String showValues;
	private String decimals;
	private String formatNumberScale;
	private String enableSmartLabels;
	private String enableRotation;
	private String bgColor;
	private String bgAlpha;
	private String bgRatio;
	private String bgAngle;
	private String startingAngle;
	
	
	
public FusionChartsBean(String palette, String showBorder, String caption,
			String xAxisName, String yAxisName, String showValues,
			String decimals, String formatNumberScale,
			String enableSmartLabels, String enableRotation, String bgColor,
			String bgAlpha, String bgRatio, String bgAngle,
			String startingAngle, List<FusionChartsSetBean> sets) {
		super();
		this.palette = palette;
		this.showBorder = showBorder;
		this.caption = caption;
		this.xAxisName = xAxisName;
		this.yAxisName = yAxisName;
		this.showValues = showValues;
		this.decimals = decimals;
		this.formatNumberScale = formatNumberScale;
		this.enableSmartLabels = enableSmartLabels;
		this.enableRotation = enableRotation;
		this.bgColor = bgColor;
		this.bgAlpha = bgAlpha;
		this.bgRatio = bgRatio;
		this.bgAngle = bgAngle;
		this.startingAngle = startingAngle;
		this.sets = sets;
	}

//	private Map<String, String> set=new HashMap<String, String>();
	private List<FusionChartsSetBean> sets=new ArrayList<FusionChartsSetBean>();
	
	public String getSets() {
		StringBuffer sb=new StringBuffer();
		for (FusionChartsSetBean fsBean : sets) {
			sb.append(getSet());
			sb.append(fsBean.getLabel()+fsBean.getValue()+fsBean.getIsSliced());
			sb.append(getEnd());
		}
		return sb.toString();
	}
	public void setSets(List<FusionChartsSetBean> sets) {
		this.sets = sets;
	}
	public String getStart(){
		return "<";
	}
	public String getRowEnd(){
		return ">";
	}
	public String getEnd(){
		return "/>";
	}
	public String getStartChart(){
		return "<chart ";
	}
	public String getEndChart(){
		return "</chart>";
	}
	public String getSet(){
		return "<set ";
	};
	public String getPalette() {
		if(palette==null){
			return "";
		}
		return "palette='"+palette+"' ";
	}
	public void setPalette(String palette) {
		this.palette = palette;
	}
	public String getShowBorder() {
		if(showBorder==null){
			return "";
		}
		return "showBorder='"+showBorder+"' ";
	}
	public void setShowBorder(String showBorder) {
		this.showBorder = showBorder;
	}
	public String getCaption() {
		if(caption==null){
			return "";
		} 
		return "caption='"+caption+"' ";
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getxAxisName() {
		if(xAxisName==null){
			return "";
		}
		return "xAxisName='"+xAxisName+"' ";
	}
	public void setxAxisName(String xAxisName) {
		this.xAxisName = xAxisName;
	}
	public String getyAxisName() {
		if(yAxisName==null){
			return "";
		} 
		return "yAxisName='"+yAxisName+"' ";
	}
	public void setyAxisName(String yAxisName) {
		this.yAxisName = yAxisName;
	}
	public String getShowValues() {
		if(showValues==null){
			return "";
		}
		return "showValues='"+showValues+"' ";
	}
	public void setShowValues(String showValues) {
		this.showValues = showValues;
	}
	public String getDecimals() {
		if(decimals==null){
			return "";
		}
		return "decimals='"+decimals+"' ";
	}
	public void setDecimals(String decimals) {
		this.decimals = decimals;
	}
	public String getFormatNumberScale() {
		if(formatNumberScale==null){
			return "";
		}
		return "formatNumberScale='"+formatNumberScale+"' ";
	}
	public void setFormatNumberScale(String formatNumberScale) {
		this.formatNumberScale = formatNumberScale;
	}
	public String getEnableSmartLabels() {
		if(enableSmartLabels==null){
			return "";
		}
		return "enableSmartLabels='"+enableSmartLabels+"' ";
	}
	public void setEnableSmartLabels(String enableSmartLabels) {
		this.enableSmartLabels = enableSmartLabels;
	}
	public String getEnableRotation() {
		if(enableRotation==null){
			return "";
		}
		return "enableRotation='"+enableRotation+"' ";
	}
	public void setEnableRotation(String enableRotation) {
		this.enableRotation = enableRotation;
	}
	public String getBgColor() {
		if(bgColor==null){
			return "";
		}
		return "bgColor='"+bgColor+"' ";
	}
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	public String getBgAlpha() {
		if(bgAlpha==null){
			return "";
		}
		return "bgAlpha='"+bgAlpha+"' ";
	}
	public void setBgAlpha(String bgAlpha) {
		this.bgAlpha = bgAlpha;
	}
	public String getBgRatio() {
		if(bgRatio==null){
			return "";
		}
		return "bgRatio='"+bgRatio+"' ";
	}
	public void setBgRatio(String bgRatio) {
		this.bgRatio = bgRatio;
	}
	public String getBgAngle() {
		if(bgAngle==null){
			return "";
		}
		return "bgAngle='"+bgAngle+"' ";
	}
	public void setBgAngle(String bgAngle) {
		this.bgAngle = bgAngle;
	}
	public String getStartingAngle() {
		if(startingAngle==null){
			return "";
		}
		return "startingAngle='"+startingAngle+"' ";
	}
	public void setStartingAngle(String startingAngle) {
		this.startingAngle = startingAngle;
	}
	
	@Override
	public String toString() {
		return getStartChart()+
				getPalette()+getShowBorder()+getDecimals()+getCaption()+getyAxisName()+getxAxisName()+getShowValues()+
				getFormatNumberScale()+getEnableSmartLabels()+getEnableRotation()+getBgColor()+getBgAlpha()+
				getBgRatio()+getBgAngle()+getStartingAngle() +getRowEnd()
				+getSets()+getEndChart();
	}

	public static void main(String[] args) {
		
		List<FusionChartsSetBean> ss=new ArrayList<FusionChartsSetBean>();
		
		for(int i=0;i<5;i++){
			FusionChartsSetBean fs=new FusionChartsSetBean("Jan"+i,"462"+i,null);
			ss.add(fs);
		}
		
		FusionChartsBean sb=new FusionChartsBean(null,null,
				"Monthly Unit Sales","Month","Units","0","0","0",
				null,null,null,null,null,null,null,ss);
		System.out.println(sb.toString());
	}
	
}
