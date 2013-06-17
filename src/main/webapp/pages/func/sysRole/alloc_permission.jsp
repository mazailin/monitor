<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/includes/include.inc.jsp"%> 

<div class="pageContent" layoutH="200">
	<form method="post" action="<%=cxt %>/sysRole/${action}" class="pageForm required-validate" onsubmit="return validateCallback(this, ${openType}AjaxDone);">
	<div class="panelBar" style="padding:5px">
		<ul class="toolBar" >
			<li><input style="width:100px; height:23px;" type="submit" value="确认提交" href="#"
				target="dialog" mask="true"></input></li>
		</ul>
	</div>
	<div id="jbsxBox2" class="unitBox"
		style="float: left; display: block;height:50%; overflow: auto; width: 30%;">
		<div class="pageContent"
			style="height:50%;border-left: 1px #B8D0D6 solid; border-right: 1px #B8D0D6 solid">
			<table class="list" width="98%" layoutH="240" >
				<thead>
					<tr>
						<th width="30"><input type="checkbox" group="roleIds" class="checkboxCtrl"></th>
						<th width="">角色名称</th>
						<!--th>描述</th-->
					</tr>
				</thead>
				<tbody>
				<c:forEach var="pojo" items="${roles}">
					<tr target="pojo_id" rel="${pojo.id}">
						<td width="30"><center><input id="${random}${pojo.id}" name="roleIds" value="${pojo.id}" type="checkbox"></center></td>
						<td onclick="selectBox('${random}${pojo.id}')">
							<a style="color:blue; text-decoration:underline" href="<%=cxt %>/sysRole/permissions/${pojo.id}" target="ajax" rel="permission_detail" reloadFlag="1">${pojo.name}</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<div id="jbsxBox3" class="unitBox" style="margin-left: 30%; height:50%;">
		<div class="pageContent" style="border: 1px #B8D0D6 solid; height:50%" layoutH="240">
			<ul class="expand tree treeFolder treeCheck">
				<li><a>全部权限</a>
					
						<ul>
					    	<c:forEach var="perm" items="${permissions}">
								<li><a>${perm.text}</a>
									<ul>
										<c:forEach var="pojo" items="${perm.children}" >
											<li><a tname="permissionIds" tvalue="${pojo.id}" >${pojo.text}</a></li>
										</c:forEach>
									</ul>
								</li>
							</c:forEach>
						</ul>
						
				</li>
			</ul>
		</div>
	</div>
	
	</form>
</div>

<script type="text/javascript">
	function interceptOnClick(id){
		var url =$("#permission_item_detail_"+id).attr("link");
		alertMsg.confirm("您确定要执行删除操作吗？", {
            okCall: function(){
            	$.post(url, {}, function(json){
					if(json.status){
						alertMsg.correct(json.message)
						$("#permission_item_"+id).hide();
					}else{
						alertMsg.error(json.message);
					}
            	}, "json");
        	}
		});
	}
</script>

<div link="testeteste" class="pageContent" style="height:200px;overflow:auto !important;border: 1px #B8D0D6 solid;"
	id="permission_detail" >
</div>


