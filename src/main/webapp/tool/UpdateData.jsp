<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

		<body style="background-color:#fdf5e6">
			<div align="center">
				<h2>外送資料</h2>
				<jsp:useBean id="ddb" scope="request" class="com.AloeTopic02.bean.DeliveryDataBean" />
				<form action="http://localhost:8080/Topic02/Update">
					<table>
						<tr style="display:none">
							<td>id
							<td><input type="text" value="${ddb.dd_id }" name="dd_idNew">
						<tr>
							<td>平台代碼
							<td><select name="d_pidNew">
									<option value=" " disabled selected>請選擇</option>
									<option <c:if test="${ddb.d_pid=='1'}">selected</c:if> value="1">FoodPanda</option>
									<option <c:if test="${ddb.d_pid=='2'}">selected</c:if> value="2">uberEat</option>
									<option <c:if test="${ddb.d_pid=='3'}">selected</c:if> value="3">LaLaMove</option>
									<option <c:if test="${ddb.d_pid=='4'}">selected</c:if> value="4">Pickupp</option>
									<option <c:if test="${ddb.d_pid=='5'}">selected</c:if> value="5">GlobalExpress
									</option>
								</select>
								<!--<input type="text" readonly value="${ddb.d_pid}" name="d_pidNew">-->
						<tr>
							<td>資料日期
							<td><input type="text" value="${ddb.insertdate }" name="insertdateNew">
						<tr>
							<td>工作時數
							<td><input type="text" value="${ddb.worktime}" name="worktimeNew">
						<tr>
							<td>當日取單
							<td><input type="text" value="${ddb.d_count}" name="d_countNew">
						<tr>
							<td>當日拒單
							<td><input type="text" value="${ddb.d_discount }" name="d_discountNew">
						<tr>
							<td>當日收入
							<td><input type="text" value="${ddb.dailyincome }" name="dailyincomeNew">


					</table>
					<input type="submit" value="修改" />
				</form>
			</div>

			<br />
			<br />
			<h3 align="center"><a href="http://localhost:8080/Topic02/tool/HomePage.html">回首頁</a></h3>

		</body>

		</html>