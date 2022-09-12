<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>外送資料</title>
<link rel="stylesheet" type="text/css" href="01.css">
<style>
body {
					height: 100vh;
					width: 100vw;
				}

				body {
					margin: 0;
					background: linear-gradient(45deg, #49a09d, #5f2c82);
					font-family: sans-serif;
					font-weight: 100;
				}

				table {
					width: 800px;
					border-collapse: collapse;
					overflow: hidden;
					box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
				}

				th,
				td {
					padding: 15px;
					background-color: rgba(255, 255, 255, 0.2);
					color: #fff;
				}

				th {
					text-align: left;
				}

				button {
					outline: none !important;
					border: none;
					background: transparent;
				}
</style>
</head>
<body style="background color:#fdf5e6">
<div align="center">
<h2>外送資料</h2>
<jsp:useBean id="ddNew" scope="request" class="com.AloeTopic02.bean.DeliveryDataBean"	/>
<form >
<table >
<tr><td>平台代碼<td><input type="text" disabled value="<%=ddNew.getD_pid()%>">
<tr><td>資料日期<td><input type="text" disabled value="<%=ddNew.getInsertdate()%>">
<tr><td>工作時數<td><input type="text" disabled value="<%=ddNew.getWorktime()%>">
<tr><td>當日取單<td><input type="text" disabled value="<%=ddNew.getD_count()%>">
<tr><td>當日拒單<td><input type="text" disabled value="<%=ddNew.getD_discount()%>">
<tr><td>當日收入<td><input type="text" disabled value="<%=ddNew.getDailyincome()%>">
</table>
<h4 align="center">更新完成</h4>
</form>
</div>

    <br/>
    <br/>
    <h3 align="center"><a href="http://localhost:8080/Topic02/tool/HomePage.html">回首頁</a></h3>

</body>
</html>