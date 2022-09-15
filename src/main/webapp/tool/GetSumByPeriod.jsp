<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*, com.AloeTopic02.bean.DeliveryDataBean" %>
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


				<div align="center" class="box" style="margin:0 auto;">
					<h2 align="center">期間外送紀錄</h2>
					<table  border="1">

						<%-- <tr>
							<th style="background-color:#00AEAE" colspan=2>各項數據加總</th>
							<th class="total">0
							<th class="total">0
							<th class="total">0
							<th class="total">0
							<th style="background-color:#00AEAE">取單率</th>
							<th class="cal">0</th>
							</tr>--%>
													<tr>
							<td>平台名稱
							<td><select class="w3-input" name="d_pidNew">
									<option value=" " disabled selected>請選擇</option>
									<option <c:if test="${ddb1.d_pid=='1'}">selected</c:if> value="1">FoodPanda</option>
									<option <c:if test="${ddb1.d_pid=='2'}">selected</c:if> value="2">uberEat</option>
									<option <c:if test="${ddb1.d_pid=='3'}">selected</c:if> value="3">LaLaMove</option>
									<option <c:if test="${ddb1.d_pid=='4'}">selected</c:if> value="4">Pickupp</option>
									<option <c:if test="${ddb1.d_pid=='5'}">selected</c:if> value="5">GlobalExpress
									</option>
								</select>
								<!--<input type="text" readonly value="${ddb.d_pid}" name="d_pidNew">-->
						
							<tr style="background-color:#00AEAE">

							
							
								<th>總工作時數
								<th>期間總接單
								<th>期間總拒單
								<th>期間總收入


									<jsp:useBean id="ddb1" scope="request" class="com.AloeTopic02.bean.DeliveryDataBean" />
							<tr>


								<td>${ddb1.worktime}
								<td>${ddb1.d_count }
								<td>${ddb1.d_discount }
								<td>${ddb1.dailyincome }
							
					</table>


				</div>

				<br />
				<br />



			</body>

			</html>