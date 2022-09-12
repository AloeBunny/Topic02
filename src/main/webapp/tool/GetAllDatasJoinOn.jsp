<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.AloeTopic02.bean.Allbean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改外送資料</title>
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

table {
	width: 800px;
	border-collapse: collapse;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0,0,0,0.1);
}

th,
td {
	padding: 15px;
	background-color: rgba(255,255,255,0.2);
	color: #fff;
}

th {
	text-align: left;
}
</style>
</head>
<body style="background color:#fdf5e6">
<div align="center">
<h2>修改外送資料</h2>
<table border="1">
<tr style="background-color:#00AEAE">
<th>平台名稱<th>資料日期<th>工作時數<th>當日接單<th>當日拒單<th>當日收入<th>修改<th>刪除

<c:forEach items="${alls}" var="all" varStatus="s" >
<%-- List<Allbean> alls =(ArrayList<Allbean>)request.getAttribute("alls"); --%>
<%-- for(Allbean all:alls ) {--%>

<tr><td>${all.p_name}
<td>${all.insertdate }
<td>${all.worktime}
<td>${all.d_count }
<td>${all.d_discount }
<td>${all.dailyincome }
<td><a href="GetUpdateData?d_pid=${all.d_pid}&insertdate=${all.insertdate}">修改</a>
<td><a href="javaScript:if(confirm('你確定要刪除嗎?')){location.href='DeleteData?d_pid=${all.d_pid}&insertdate=${all.insertdate}'}">刪除</a>
<c:set var="count" value="${s.count}"/>

<%--} --%>
</c:forEach>
</table>
<h3>一共${count}筆資料</h3>
</div>

    <br/>
    <br/>
    <h3 align="center"><a href="http://localhost:8080/Topic02/tool/HomePage.html">回首頁</a></h3>

</body>
</html>