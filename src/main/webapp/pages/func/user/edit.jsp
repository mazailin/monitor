<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/include.inc.jsp"%> 
<div class="pageContent">
<form method="post" action="<%=cxt %>/user/update?navTabId=userLiNav" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
	<input type="hidden" name="id" value="${vo.id}"/>
	<div class="pageFormContent" layoutH="58">
		<p>
			<label>姓名: </label>
			<input type="text" name="name" value="${vo.name}" readonly="readonly"/>
		</p>
	
		<p>
			<label>密码: </label>
			<input type="text" name="password" class="required "  value="${vo.password}" minlength="6" maxlength="20"/>
		</p>
		<p>
			<label>登陆名: </label>
			<input type="text" name="loginname" class="required" value="${vo.loginname}"  readonly="readonly"/>
		</p>
		<p>
			<label>组编号: </label>
			<select name="groupid" class="required" >
				<c:forEach var="item" items="${groupidList}">
				<option value="${item.groupid}"  <c:if test="${vo.groupid==item.groupid}">selected="selected"</c:if> >${item.groupname}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>工作编号: </label>
			<input type="text" name="workid" class="required" value="${vo.workid}"  maxlength="30"/>
		</p>
		<p>
			<label>坐席分机: </label>
			<input type="text" name="agclineno" class="required digits" value="${vo.agclineno}"   min="1" max="2000"/>
		</p>
		<p>
			<label>电话: </label>
			<input type="text" name="callno"  value="${vo.callno}"  maxlength="30"/>
		</p>
		<p>
			<label>所属角色: </label>
			<select name="roleId" class="required" >
				<c:forEach var="item" items="${roleList}">
				<option value="${item.id}" <c:if test="${vo.roleId==item.id}">selected="selected"</c:if> >${item.name}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>描述: </label>
			<textarea name="description" rows="2" cols="80"  value="${vo.description}"   maxlength="255"></textarea>
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