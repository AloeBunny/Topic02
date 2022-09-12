<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>外送資料</title>
<link rel="stylesheet" type="text/css" href="01.css">
</head>
<body style="background color:#fdf5e6">
<div align="center">
<h2>外送資料</h2>
<jsp:useBean id="ddb" scope="request" class="com.AloeTopic02.bean.DeliveryDataBean"	/>
<table>
<tr><td>平台代碼<td><input type="text" disabled value="<%=ddb.getD_pid()%>">
<tr><td>資料日期<td><input type="text" disabled value="<%=ddb.getInsertdate()%>">
<tr><td>工作時數<td><input type="text" disabled value="<%=ddb.getWorktime()%>">
<tr><td>當日取單<td><input type="text" disabled value="<%=ddb.getD_count()%>">
<tr><td>當日拒單<td><input type="text" disabled value="<%=ddb.getD_discount()%>">
<tr><td>當日收入<td><input type="text" disabled value="<%=ddb.getDailyincome()%>">
</table>
</div>

    <br/>
    <br/>
    <h3 align="center"><a href="http://localhost:8080/Topic02/tool/HomePage.html">回首頁</a></h3>

</body>
</html>