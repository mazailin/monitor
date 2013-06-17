package com.ruyicai.monitor.jms;

import java.math.BigDecimal;
import java.util.List;

public class OrderRequest {
    String orderid;
	String batchcode;
	String lotno;
	BigDecimal amt;
	BigDecimal bettype = BetType.touzhu.value();
	String userno;
	BigDecimal lotmulti;
	String buyuserno;
	String channel = "1";
	String subchannel = "00092493";
	SubaccountType subaccount;
	BigDecimal paytype = TorderState.payType_no.value();
	BigDecimal oneamount = new BigDecimal(200);

	String memo;
	String desc;

	List<BetRequest> betRequests;

	BigDecimal prizeend = BigDecimal.ZERO;
	BigDecimal prizeendamt = BigDecimal.ZERO;
	BigDecimal leijiprizeendamt = BigDecimal.ZERO;
	BigDecimal accountnomoneysms = BigDecimal.ZERO;
	List<SubscribeRequest> subscribeRequests;
	CaseLotRequest caseLotRequest;
	/** 投注方式，（0-单式，1-复式，2-胆拖，3-单式上传），追号时使用 */
	BigDecimal drawway;
	/** 订单类型 0-单式上传，1-复式，2-胆拖，3-多方案 */
	BigDecimal lotsType;

	BigDecimal nodeduct = BigDecimal.ZERO;

	String agencyno;

	BigDecimal endsms;

	BigDecimal cancancel;
	/** 赠送寄语 */
	String Blessing;
	/** 赠送彩票接受人手机号 */
	String reciverMobile;
	
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getBatchcode() {
		return batchcode;
	}
	public void setBatchcode(String batchcode) {
		this.batchcode = batchcode;
	}
	public String getLotno() {
		return lotno;
	}
	public void setLotno(String lotno) {
		this.lotno = lotno;
	}
	public BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	public BigDecimal getBettype() {
		return bettype;
	}
	public void setBettype(BigDecimal bettype) {
		this.bettype = bettype;
	}
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	public BigDecimal getLotmulti() {
		return lotmulti;
	}
	public void setLotmulti(BigDecimal lotmulti) {
		this.lotmulti = lotmulti;
	}
	public String getBuyuserno() {
		return buyuserno;
	}
	public void setBuyuserno(String buyuserno) {
		this.buyuserno = buyuserno;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getSubchannel() {
		return subchannel;
	}
	public void setSubchannel(String subchannel) {
		this.subchannel = subchannel;
	}
	public SubaccountType getSubaccount() {
		return subaccount;
	}
	public void setSubaccount(SubaccountType subaccount) {
		this.subaccount = subaccount;
	}
	public BigDecimal getPaytype() {
		return paytype;
	}
	public void setPaytype(BigDecimal paytype) {
		this.paytype = paytype;
	}
	public BigDecimal getOneamount() {
		return oneamount;
	}
	public void setOneamount(BigDecimal oneamount) {
		this.oneamount = oneamount;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<BetRequest> getBetRequests() {
		return betRequests;
	}
	public void setBetRequests(List<BetRequest> betRequests) {
		this.betRequests = betRequests;
	}
	public BigDecimal getPrizeend() {
		return prizeend;
	}
	public void setPrizeend(BigDecimal prizeend) {
		this.prizeend = prizeend;
	}
	public BigDecimal getPrizeendamt() {
		return prizeendamt;
	}
	public void setPrizeendamt(BigDecimal prizeendamt) {
		this.prizeendamt = prizeendamt;
	}
	public BigDecimal getLeijiprizeendamt() {
		return leijiprizeendamt;
	}
	public void setLeijiprizeendamt(BigDecimal leijiprizeendamt) {
		this.leijiprizeendamt = leijiprizeendamt;
	}
	public BigDecimal getAccountnomoneysms() {
		return accountnomoneysms;
	}
	public void setAccountnomoneysms(BigDecimal accountnomoneysms) {
		this.accountnomoneysms = accountnomoneysms;
	}
	public List<SubscribeRequest> getSubscribeRequests() {
		return subscribeRequests;
	}
	public void setSubscribeRequests(List<SubscribeRequest> subscribeRequests) {
		this.subscribeRequests = subscribeRequests;
	}
	public CaseLotRequest getCaseLotRequest() {
		return caseLotRequest;
	}
	public void setCaseLotRequest(CaseLotRequest caseLotRequest) {
		this.caseLotRequest = caseLotRequest;
	}
	public BigDecimal getDrawway() {
		return drawway;
	}
	public void setDrawway(BigDecimal drawway) {
		this.drawway = drawway;
	}
	public BigDecimal getLotsType() {
		return lotsType;
	}
	public void setLotsType(BigDecimal lotsType) {
		this.lotsType = lotsType;
	}
	public BigDecimal getNodeduct() {
		return nodeduct;
	}
	public void setNodeduct(BigDecimal nodeduct) {
		this.nodeduct = nodeduct;
	}
	public String getAgencyno() {
		return agencyno;
	}
	public void setAgencyno(String agencyno) {
		this.agencyno = agencyno;
	}
	public BigDecimal getEndsms() {
		return endsms;
	}
	public void setEndsms(BigDecimal endsms) {
		this.endsms = endsms;
	}
	public BigDecimal getCancancel() {
		return cancancel;
	}
	public void setCancancel(BigDecimal cancancel) {
		this.cancancel = cancancel;
	}
	public String getBlessing() {
		return Blessing;
	}
	public void setBlessing(String blessing) {
		Blessing = blessing;
	}
	public String getReciverMobile() {
		return reciverMobile;
	}
	public void setReciverMobile(String reciverMobile) {
		this.reciverMobile = reciverMobile;
	}
	
	
}
