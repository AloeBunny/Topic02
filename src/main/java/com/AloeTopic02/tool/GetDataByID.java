package com.AloeTopic02.tool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework.bean.EmpBean;

/**
 * Servlet implementation class GetEmpByName
 */
@WebServlet("/GetDataByID")
public class GetDataByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String empno = request.getParameter("empno");
		String url = "jdbc:sqlserver://localhost:1433;databaseName = DeliveryRunner;trustServerCertificate = true";
		
		try {
			Class.forName(JDBC_Driver);
			
			conn=DriverManager.getConnection(url,"sa","passw0rd");
			String sql ="select * from employee where empno = ?";
			
			PreparedStatement preState = conn.prepareStatement(sql);
			preState.setString(1,empno);
			
			ResultSet rs = preState.executeQuery();
			EmpBean emp = new EmpBean();
			
			if(rs.next()) {
				emp.setEmpno(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("deptno"));
				emp.setTitle(rs.getString("title"));
			}
			request.setAttribute("emp", emp);
			//setAttribute(String name, Object name)，將物件(資訊)存入request中，關係到你關聯的jsp:usebean裡面的id宣告甚麼
			rs.close();
			preState.close();
			
//			response.getWriter().append("Served at: ").append(request.getContextPath());
			request.getRequestDispatcher("/tool/GetEmp.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
