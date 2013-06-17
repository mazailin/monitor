package com.ruyicai.monitor.jms;

import java.math.BigDecimal;

public class BetRequest {

	private String betcode;

	private BigDecimal amt;
	/**	投注方式，（0-单式，1-复式，2-胆拖，3-单式上传）*/
	private BigDecimal drawway;
	public String getBetcode() {
		return betcode;
	}
	public void setBetcode(String betcode) {
		this.betcode = betcode;
	}
	public BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	public BigDecimal getDrawway() {
		return drawway;
	}
	public void setDrawway(BigDecimal drawway) {
		this.drawway = drawway;
	}
	
}
