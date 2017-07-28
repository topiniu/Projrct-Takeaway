<%@ page language="java" import="java.util.*" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Css/index.css">
	
	<script type="text/javascript" src="Js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="Js/index.js"></script>

  </head>
  
  <body id="body">
  <div id="user">
  <%
  	if(session.getAttribute("Logined_user")!=null){
  		%>
  			<a style="line-height:20px;height:30px;">欢迎</a>&nbsp;<a id="userButt" href="User/userMain?id=<s:property value='#session.Logined_user.id'/>&pageNo=1"><s:property value="#session.Logined_user.name"/></a>
  		<%
  	}else{
  		%>
  			<a id="loginButt" href="javaScript:void(0)">登录</a>
  		<%
  	}
   %>
   </div>
  	<div id="mainContainer">
		<h1>Welcome to topiniu's takeaway website</h1>
		&nbsp;&nbsp;&nbsp;<h2>Please enjoy yourself</h2>
  	</div>
  	
  </body>
</html>









