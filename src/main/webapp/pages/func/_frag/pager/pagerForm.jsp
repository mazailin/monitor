<%@ include file="/includes/include.inc.jsp"%> 

<form id="pagerForm" method="post" action="#rel#">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${vo.numPerPage}" />
	<input type="hidden" name="orderField" value="${vo.orderField}" />
	<input type="hidden" name="orderDirection" value="${vo.orderDirection}" />
</form>
