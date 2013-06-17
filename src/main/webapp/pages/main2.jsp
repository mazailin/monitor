<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta name="author" content="cfuture" />
<title>${pageTitle}</title>
<%@ include file="/includes/dwz.jsp"%>
<script type="text/javascript">
$(function(){
	DWZ.init("dwz/dwz.frag.xml", {
		loginUrl:"pages/common/login.jsp",	// 跳到登录页面
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"dwz/themes"});
		}
	});
});
$(document).ready(function(){
});
</script>

 
<style type="text/css">
<!--
img{border:none;vertical-align:middle}
body{font-size:12px; color:#333;font-family:"微软雅黑","宋体",Arial, Helvetica, sans-serif;}
.title1{background:url(styles/images/blue-bg.jpg) repeat-x; font-size:14px; font-weight:bold; color:#000; vertical-align:center;}
.title2{background:url(styles/images/yell-bg.jpg) repeat-x; font-size:14px; font-weight:bold; color:#000; vertical-align:center;}
.title3{background:url(styles/images/green-bg.jpg) repeat-x; font-size:14px; font-weight:bold; color:#000; vertical-align:center;}
.con-pro{background:#F1F1F1; padding:10px 10px 0 10px;}
.con-pro-box{ border:2px solid #2687BE; padding:12px 0px 10px 7px; background:#FFFDFB}

.con-pro-box table tr th{ text-align:center; border:1px solid #AEB3B6; height:30px; vertical-align:center;}
.table-sec td{ font-size:12px; color:#005C94; font-weight:bold; background:#EEEEEE;text-align:center;}
.con-pro-box table tr td span{ color:#C60204;}
.con-pro-box table tr .td-1{ background:#F7FCFF;}
.con-pro-box table tr .td-2{ background:#FFFEF9;}
.con-pro-box table tr .td-3{ background:#FCFFF6;}
.con-pro-box table tr .td-1-2{ background:#F4F9FD;}
.con-pro-box table tr .td-2-2{ background:#FCFBF6;}
.con-pro-box table tr .td-3-2{ background:#F9FCF3;}
table.page tr td{ border-top:none;}
table.page tr td a{ text-decoration:none; color:#000;}
table.page tr td select{ width:48px; margin-right:5px;}
.con-pro p{ text-align:center; height:44px; line-height:44px; color:#929292}	
  	
-->
</style>	
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav"><a class="logo" href="http://www.ruyicai.com">ruyicai.com</a>
			 <div id="ctiinfo" style="color:red;font-size:250%"></div>
				<ul class="nav">
					<li><a href="javascript:;">欢迎 [<b>${loginUserName}</b>]</a></li>
<%-- 		TODO			<li><a href="<%=cxt %>/user/profile" target="dialog" height="380">[我的资料 ]</a></li> --%>
					<li><a href="<%=cxt %>/j_spring_security_logout" onclick="var f = document.createElement('form');f.style.display = 'none'; this.parentNode.appendChild(f); f.method='POST'; f.action = this.href; var m = document.createElement('input');m.setAttribute('type','hidden');m.setAttribute('name','_method');m.setAttribute('value','put'); f.appendChild(m);f.submit();return false;">[退出 ]</a></li>
					<li><a href="<%=cxt %>/pages/about。jsp" target="dialog">关于</a></li>
				</ul>
			</div>
            <c:if test="${navMenus != null}">
			<div id="navMenu">
					${navMenus}
			</div>
			 </c:if>
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>功能菜单</h2>
					<div>收缩</div>
				</div>
				<div class="accordion" fillSpace="sideBar">
					${treeMenus}
				</div>
				
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">桌面</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				
				 <div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
				
				<!-- start homepage -->
			
				</div>
			</div>
		</div>

		<div id="taskbar" style="left:0px; display:none;">
			<div class="taskbarContent">
				<ul></ul>
			</div>
			<div class="taskbarLeft taskbarLeftDisabled" style="display:none;">taskbarLeft</div>
			<div class="taskbarRight" style="display:none;">taskbarRight</div>
		</div>
<!--		<div id="splitBar"></div>-->
<!--		<div id="splitBarProxy"></div>-->
	</div>
    <c:if test="${validatefoot==1 }">
	<div id="footer">${copyright}</div>
    </c:if>
	<!--拖动效果-->
	<div class="resizable"></div>
	<!--阴影-->
	<div class="shadow" style="width:508px; top:148px; left:296px;">
		<div class="shadow_h">
			<div class="shadow_h_l"></div>
			<div class="shadow_h_r"></div>
			<div class="shadow_h_c"></div>
		</div>
		<div class="shadow_c">
			<div class="shadow_c_l" style="height:296px;"></div>
			<div class="shadow_c_r" style="height:296px;"></div>
			<div class="shadow_c_c" style="height:296px;"></div>
		</div>
		<div class="shadow_f">
			<div class="shadow_f_l"></div>
			<div class="shadow_f_r"></div>
			<div class="shadow_f_c"></div>
		</div>
	</div>
	<!--遮盖屏幕-->
	<div id="alertBackground" class="alertBackground"></div>
	<div id="dialogBackground" class="dialogBackground"></div>

<!--	<div id='background' class='background'></div>-->
<!--	<div id='progressBar' class='progressBar'>数据加载中，请稍等...</div>-->
</body>
</html>