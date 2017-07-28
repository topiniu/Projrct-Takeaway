<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Join us!</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Css/register.css">
	<link rel="stylesheet" type="text/css" href="jquery-ui/css/blitzer/jquery-ui-1.10.4.custom.css">
	<script type="text/javascript" src="Js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="Js/register.js"></script>
	<script type="text/javascript" src="jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
  </head>
  
  <body background="Images/register.jpg">
  <div id="container">
  	<div id="banner">
		<a href="javascript:void(0)" id="usual">普通用户</a>
		<a href="javascript:void(0)" id="operator">我要开店</a>
	</div>
  <div id="operatorForm">
  	<form id="form" action="Base/register" enctype="multipart/form-data" method="post"> 
  		<div id="photoDiv" style="float:left" >
  			<input id="choosePhoto" class="input" style="display: none;" type="file" name="img" />
  					<div style="margin-top:25px;">
  					证件照:<a id="photoBar" href="javascript:void(0)">点击选取照片</a><br><br><br>
  					</div>
  					<img id="img" style="width:234;height:200;display: none;" src="">
  		</div>
  		<div id="formDiv" style="float:right" >
  		<fieldset>
  		<legend>普通用户信息</legend>
  			昵称：<input class="input" type="text" name="user.name"/><br>
  			密码：<input class="input" type="password" name="user.password"/><br>
  		</fieldset>
  		<fieldset>
  		<legend>真实身份信息</legend>
	  		真实姓名：<input class="input" type="text" name="identity.name"/><br>
	  		性&nbsp;&nbsp;&nbsp;&nbsp;别：<input id="radio" type="radio" checked="checked" name="identity.sex" value="male"/>男 &nbsp; <input id="radio" type="radio" name="identity.sex" value="female"/>女  <br>
	  		详细地址：<input class="input" type="text" name="identity.address"/><br>
	  		联系电话：<input class="input" type="text" name="identity.tel"/><br>
	  		出生日期：<input class="input" id="datePicker" name="identity.birthDate" />	<br>
	  		证件类型：<input class="input" type="text" name="identity.identityType"/><br>
	  		证件号码：<input class="input" type="text" name="identity.identityNumber"/><br>
	  	</fieldset>
	  	<fieldset>
  		<legend>申请表信息</legend>
	  		<p>申请理由:</p><textarea placeholder="申请理由" class="textArea" name="app.applicationText"></textarea><br>
  		</fieldset>
  			<input id="submit" type="submit" value="提     交"/>
  		</div>
  	</form>
  </div>
  
  
 <!-- ================================================================= -->
  
  
  <div id="usualForm">
  	<form id="form" action="" enctype="multipart/form-data">
  		真实姓名：<input class="input" type="text" name="name"/><br>
  		性&nbsp;&nbsp;&nbsp;&nbsp;别：<input id="radio" type="radio" checked="checked" name="identity.sex" value="male"/>男 &nbsp; <input id="radio" type="radio" name="identity.sex" value="female"/>女  <br>
  		出生日期：<input class="input" type="text" name="identity.birthDate"/><br>
  		详细地址：<input class="input" type="text" name="identity.address"/><br>
  		联系电话：<input class="input" type="text" name="identity.tel"/><br>
  		
  		证件类型：<input class="input" type="text" name="identity.identityType"/><br>
  		证件号码：<input class="input" type="text" name="identity.identityNumber"/><br>
  	
  		申请理由:<textarea class="textArea" name="app.applicationText"></textarea><br>
  		证件照:<input id="input" type="file" name="img" value="haha"/><br>
  	</form>
  </div>
  </div>
  </body>
</html>
