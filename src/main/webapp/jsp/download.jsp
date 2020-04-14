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
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
	<head>
    	<title>文件下载</title>
    	<link rel="stylesheet" type="text/css" href="../res/css/style.css">
  	</head>  
	<body bgcolor="#E1E1E1">
		<c:set var="files" value="${requestScope.filelist}"/>
    	<center>
			<table border="1" bordercolor="#BFD3E1" bordercolorlight="#BFD3E1" bordercolordark="white" cellpadding="0" cellspacing="0" rules="cols">
				<tr height="25"><tr>
				<tr><td colspan="2"><img src="../res/img/top.jpg" width="100%"></td><tr>
				<tr height="30" bgcolor="black">
					<td colspan="2" style="text-indent:20" align="right">
						<% String contextPath=request.getContextPath(); %>
						<a style="color:white" href="<%=contextPath%>/index.jsp">首页</a>
						<a style="color:white" href="toUpload">上传文件</a>&nbsp;&nbsp;
					</td>
				</tr>
				<tr height="350">
					<td width="180" align="center" valign="top" bgcolor="#F7FAF6" style="padding-top:8">
						<div style="background:#177B6C;width:94%;height:25;color:white"><b>注意事项：</b></div>
						●文件下载容量最大＜50M！
					</td>
					<td align="center" valign="top" bgcolor="white">
						<table border="0" width="95%" cellpadding="5" cellspacing="1" bgcolor="#999999" style="word-break:break-all;margin-top:20">
									<tr height="25" align="center" class="listhead">
											<td width="40%">文件名称</td>
											<td width="15%">文件大小</td>
											<td>文件描述</td>
											<td width="8%">下载</td>
									</tr>
							<c:if test="${!empty files}">
							<c:forEach var="file" varStatus="fvs" items="${files}">
							<c:if test="${fvs.index%2 == 0}"><c:set var="bgc" value="#F5F5F5"/></c:if>
							<c:if test="${fvs.index%2 != 0}"><c:set var="bgc" value="white"/></c:if>
							<tr bgcolor="${bgc}">
								<td>${file.fileName}</td>
								<td>${file.fileSize} 字节</td>
								<td>${file.fileDetail}</td>
								<td align="center"><a href="downLoad?downfile=${file.fileSave}">下载</a>
							</tr>
							</c:forEach>
							</c:if>
							<c:if test="${empty files}">
							<tr height="50" bgcolor="white" align="center"><td colspan="4">没有文件！</td></tr>
							</c:if>
								</table>
					</td>
				</tr>
				<tr><td colspan="2"><img src="../res/img/end.jpg" width="100%"></td><tr>
			</table>
    	</center>
  	</body>
</html>