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
<% String contextPath=request.getContextPath(); %>
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/res/css/style.css">
<body>
<center>
<table border="0" width="80%" cellspacing="1" cellpadding="5" bgcolor="#999999" style="word-break:break-all">
	<tr class="listhead" height="25"><td>文件上传</td></tr>
	<tr bgcolor="#F5F5F5"><td>${requestScope.message}</td></tr>
</table>
</center>
</body>