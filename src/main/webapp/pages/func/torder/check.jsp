
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/include.inc.jsp"%> 

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
	        无法找到的订单数：${fn:length(torderListleft)}<br/>
		 <c:if test="${ torderList==null||fn:length(torderList)<=0}">
	    	<tr><td><center>抱歉，没有任何记录。</center></td></tr>
	      </c:if>
		<c:forEach var="item" items="${torderList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				                               		                           <td>${item.id}/${item.torder.id}</td>
		                                           		                       <td>${item.batchcode}/${item.torder.batchcode}</td>
		                                           		                       <td>${item.lotno}/${item.torder.lotno}</td>
<!--		                                           		                       <td>${item.amt}</td>-->
<!--		                                           		                       <td>${item.paytype}</td>-->
		                                           		                       <td>${item.orderstate}/${item.torder.orderstate}</td>
<!--		                                           		                       <td>${item.bettype}</td>-->
<!--		                                           		                       <td>${item.prizestate}</td>-->
<!--		                                           		                       <td>${item.orderprizeamt}</td>-->
<!--		                                           		                       <td>${item.winbasecode}</td>-->
<!--		                                           		                       <td>${item.ordertype}</td>-->
<!--		                                           		                       <td>${item.tsubscribeflowno}</td>-->
<!--		                                           		                       <td>${item.tlotcaseid}</td>-->
		                                           		                       <td>${item.createtime}/${item.torder.createtime}</td>
		                                           		                       <td>${item.userno}/${item.torder.userno}</td>
		                                           		                       <td>${item.buyuserno}/${item.torder.buyuserno}</td>
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
		                                                    <td>${item.lastprinttime}/${item.torder.lastprinttime}</td>    
			</tr>
		</c:forEach>
		</tbody>
	</table>

</div>
