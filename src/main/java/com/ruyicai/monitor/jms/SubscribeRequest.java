package com.ruyicai.monitor.jms;

import java.math.BigDecimal;
import java.util.Date;


public class SubscribeRequest implements Comparable<SubscribeRequest> {

	private BigDecimal lotmulti;
	
	private BigDecimal amt;
	
	private String batchcode;
	
	private Date endtime;
	
	private String desc;
	
	private BigDecimal lotsType;

	public BigDecimal getLotsType() {
		return lotsType;
	}

	public void setLotsType(BigDecimal lotsType) {
		this.lotsType = lotsType;
	}

	public BigDecimal getLotmulti() {
		return lotmulti;
	}

	public void setLotmulti(BigDecimal lotmulti) {
		this.lotmulti = lotmulti;
	}

	public BigDecimal getAmt() {
		return amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	public String getBatchcode() {
		return batchcode;
	}

	public void setBatchcode(String batchcode) {
		this.batchcode = batchcode;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public int compareTo(SubscribeRequest o) {
		if(Long.parseLong(batchcode) > Long.parseLong(o.getBatchcode())) {
			return 1;
		}
		if(Long.parseLong(batchcode) < Long.parseLong(o.getBatchcode())) {
			return -1;
		}
		return 0;
	}
}
