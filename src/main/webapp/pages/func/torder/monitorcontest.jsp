
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/include.inc.jsp"%> 
<script type="text/javascript">

function changeMessage(){
	//	alert("aaaaaaaaaaaaaaaaaaaaaaa");
		dwzPageBreak({targetType:"navTab", rel:"", data:{pageNum:"1"}});
}
$(function(){
	setTimeout(changeMessage,300000);
	});

</script>
   
<div class="pageContent con-pro-box ">
     <div>
     <table class="table" width="100%">
    <tr>
<!--     <th colspan="4"  height="35" class="title1">高频彩</th> -->
<!--     <th colspan="4"   height="35" class="title2">数字彩</th> -->
    <th colspan="4" height="35" class="title3">竞球彩</th>
    </tr>   
    </table>
    </div>
	<table class="table" width="100%"  layoutH="115" >
		<thead>
<!--	 	<tr>-->
<!--    <td colspan="4" width="600" height="35" class="title1">高频彩</td>-->
<!--    <td colspan="4"  width="600" height="35" class="title2">数字彩</td>-->
<!--    <td colspan="4" height="35" class="title3">竞球彩</td>-->
<!--    </tr>   -->
  <tr  class="table-sec" >
    <th width="20%">票单号</th>
    <th width="22%" >创建时间</th>
    <th width="15%" >彩种</th>
    <th width="15%" >期号</th>
    <th width="28%" >期结倒计时</th>
<!--     <th width="7%" >票单号</th> -->
<!--       <th width="3%" >彩种</th> -->
<!--     <th width="5%" >期号</th> -->
<!--     <th width="7%" >期结倒计时</th> -->
<!--     <th width="7%" >票单号</th> -->
<!--      <th width="3%" >彩种</th> -->
<!--     <th width="5%" >期号</th> -->
<!--     <th width="7%" >期结倒计时</th> -->
  </tr>
		                                                  
			
		</thead>
		<tbody id="monitordata">
		<c:if test="${ monitorShowList==null||fn:length(monitorShowList)<=0}">
	    	<tr><td colspan="4"><center>抱歉，没有任何记录。</center></td></tr>
	      </c:if>
		<c:forEach var="item" items="${monitorShowList}" varStatus="s">
		<c:if test="${ s.index%2==0}">
		  <tr>
<%--     <td class="td-1">${item.hflid}</td> --%>
<%--     <td class="td-1">${item.hfllotno}</td> --%>
<%--      <td class="td-1">${item.hflbatchcode}</td> --%>
<%--     <td class="td-1">${item.hflremainingtime}</td> --%>
<%--     <td class="td-2">${item.dlid}</td> --%>
<%--     <td class="td-2">${item.dllotno}</td> --%>
<%--      <td class="td-2">${item.dlbatchcode}</td> --%>
<%--     <td class="td-2">${item.dlremainingtime}</td> --%>
    <td class="td-3">${item.kblid}</td>
     <td class="td-3">${item.kblcreatetime}</td>
    <td class="td-3">${item.kbllotno}</td>
    <td class="td-3">${item.kblbatchcode}</td>
    <td class="td-3">${item.kblremainingtime}</td>
		</c:if >
		<c:if test="${ s.index%2!=0}">
		   <tr bgcolor="#F4F9FD">
<%-- 		   <td class="td-1-2">${item.hflid}</td> --%>
<%--      <td class="td-1-2">${item.hfllotno}</td> --%>
<%--      <td class="td-1-2">${item.hflbatchcode}</td> --%>
<%--      <td class="td-1-2">${item.hflremainingtime}</td> --%>
<%--      <td class="td-2-2">${item.dlid}</td> --%>
<%--       <td class="td-2-2">${item.dllotno}</td> --%>
<%--      <td class="td-2-2">${item.dlbatchcode}</td> --%>
<%--     <td class="td-2-2">${item.dlremainingtime}</td> --%>
    <td class="td-3-2">${item.kblid}</td>
     <td class="td-3-2">${item.kblcreatetime}</td>
    <td class="td-3-2">${item.kbllotno}</td>
    <td class="td-3-2">${item.kblbatchcode}</td>
    <td class="td-3-2">${item.kblremainingtime}</td>
	    </c:if>
  	
       </tr>
 </c:forEach>
		</tbody>
	</table>
<div class="panelBar">
		<div class="pages"><span>每页</span>
	    <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
			<c:forEach begin="10" end="40" step="10" varStatus="s">
				<option value="${s.index}" ${vo.numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>
		<span>条，共${vo.totalCount}条记录，每页${vo.numPerPage}条，当前第${vo.pageNum}/${vo.pageCount}页</span>
	    </div>
	
	<div class="pagination" targetType="navTab" totalCount="${vo.totalCount}" numPerPage="${vo.numPerPage}" pageNumShown="10" currentPage="${vo.pageNum}"></div>
</div>
<form id="pagerForm" method="post" action="<%=cxt %>/tordermonitor/monitorcontest">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${vo.numPerPage}" />
	<input type="hidden" name="orderField" value="${vo.orderField}" />
	<input type="hidden" name="orderDirection" value="${vo.orderDirection}" />
</form>
    </div>
