<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.sql.*, com.homework.bean.EmpBean"%>
  <% Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); %>  
 <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>員 工 資 料</title>
</head>
<body style="background color:#fdf5e6">
<div align="center">
<h2>員 工 資 料</h2>
<%
	Connection connection = DriverManager.getConnection(
			"jdbc:sqlserver://localhost:1433;databaseName = servdb;trustServerCertificate = true",
			"sa", "passw0rd");

    Statement statement = connection.createStatement();
    String query = "select empno, ename, hiredate, salary, dname, title\r\n"
			+ "from employee m \r\n"
			+ "join department d on m.deptno = d.deptno;";

    ResultSet resultset = 
        statement.executeQuery(query) ; 

%>

<table border="1">
<tr style="background-color:#a8fefa">
<th>員工編號<th>姓名<th>到職日<th>薪水<th>部門編號<th>職稱<th>修改<th>刪除

<% List<EmpBean> emps =(ArrayList<EmpBean>)request.getAttribute("emps"); %>
<% for(EmpBean emp : emps) {%>
<tr><td><%= emp.getEmpno() %>
<td><%= emp.getEname() %>
<td><%= emp.getHiredate() %>
<td><%= emp.getSalary() %>
<td><%= emp.getDeptno() %>
<td><%= emp.getTitle() %>
<td><a href="GetUpdateData?empno=<%= emp.getEmpno() %>">修改</a>
<td><a href="javaScript:if(confirm('你確定要刪除嗎?')){location.href='DeleteEmp?empno=<%= emp.getEmpno() %>'}">刪除</a>

<%} %>
</table>
<h3>一共<%= emps.size() %>筆員工資料</h3>
</div>

    <br/>
    <br/>
    <h3 align="center"><a href="http://localhost:8080/Topic02/tool/HomePage.html">回首頁</a></h3>

</body>
</html>