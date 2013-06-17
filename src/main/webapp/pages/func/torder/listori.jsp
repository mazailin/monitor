
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/include.inc.jsp"%> 


<div class="pageHeader">
<form method="post" rel="pagerForm" action="<%=cxt %>/torder/listTorderBean" onsubmit="return navTabSearch(this)">

	<div class="searchBar">
		<table class="searchContent">
	<tr>	

               		<td>
				<label>${vo}</label>
	            </td>
		</tr>	
		</table>
	</div>

</form>
</div>

