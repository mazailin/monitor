package com.ruyicai.monitor.jms;


public class CaseLotRequest {
	private long buyAmt;
	private long safeAmt;
	private long totalAmt;
	private int commisionRatio;
	private String title;
	private String desc;
	private int visibility;
	private long minAmt;
	private String starter;
	private String caselotinfo;
	public long getBuyAmt() {
		return buyAmt;
	}
	public void setBuyAmt(long buyAmt) {
		this.buyAmt = buyAmt;
	}
	public long getSafeAmt() {
		return safeAmt;
	}
	public void setSafeAmt(long safeAmt) {
		this.safeAmt = safeAmt;
	}
	public long getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(long totalAmt) {
		this.totalAmt = totalAmt;
	}
	public int getCommisionRatio() {
		return commisionRatio;
	}
	public void setCommisionRatio(int commisionRatio) {
		this.commisionRatio = commisionRatio;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getVisibility() {
		return visibility;
	}
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}
	public long getMinAmt() {
		return minAmt;
	}
	public void setMinAmt(long minAmt) {
		this.minAmt = minAmt;
	}
	public String getStarter() {
		return starter;
	}
	public void setStarter(String starter) {
		this.starter = starter;
	}
	public String getCaselotinfo() {
		return caselotinfo;
	}
	public void setCaselotinfo(String caselotinfo) {
		this.caselotinfo = caselotinfo;
	}
	
}
