<%@ page contentType="text/html;charset=gbk"%>
<%
String urI=request.getRequestURI();
String url=request.getRequestURL().toString();
int i=url.indexOf(urI);
url=url.substring(0,i);
%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=gbk"/>
    <title>用户登录已超时</title>
    <style type="text/css"><!-- 
	    body{
			text-align:center; 
			margin:0 auto;
		}
		
		.sessionOut {
            margin:50px auto;
			padding: 15px 50px;
			width: 500px;
			border: 2px solid green;
			background-color: yellow;
			text-align: center;
			
		}
		
		a{
			font-weight:bold;
			font-family:"宋体";
			font-size:18px;
		}

   -->  </style>
  </head>

<body>

	<div class ="sessionOut" >
		您长时间未操作系统，为确保您的资料及数据信息安全，
		系统自动超时退出，请重新<a href="<%= url%><%= request.getContextPath()%>">登录</a>系统！
	</div>	
	
</body>

<script type="text/javascript">
  
if (self != top){
	//window.top.location = window.location;
}

</script>

</html>