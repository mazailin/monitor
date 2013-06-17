
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/include.inc.jsp"%> 
 <c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<div class="pageHeader">
<form method="post" rel="pagerForm" action="<%=cxt %>/sysResource/listSysResourceBean" onsubmit="return navTabSearch(this)">

	<div class="searchBar">
		<ul class="searchContent">
		
		       		<li>
				<label>名字：</label>
				<input type="text" name="name" value=""/>
	</li>
               		<li>
				<label>路径：</label>
				<input type="text" name="path" value=""/>
	</li>
               		<li>
				<label>父id：</label>
				<input type="text" name="parent" value=""/>
	</li>
               		<li>
				<label>额外参数：</label>
				<input type="text" name="params" value=""/>
	</li>
               		<li>
				<label>是否叶子节点：</label>
				<input type="text" name="leaf" value=""/>
	</li>
               		<li>
				<label>样式：</label>
				<input type="text" name="iconcls" value=""/>
	</li>
               		<li>
				<label>是否是menu：</label>
				<input type="text" name="headermenu" value=""/>
	</li>
               		<li>
				<label>排序：</label>
				<input type="text" name="displayorder" value=""/>
	</li>
               		<li>
				<label>描述：</label>
				<input type="text" name="description" value=""/>
	</li>
               		<li>
				<label>navTab：</label>
				<input type="text" name="target" value=""/>
	</li>
               		<li>
				<label>chart：</label>
				<input type="text" name="rel" value=""/>
	</li>
               		<li>
				<label>reloadFlag：</label>
				<input type="text" name="reloadflag" value=""/>
	</li>
               		<li>
				<label>external：</label>
				<input type="text" name="external" value=""/>
	</li>
               		<li>
				<label>宽度：</label>
				<input type="text" name="width" value=""/>
	</li>
               		<li>
				<label>高度：</label>
				<input type="text" name="height" value=""/>
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
			<li><a class="add" target="dialog" rel="userNav" href="<%=cxt %>/sysResource/add" title="添加"><span>添加</span></a></li>
			<li><a class="edit" target="dialog" rel="userNav" href="<%=cxt %>/sysResource/edit/{slt_objId}"  warn="请选择一条记录" title="编辑"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<%=cxt %>/sysResource/delete/{slt_objId}" title="你确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
			<th width="30"><input type="checkbox" group="ids"
				class="checkboxCtrl"></th>
				                                            	                 		                <th width="100">名字</th>
		                                   	                 		                <th width="100">路径</th>
		                                   	                 		                <th width="100">父id</th>
		                                   	                 		                <th width="100">额外参数</th>
		                                   	                 		                <th width="100">是否叶子节点</th>
		                                   	                 		                <th width="100">样式</th>
		                                   	                 		                <th width="100">是否是menu</th>
		                                   	                 		                <th width="100">排序</th>
		                                   	                 		                <th width="100">描述</th>
		                                   	                 		                <th width="100">navTab</th>
		                                   	                 		                <th width="100">chart</th>
		                                   	                 		                <th width="100">reloadFlag</th>
		                                   	                 		                <th width="100">external</th>
		                                   	                 		                <th width="100">宽度</th>
		                                   	                 		                <th width="100">高度</th>
		                                   			</tr>
		</thead>
		<tbody>
		 <c:if test="${ sysResourceList==null||fn:length(sysResourceList)<=0}">
	    	<tr><td><center>抱歉，没有任何记录。</center></td></tr>
	      </c:if>
		<c:forEach var="item" items="${sysResourceList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				                               		                       <td>${item.name}</td>
		                                           		                       <td>${item.path}</td>
		                                           		                       <td>${item.parent}</td>
		                                           		                       <td>${item.params}</td>
		                                           		                       <td>${item.leaf}</td>
		                                           		                       <td>${item.iconcls}</td>
		                                           		                       <td>${item.headermenu}</td>
		                                           		                       <td>${item.displayorder}</td>
		                                           		                       <td>${item.description}</td>
		                                           		                       <td>${item.target}</td>
		                                           		                       <td>${item.rel}</td>
		                                           		                       <td>${item.reloadflag}</td>
		                                           		                       <td>${item.external}</td>
		                                           		                       <td>${item.width}</td>
		                                           		                       <td>${item.height}</td>
		                                         			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>
