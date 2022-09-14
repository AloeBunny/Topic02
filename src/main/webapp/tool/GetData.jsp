<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>外送資料</title>
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
				background-color: rgba(68, 61, 167, 0.781);
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
				background-color: #aadfca;
				color: rgb(34, 13, 151);
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
			<a href="GetAllDatasJoinOn">查看所有資料</a>
			<a href="http://localhost:8080/Topic02/tool/GetDataByPeriod.html">區間資料查詢</a>
		</div>

		<div class="box container">
			<h2>外送資料</h2>
			<jsp:useBean id="ddb" scope="request" class="com.AloeTopic02.bean.DeliveryDataBean" />
			<table>
				<tr>
					<td>平台代碼
					<td><input class="w3-input" type="text" disabled value="<%=ddb.getD_pid()%>">
				<tr>
					<td>資料日期
					<td><input class="w3-input" type="text" disabled value="<%=ddb.getInsertdate()%>">
				<tr>
					<td>工作時數
					<td><input class="w3-input" type="text" disabled value="<%=ddb.getWorktime()%>">
				<tr>
					<td>當日取單
					<td><input class="w3-input" type="text" disabled value="<%=ddb.getD_count()%>">
				<tr>
					<td>當日拒單
					<td><input class="w3-input" type="text" disabled value="<%=ddb.getD_discount()%>">
				<tr>
					<td>當日收入
					<td><input class="w3-input" type="text" disabled value="<%=ddb.getDailyincome()%>">
			</table>
		</div>

		<br />
		<br />


	</body>

	</html>