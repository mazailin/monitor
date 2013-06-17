package com.ruyicai.monitor.jms;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.ruyicai.monitor.domain.TorderBean;


public class Torder {

	private Integer flagvalue =0;
	private String id;

	private String batchcode;

	private String lotno;

	private BigDecimal amt;

	private BigDecimal paytype;

	private BigDecimal orderstate;

	private BigDecimal bettype;

	private BigDecimal prizestate;

	private BigDecimal orderprizeamt;
	
	private BigDecimal orderpreprizeamt;
	
	private BigDecimal hasachievement;

	private String winbasecode;

	private BigDecimal ordertype;

	private String tsubscribeflowno;

	private String tlotcaseid;

	private Date createtime;

	private String userno;

	private String buyuserno;

	private String memo;

	private String subaccount;

	private BigDecimal betnum;

	private Date canceltime;
	
	private Date endtime;
	
	private String desc;
	
	private String betcode;
	
	private BigDecimal alreadytrans;
	
	private BigDecimal lotmulti;
	
	private String prizeinfo;
	
	private String orderinfo;
	
	private String body;
	
	private BigDecimal instate;
	
	private BigDecimal paystate;
	
	/** 方案类型 */
	private BigDecimal lotsType;
	
	private Date encashtime;
	
	private String eventcode;
	
	private String agencyno;
	
	private String channel;
	
	private String subchannel;
	
	private String playtype;
	
	private String latedteamid;
	
	private transient BigDecimal orderamt;
	
	private transient Date modifytime;
	
	private transient BigDecimal orderprize;
	private java.util.Date  lastprinttime;
	
	
	public Integer getFlagvalue() {
		return flagvalue;
	}

	public void setFlagvalue(Integer flagvalue) {
		this.flagvalue = flagvalue;
	}

	public BigDecimal getOrderpreprizeamt() {
		return orderpreprizeamt;
	}

	public void setOrderpreprizeamt(BigDecimal orderpreprizeamt) {
		this.orderpreprizeamt = orderpreprizeamt;
	}

	public BigDecimal getHasachievement() {
		return hasachievement;
	}

	public void setHasachievement(BigDecimal hasachievement) {
		this.hasachievement = hasachievement;
	}

	public BigDecimal getOrderamt() {
		return orderamt;
	}

	public void setOrderamt(BigDecimal orderamt) {
		this.orderamt = orderamt;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	
	public BigDecimal getOrderprize() {
		return orderprize;
	}

	public void setOrderprize(BigDecimal orderprize) {
		this.orderprize = orderprize;
	}
	
	public BigDecimal getLotsType() {
		return lotsType;
	}

	public void setLotsType(BigDecimal lotsType) {
		this.lotsType = lotsType;
	}

	

	public BigDecimal getPaystate() {
		return paystate;
	}

	public void setPaystate(BigDecimal paystate) {
		this.paystate = paystate;
	}

	public String getPlaytype() {
		return playtype;
	}

	public void setPlaytype(String playtype) {
		this.playtype = playtype;
	}

	public BigDecimal getPrizestate() {
		return prizestate;
	}

	public void setPrizestate(BigDecimal prizestate) {
		this.prizestate = prizestate;
	}

	public String getLatedteamid() {
		return latedteamid;
	}

	public void setLatedteamid(String latedteamid) {
		this.latedteamid = latedteamid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public BigDecimal getPaytype() {
		return paytype;
	}

	public void setPaytype(BigDecimal paytype) {
		this.paytype = paytype;
	}

	public BigDecimal getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(BigDecimal orderstate) {
		this.orderstate = orderstate;
	}

	public BigDecimal getBettype() {
		return bettype;
	}

	public void setBettype(BigDecimal bettype) {
		this.bettype = bettype;
	}

	public BigDecimal getOrderprizeamt() {
		return orderprizeamt;
	}

	public void setOrderprizeamt(BigDecimal orderprizeamt) {
		this.orderprizeamt = orderprizeamt;
	}

	public String getWinbasecode() {
		return winbasecode;
	}

	public void setWinbasecode(String winbasecode) {
		this.winbasecode = winbasecode;
	}

	public BigDecimal getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(BigDecimal ordertype) {
		this.ordertype = ordertype;
	}

	public String getTsubscribeflowno() {
		return tsubscribeflowno;
	}

	public void setTsubscribeflowno(String tsubscribeflowno) {
		this.tsubscribeflowno = tsubscribeflowno;
	}

	public String getTlotcaseid() {
		return tlotcaseid;
	}

	public void setTlotcaseid(String tlotcaseid) {
		this.tlotcaseid = tlotcaseid;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getUserno() {
		return userno;
	}

	public void setUserno(String userno) {
		this.userno = userno;
	}

	public String getBuyuserno() {
		return buyuserno;
	}

	public void setBuyuserno(String buyuserno) {
		this.buyuserno = buyuserno;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getSubaccount() {
		return subaccount;
	}

	public void setSubaccount(String subaccount) {
		this.subaccount = subaccount;
	}

	public BigDecimal getBetnum() {
		return betnum;
	}

	public void setBetnum(BigDecimal betnum) {
		this.betnum = betnum;
	}

	public Date getCanceltime() {
		return canceltime;
	}

	public void setCanceltime(Date canceltime) {
		this.canceltime = canceltime;
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

	public String getBetcode() {
		return betcode;
	}

	public void setBetcode(String betcode) {
		this.betcode = betcode;
	}

	public BigDecimal getAlreadytrans() {
		return alreadytrans;
	}

	public void setAlreadytrans(BigDecimal alreadytrans) {
		this.alreadytrans = alreadytrans;
	}

	public BigDecimal getLotmulti() {
		return lotmulti;
	}

	public void setLotmulti(BigDecimal lotmulti) {
		this.lotmulti = lotmulti;
	}

	public String getPrizeinfo() {
		return prizeinfo;
	}

	public void setPrizeinfo(String prizeinfo) {
		this.prizeinfo = prizeinfo;
	}

	public String getOrderinfo() {
		return orderinfo;
	}

	public void setOrderinfo(String orderinfo) {
		this.orderinfo = orderinfo;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public BigDecimal getInstate() {
		return instate;
	}

	public void setInstate(BigDecimal instate) {
		this.instate = instate;
	}

	public Date getEncashtime() {
		return encashtime;
	}

	public void setEncashtime(Date encashtime) {
		this.encashtime = encashtime;
	}

	public String getEventcode() {
		return eventcode;
	}

	public void setEventcode(String eventcode) {
		this.eventcode = eventcode;
	}

	public String getAgencyno() {
		return agencyno;
	}

	public void setAgencyno(String agencyno) {
		this.agencyno = agencyno;
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

	public java.util.Date getLastprinttime() {
		return lastprinttime;
	}

	public void setLastprinttime(java.util.Date lastprinttime) {
		this.lastprinttime = lastprinttime;
	}
	/**
	 * you can use the following styles:
	 * <li>ToStringStyle.DEFAULT_STYLE</li>
	 * <li>ToStringStyle.MULTI_LINE_STYLE</li>
     * <li>ToStringStyle.NO_FIELD_NAMES_STYLE</li>
     * <li>ToStringStyle.SHORT_PREFIX_STYLE</li>
     * <li>ToStringStyle.SIMPLE_STYLE</li>
	 */
	public String toString(ToStringStyle style) {
		return new ToStringBuilder(this, style)
            .append("id", getId())
            .append("memo", getMemo())
            .append("batchcode", getBatchcode())
            .append("lotno", getLotno())
            .append("amt", getAmt())
            .append("paytype", getPaytype())
            .append("orderstate", getOrderstate())
            .append("bettype", getBettype())
            .append("prizestate", getPrizestate())
            .append("orderprizeamt", getOrderprizeamt())
            .append("winbasecode", getWinbasecode())
            .append("ordertype", getOrdertype())
            .append("tsubscribeflowno", getTsubscribeflowno())
            .append("tlotcaseid", getTlotcaseid())
            .append("createtime", getCreatetime())
            .append("userno", getUserno())
            .append("buyuserno", getBuyuserno())
            .append("subaccount", getSubaccount())
            .append("betnum", getBetnum())
            .append("canceltime", getCanceltime())
            .append("endtime", getEndtime())
            .append("betcode", getBetcode())
            .append("alreadytrans", getAlreadytrans())
            .append("lotstype", getLotsType())
            .append("lotmulti", getLotmulti())
            .append("prizeinfo", getPrizeinfo())
            .append("hasachievement", getHasachievement())
            .append("orderpreprizeamt", getOrderpreprizeamt())
            .append("orderinfo", getOrderinfo())
            .append("body", getBody())
            .append("instate", getInstate())
            .append("paystate", getPaystate())
            .append("encashtime", getEncashtime())
            .append("eventcode", getEventcode())
            .append("channel", getChannel())
            .append("SUBCHANNEL", getSubchannel())
            .append("agencyno", getAgencyno())
            .append("playtype", getPlaytype())
            .append("latedteamid", getLatedteamid())
            .append("lastprinttime", getLastprinttime())
            .toString();
	}
	/**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     */
    public void copy(TorderBean bean)
    {
    	bean.setFlagvalue(getFlagvalue());
    	bean.setId(getId());
    	bean.setMemo(getMemo());
    	bean.setBatchcode(getBatchcode());
    	bean.setLotno(getLotno());
    	bean.setAmt(getAmt()!=null?getAmt().toString():"");
    	bean.setPaytype(getPaytype()!=null?getPaytype().intValue():0);
    	bean.setOrderstate(getOrderstate()!=null?getOrderstate().intValue():0);
    	bean.setBettype(getBettype()!=null?getBettype().toString():"");
    	bean.setPrizestate(getPrizestate()!=null?getPrizestate().intValue():0);
    	bean.setOrderprizeamt(getOrderprizeamt()!=null?getOrderprizeamt().longValue():0l);
    	bean.setWinbasecode(getWinbasecode());
    	bean.setOrdertype(getOrdertype()!=null?getOrdertype().intValue():0);
    	bean.setTsubscribeflowno(getTsubscribeflowno());
    	bean. setTlotcaseid(getTlotcaseid());
    	bean.setCreatetime(getCreatetime());
    	bean.setUserno(getUserno());
    	bean.setBuyuserno(getBuyuserno());
    	bean.setSubaccount(getSubaccount());
    	bean.setBetnum(getBetnum()!=null?getBetnum().intValue():0);
    	bean.setCanceltime(getCanceltime());
    	bean.setEndtime(getEndtime());
//    	bean.setOdesc(getOdesc().);
    	bean.setBetcode(getBetcode());
    	bean.setAlreadytrans(getAlreadytrans()!=null?getAlreadytrans().intValue():0);
    	bean.setLotstype(getLotsType()!=null?getLotsType().intValue():0);
    	bean.setLotmulti(getLotmulti()!=null?getLotmulti().intValue():0);
    	bean.setPrizeinfo(getPrizeinfo());
    	bean.setHasachievement(getHasachievement()!=null?getHasachievement().intValue():0);
    	bean.setOrderpreprizeamt(getOrderpreprizeamt()!=null?getOrderpreprizeamt().longValue():0l);
    	bean.setOrderinfo(getOrderinfo());
    	bean.setBody(getBody());
    	bean.setInstate(getInstate().intValue());
    	bean.setPaystate(getPaystate().intValue());
    	bean.setEncashtime(getEncashtime());
    	bean.setEventcode(getEventcode());
    	bean.setChannel(getChannel());
    	bean.setSubchannel(getSubchannel());
    	bean.setAgencyno(getAgencyno());
    	bean.setPlaytype(getPlaytype());
    	bean.setLatedteamid(getLatedteamid());
    	bean.setLastprinttime(getLastprinttime());
    }
}
