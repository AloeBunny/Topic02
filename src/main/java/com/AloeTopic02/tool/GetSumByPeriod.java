package com.AloeTopic02.tool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.AloeTopic02.bean.DeliveryDataBean;


@WebServlet("/GetSumByPeriod")
public class GetSumByPeriod extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection conn;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String insertdate1 = request.getParameter("insertdate1"); 
		System.out.println(insertdate1);
		String insertdate2 = request.getParameter("insertdate2"); 
		System.out.println(insertdate2);
		String d_pid = request.getParameter("d_pid");
		
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/DeliveryRunner");
			conn = ds.getConnection();
			
			String sql = "select sum(worktime) Sworktime, sum(d_count) Sd_count, sum(d_discount) Sd_discount, sum(dailyincome) Sdailyincome \r\n"
					+ "from DeliveryData \r\n"
					+ "where users_id=1 and insertdate between ? and ? and d_pid= ? ;";
			
			PreparedStatement pest = conn.prepareStatement(sql);
			pest.setString(1,insertdate1);
			System.out.println(insertdate1);
			pest.setString(2,insertdate2);
			System.out.println(insertdate2);
			pest.setString(3,d_pid);
			
			ResultSet rs = pest.executeQuery();
			DeliveryDataBean ddb1 = new DeliveryDataBean();
			
			if(rs.next()) {
				ddb1.setD_pid(d_pid);
			ddb1.setWorktime(rs.getString("Sworktime"));
			ddb1.setD_count(rs.getString("Sd_count"));
			ddb1.setD_discount(rs.getString("Sd_discount"));
			ddb1.setDailyincome(rs.getString("Sdailyincome"));
			}
			request.setAttribute("ddb1", ddb1);
			
			request.getRequestDispatcher("/tool/GetSumByPeriod.jsp").forward(request, response);
			
			pest.close();
			
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
