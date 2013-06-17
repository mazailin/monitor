
package com.ruyicai.monitor.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
/**
 * TorderBean is a mapping of torder Table.
 * @author tianshangjun
*/
@Entity
@Table(name = "torder")
public class TorderBean
    implements Serializable
{
	private static final long serialVersionUID = -6094625864831002002L;
	
   	@Id
   	@GeneratedValue(generator = "paymentableGenerator")
   	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
   	@Column(name = "id")
    private String id;  
   	
   	@Column(name = "flagvalue")
    private Integer flagvalue =0; // 0.0;   
   	
   	@Column(name = "memo")
    private String memo;   

   	@Column(name = "batchcode")
    private String batchcode  ;   

   	@Column(name = "lotno")
    private String lotno  ;   

   	@Column(name = "amt")
    private String amt ;   

   	@Column(name = "paytype")
    private Integer paytype =0; // 0.0;   

   	@Column(name = "orderstate")
    private Integer orderstate =0; // 0.0;   

   	@Column(name = "bettype")
    private String bettype  ;   

   	@Column(name = "prizestate")
    private Integer prizestate =0; // 0.0;   

   	@Column(name = "orderprizeamt")
    private Long orderprizeamt=0l ; // 0.0;   

   	@Column(name = "winbasecode")
    private String winbasecode;   

   	@Column(name = "ordertype")
    private Integer ordertype =0; // 0.0;   

   	@Column(name = "tsubscribeflowno")
    private String tsubscribeflowno;   

   	@Column(name = "tlotcaseid")
    private String tlotcaseid;   

   	@Column(name = "createtime")
    private java.util.Date createtime =null; // CURRENT_TIMESTAMP;   

   	@Column(name = "userno")
    private String userno ;   

   	@Column(name = "buyuserno")
    private String buyuserno;   

   	@Column(name = "subaccount")
    private String subaccount;   

   	@Column(name = "betnum")
    private Integer betnum =0; // 0.0;   

   	@Column(name = "canceltime")
    private java.util.Date canceltime =null; // 0000-00-00 00:00:00;   

   	@Column(name = "endtime")
    private java.util.Date endtime =null; // 0000-00-00 00:00:00;   

   	@Column(name = "odesc")
    private String odesc;   

   	@Column(name = "betcode")
    private String betcode;   

   	@Column(name = "alreadytrans")
    private Integer alreadytrans;   

   	@Column(name = "lotstype")
    private Integer lotstype;   

   	@Column(name = "lotmulti")
    private Integer lotmulti;   

   	@Column(name = "prizeinfo")
    private String prizeinfo;   

   	@Column(name = "hasachievement")
    private Integer hasachievement;   

   	@Column(name = "orderpreprizeamt")
    private Long orderpreprizeamt;   

   	@Column(name = "orderinfo")
    private String orderinfo;   

   	@Column(name = "body")
    private String body;   

   	@Column(name = "instate")
    private Integer instate;   

   	@Column(name = "paystate")
    private Integer paystate;   

   	@Column(name = "encashtime")
    private java.util.Date encashtime =null; // 0000-00-00 00:00:00;   

   	@Column(name = "eventcode")
    private String eventcode;   

   	@Column(name = "channel")
    private String channel;   

   	@Column(name = "SUBCHANNEL")
    private String subchannel;   

   	@Column(name = "agencyno")
    private String agencyno;   

   	@Column(name = "playtype")
    private String playtype;   

   	@Column(name = "latedteamid")
    private String latedteamid;   
   	
	@Column(name = "lastprinttime")
   	private java.util.Date  lastprinttime;
	
    public Integer getFlagvalue() {
		return flagvalue;
	}

	public void setFlagvalue(Integer flagvalue) {
		this.flagvalue = flagvalue;
	}

	/**
     * Prefered methods to create a TorderBean is via the createTorderBean method in TorderManager or
     * via the factory class TorderFactory create method
     */
    public TorderBean()
    {
    }

    /**
     * Getter method for id.
     * <br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.id</li>
     * <li>comments: 编号</li>
     * <li>column size: 32</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of id
     */
    public String getId()
    {
        return id;
    }

    /**
     * Setter method for id.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to id
     */
    public void setId(String id)
    {

        this.id = id;
       
    }
    /**
     * Getter method for memo.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.memo</li>
     * <li>comments: 描述</li>
     * <li>column size: 32</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of memo
     */
    public String getMemo()
    {
        return memo;
    }

    /**
     * Setter method for memo.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to memo
     */
    public void setMemo(String memo)
    {

        this.memo = memo;
       
    }
    /**
     * Getter method for batchcode.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.batchcode</li>
     * <li>comments: 期号</li>
     * <li>default value:  </li>
     * <li>column size: 15</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of batchcode
     */
    public String getBatchcode()
    {
        return batchcode;
    }

    /**
     * Setter method for batchcode.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to batchcode
     */
    public void setBatchcode(String batchcode)
    {

        this.batchcode = batchcode;
       
    }
    /**
     * Getter method for lotno.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.lotno</li>
     * <li>comments: 彩种编号</li>
     * <li>default value:  </li>
     * <li>column size: 6</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of lotno
     */
    public String getLotno()
    {
        return lotno;
    }

    /**
     * Setter method for lotno.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to lotno
     */
    public void setLotno(String lotno)
    {

        this.lotno = lotno;
       
    }
    /**
     * Getter method for amt.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.amt</li>
     * <li>comments: 订单金额，订单下所有票的票面金额之和</li>
     * <li>default value: 0</li>
     * <li>column size: 12</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of amt
     */
    public String getAmt()
    {
        return amt;
    }

    /**
     * Setter method for amt.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to amt
     */
    public void setAmt(String amt)
    {

        this.amt = amt;
       
    }
    /**
     * Getter method for paytype.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.paytype</li>
     * <li>comments: 订单付款状态（0-未付款、1-已付款）</li>
     * <li>default value: 0; // 0.0</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of paytype
     */
    public Integer getPaytype()
    {
        return paytype;
    }

    /**
     * Setter method for paytype.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to paytype
     */
    public void setPaytype(Integer paytype)
    {

        this.paytype = paytype;
       
    }
    /**
     * Getter method for orderstate.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.orderstate</li>
     * <li>comments: 订单状态（0-等待处理、1-已购买、2-空订单、3-处理失败）</li>
     * <li>default value: 0; // 0.0</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of orderstate
     */
    public Integer getOrderstate()
    {
        return orderstate;
    }

    /**
     * Setter method for orderstate.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to orderstate
     */
    public void setOrderstate(Integer orderstate)
    {

        this.orderstate = orderstate;
       
    }
    /**
     * Getter method for bettype.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.bettype</li>
     * <li>comments: 投注方式，前台传入什么，则设置成什么</li>
     * <li>default value:  </li>
     * <li>column size: 20</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of bettype
     */
    public String getBettype()
    {
        return bettype;
    }

    /**
     * Setter method for bettype.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to bettype
     */
    public void setBettype(String bettype)
    {

        this.bettype = bettype;
       
    }
    /**
     * Getter method for prizestate.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.prizestate</li>
     * <li>comments: 中奖状态（0-未开奖，1-等待开奖，2-开奖处理中，3-开奖处理完成，4-中得大奖）</li>
     * <li>default value: 0; // 0.0</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of prizestate
     */
    public Integer getPrizestate()
    {
        return prizestate;
    }

    /**
     * Setter method for prizestate.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to prizestate
     */
    public void setPrizestate(Integer prizestate)
    {

        this.prizestate = prizestate;
       
    }
    /**
     * Getter method for orderprizeamt.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.orderprizeamt</li>
     * <li>comments: 订单中奖金额（默认为0，已开奖状态为0时表明未中奖）</li>
     * <li>default value: 0; // 0.0</li>
     * <li>column size: 19</li>
     * <li>jdbc type returned by the driver: Types.BIGINT</li>
     * </ul>
     *
     * @return the value of orderprizeamt
     */
    public Long getOrderprizeamt()
    {
        return orderprizeamt;
    }

    /**
     * Setter method for orderprizeamt.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to orderprizeamt
     */
    public void setOrderprizeamt(Long orderprizeamt)
    {

        this.orderprizeamt = orderprizeamt;
       
    }
    /**
     * Getter method for winbasecode.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.winbasecode</li>
     * <li>comments: 开奖号码，包括普通号与特殊号</li>
     * <li>column size: 60</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of winbasecode
     */
    public String getWinbasecode()
    {
        return winbasecode;
    }

    /**
     * Setter method for winbasecode.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to winbasecode
     */
    public void setWinbasecode(String winbasecode)
    {

        this.winbasecode = winbasecode;
       
    }
    /**
     * Getter method for ordertype.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.ordertype</li>
     * <li>comments: 订单类型（0-普通投注订单，1-追号订单，2-合买订单）</li>
     * <li>default value: 0; // 0.0</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of ordertype
     */
    public Integer getOrdertype()
    {
        return ordertype;
    }

    /**
     * Setter method for ordertype.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to ordertype
     */
    public void setOrdertype(Integer ordertype)
    {

        this.ordertype = ordertype;
       
    }
    /**
     * Getter method for tsubscribeflowno.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.tsubscribeflowno</li>
     * <li>comments: 追号表的流水号，用于关联追号记录</li>
     * <li>column size: 16</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of tsubscribeflowno
     */
    public String getTsubscribeflowno()
    {
        return tsubscribeflowno;
    }

    /**
     * Setter method for tsubscribeflowno.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to tsubscribeflowno
     */
    public void setTsubscribeflowno(String tsubscribeflowno)
    {

        this.tsubscribeflowno = tsubscribeflowno;
       
    }
    /**
     * Getter method for tlotcaseid.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.tlotcaseid</li>
     * <li>comments: 合买表的流水号，用于关联合买记录</li>
     * <li>column size: 16</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of tlotcaseid
     */
    public String getTlotcaseid()
    {
        return tlotcaseid;
    }

    /**
     * Setter method for tlotcaseid.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to tlotcaseid
     */
    public void setTlotcaseid(String tlotcaseid)
    {

        this.tlotcaseid = tlotcaseid;
       
    }
    /**
     * Getter method for createtime.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.createtime</li>
     * <li>comments: 创建订单时间</li>
     * <li>default value: null; // CURRENT_TIMESTAMP</li>
     * <li>column size: 0</li>
     * <li>jdbc type returned by the driver: Types.TIMESTAMP</li>
     * </ul>
     *
     * @return the value of createtime
     */
    public java.util.Date getCreatetime()
    {
        return createtime;
    }

    /**
     * Setter method for createtime.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to createtime
     */
    public void setCreatetime(java.util.Date createtime)
    {

        this.createtime = createtime;
       
    }
    /**
     * Getter method for userno.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.userno</li>
     * <li>comments: 票所属用户的用户编号</li>
     * <li>default value:  </li>
     * <li>column size: 8</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of userno
     */
    public String getUserno()
    {
        return userno;
    }

    /**
     * Setter method for userno.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to userno
     */
    public void setUserno(String userno)
    {

        this.userno = userno;
       
    }
    /**
     * Getter method for buyuserno.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.buyuserno</li>
     * <li>comments: 购买者的用户编号，为空则表示USERNO就是购买者</li>
     * <li>default value:  </li>
     * <li>column size: 8</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of buyuserno
     */
    public String getBuyuserno()
    {
        return buyuserno;
    }

    /**
     * Setter method for buyuserno.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to buyuserno
     */
    public void setBuyuserno(String buyuserno)
    {

        this.buyuserno = buyuserno;
       
    }
    /**
     * Getter method for subaccount.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.subaccount</li>
     * <li>comments: subaccount</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of subaccount
     */
    public String getSubaccount()
    {
        return subaccount;
    }

    /**
     * Setter method for subaccount.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to subaccount
     */
    public void setSubaccount(String subaccount)
    {

        this.subaccount = subaccount;
       
    }
    /**
     * Getter method for betnum.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.betnum</li>
     * <li>comments: 订单总注数</li>
     * <li>default value: 0; // 0.0</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of betnum
     */
    public Integer getBetnum()
    {
        return betnum;
    }

    /**
     * Setter method for betnum.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to betnum
     */
    public void setBetnum(Integer betnum)
    {

        this.betnum = betnum;
       
    }
    /**
     * Getter method for canceltime.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.canceltime</li>
     * <li>comments: 取消时间</li>
     * <li>default value: null; // 0000-00-00 00:00:00</li>
     * <li>column size: 0</li>
     * <li>jdbc type returned by the driver: Types.TIMESTAMP</li>
     * </ul>
     *
     * @return the value of canceltime
     */
    public java.util.Date getCanceltime()
    {
        return canceltime;
    }

    /**
     * Setter method for canceltime.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to canceltime
     */
    public void setCanceltime(java.util.Date canceltime)
    {

        this.canceltime = canceltime;
       
    }
    /**
     * Getter method for endtime.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.endtime</li>
     * <li>comments: 结束时间</li>
     * <li>default value: null; // 0000-00-00 00:00:00</li>
     * <li>column size: 0</li>
     * <li>jdbc type returned by the driver: Types.TIMESTAMP</li>
     * </ul>
     *
     * @return the value of endtime
     */
    public java.util.Date getEndtime()
    {
        return endtime;
    }

    /**
     * Setter method for endtime.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to endtime
     */
    public void setEndtime(java.util.Date endtime)
    {

        this.endtime = endtime;
       
    }
    /**
     * Getter method for odesc.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.odesc</li>
     * <li>comments: odesc</li>
     * <li>column size: 150</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of odesc
     */
    public String getOdesc()
    {
        return odesc;
    }

    /**
     * Setter method for odesc.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to odesc
     */
    public void setOdesc(String odesc)
    {

        this.odesc = odesc;
       
    }
    /**
     * Getter method for betcode.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.betcode</li>
     * <li>comments: betcode</li>
     * <li>column size: 65535</li>
     * <li>jdbc type returned by the driver: Types.LONGVARCHAR</li>
     * </ul>
     *
     * @return the value of betcode
     */
    public String getBetcode()
    {
        return betcode;
    }

    /**
     * Setter method for betcode.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to betcode
     */
    public void setBetcode(String betcode)
    {

        this.betcode = betcode;
       
    }
    /**
     * Getter method for alreadytrans.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.alreadytrans</li>
     * <li>comments: alreadytrans</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of alreadytrans
     */
    public Integer getAlreadytrans()
    {
        return alreadytrans;
    }

    /**
     * Setter method for alreadytrans.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to alreadytrans
     */
    public void setAlreadytrans(Integer alreadytrans)
    {

        this.alreadytrans = alreadytrans;
       
    }
    /**
     * Getter method for lotstype.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.lotstype</li>
     * <li>comments: 订单类型 0-单式上传，1-复式，2-胆拖，3-多方案</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of lotstype
     */
    public Integer getLotstype()
    {
        return lotstype;
    }

    /**
     * Setter method for lotstype.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to lotstype
     */
    public void setLotstype(Integer lotstype)
    {

        this.lotstype = lotstype;
       
    }
    /**
     * Getter method for lotmulti.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.lotmulti</li>
     * <li>comments: lotmulti</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of lotmulti
     */
    public Integer getLotmulti()
    {
        return lotmulti;
    }

    /**
     * Setter method for lotmulti.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to lotmulti
     */
    public void setLotmulti(Integer lotmulti)
    {

        this.lotmulti = lotmulti;
       
    }
    /**
     * Getter method for prizeinfo.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.prizeinfo</li>
     * <li>comments: prizeinfo</li>
     * <li>column size: 200</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of prizeinfo
     */
    public String getPrizeinfo()
    {
        return prizeinfo;
    }

    /**
     * Setter method for prizeinfo.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to prizeinfo
     */
    public void setPrizeinfo(String prizeinfo)
    {

        this.prizeinfo = prizeinfo;
       
    }
    /**
     * Getter method for hasachievement.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.hasachievement</li>
     * <li>comments: 是否有战绩	0：没有，1：有</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of hasachievement
     */
    public Integer getHasachievement()
    {
        return hasachievement;
    }

    /**
     * Setter method for hasachievement.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to hasachievement
     */
    public void setHasachievement(Integer hasachievement)
    {

        this.hasachievement = hasachievement;
       
    }
    /**
     * Getter method for orderpreprizeamt.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.orderpreprizeamt</li>
     * <li>comments: 税前奖金</li>
     * <li>column size: 19</li>
     * <li>jdbc type returned by the driver: Types.BIGINT</li>
     * </ul>
     *
     * @return the value of orderpreprizeamt
     */
    public Long getOrderpreprizeamt()
    {
        return orderpreprizeamt;
    }

    /**
     * Setter method for orderpreprizeamt.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to orderpreprizeamt
     */
    public void setOrderpreprizeamt(Long orderpreprizeamt)
    {

        this.orderpreprizeamt = orderpreprizeamt;
       
    }
    /**
     * Getter method for orderinfo.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.orderinfo</li>
     * <li>comments: orderinfo</li>
     * <li>column size: 65535</li>
     * <li>jdbc type returned by the driver: Types.LONGVARCHAR</li>
     * </ul>
     *
     * @return the value of orderinfo
     */
    public String getOrderinfo()
    {
        return orderinfo;
    }

    /**
     * Setter method for orderinfo.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to orderinfo
     */
    public void setOrderinfo(String orderinfo)
    {

        this.orderinfo = orderinfo;
       
    }
    /**
     * Getter method for body.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.body</li>
     * <li>comments: body</li>
     * <li>column size: 65535</li>
     * <li>jdbc type returned by the driver: Types.LONGVARCHAR</li>
     * </ul>
     *
     * @return the value of body
     */
    public String getBody()
    {
        return body;
    }

    /**
     * Setter method for body.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to body
     */
    public void setBody(String body)
    {

        this.body = body;
       
    }
    /**
     * Getter method for instate.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.instate</li>
     * <li>comments: instate</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of instate
     */
    public Integer getInstate()
    {
        return instate;
    }

    /**
     * Setter method for instate.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to instate
     */
    public void setInstate(Integer instate)
    {

        this.instate = instate;
       
    }
    /**
     * Getter method for paystate.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.paystate</li>
     * <li>comments: paystate</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of paystate
     */
    public Integer getPaystate()
    {
        return paystate;
    }

    /**
     * Setter method for paystate.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to paystate
     */
    public void setPaystate(Integer paystate)
    {

        this.paystate = paystate;
       
    }
    /**
     * Getter method for encashtime.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.encashtime</li>
     * <li>comments: encashtime</li>
     * <li>default value: null; // 0000-00-00 00:00:00</li>
     * <li>column size: 0</li>
     * <li>jdbc type returned by the driver: Types.TIMESTAMP</li>
     * </ul>
     *
     * @return the value of encashtime
     */
    public java.util.Date getEncashtime()
    {
        return encashtime;
    }

    /**
     * Setter method for encashtime.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to encashtime
     */
    public void setEncashtime(java.util.Date encashtime)
    {

        this.encashtime = encashtime;
       
    }
    /**
     * Getter method for eventcode.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.eventcode</li>
     * <li>comments: eventcode</li>
     * <li>column size: 50</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of eventcode
     */
    public String getEventcode()
    {
        return eventcode;
    }

    /**
     * Setter method for eventcode.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to eventcode
     */
    public void setEventcode(String eventcode)
    {

        this.eventcode = eventcode;
       
    }
    /**
     * Getter method for channel.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.channel</li>
     * <li>comments: channel</li>
     * <li>column size: 11</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of channel
     */
    public String getChannel()
    {
        return channel;
    }

    /**
     * Setter method for channel.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to channel
     */
    public void setChannel(String channel)
    {

        this.channel = channel;
       
    }
    /**
     * Getter method for subchannel.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.SUBCHANNEL</li>
     * <li>comments: SUBCHANNEL</li>
     * <li>column size: 8</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of subchannel
     */
    public String getSubchannel()
    {
        return subchannel;
    }

    /**
     * Setter method for subchannel.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to subchannel
     */
    public void setSubchannel(String subchannel)
    {

        this.subchannel = subchannel;
       
    }
    /**
     * Getter method for agencyno.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.agencyno</li>
     * <li>comments: agencyno</li>
     * <li>column size: 50</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of agencyno
     */
    public String getAgencyno()
    {
        return agencyno;
    }

    /**
     * Setter method for agencyno.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to agencyno
     */
    public void setAgencyno(String agencyno)
    {

        this.agencyno = agencyno;
       
    }
    /**
     * Getter method for playtype.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.playtype</li>
     * <li>comments: playtype</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of playtype
     */
    public String getPlaytype()
    {
        return playtype;
    }

    /**
     * Setter method for playtype.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to playtype
     */
    public void setPlaytype(String playtype)
    {

        this.playtype = playtype;
       
    }
    /**
     * Getter method for latedteamid.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: torder.latedteamid</li>
     * <li>comments: latedteamid</li>
     * <li>column size: 20</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of latedteamid
     */
    public String getLatedteamid()
    {
        return latedteamid;
    }

    /**
     * Setter method for latedteamid.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param  the new value to be assigned to latedteamid
     */
    public void setLatedteamid(String latedteamid)
    {

        this.latedteamid = latedteamid;
       
    }
 

    public java.util.Date getLastprinttime() {
		return lastprinttime;
	}

	public void setLastprinttime(java.util.Date lastprinttime) {
		this.lastprinttime = lastprinttime;
	}

	/**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     */
    public void copy(TorderBean bean)
    {
        setId(bean.getId());
        setMemo(bean.getMemo());
        setBatchcode(bean.getBatchcode());
        setLotno(bean.getLotno());
        setAmt(bean.getAmt());
        setPaytype(bean.getPaytype());
        setOrderstate(bean.getOrderstate());
        setBettype(bean.getBettype());
        setPrizestate(bean.getPrizestate());
        setOrderprizeamt(bean.getOrderprizeamt());
        setWinbasecode(bean.getWinbasecode());
        setOrdertype(bean.getOrdertype());
        setTsubscribeflowno(bean.getTsubscribeflowno());
        setTlotcaseid(bean.getTlotcaseid());
        setCreatetime(bean.getCreatetime());
        setUserno(bean.getUserno());
        setBuyuserno(bean.getBuyuserno());
        setSubaccount(bean.getSubaccount());
        setBetnum(bean.getBetnum());
        setCanceltime(bean.getCanceltime());
        setEndtime(bean.getEndtime());
        setOdesc(bean.getOdesc());
        setBetcode(bean.getBetcode());
        setAlreadytrans(bean.getAlreadytrans());
        setLotstype(bean.getLotstype());
        setLotmulti(bean.getLotmulti());
        setPrizeinfo(bean.getPrizeinfo());
        setHasachievement(bean.getHasachievement());
        setOrderpreprizeamt(bean.getOrderpreprizeamt());
        setOrderinfo(bean.getOrderinfo());
        setBody(bean.getBody());
        setInstate(bean.getInstate());
        setPaystate(bean.getPaystate());
        setEncashtime(bean.getEncashtime());
        setEventcode(bean.getEventcode());
        setChannel(bean.getChannel());
        setSubchannel(bean.getSubchannel());
        setAgencyno(bean.getAgencyno());
        setPlaytype(bean.getPlaytype());
        setLatedteamid(bean.getLatedteamid());
    }

    /**
     * return a dictionnary of the object
     */
	@JsonIgnore 
    public Map<String,String> getDictionnary()
    {
        Map<String,String> dictionnary = new HashMap<String,String>();
        dictionnary.put("id", getId() == null ? "" : getId().toString());
        dictionnary.put("memo", getMemo() == null ? "" : getMemo().toString());
        dictionnary.put("batchcode", getBatchcode() == null ? "" : getBatchcode().toString());
        dictionnary.put("lotno", getLotno() == null ? "" : getLotno().toString());
        dictionnary.put("amt", getAmt() == null ? "" : getAmt().toString());
        dictionnary.put("paytype", getPaytype() == null ? "" : getPaytype().toString());
        dictionnary.put("orderstate", getOrderstate() == null ? "" : getOrderstate().toString());
        dictionnary.put("bettype", getBettype() == null ? "" : getBettype().toString());
        dictionnary.put("prizestate", getPrizestate() == null ? "" : getPrizestate().toString());
        dictionnary.put("orderprizeamt", getOrderprizeamt() == null ? "" : getOrderprizeamt().toString());
        dictionnary.put("winbasecode", getWinbasecode() == null ? "" : getWinbasecode().toString());
        dictionnary.put("ordertype", getOrdertype() == null ? "" : getOrdertype().toString());
        dictionnary.put("tsubscribeflowno", getTsubscribeflowno() == null ? "" : getTsubscribeflowno().toString());
        dictionnary.put("tlotcaseid", getTlotcaseid() == null ? "" : getTlotcaseid().toString());
        dictionnary.put("createtime", getCreatetime() == null ? "" : getCreatetime().toString());
        dictionnary.put("userno", getUserno() == null ? "" : getUserno().toString());
        dictionnary.put("buyuserno", getBuyuserno() == null ? "" : getBuyuserno().toString());
        dictionnary.put("subaccount", getSubaccount() == null ? "" : getSubaccount().toString());
        dictionnary.put("betnum", getBetnum() == null ? "" : getBetnum().toString());
        dictionnary.put("canceltime", getCanceltime() == null ? "" : getCanceltime().toString());
        dictionnary.put("endtime", getEndtime() == null ? "" : getEndtime().toString());
        dictionnary.put("odesc", getOdesc() == null ? "" : getOdesc().toString());
        dictionnary.put("betcode", getBetcode() == null ? "" : getBetcode().toString());
        dictionnary.put("alreadytrans", getAlreadytrans() == null ? "" : getAlreadytrans().toString());
        dictionnary.put("lotstype", getLotstype() == null ? "" : getLotstype().toString());
        dictionnary.put("lotmulti", getLotmulti() == null ? "" : getLotmulti().toString());
        dictionnary.put("prizeinfo", getPrizeinfo() == null ? "" : getPrizeinfo().toString());
        dictionnary.put("hasachievement", getHasachievement() == null ? "" : getHasachievement().toString());
        dictionnary.put("orderpreprizeamt", getOrderpreprizeamt() == null ? "" : getOrderpreprizeamt().toString());
        dictionnary.put("orderinfo", getOrderinfo() == null ? "" : getOrderinfo().toString());
        dictionnary.put("body", getBody() == null ? "" : getBody().toString());
        dictionnary.put("instate", getInstate() == null ? "" : getInstate().toString());
        dictionnary.put("paystate", getPaystate() == null ? "" : getPaystate().toString());
        dictionnary.put("encashtime", getEncashtime() == null ? "" : getEncashtime().toString());
        dictionnary.put("eventcode", getEventcode() == null ? "" : getEventcode().toString());
        dictionnary.put("channel", getChannel() == null ? "" : getChannel().toString());
        dictionnary.put("subchannel", getSubchannel() == null ? "" : getSubchannel().toString());
        dictionnary.put("agencyno", getAgencyno() == null ? "" : getAgencyno().toString());
        dictionnary.put("playtype", getPlaytype() == null ? "" : getPlaytype().toString());
        dictionnary.put("latedteamid", getLatedteamid() == null ? "" : getLatedteamid().toString());
        return dictionnary;
    }

    /**
     * return a dictionnary of the pk columns
     */
	@JsonIgnore 
    public Map<String,String> getPkDictionnary()
    {
        Map<String,String> dictionnary = new HashMap<String,String>();
        dictionnary.put("id", getId() == null ? "" : getId().toString());
        return dictionnary;
    }

    /**
     * return a the value string representation of the given field
     */
    public String getValue(String column)
    {
        if (null == column || "".equals(column)) {
            return "";
        } else if ("id".equalsIgnoreCase(column) || "id".equalsIgnoreCase(column)) {
            return getId() == null ? "" : getId().toString();
        } else if ("memo".equalsIgnoreCase(column) || "memo".equalsIgnoreCase(column)) {
            return getMemo() == null ? "" : getMemo().toString();
        } else if ("batchcode".equalsIgnoreCase(column) || "batchcode".equalsIgnoreCase(column)) {
            return getBatchcode() == null ? "" : getBatchcode().toString();
        } else if ("lotno".equalsIgnoreCase(column) || "lotno".equalsIgnoreCase(column)) {
            return getLotno() == null ? "" : getLotno().toString();
        } else if ("amt".equalsIgnoreCase(column) || "amt".equalsIgnoreCase(column)) {
            return getAmt() == null ? "" : getAmt().toString();
        } else if ("paytype".equalsIgnoreCase(column) || "paytype".equalsIgnoreCase(column)) {
            return getPaytype() == null ? "" : getPaytype().toString();
        } else if ("orderstate".equalsIgnoreCase(column) || "orderstate".equalsIgnoreCase(column)) {
            return getOrderstate() == null ? "" : getOrderstate().toString();
        } else if ("bettype".equalsIgnoreCase(column) || "bettype".equalsIgnoreCase(column)) {
            return getBettype() == null ? "" : getBettype().toString();
        } else if ("prizestate".equalsIgnoreCase(column) || "prizestate".equalsIgnoreCase(column)) {
            return getPrizestate() == null ? "" : getPrizestate().toString();
        } else if ("orderprizeamt".equalsIgnoreCase(column) || "orderprizeamt".equalsIgnoreCase(column)) {
            return getOrderprizeamt() == null ? "" : getOrderprizeamt().toString();
        } else if ("winbasecode".equalsIgnoreCase(column) || "winbasecode".equalsIgnoreCase(column)) {
            return getWinbasecode() == null ? "" : getWinbasecode().toString();
        } else if ("ordertype".equalsIgnoreCase(column) || "ordertype".equalsIgnoreCase(column)) {
            return getOrdertype() == null ? "" : getOrdertype().toString();
        } else if ("tsubscribeflowno".equalsIgnoreCase(column) || "tsubscribeflowno".equalsIgnoreCase(column)) {
            return getTsubscribeflowno() == null ? "" : getTsubscribeflowno().toString();
        } else if ("tlotcaseid".equalsIgnoreCase(column) || "tlotcaseid".equalsIgnoreCase(column)) {
            return getTlotcaseid() == null ? "" : getTlotcaseid().toString();
        } else if ("createtime".equalsIgnoreCase(column) || "createtime".equalsIgnoreCase(column)) {
            return getCreatetime() == null ? "" : getCreatetime().toString();
        } else if ("userno".equalsIgnoreCase(column) || "userno".equalsIgnoreCase(column)) {
            return getUserno() == null ? "" : getUserno().toString();
        } else if ("buyuserno".equalsIgnoreCase(column) || "buyuserno".equalsIgnoreCase(column)) {
            return getBuyuserno() == null ? "" : getBuyuserno().toString();
        } else if ("subaccount".equalsIgnoreCase(column) || "subaccount".equalsIgnoreCase(column)) {
            return getSubaccount() == null ? "" : getSubaccount().toString();
        } else if ("betnum".equalsIgnoreCase(column) || "betnum".equalsIgnoreCase(column)) {
            return getBetnum() == null ? "" : getBetnum().toString();
        } else if ("canceltime".equalsIgnoreCase(column) || "canceltime".equalsIgnoreCase(column)) {
            return getCanceltime() == null ? "" : getCanceltime().toString();
        } else if ("endtime".equalsIgnoreCase(column) || "endtime".equalsIgnoreCase(column)) {
            return getEndtime() == null ? "" : getEndtime().toString();
        } else if ("odesc".equalsIgnoreCase(column) || "odesc".equalsIgnoreCase(column)) {
            return getOdesc() == null ? "" : getOdesc().toString();
        } else if ("betcode".equalsIgnoreCase(column) || "betcode".equalsIgnoreCase(column)) {
            return getBetcode() == null ? "" : getBetcode().toString();
        } else if ("alreadytrans".equalsIgnoreCase(column) || "alreadytrans".equalsIgnoreCase(column)) {
            return getAlreadytrans() == null ? "" : getAlreadytrans().toString();
        } else if ("lotstype".equalsIgnoreCase(column) || "lotstype".equalsIgnoreCase(column)) {
            return getLotstype() == null ? "" : getLotstype().toString();
        } else if ("lotmulti".equalsIgnoreCase(column) || "lotmulti".equalsIgnoreCase(column)) {
            return getLotmulti() == null ? "" : getLotmulti().toString();
        } else if ("prizeinfo".equalsIgnoreCase(column) || "prizeinfo".equalsIgnoreCase(column)) {
            return getPrizeinfo() == null ? "" : getPrizeinfo().toString();
        } else if ("hasachievement".equalsIgnoreCase(column) || "hasachievement".equalsIgnoreCase(column)) {
            return getHasachievement() == null ? "" : getHasachievement().toString();
        } else if ("orderpreprizeamt".equalsIgnoreCase(column) || "orderpreprizeamt".equalsIgnoreCase(column)) {
            return getOrderpreprizeamt() == null ? "" : getOrderpreprizeamt().toString();
        } else if ("orderinfo".equalsIgnoreCase(column) || "orderinfo".equalsIgnoreCase(column)) {
            return getOrderinfo() == null ? "" : getOrderinfo().toString();
        } else if ("body".equalsIgnoreCase(column) || "body".equalsIgnoreCase(column)) {
            return getBody() == null ? "" : getBody().toString();
        } else if ("instate".equalsIgnoreCase(column) || "instate".equalsIgnoreCase(column)) {
            return getInstate() == null ? "" : getInstate().toString();
        } else if ("paystate".equalsIgnoreCase(column) || "paystate".equalsIgnoreCase(column)) {
            return getPaystate() == null ? "" : getPaystate().toString();
        } else if ("encashtime".equalsIgnoreCase(column) || "encashtime".equalsIgnoreCase(column)) {
            return getEncashtime() == null ? "" : getEncashtime().toString();
        } else if ("eventcode".equalsIgnoreCase(column) || "eventcode".equalsIgnoreCase(column)) {
            return getEventcode() == null ? "" : getEventcode().toString();
        } else if ("channel".equalsIgnoreCase(column) || "channel".equalsIgnoreCase(column)) {
            return getChannel() == null ? "" : getChannel().toString();
        } else if ("SUBCHANNEL".equalsIgnoreCase(column) || "subchannel".equalsIgnoreCase(column)) {
            return getSubchannel() == null ? "" : getSubchannel().toString();
        } else if ("agencyno".equalsIgnoreCase(column) || "agencyno".equalsIgnoreCase(column)) {
            return getAgencyno() == null ? "" : getAgencyno().toString();
        } else if ("playtype".equalsIgnoreCase(column) || "playtype".equalsIgnoreCase(column)) {
            return getPlaytype() == null ? "" : getPlaytype().toString();
        } else if ("latedteamid".equalsIgnoreCase(column) || "latedteamid".equalsIgnoreCase(column)) {
            return getLatedteamid() == null ? "" : getLatedteamid().toString();
        }
        return "";
    }

    /**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof TorderBean)) {
			return false;
		}

		TorderBean obj = (TorderBean) object;
		return new EqualsBuilder()
            .append(getId(), obj.getId())
            .append(getMemo(), obj.getMemo())
            .append(getBatchcode(), obj.getBatchcode())
            .append(getLotno(), obj.getLotno())
            .append(getAmt(), obj.getAmt())
            .append(getPaytype(), obj.getPaytype())
            .append(getOrderstate(), obj.getOrderstate())
            .append(getBettype(), obj.getBettype())
            .append(getPrizestate(), obj.getPrizestate())
            .append(getOrderprizeamt(), obj.getOrderprizeamt())
            .append(getWinbasecode(), obj.getWinbasecode())
            .append(getOrdertype(), obj.getOrdertype())
            .append(getTsubscribeflowno(), obj.getTsubscribeflowno())
            .append(getTlotcaseid(), obj.getTlotcaseid())
            .append(getCreatetime(), obj.getCreatetime())
            .append(getUserno(), obj.getUserno())
            .append(getBuyuserno(), obj.getBuyuserno())
            .append(getSubaccount(), obj.getSubaccount())
            .append(getBetnum(), obj.getBetnum())
            .append(getCanceltime(), obj.getCanceltime())
            .append(getEndtime(), obj.getEndtime())
            .append(getOdesc(), obj.getOdesc())
            .append(getBetcode(), obj.getBetcode())
            .append(getAlreadytrans(), obj.getAlreadytrans())
            .append(getLotstype(), obj.getLotstype())
            .append(getLotmulti(), obj.getLotmulti())
            .append(getPrizeinfo(), obj.getPrizeinfo())
            .append(getHasachievement(), obj.getHasachievement())
            .append(getOrderpreprizeamt(), obj.getOrderpreprizeamt())
            .append(getOrderinfo(), obj.getOrderinfo())
            .append(getBody(), obj.getBody())
            .append(getInstate(), obj.getInstate())
            .append(getPaystate(), obj.getPaystate())
            .append(getEncashtime(), obj.getEncashtime())
            .append(getEventcode(), obj.getEventcode())
            .append(getChannel(), obj.getChannel())
            .append(getSubchannel(), obj.getSubchannel())
            .append(getAgencyno(), obj.getAgencyno())
            .append(getPlaytype(), obj.getPlaytype())
            .append(getLatedteamid(), obj.getLatedteamid())
            .isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
            .append(getId())
            .append(getMemo())
            .append(getBatchcode())
            .append(getLotno())
            .append(getAmt())
            .append(getPaytype())
            .append(getOrderstate())
            .append(getBettype())
            .append(getPrizestate())
            .append(getOrderprizeamt())
            .append(getWinbasecode())
            .append(getOrdertype())
            .append(getTsubscribeflowno())
            .append(getTlotcaseid())
            .append(getCreatetime())
            .append(getUserno())
            .append(getBuyuserno())
            .append(getSubaccount())
            .append(getBetnum())
            .append(getCanceltime())
            .append(getEndtime())
            .append(getOdesc())
            .append(getBetcode())
            .append(getAlreadytrans())
            .append(getLotstype())
            .append(getLotmulti())
            .append(getPrizeinfo())
            .append(getHasachievement())
            .append(getOrderpreprizeamt())
            .append(getOrderinfo())
            .append(getBody())
            .append(getInstate())
            .append(getPaystate())
            .append(getEncashtime())
            .append(getEventcode())
            .append(getChannel())
            .append(getSubchannel())
            .append(getAgencyno())
            .append(getPlaytype())
            .append(getLatedteamid())
            .toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
	    return toString(ToStringStyle.MULTI_LINE_STYLE);
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
            .append("odesc", getOdesc())
            .append("betcode", getBetcode())
            .append("alreadytrans", getAlreadytrans())
            .append("lotstype", getLotstype())
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
            .toString();
	}


    public int compareTo(Object object)
    {
        TorderBean obj = (TorderBean) object;
        return new CompareToBuilder()
            .append(getId(), obj.getId())
            .append(getMemo(), obj.getMemo())
            .append(getBatchcode(), obj.getBatchcode())
            .append(getLotno(), obj.getLotno())
            .append(getAmt(), obj.getAmt())
            .append(getPaytype(), obj.getPaytype())
            .append(getOrderstate(), obj.getOrderstate())
            .append(getBettype(), obj.getBettype())
            .append(getPrizestate(), obj.getPrizestate())
            .append(getOrderprizeamt(), obj.getOrderprizeamt())
            .append(getWinbasecode(), obj.getWinbasecode())
            .append(getOrdertype(), obj.getOrdertype())
            .append(getTsubscribeflowno(), obj.getTsubscribeflowno())
            .append(getTlotcaseid(), obj.getTlotcaseid())
            .append(getCreatetime(), obj.getCreatetime())
            .append(getUserno(), obj.getUserno())
            .append(getBuyuserno(), obj.getBuyuserno())
            .append(getSubaccount(), obj.getSubaccount())
            .append(getBetnum(), obj.getBetnum())
            .append(getCanceltime(), obj.getCanceltime())
            .append(getEndtime(), obj.getEndtime())
            .append(getOdesc(), obj.getOdesc())
            .append(getBetcode(), obj.getBetcode())
            .append(getAlreadytrans(), obj.getAlreadytrans())
            .append(getLotstype(), obj.getLotstype())
            .append(getLotmulti(), obj.getLotmulti())
            .append(getPrizeinfo(), obj.getPrizeinfo())
            .append(getHasachievement(), obj.getHasachievement())
            .append(getOrderpreprizeamt(), obj.getOrderpreprizeamt())
            .append(getOrderinfo(), obj.getOrderinfo())
            .append(getBody(), obj.getBody())
            .append(getInstate(), obj.getInstate())
            .append(getPaystate(), obj.getPaystate())
            .append(getEncashtime(), obj.getEncashtime())
            .append(getEventcode(), obj.getEventcode())
            .append(getChannel(), obj.getChannel())
            .append(getSubchannel(), obj.getSubchannel())
            .append(getAgencyno(), obj.getAgencyno())
            .append(getPlaytype(), obj.getPlaytype())
            .append(getLatedteamid(), obj.getLatedteamid())
            .toComparison();
   }
}
