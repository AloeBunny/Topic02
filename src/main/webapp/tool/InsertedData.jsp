<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.AloeTopic02.bean.DeliveryDataBean"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="01.css">
<style>

body {
	height: 100vh;
	
}

body {
	margin: 0;
	background: linear-gradient(45deg, #49a09d, #5f2c82);
	font-family: sans-serif;
	font-weight: 100;
}
input {
	outline: none;
	border: none;
}

input[type="number"] {
    -moz-appearance: textfield;
    appearance: none;
    -webkit-appearance: none;
}

input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
}

textarea {
  outline: none;
  border: none;
}

textarea:focus, input:focus {
  border-color: transparent !important;
}

input:focus::-webkit-input-placeholder { color:transparent; }
input:focus:-moz-placeholder { color:transparent; }
input:focus::-moz-placeholder { color:transparent; }
input:focus:-ms-input-placeholder { color:transparent; }

textarea:focus::-webkit-input-placeholder { color:transparent; }
textarea:focus:-moz-placeholder { color:transparent; }
textarea:focus::-moz-placeholder { color:transparent; }
textarea:focus:-ms-input-placeholder { color:transparent; }

input::-webkit-input-placeholder { color: #adadad;}
input:-moz-placeholder { color: #adadad;}
input::-moz-placeholder { color: #adadad;}
input:-ms-input-placeholder { color: #adadad;}

textarea::-webkit-input-placeholder { color: #adadad;}
textarea:-moz-placeholder { color: #adadad;}
textarea::-moz-placeholder { color: #adadad;}
textarea:-ms-input-placeholder { color: #adadad;}
</style>
<html>
<head>
<meta charset="UTF-8">
<title>新增外送資料</title>
<link rel="stylesheet" type="text/css" href="01.css">
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2>新增外送資料</h2>
<jsp:useBean id="ddb" scope="request" class="com.AloeTopic02.bean.DeliveryDataBean"	/>
<table>
<tr><td>平台編號<td><input type="text" disabled value="${ddb.d_pid}">
<tr><td>資料日期<td><input type="text" disabled value="${ddb.insertdate}">
<tr><td>工作時數<td><input type="text" disabled value="${ddb.worktime}">
<tr><td>當日單量<td><input type="text" disabled value="${ddb.d_count }">
<tr><td>拒單量<td><input type="text" disabled value="${ddb.d_discount}">
<tr><td>當日收入<td><input type="text" disabled value="${ddb.dailyincome}">
</table>
<h3 align="center">以上資料新增成功</h3>
</div>
    <br/>
<h3 align="center">
			<a href="http://localhost:8080/Topic02/tool/AddData.html">繼續新增資料</a>
		</h3>
    <br/>
    <h3 align="center"><a href="http://localhost:8080/Topic02/tool/HomePage.html">回首頁</a></h3>
</body>
</html>