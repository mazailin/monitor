
package com.ruyicai.monitor.domainshow;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ruyicai.monitor.jms.Torder;

/**
 * TorderBean is a mapping of torder Table.
 * @author tianshangjun
*/

public class TorderBeanShow
    implements Serializable
{
	private static final long serialVersionUID = 8622616739805063994L;
	 private Integer flagvalue =0;
   private int type;   

    private String id;   
    private Torder torder;
  
    private String memo;   

  
    private String batchcode  ;   

  
    private String lotno ;   

  
    private String amt ;   

  
    private Integer paytype =0; // 0.0;   

  
    private Integer orderstate =0; // 0.0;   

  
    private String bettype  ;   

  
    private Integer prizestate =0; // 0.0;   

  
    private Long orderprizeamt ; // 0.0;   

  
    private String winbasecode;   

  
    private Integer ordertype =0; // 0.0;   

  
    private String tsubscribeflowno;   

  
    private String tlotcaseid;   

  
    private java.util.Date createtime =null; // CURRENT_TIMESTAMP;   

  
    private String userno ;   

  
    private String buyuserno  ;   

  
    private String subaccount;   

  
    private Integer betnum =0; // 0.0;   

  
    private java.util.Date canceltime =null; // 0000-00-00 00:00:00;   

  
    private java.util.Date endtime =null; // 0000-00-00 00:00:00;   

  
    private String odesc;   

  
    private String betcode;   

  
    private Integer alreadytrans;   

  
    private Integer lotstype;   

  
    private Integer lotmulti;   

  
    private String prizeinfo;   

  
    private Integer hasachievement;   

  
    private Long orderpreprizeamt;   

  
    private String orderinfo;   

  
    private String body;   

  
    private Integer instate;   

  
    private Integer paystate;   

  
    private java.util.Date encashtime =null; // 0000-00-00 00:00:00;   

  
    private String eventcode;   

  
    private String channel;   

  
    private String subchannel;   

  
    private String agencyno;   

  
    private String playtype;   

  
    private String latedteamid;   


  	private java.util.Date  lastprinttime;
  

  
    public Integer getFlagvalue() {
		return flagvalue;
	}


	public void setFlagvalue(Integer flagvalue) {
		this.flagvalue = flagvalue;
	}

	public java.util.Date getLastprinttime() {
		return lastprinttime;
	}


	public void setLastprinttime(java.util.Date lastprinttime) {
		this.lastprinttime = lastprinttime;
	}


	public int getType() {
		return type;
	}


	public void setType(java.math.BigInteger  type) {
		this.type = type.intValue();
	}


	public String getId()
    {
        return this.id;
    }

  
    public void setId(String id)
    {

        this.id = id;
       
    }
  
    public String getMemo()
    {
        return this.memo;
    }

  
    public void setMemo(String memo)
    {

        this.memo = memo;
       
    }
  
    public String getBatchcode()
    {
        return this.batchcode;
    }

  
    public void setBatchcode(String batchcode)
    {

        this.batchcode = batchcode;
       
    }
  
    public String getLotno()
    {
        return this.lotno;
    }

  
    public void setLotno(String lotno)
    {

        this.lotno = lotno;
       
    }
  
    public String getAmt()
    {
        return this.amt;
    }

  
    public void setAmt(String amt)
    {

        this.amt = amt;
       
    }
  
    public Integer getPaytype()
    {
        return this.paytype;
    }

  
    public void setPaytype(Integer paytype)
    {

        this.paytype = paytype;
       
    }
  
    public Integer getOrderstate()
    {
        return this.orderstate;
    }

  
    public void setOrderstate(Integer orderstate)
    {

        this.orderstate = orderstate;
       
    }
  
    public String getBettype()
    {
        return this.bettype;
    }

  
    public void setBettype(String bettype)
    {

        this.bettype = bettype;
       
    }
  
    public Integer getPrizestate()
    {
        return this.prizestate;
    }

  
    public void setPrizestate(Integer prizestate)
    {

        this.prizestate = prizestate;
       
    }
  
    public Long getOrderprizeamt()
    {
        return this.orderprizeamt;
    }

  
    public void setOrderprizeamt(java.math.BigInteger orderprizeamt)
    {

        this.orderprizeamt = orderprizeamt.longValue();
       
    }
  
    public String getWinbasecode()
    {
        return this.winbasecode;
    }

  
    public void setWinbasecode(String winbasecode)
    {

        this.winbasecode = winbasecode;
       
    }
  
    public Integer getOrdertype()
    {
        return this.ordertype;
    }

  
    public void setOrdertype(Integer ordertype)
    {

        this.ordertype = ordertype;
       
    }
  
    public String getTsubscribeflowno()
    {
        return this.tsubscribeflowno;
    }

  
    public void setTsubscribeflowno(String tsubscribeflowno)
    {

        this.tsubscribeflowno = tsubscribeflowno;
       
    }
  
    public String getTlotcaseid()
    {
        return this.tlotcaseid;
    }

  
    public void setTlotcaseid(String tlotcaseid)
    {

        this.tlotcaseid = tlotcaseid;
       
    }
  
    public java.util.Date getCreatetime()
    {
        return this.createtime;
    }

  
    public void setCreatetime(java.util.Date createtime)
    {

        this.createtime = createtime;
       
    }
  
    public String getUserno()
    {
        return this.userno;
    }

  
    public void setUserno(String userno)
    {

        this.userno = userno;
       
    }
  
    public String getBuyuserno()
    {
        return this.buyuserno;
    }

  
    public void setBuyuserno(String buyuserno)
    {

        this.buyuserno = buyuserno;
       
    }
  
    public String getSubaccount()
    {
        return this.subaccount;
    }

  
    public void setSubaccount(String subaccount)
    {

        this.subaccount = subaccount;
       
    }
  
    public Integer getBetnum()
    {
        return this.betnum;
    }

  
    public void setBetnum(Integer betnum)
    {

        this.betnum = betnum;
       
    }
  
    public java.util.Date getCanceltime()
    {
        return this.canceltime;
    }

  
    public void setCanceltime(java.util.Date canceltime)
    {

        this.canceltime = canceltime;
       
    }
  
    public java.util.Date getEndtime()
    {
        return this.endtime;
    }

  
    public void setEndtime(java.util.Date endtime)
    {

        this.endtime = endtime;
       
    }
  
    public String getOdesc()
    {
        return this.odesc;
    }

  
    public void setOdesc(String odesc)
    {

        this.odesc = odesc;
       
    }
  
    public String getBetcode()
    {
        return this.betcode;
    }

  
    public void setBetcode(String betcode)
    {

        this.betcode = betcode;
       
    }
  
    public Integer getAlreadytrans()
    {
        return this.alreadytrans;
    }

  
    public void setAlreadytrans(Integer alreadytrans)
    {

        this.alreadytrans = alreadytrans;
       
    }
  
    public Integer getLotstype()
    {
        return this.lotstype;
    }

  
    public void setLotstype(Integer lotstype)
    {

        this.lotstype = lotstype;
       
    }
  
    public Integer getLotmulti()
    {
        return this.lotmulti;
    }

  
    public void setLotmulti(Integer lotmulti)
    {

        this.lotmulti = lotmulti;
       
    }
  
    public String getPrizeinfo()
    {
        return this.prizeinfo;
    }

  
    public void setPrizeinfo(String prizeinfo)
    {

        this.prizeinfo = prizeinfo;
       
    }
  
    public Integer getHasachievement()
    {
        return this.hasachievement;
    }

  
    public void setHasachievement(Integer hasachievement)
    {

        this.hasachievement = hasachievement;
       
    }
  
    public Long getOrderpreprizeamt()
    {
        return this.orderpreprizeamt;
    }

  
    public void setOrderpreprizeamt(java.math.BigInteger orderpreprizeamt)
    {
        this.orderpreprizeamt = orderpreprizeamt.longValue();
       
    }
  
    public String getOrderinfo()
    {
        return this.orderinfo;
    }

  
    public void setOrderinfo(String orderinfo)
    {

        this.orderinfo = orderinfo;
       
    }
  
    public String getBody()
    {
        return this.body;
    }

  
    public void setBody(String body)
    {

        this.body = body;
       
    }
  
    public Integer getInstate()
    {
        return this.instate;
    }

  
    public void setInstate(Integer instate)
    {

        this.instate = instate;
       
    }
  
    public Integer getPaystate()
    {
        return this.paystate;
    }

  
    public void setPaystate(Integer paystate)
    {

        this.paystate = paystate;
       
    }
  
    public java.util.Date getEncashtime()
    {
        return this.encashtime;
    }

  
    public void setEncashtime(java.util.Date encashtime)
    {

        this.encashtime = encashtime;
       
    }
  
    public String getEventcode()
    {
        return this.eventcode;
    }

  
    public void setEventcode(String eventcode)
    {

        this.eventcode = eventcode;
       
    }
  
    public String getChannel()
    {
        return this.channel;
    }

  
    public void setChannel(String channel)
    {

        this.channel = channel;
       
    }
  
    public String getSubchannel()
    {
        return this.subchannel;
    }

  
    public void setSubchannel(String subchannel)
    {

        this.subchannel = subchannel;
       
    }
  
    public String getAgencyno()
    {
        return this.agencyno;
    }

  
    public void setAgencyno(String agencyno)
    {

        this.agencyno = agencyno;
       
    }
  
    public String getPlaytype()
    {
        return this.playtype;
    }

  
    public void setPlaytype(String playtype)
    {

        this.playtype = playtype;
       
    }
  
    public String getLatedteamid()
    {
        return this.latedteamid;
    }

  
    public void setLatedteamid(String latedteamid)
    {

        this.latedteamid = latedteamid;
       
    }


	public Torder getTorder() {
		return torder;
	}


	public void setTorder(Torder torder) {
		this.torder = torder;
	}

}
