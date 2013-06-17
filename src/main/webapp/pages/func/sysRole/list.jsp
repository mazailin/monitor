
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/include.inc.jsp"%> 
 <c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<div class="pageHeader">
<form method="post" rel="pagerForm" action="<%=cxt %>/sysRole/listSysRoleBean" onsubmit="return navTabSearch(this)">

	<div class="searchBar">
		<ul class="searchContent">
		
		       		<li>
				<label>角色姓名：</label>
				<input type="text" name="name" value=""/>
	</li>
               		<li>
				<label>描述：</label>
				<input type="text" name="description" value=""/>
	</li>
               		</ul>
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>

</form>
</div>
<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" rel="userNav" href="<%=cxt %>/sysRole/add" title="添加"><span>添加</span></a></li>
			<li><a class="edit" target="dialog" rel="userNav" href="<%=cxt %>/sysRole/edit/{slt_objId}"  warn="请选择一条记录" title="编辑"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<%=cxt %>/sysRole/delete/{slt_objId}" title="你确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
			<th width="30"><input type="checkbox" group="ids"
				class="checkboxCtrl"></th>
				<th width="100">角色姓名</th>
		        <th width="100">描述</th>
		        <th width="80">操作</th>
		    </tr>
		</thead>
		<tbody>
		 <c:if test="${ sysRoleList==null||fn:length(sysRoleList)<=0}">
	    	<tr><td><center>抱歉，没有任何记录。</center></td></tr>
	      </c:if>
		<c:forEach var="item" items="${sysRoleList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
			    <td>${item.name}</td>
		        <td>${item.description}</td>
		        <td><a title="删除" target="ajaxTodo"
					href="<%=cxt %>/sysRole/delete/${item.id}" class="btnDel">删除</a>
				<a title="编辑" target="dialog" href="<%=cxt %>/sysRole/edit/${item.id}"
					class="btnEdit" width="300" height="200">编辑</a></td>
		        </tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>
