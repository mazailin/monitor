
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/include.inc.jsp"%> 
 <div class="pageContent">
<form method="post" action="<%=cxt %>/sysResource/update?navTabId=sysResourceLiNav" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<input type="hidden" name="id" value="${vo.id}"/>
	<div class="pageFormContent" layoutH="56">
	 	         	 	        <p>
			<label>名字：</label>
			<input type="text" name="name" value="${vo.name}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>路径：</label>
			<input type="text" name="path" value="${vo.path}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>父id：</label>
			<input type="text" name="parent" value="${vo.parent}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>额外参数：</label>
			<input type="text" name="params" value="${vo.params}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>是否叶子节点：</label>
			<input type="text" name="leaf" value="${vo.leaf}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>样式：</label>
			<input type="text" name="iconcls" value="${vo.iconcls}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>是否是menu：</label>
			<input type="text" name="headermenu" value="${vo.headermenu}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>排序：</label>
			<input type="text" name="displayorder" value="${vo.displayorder}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>描述：</label>
			<input type="text" name="description" value="${vo.description}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>navTab：</label>
			<input type="text" name="target" value="${vo.target}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>chart：</label>
			<input type="text" name="rel" value="${vo.rel}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>reloadFlag：</label>
			<input type="text" name="reloadflag" value="${vo.reloadflag}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>external：</label>
			<input type="text" name="external" value="${vo.external}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>宽度：</label>
			<input type="text" name="width" value="${vo.width}"  class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>	
                	 	        <p>
			<label>高度：</label>
			<input type="text" name="height" value="${vo.height}"  class="required alphanumeric" minlength="6" maxlength="20"/>
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