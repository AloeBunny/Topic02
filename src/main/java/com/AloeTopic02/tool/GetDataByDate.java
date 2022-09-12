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

import com.AloeTopic02.bean.DeliveryDataBean;

/**
 * Servlet implementation class GetEmpByName
 */
@WebServlet("/GetDataByDate")
public class GetDataByDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String d_pid = request.getParameter("d_pid");
		String insertdate = request.getParameter("insertdate"); 
		String url = "jdbc:sqlserver://localhost:1433;databaseName = DeliveryRunner;trustServerCertificate = true";
		
		try {
			Class.forName(JDBC_Driver);
			
			conn=DriverManager.getConnection(url,"sa","passw0rd");
			String sql ="select * from DeliveryData where users_id = 1 and d_pid= ? and insertdate= ?";
			
			PreparedStatement preState = conn.prepareStatement(sql);
			preState.setString(1,d_pid);
			preState.setString(2,insertdate);
			
			ResultSet rs = preState.executeQuery();
			DeliveryDataBean ddb = new DeliveryDataBean();
			
			if(rs.next()) {
				ddb.setD_pid(rs.getString("d_pid"));
				ddb.setInsertdate(rs.getString("insertdate"));
				ddb.setWorktime(rs.getString("worktime"));
				ddb.setD_count(rs.getString("d_count"));
				ddb.setD_discount(rs.getString("d_discount"));
				ddb.setDailyincome(rs.getString("dailyincome"));
			}
			request.setAttribute("ddb", ddb);
			//setAttribute(String name, Object name)，將物件(資訊)存入request中，關係到你關聯的jsp:usebean裡面的id宣告甚麼
			rs.close();
			preState.close();
			
//			response.getWriter().append("Served at: ").append(request.getContextPath());
			request.getRequestDispatcher("/tool/GetData.jsp").forward(request, response);
			
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
