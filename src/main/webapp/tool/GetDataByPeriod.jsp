<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*, com.AloeTopic02.bean.FullBean" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%! @SuppressWarnings("unchecked") %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>期間外送紀錄</title>
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
						width: 100vw;
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
					<h2 align="center">期間外送紀錄</h2>
					<table class="w3-table" border="1">

						<%-- <tr>
							<th style="background-color:#00AEAE" colspan=2>各項數據加總</th>
							<th class="total">0
							<th class="total">0
							<th class="total">0
							<th class="total">0
							<th style="background-color:#00AEAE">取單率</th>
							<th class="cal">0</th>
							</tr>--%>
							<tr style="background-color:#00AEAE">
								<th>平台名稱
								<th>資料日期
								<th>工作時數
								<th>當日接單
								<th>當日拒單
								<th>當日收入
								<th>修改
								<th>刪除

									<c:forEach items="${alls}" var="all" varStatus="s">
							<tr>
								<td>${all.p_name}
								<td>${all.insertdate }
								<td>${all.worktime}
								<td>${all.d_count }
								<td>${all.d_discount }
								<td>${all.dailyincome }
								<td><a href="GetUpdateData?d_pid=${all.d_pid}&insertdate=${all.insertdate}">修改</a>
								<td><a
										href="javaScript:if(confirm('你確定要刪除嗎?')){location.href='DeleteData?d_pid=${all.d_pid}&insertdate=${all.insertdate}'}">刪除</a>
									<c:set var="count" value="${s.count}" />

									</c:forEach>
					</table>
					<h3>資料期間：
						<c:forEach items="${alls}" var="all" varStatus="s">
							<c:if test="${s.first}">${all.insertdate}到</c:if>
							<c:if test="${s.last}">${all.insertdate}</c:if>
						</c:forEach>
					</h3>
					<h3>一共${count}筆資料</h3>
				</div>

				<br />
				<br />



			</body>

			</html>