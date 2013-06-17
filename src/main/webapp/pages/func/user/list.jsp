<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/include.inc.jsp"%> 
 <c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<div class="pageHeader">
<form  method="post" rel="pagerForm" action="<%=cxt %>/user/listUser" onsubmit="return navTabSearch(this)">

	<div class="searchBar">
		<ul class="searchContent">
<!--          	<li> -->
<!-- 				<label>姓名：</label> -->
<!-- 				<input type="text" name="name" value=""/> -->
<!-- 	        </li> -->
<!--          	<li> -->
<!-- 				<label>登陆用户名：</label> -->
<!-- 				<input type="text" name="loginname" value=""/> -->
<!-- 	        </li> -->
         	
         	<li>
				<label>工作编号：</label>
				<input type="text" name="workid" value=""/>
	        </li>
<!--          	<li> -->
<!-- 				<label>组编号：</label> -->
<!-- 				<input type="text" name="groupid" value=""/> -->
<!-- 	</li> -->
<!--          	<li> -->
<!-- 				<label>激活状态：</label> -->
<!-- 				<input type="text" name="state" value=""/> -->
<!-- 	</li> -->
<!--          	<li> -->
<!-- 				<label>初始时间：</label> -->
<!-- 				<input type="text" name="intime" value=""/> -->
<!-- 	</li> -->
<!--          	<li> -->
<!-- 				<label>登录时间：</label> -->
<!-- 				<input type="text" name="begintime" value=""/> -->
<!-- 	</li> -->
<!--          	<li> -->
<!-- 				<label>退出时间：</label> -->
<!-- 				<input type="text" name="endtime" value=""/> -->
<!-- 	</li> -->
<!--          	<li> -->
<!-- 				<label>电话号码：</label> -->
<!-- 				<input type="text" name="callno" value=""/> -->
<!-- 	</li> -->
<!--          	<li> -->
<!-- 				<label>AGC类型：</label> -->
<!-- 				<input type="text" name="agctype" value=""/> -->
<!-- 	</li> -->
<!--          	<li> -->
<!-- 				<label>电话呼叫数量：</label> -->
<!-- 				<input type="text" name="callcount" value=""/> -->
<!-- 	</li> -->
<!--          	<li> -->
<!-- 				<label>AGC分机号：</label> -->
<!-- 				<input type="text" name="agclineno" value=""/> -->
<!-- 	</li> -->
<!--          	<li> -->
<!-- 				<label>所属角色ID：</label> -->
<!-- 				<input type="text" name="roleId" value=""/> -->
<!-- 	</li> -->
		</ul>
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div>
	</div>

</form>
</div>
<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" rel="userNav"  href="<%=cxt %>/user/add"   title="添加用户"><span>添加</span></a></li>
			<li><a class="edit" target="dialog" rel="userNav" href="<%=cxt %>/user/edit/{slt_objId}"   warn="请选择一条记录" title="编辑用户"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<%=cxt %>/user/delete/{slt_objId}" title="你确定要删除吗?" warn="您没有选择任何项目！请选择列表中的数据，选中项将会以蓝色高亮显示！" ><span>删除</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
			     <th width="30"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				 <th width="100">姓名</th>
		          <th width="100">登陆用户名</th>
		          <th width="100">密码</th>
		          <th width="100">描述</th>
		          <th width="100">工作编号</th>
		          <th width="100">组编号</th>
		          <th width="100">激活状态</th>
		          <th width="100">初始时间</th>
		          <th width="100">登录时间</th>
		          <th width="100">退出时间</th>
		          <th width="100">电话号码</th>
		          <th width="100">AGC类型</th>
		          <th width="100">电话呼叫数量</th>
		          <th width="100">AGC分机号</th>
		          <th width="100">所属角色ID</th>
			</tr>
		</thead>
		<tbody>
		  <c:if test="${ userList==null||fn:length(userList)<=0}">
	    	<tr><td><center>抱歉，没有任何记录。</center></td></tr>
	    </c:if>
        
		<c:forEach var="item" items="${userList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				 <td>${item.name}</td>
		             <td>${item.loginname}</td>
		             <td>${item.password}</td>
		             <td>${item.description}</td>
		             <td>${item.workid}</td>
		             <td>${item.groupid}</td>
		             <td>${item.state}</td>
		             <td>${item.intime}</td>
		             <td>${item.begintime}</td>
		             <td>${item.endtime}</td>
		             <td>${item.callno}</td>
		             <td>${item.agctype}</td>
		             <td>${item.callcount}</td>
		             <td>${item.agclineno}</td>
		             <td>${item.roleId}</td>
		                                         			</tr>
		</c:forEach>
		</tbody>
	</table>

		<c:import url="../_frag/pager/panelBar.jsp"></c:import> 

</div>