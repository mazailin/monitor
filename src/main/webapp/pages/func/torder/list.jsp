
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/include.inc.jsp"%> 
 <c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<div class="pageHeader">
<form method="post" rel="pagerForm" action="<%=cxt %>/torder/listTorderBean" onsubmit="return navTabSearch(this)">

	<div class="searchBar">
		<table class="searchContent">
	<tr>	

           <td class="dateRange" style="width:500px;">
				<label>期号范围:</label>
				<input style="width:130px;" type="text" name="startDate" class="textInput" value="${vo.startDate}"/>
				<span class="limit">-</span>
				<input style="width:130px;" type="text" name="endDate" class="textInput"  value="${vo.endDate}" />
	        
	         </td>
               		<td>
				<label>彩种编号：</label>
				<input type="text" name="lotno" value="${lotno}"/>
	            </td>
<!--               		<td>-->
<!--				<label>订单金额，订单下所有票的票面金额之和：</label>-->
<!--				<input type="text" name="amt" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>订单付款状态（0-未付款、1-已付款）：</label>-->
<!--				<input type="text" name="paytype" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>订单状态（0-等待处理、1-已购买、2-空订单、3-处理失败）：</label>-->
<!--				<input type="text" name="orderstate" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>投注方式，前台传入什么，则设置成什么：</label>-->
<!--				<input type="text" name="bettype" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>中奖状态（0-未开奖，1-等待开奖，2-开奖处理中，3-开奖处理完成，4-中得大奖）：</label>-->
<!--				<input type="text" name="prizestate" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>订单中奖金额（默认为0，已开奖状态为0时表明未中奖）：</label>-->
<!--				<input type="text" name="orderprizeamt" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>开奖号码，包括普通号与特殊号：</label>-->
<!--				<input type="text" name="winbasecode" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>订单类型（0-普通投注订单，1-追号订单，2-合买订单）：</label>-->
<!--				<input type="text" name="ordertype" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>追号表的流水号，用于关联追号记录：</label>-->
<!--				<input type="text" name="tsubscribeflowno" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>合买表的流水号，用于关联合买记录：</label>-->
<!--				<input type="text" name="tlotcaseid" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>创建订单时间：</label>-->
<!--				<input type="text" name="createtime" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>票所属用户的用户编号：</label>-->
<!--				<input type="text" name="userno" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>购买者的用户编号，为空则表示USERNO就是购买者：</label>-->
<!--				<input type="text" name="buyuserno" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>subaccount：</label>-->
<!--				<input type="text" name="subaccount" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>订单总注数：</label>-->
<!--				<input type="text" name="betnum" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>取消时间：</label>-->
<!--				<input type="text" name="canceltime" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>结束时间：</label>-->
<!--				<input type="text" name="endtime" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>odesc：</label>-->
<!--				<input type="text" name="odesc" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>betcode：</label>-->
<!--				<input type="text" name="betcode" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>alreadytrans：</label>-->
<!--				<input type="text" name="alreadytrans" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>订单类型 0-单式上传，1-复式，2-胆拖，3-多方案：</label>-->
<!--				<input type="text" name="lotstype" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>lotmulti：</label>-->
<!--				<input type="text" name="lotmulti" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>prizeinfo：</label>-->
<!--				<input type="text" name="prizeinfo" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>是否有战绩	0：没有，1：有：</label>-->
<!--				<input type="text" name="hasachievement" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>税前奖金：</label>-->
<!--				<input type="text" name="orderpreprizeamt" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>orderinfo：</label>-->
<!--				<input type="text" name="orderinfo" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>body：</label>-->
<!--				<input type="text" name="body" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>instate：</label>-->
<!--				<input type="text" name="instate" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>paystate：</label>-->
<!--				<input type="text" name="paystate" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>encashtime：</label>-->
<!--				<input type="text" name="encashtime" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>eventcode：</label>-->
<!--				<input type="text" name="eventcode" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>channel：</label>-->
<!--				<input type="text" name="channel" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>SUBCHANNEL：</label>-->
<!--				<input type="text" name="subchannel" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>agencyno：</label>-->
<!--				<input type="text" name="agencyno" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>playtype：</label>-->
<!--				<input type="text" name="playtype" value=""/>-->
<!--	</td>-->
<!--               		<td>-->
<!--				<label>latedteamid：</label>-->
<!--				<input type="text" name="latedteamid" value=""/>-->
<!--	</td>-->
                     <td>
		<div class="subBar"  style="margin-top:4px;">
			<ul  style="float:left;">						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div>
		</td>
		</tr>	
		</table>
	</div>

</form>
</div>
<div class="pageContent">

	<table class="table" width="100%" layoutH="90">
		<thead>
			<tr>
			<th width="30"><input type="checkbox" group="ids"
				class="checkboxCtrl"></th>
				                                            	                 	 <th width="100">订单号</th>
		                                   	                 		                <th width="100">期号</th>
		                                   	                 		                <th width="100">彩种编号</th>
<!--		                                   	                 		                <th width="100">订单金额</th>-->
<!--		                                   	                 		                <th width="100">订单付款状态</th>-->
		                                   	                 		                <th width="100">订单状态</th>
<!--		                                   	                 		                <th width="100">投注方式</th>-->
<!--		                                   	                 		                <th width="100">中奖状态</th>-->
<!--		                                   	                 		                <th width="100">订单中奖金额</th>-->
<!--		                                   	                 		                <th width="100">开奖号码</th>-->
<!--		                                   	                 		                <th width="100">订单类型</th>-->
<!--		                                   	                 		                <th width="100">追号表的流水号</th>-->
<!--		                                   	                 		                <th width="100">合买表的流水号</th>-->
		                                   	                 		                <th width="100">创建订单时间</th>
		                                   	                 		                <th width="100">票所属用户的用户编号</th>
		                                   	                 		                <th width="100">购买者的用户编号</th>
<!--		                                   	                 		                <th width="100">subaccount</th>-->
<!--		                                   	                 		                <th width="100">订单总注数</th>-->
<!--		                                   	                 		                <th width="100">取消时间</th>-->
<!--		                                   	                 		                <th width="100">结束时间</th>-->
<!--		                                   	                 		                <th width="100">odesc</th>-->
<!--		                                   	                 		                <th width="100">betcode</th>-->
<!--		                                   	                 		                <th width="100">alreadytrans</th>-->
<!--		                                   	                 		                <th width="100">订单类型</th>-->
<!--		                                   	                 		                <th width="100">lotmulti</th>-->
<!--		                                   	                 		                <th width="100">prizeinfo</th>-->
<!--		                                   	                 		                <th width="100">是否有战绩</th>-->
<!--		                                   	                 		                <th width="100">税前奖金</th>-->
<!--		                                   	                 		                <th width="100">orderinfo</th>-->
<!--		                                   	                 		                <th width="100">body</th>-->
<!--		                                   	                 		                <th width="100">instate</th>-->
<!--		                                   	                 		                <th width="100">paystate</th>-->
<!--		                                   	                 		                <th width="100">encashtime</th>-->
<!--		                                   	                 		                <th width="100">eventcode</th>-->
<!--		                                   	                 		                <th width="100">channel</th>-->
<!--		                                   	                 		                <th width="100">SUBCHANNEL</th>-->
<!--		                                   	                 		                <th width="100">agencyno</th>-->
<!--		                                   	                 		                <th width="100">playtype</th>-->
<!--		                                   	                 		                <th width="100">latedteamid</th>-->
                                                                                       <th width="100">期结时间</th>
		                                                  
			</tr>
		</thead>
		<tbody>
		 <c:if test="${ torderList==null||fn:length(torderList)<=0}">
	    	<tr><td><center>抱歉，没有任何记录。</center></td></tr>
	      </c:if>
		<c:forEach var="item" items="${torderList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				                               		                           <td>${item.id}</td>
		                                           		                       <td>${item.batchcode}</td>
		                                           		                       <td>${item.lotno}</td>
<!--		                                           		                       <td>${item.amt}</td>-->
<!--		                                           		                       <td>${item.paytype}</td>-->
		                                           		                       <td>${item.orderstate}</td>
<!--		                                           		                       <td>${item.bettype}</td>-->
<!--		                                           		                       <td>${item.prizestate}</td>-->
<!--		                                           		                       <td>${item.orderprizeamt}</td>-->
<!--		                                           		                       <td>${item.winbasecode}</td>-->
<!--		                                           		                       <td>${item.ordertype}</td>-->
<!--		                                           		                       <td>${item.tsubscribeflowno}</td>-->
<!--		                                           		                       <td>${item.tlotcaseid}</td>-->
		                                           		                       <td>${item.createtime}</td>
		                                           		                       <td>${item.userno}</td>
		                                           		                       <td>${item.buyuserno}</td>
<!--		                                           		                       <td>${item.subaccount}</td>-->
<!--		                                           		                       <td>${item.betnum}</td>-->
<!--		                                           		                       <td>${item.canceltime}</td>-->
<!--		                                           		                       <td>${item.endtime}</td>-->
<!--		                                           		                       <td>${item.odesc}</td>-->
<!--		                                           		                       <td>${item.betcode}</td>-->
<!--		                                           		                       <td>${item.alreadytrans}</td>-->
<!--		                                           		                       <td>${item.lotstype}</td>-->
<!--		                                           		                       <td>${item.lotmulti}</td>-->
<!--		                                           		                       <td>${item.prizeinfo}</td>-->
<!--		                                           		                       <td>${item.hasachievement}</td>-->
<!--		                                           		                       <td>${item.orderpreprizeamt}</td>-->
<!--		                                           		                       <td>${item.orderinfo}</td>-->
<!--		                                           		                       <td>${item.body}</td>-->
<!--		                                           		                       <td>${item.instate}</td>-->
<!--		                                           		                       <td>${item.paystate}</td>-->
<!--		                                           		                       <td>${item.encashtime}</td>-->
<!--		                                           		                       <td>${item.eventcode}</td>-->
<!--		                                           		                       <td>${item.channel}</td>-->
<!--		                                           		                       <td>${item.subchannel}</td>-->
<!--		                                           		                       <td>${item.agencyno}</td>-->
<!--		                                           		                       <td>${item.playtype}</td>-->
<!--		                                           		                       <td>${item.latedteamid}</td>-->
		                                                    <td>${item.lastprinttime}</td>    
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>
