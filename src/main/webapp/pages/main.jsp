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
	var iContentW = $(window).width() - 39;
	var iContentH = $(window).height() - $("#header").height() - 34;
	$("#container").width(iContentW);
	$("#container .panelContent").height(iContentH - 34).find("[layoutH]").layoutH();
	setTimeOut(setInterval(changeMessage, 30000),1000);
});
function changeMessage(){
	$.ajax({
		   type: "POST",
		   url: "<%=cxt %>/torder/monitor",
		   success: function(data){
			   if(data){
				   var obj = eval('('+data+')');
			   }
			   var monitordata = obj.monitordata;
			   $('#monitordata').html(monitordata);
		   }
	}); 
}

</script>

 <c:if test="${navMenus != null}">
<style type="text/css">
<!--
#header{height:85px}
#leftside, #container, #splitBar, #splitBarProxy{top:90px}
-->
</style>	
 </c:if>
 <style type="text/css">	
<!--
img{border:none;vertical-align:middle}
body{font-size:12px; color:#333;font-family:"微软雅黑","宋体",Arial, Helvetica, sans-serif;}
.title1{background:url(styles/images/blue-bg.jpg) repeat-x; font-size:14px; font-weight:bold; color:#000;}
.title2{background:url(styles/images/yell-bg.jpg) repeat-x; font-size:14px; font-weight:bold; color:#000;}
.title3{background:url(styles/images/green-bg.jpg) repeat-x; font-size:14px; font-weight:bold; color:#000;}
.con-pro{background:#F1F1F1; padding:10px 10px 0 10px;}
.con-pro-box{ border:2px solid #2687BE; padding:12px 7px 10px 7px; background:#FFFDFB}
.con-pro-box table{ border-collapse:collapse;}
.con-pro-box table tr td{ text-align:center; border:1px solid #AEB3B6; height:30px; vertical-align:center;}
.table-sec td{ font-size:12px; color:#005C94; font-weight:bold; background:#EEEEEE}
.con-pro-box table tr td span{ color:#C60204;}
.con-pro-box table tr .td-1{ background:#F7FCFF}
.con-pro-box table tr .td-2{ background:#FFFEF9}
.con-pro-box table tr .td-3{ background:#FCFFF6;}
.con-pro-box table tr .td-1-2{ background:#F4F9FD}
.con-pro-box table tr .td-2-2{ background:#FCFBF6}
.con-pro-box table tr .td-3-2{ background:#F9FCF3;}
table.page tr td{ border-top:none;}
table.page tr td a{ text-decoration:none; color:#000;}
table.page tr td select{ width:48px; margin-right:5px;}
.con-pro p{ text-align:center; height:44px; line-height:44px; color:#929292}	
  	
  -->
 </style>
</head>

<body >
	<div id="layout">
		<div id="header">
			<div class="headerNav"><a class="logo" href="http://www.ruyicai.com">ruyicai.com</a>
			 <div id="ctiinfo" style="color:red;font-size:250%"></div>
				<ul class="nav">
					<li><a href="javascript:;">欢迎 [<b>${loginUserName}</b>]</a></li>
<%-- 		TODO			<li><a href="<%=cxt %>/user/profile" target="dialog" height="380">[我的资料 ]</a></li> --%>
					<li><a href="<%=cxt %>/j_spring_security_logout" onclick="var f = document.createElement('form');f.style.display = 'none'; this.parentNode.appendChild(f); f.method='POST'; f.action = this.href; var m = document.createElement('input');m.setAttribute('type','hidden');m.setAttribute('name','_method');m.setAttribute('value','put'); f.appendChild(m);f.submit();return false;">[退出 ]</a></li>
					<li><a href="<%=cxt %>/pages/about.jsp" target="dialog">关于</a></li>
				</ul>
			</div>
            <c:if test="${navMenus != null}">
			<div id="navMenu">
					${navMenus}
			</div>
			 </c:if>
		</div>


		<div id="container">
				 <!-- start homepage -->
	 <div class="panel">
<div class="panelContent">
	<div class="page unitBox">
	<div class="con-pro">
    		<div class="con-pro-box">
	<table class="table" width="100%" >
	
		<thead>
		<tr>
    <td width="33%" colspan="3" height="35" class="title1">高频彩</td>
    <td width="33%"  colspan="3" height="35" class="title2">数字彩</td>
    <td width="34%"  colspan="3" height="35" class="title3">竞球彩</td>
    </tr>
			<tr>
  <tr class="table-sec">
    <td width="11%" >票单号</td>
    <td width="11%" >投注时间</td>
    <td width="11%" >期结倒计时</td>
    <td width="11%" >票单号</td>
    <td width="11%" >投注时间</td>
    <td width="11%" >期结倒计时</td>
    <td width="11%" >票单号</td>
    <td width="11%" >投注时间</td>
    <td width="12%" >期结倒计时</td>
  </tr>
		                                                  
			</tr>
		</thead>
		<tbody id="monitordata">
		<c:if test="${ monitorShowList==null||fn:length(monitorShowList)<=0}">
	    	<tr><td/><td/><td/><td/><td><center>抱歉，没有任何记录。</center></td></tr>
	      </c:if>
		<c:forEach var="item" items="${monitorShowList}" varStatus="s">
		<c:if test="${ s.index%2==0}">
		  <tr>
		</c:if >
		<c:if test="${ s.index%2!=0}">
		   <tr bgcolor="#F4F9FD">
	    </c:if>
  	<td class="td-1">${item.hflid}</td>
    <td class="td-1">>${item.hflcreatetime}</td>
    <td class="td-1">${item.hflremainingtime}</td>
    <td class="td-2">${item.dlid}</td>
    <td class="td-2">${item.dlcreatetime}</td>
    <td class="td-2">${item.dlremainingtime}</td>
    <td class="td-3">${item.kblid}</td>
    <td class="td-3">${item.kblcreatetime}</td>
    <td class="td-3">${item.kblremainingtime}</td>
       </tr>
 </c:forEach>
		</tbody>
	</table>

</div>
</div>
</div>
</div>     

<div class="panelBar">
		<div class="pages">共${vo.totalCount}条记录，每页${vo.numPerPage}条，当前第${vo.pageNum}/${vo.pageCount}页</span>
	    </div>
	
	<div class="pagination" targetType="navTab" totalCount="${vo.totalCount}" numPerPage="${vo.numPerPage}" pageNumShown="10" currentPage="${vo.pageNum}"></div>
</div>

    </div>
				<!-- end homepage -->
			
				</div>
<!--			</div>-->
<!--		</div>-->

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