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
    <title>�û���¼�ѳ�ʱ</title>
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
			font-family:"����";
			font-size:18px;
		}

   -->  </style>
  </head>

<body>

	<div class ="sessionOut" >
		����ʱ��δ����ϵͳ��Ϊȷ���������ϼ�������Ϣ��ȫ��
		ϵͳ�Զ���ʱ�˳���������<a href="<%= url%><%= request.getContextPath()%>">��¼</a>ϵͳ��
	</div>	
	
</body>

<script type="text/javascript">
  
if (self != top){
	//window.top.location = window.location;
}

</script>

</html>