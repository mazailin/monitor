<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/includes/include.inc.jsp"%> 
<div class="panelBar">
	<ul class="toolBar">
		<li>
			<a title="确实要删除这些记录吗?" target="selectedTodo" rel="permissionIds" 
				href="<%=cxt %>/sysRole/rolepermissionremove/?roleId=${roleroleId}" class="delete">
				<span>批量删除</span>
			</a>
		</li>
	</ul>
</div>

<table class="list" width="100%">
	<thead>
		<tr>
			<th width="30"><input type="checkbox" group="permissionIds" class="checkboxCtrl"></th>
			<th width="300">权限名称</th>
			<th>资源URI</th>
			<th width="40">操作</th>
		</tr>
	</thead>

	<tbody>
		<c:if test="${rolepermissions == null}">
	    	<tr><td colspan="4"><center>抱歉，没有任何记录。</center></td></tr>
	    </c:if>
		<c:forEach var="pojo" items="${rolepermissions}">
	
			<tr id="permission_item_${pojo.id}" target="pojo_id" rel="${pojo.id}">
				<td style="text-align:center;"><input id="${random}${pojo.id}" name="permissionIds" value="${pojo.id}" type="checkbox"></td>
				
				<td onclick="selectBox('${random}${pojo.id}')">${pojo.text}</td>
				<td onclick="selectBox('${random}${pojo.id}')">${pojo.path}</td>
				<td>
					<a href="#" title="删除" rel="permission_detail" onclick="return interceptOnClick('${pojo.id}');"  link="<%=cxt %>/sysRole/rolepermissionremove/?roleId=${roleroleId}&permissionIds=${pojo.id}" id="permission_item_detail_${pojo.id}" class="btnDel">删除</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
