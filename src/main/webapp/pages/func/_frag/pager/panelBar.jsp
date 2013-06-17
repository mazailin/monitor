<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/include.inc.jsp"%> 

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
