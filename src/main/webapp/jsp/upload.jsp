<%--
  Created by IntelliJ IDEA.
  User:    Administrator
  author:  信息化管理部-方波
  site:    http://www.cr121.com/
  company: 中铁十二局集团第一工程有限公司
  Date:    2020/3/24
  Time:    12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>上传文件</title>
		<link type="text/css" rel="stylesheet" href="../res/css/style.css">
	</head>
	<body bgcolor="#E1E1E1">
		<center>
		<table border="1" bordercolor="#BFD3E1" bordercolorlight="#BFD3E1" bordercolordark="white" cellpadding="0" cellspacing="0" rules="cols">
			<tr height="25"><tr>
			<tr><td colspan="2"><img src="../res/img/top.jpg" width="100%"></td><tr>
			<tr height="30" bgcolor="black">
				<td colspan="2" style="text-indent:20" align="right">
					<% String contextPath=request.getContextPath(); %>
					<a style="color:white" href="<%=contextPath%>/index.jsp">首页</a>
					<a style="color:white" href="toDownLoad">下载文件</a>&nbsp;&nbsp;
				</td>
			</tr>
			<form action="upLoad" enctype="multipart/form-data" name="uploadform" method="post">
			<tr>
				<td width="180" align="center" valign="top" bgcolor="#F7FAF6" style="padding-top:8">
					<div style="background:#177B6C;width:94%;height:25;color:white"><b>注意事项：</b></div>
					●文件上传容量最小＞00k！<br>
					●文件上传容量最大＜50M！
				</td>
				<td valign="top" style="padding-left:30;padding-top:10" bgcolor="white">
					<img src="../res/img/title.jpg"><br><br>
					文件路径1：<br>
					<input type="file" name="file1" size="60"><br>
					文件描述1：<br>
					<textarea rows="5" cols="80" name="fileinfo1" ></textarea><br>
					<hr color="black">
					文件路径2：<br>
					<input type="file" name="file2" size="60"><br>
					文件描述2：<br>
					<textarea rows="5" cols="80" name="fileinfo2"></textarea><br>
					<input type="button" style="border:0;background:url(../res/img/submit.jpg);width:74;height:21" value="" onclick="uploadform.submit()">
					<input type="reset" style="border:0;background:url(../res/img/reset.jpg);width:74;height:21" value="">
					<br><br>
				</td>
			</tr>
			</form>
			<tr><td colspan="2"><img src="../res/img/end.jpg" width="100%"></td><tr>
		</table>
		</center>
	</body>
</html>