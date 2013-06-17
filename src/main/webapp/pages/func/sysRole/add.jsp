
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/include.inc.jsp"%> 
 <div class="pageContent">
<form method="post" action="<%=cxt %>/sysRole/insert?navTabId=sysRoleLiNav" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<div class="pageFormContent" layoutH="56">
                                              	        <p>
			<label>角色姓名：</label>
			<input type="text" name="name" class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>
		                     	        <p>
			<label>描述：</label>
			<input type="text" name="description" class="required alphanumeric" minlength="6" maxlength="20"/>
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