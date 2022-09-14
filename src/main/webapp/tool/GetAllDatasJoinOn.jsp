<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.AloeTopic02.bean.FullBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改外送資料</title>
<link rel="stylesheet" type="text/css" href="01.css">
<style>

html {
  height: 100%;
}
body {
  min-height: 100%;
}

body {
	margin: 0;
	background: linear-gradient(to right, #49a09d, #5f2c82);
	font-family: sans-serif;
	font-weight: 100;
	background-repeat: repeat;
}

.container {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
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



h1,h2,h3,h4,h5,h6{
color: #FFFFFF;
}

input {
	outline: none;
	border: none;
}

div {
	padding: 15px;
	background-color: rgba(255, 255, 255, 0.2);
	color: #fff;
}

th {
	text-align: left;
}



textarea {
	outline: none;
	border: none;
}

/* Add a black background color to the top navigation */
.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #04AA6D;
  color: white;
}



/*---------------------------------------------*/
button {
	outline: none !important;
	border: none;
	background: transparent;
}

button:hover {
	cursor: pointer;
}

iframe {
	border: none !important;
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