<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>外送資料</title>
			<link rel="stylesheet" type="text/css" href="01.css">
			<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
			<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">
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



				h1,
				h2,
				h3,
				h4,
				h5,
				h6 {
					color: #FFFFFF;
				}

				input {
					outline: none;
					border: none;
				}

				.box {
					width: 50vw;
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

		<body style="background-color:#fdf5e6">
	<div class="topnav">
		<a class="active" href="http://localhost:8080/Topic02/tool/HomePage.html">首頁</a>
		<a href="http://localhost:8080/Topic02/tool/AddData.html">新增外送資料</a>
		<form id="form1" action="../GetAllDatasJoinOn" method="post">
    <a href="javascript:;" onclick="document.getElementById('form1').submit();">查看所有資料</a>
    <input type="hidden" name="mess" value="checkall"/>
</form>
		<a href="http://localhost:8080/Topic02/tool/GetDataByPeriod.html">區間資料查詢</a>
		<a href="http://localhost:8080/Topic02/tool/GetSumByPeriodAll.html">平台資料比較</a>
	</div>
				<a href="http://localhost:8080/Topic02/tool/GetDataByPeriod.html">區間資料查詢</a>
			</div>

			<div class="box container" align="center">
				<h2>外送資料</h2>
				<jsp:useBean id="ddNew" scope="request" class="com.AloeTopic02.bean.DeliveryDataBean" />
				<form class="w3-container">
					<table class="w3-table">
						<tr>
							<td>平台代碼
							<td><input class="w3-input" type="text" disabled value="<%=ddNew.getD_pid()%>">
						<tr>
							<td>資料日期
							<td><input class="w3-input" type="text" disabled value="<%=ddNew.getInsertdate()%>">
						<tr>
							<td>工作時數
							<td><input class="w3-input" type="text" disabled value="<%=ddNew.getWorktime()%>">
						<tr>
							<td>當日取單
							<td><input class="w3-input" type="text" disabled value="<%=ddNew.getD_count()%>">
						<tr>
							<td>當日拒單
							<td><input class="w3-input" type="text" disabled value="<%=ddNew.getD_discount()%>">
						<tr>
							<td>當日收入
							<td><input class="w3-input" type="text" disabled value="<%=ddNew.getDailyincome()%>">
					</table>
					<h4 align="center">更新完成</h4>
				</form>
			</div>

			<br />
			<br />


		</body>

		</html>