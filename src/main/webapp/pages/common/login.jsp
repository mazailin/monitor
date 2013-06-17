<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登陆</title>
<script src="<%=request.getContextPath()%>/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/dwz/js/dwz.util.date.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/dwz/js/Dialog.js" type="text/javascript"></script>
<script>
function login(){
	if($.trim($("#UserName").val())==""||$.trim($("#Password").val())==""){
		Dialog.alert("请输入用户名和密码");
		return;
	} else {
		
		$("#form1").submit();
	}
}
$(document).ready(function() {
	if(window.top.location != window.self.location){
		window.top.location = window.self.location;
	}else{
		$("#UserName").focus();
	}
	$("html").die().live("keydown",function(event){
        if(event.keyCode==13){
        	login();
         }
    });
});

<% 
String errormsg = (String)request.getAttribute("errormsg");
if(errormsg!=null&&!"".equals(errormsg)) {
%>
function showerror() {
	Dialog.alert("<%=errormsg%>");
}
$(document).ready(function() {
	showerror();
});
<%	
}
%>	
</script>
</head>
<body>
 
<form id="form1" action="<%=request.getContextPath() %>/j_spring_security_check" method="POST" style=" display:block;height:100%;">
<table width="100%" height="100%">
     <tr><td align="center" valign="middle"> <div class="error ${param.error == true ? '' : 'hide'}">           
          <font color="red">${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
          </font>        
     </div> </td></tr>
	<tr>
		<td align="center" valign="middle">
		<table
			style=" height:283px; width:620px; background:url(<%=request.getContextPath()%>/styles/images/loginbg_ruyicai.jpg) no-repeat 0px 0px;">
			<tr>
				<td>
				<div style="height:213px; width:620px;"></div>
				<div style="height:70px; width:620px;margin:0px auto 0px auto;">
				<table width="95%" border="0" align="center" cellpadding="0"
					cellspacing="0" style="margin-top:8px;">
					<tr>
						<td align="center">用户名：
					    <input name="j_username" type="text" style="width:120px"
							id="UserName" class="inputText" onfocus="this.select();"/>
					    &nbsp;密码：
					    <input name="j_password" type="password" style="width:120px"
							id="Password" class="inputText" onfocus="this.select();"/>
					    <span id='spanVerifyCode'></span>	
						&nbsp;<img src="<%=request.getContextPath()%>/styles/images/loginbutton.jpg" name="LoginImg" align="absmiddle" id="LoginImg" style="cursor:pointer"
							onClick="login();" /></td>
					</tr>
					<tr>
						<td height="23" align="center" valign="bottom">Copyright
						&copy; 2007-2010 ruyicai.com Inc. All rights reserved.</td>
					</tr>
				</table>
				</div>
				</td>
			</tr>
		</table>
		<br>
		</td>
	</tr>
</table>
</form>
</body>
</html>
