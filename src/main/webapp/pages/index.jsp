<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/includes/include.inc.jsp"%>
<%@ include file="/includes/dwz.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta name="author" content="cfuture" />
<title>${pageTitle}</title>
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

	var iContentW = $(window).width() - 39;
	var iContentH = $(window).height() - $("#header").height() - 34;
	$("#container").width(iContentW);
	$("#container .panelContent").height(iContentH - 34).find("[layoutH]").layoutH();
	setTimeout(changeMessage,300000);
});

function changeMessage(){
		  window.location= "<%=cxt %>/"
	  
}

</script>
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
	<div class="con-wrap">
<!-- 	       <div class="con-head">-->
<!--    	   <div>-->
<!--    	   <span><a href="#">用户管理</a><a href="#">修改密码</a><a href="#" style="padding-right:0;">退出</a></span>-->
<!--    	   <em>当前用户：${loginUserName}</em> -->
<!--           </div>-->
<!--           </div>-->
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
		</div>
		<div id="container">
			 <div  id="navTab" class="tabsPage" >
<div class="panelContent">
				 <!-- start homepage -->
                <div  class=" con-pro">
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
	    	<tr><td/><td/><td/><td/><td><center>抱歉，没有任何记录。</center></td><td/><td/><td/><td/></tr>
	      </c:if>
		<c:forEach var="item" items="${monitorShowList}" varStatus="s">
		<c:if test="${ s.index%2==0}">
		  <tr>
		</c:if >
		<c:if test="${ s.index%2!=0}">
		   <tr bgcolor="#F4F9FD">
	    </c:if>
  	<td class="td-1">${item.hflid}</td>
    <td class="td-1">${item.hflcreatetime}</td>
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
<div class="panelBar">
		<div class="pages"><span>每页</span>
	    <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
			<c:forEach begin="10" end="40" step="10" varStatus="s">
				<option value="${s.index}" ${vo.numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>
		<span>条，共${vo.totalCount}条记录，每页${vo.numPerPage}条，当前第${vo.pageNum}/${vo.pageCount}页</span>
	    </div>
	
	<div class="pagination" targetType="navTab" totalCount="${vo.totalCount}" numPerPage="${vo.numPerPage}" pageNumShown="10" currentPage="${vo.pageNum}"></div>
</div>
<form id="pagerForm" method="post" action="/torder/monitor">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${vo.numPerPage}" />
	<input type="hidden" name="orderField" value="${vo.orderField}" />
	<input type="hidden" name="orderDirection" value="${vo.orderDirection}" />
</form>
</div>
</div></div></div>
<p>北京金软瑞彩科技有限公司</p>
</div>
				
			

	      <!-- end homepage -->
	     
   
    

</body>
</html>