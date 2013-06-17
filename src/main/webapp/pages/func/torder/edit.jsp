
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/include.inc.jsp"%> 
 <div class="pageContent">
<form method="post" action="<%=cxt %>/torder/update?navTabId=torderLiNav" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<input type="hidden" name="id" value="${vo.id}"/>
	<div class="pageFormContent" layoutH="56">
	 	         	 	        <p>
			<label>描述：</label>
			<input type="text" name="memo" value="${vo.memo}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>期号：</label>
			<input type="text" name="batchcode" value="${vo.batchcode}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>彩种编号：</label>
			<input type="text" name="lotno" value="${vo.lotno}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>订单金额，订单下所有票的票面金额之和：</label>
			<input type="text" name="amt" value="${vo.amt}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>订单付款状态（0-未付款、1-已付款）：</label>
			<input type="text" name="paytype" value="${vo.paytype}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>订单状态（0-等待处理、1-已购买、2-空订单、3-处理失败）：</label>
			<input type="text" name="orderstate" value="${vo.orderstate}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>投注方式，前台传入什么，则设置成什么：</label>
			<input type="text" name="bettype" value="${vo.bettype}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>中奖状态（0-未开奖，1-等待开奖，2-开奖处理中，3-开奖处理完成，4-中得大奖）：</label>
			<input type="text" name="prizestate" value="${vo.prizestate}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>订单中奖金额（默认为0，已开奖状态为0时表明未中奖）：</label>
			<input type="text" name="orderprizeamt" value="${vo.orderprizeamt}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>开奖号码，包括普通号与特殊号：</label>
			<input type="text" name="winbasecode" value="${vo.winbasecode}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>订单类型（0-普通投注订单，1-追号订单，2-合买订单）：</label>
			<input type="text" name="ordertype" value="${vo.ordertype}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>追号表的流水号，用于关联追号记录：</label>
			<input type="text" name="tsubscribeflowno" value="${vo.tsubscribeflowno}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>合买表的流水号，用于关联合买记录：</label>
			<input type="text" name="tlotcaseid" value="${vo.tlotcaseid}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>创建订单时间：</label>
			<input type="text" name="createtime" value="${vo.createtime}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>票所属用户的用户编号：</label>
			<input type="text" name="userno" value="${vo.userno}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>购买者的用户编号，为空则表示USERNO就是购买者：</label>
			<input type="text" name="buyuserno" value="${vo.buyuserno}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>subaccount：</label>
			<input type="text" name="subaccount" value="${vo.subaccount}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>订单总注数：</label>
			<input type="text" name="betnum" value="${vo.betnum}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>取消时间：</label>
			<input type="text" name="canceltime" value="${vo.canceltime}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>结束时间：</label>
			<input type="text" name="endtime" value="${vo.endtime}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>odesc：</label>
			<input type="text" name="odesc" value="${vo.odesc}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>betcode：</label>
			<input type="text" name="betcode" value="${vo.betcode}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>alreadytrans：</label>
			<input type="text" name="alreadytrans" value="${vo.alreadytrans}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>订单类型 0-单式上传，1-复式，2-胆拖，3-多方案：</label>
			<input type="text" name="lotstype" value="${vo.lotstype}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>lotmulti：</label>
			<input type="text" name="lotmulti" value="${vo.lotmulti}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>prizeinfo：</label>
			<input type="text" name="prizeinfo" value="${vo.prizeinfo}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>是否有战绩	0：没有，1：有：</label>
			<input type="text" name="hasachievement" value="${vo.hasachievement}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>税前奖金：</label>
			<input type="text" name="orderpreprizeamt" value="${vo.orderpreprizeamt}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>orderinfo：</label>
			<input type="text" name="orderinfo" value="${vo.orderinfo}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>body：</label>
			<input type="text" name="body" value="${vo.body}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>instate：</label>
			<input type="text" name="instate" value="${vo.instate}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>paystate：</label>
			<input type="text" name="paystate" value="${vo.paystate}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>encashtime：</label>
			<input type="text" name="encashtime" value="${vo.encashtime}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>eventcode：</label>
			<input type="text" name="eventcode" value="${vo.eventcode}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>channel：</label>
			<input type="text" name="channel" value="${vo.channel}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>SUBCHANNEL：</label>
			<input type="text" name="subchannel" value="${vo.subchannel}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>agencyno：</label>
			<input type="text" name="agencyno" value="${vo.agencyno}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>playtype：</label>
			<input type="text" name="playtype" value="${vo.playtype}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>latedteamid：</label>
			<input type="text" name="latedteamid" value="${vo.latedteamid}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	</div>

	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>