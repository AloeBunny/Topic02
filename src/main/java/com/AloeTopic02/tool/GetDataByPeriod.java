package com.AloeTopic02.tool;

import com.AloeTopic02.bean.FullBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



@WebServlet("/GetDataByPeriod")
public class GetDataByPeriod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String d_pid = request.getParameter("d_pid");
		String insertdate1 = request.getParameter("insertdate1"); 
		System.out.println(insertdate1);
		String insertdate2 = request.getParameter("insertdate2"); 
		System.out.println(insertdate2);

	
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/DeliveryRunner");
			conn = ds.getConnection();


			String sql ="select dd_id, d_pid, p_name, insertdate, worktime, d_count, d_discount, dailyincome \r\n"
					+ "from D_platform dp \r\n"
					+ "join DeliveryData d on d.d_pid = dp.p_id \r\n"
					+ "where insertdate BETWEEN ? AND ? and users_id=1 and d_pid=? "
					+ "order by insertdate ;";
			
			PreparedStatement preState = conn.prepareStatement(sql);
			preState.setString(1,insertdate1);
			System.out.println(insertdate1);
			preState.setString(2,insertdate2);
			System.out.println(insertdate2);
			preState.setString(3,d_pid);
			
			ResultSet rs = preState.executeQuery();
			List<FullBean> alls = new ArrayList<>();
			FullBean all = null;
			
			while(rs.next()) {
				all = new FullBean();
				
				all.setDd_id(rs.getString("dd_id"));
				all.setD_pid(rs.getString("d_pid"));
				all.setP_name(rs.getString("p_name"));
				all.setInsertdate(rs.getString("insertdate"));
				all.setWorktime(rs.getString("worktime"));
				all.setD_count(rs.getString("d_count"));
				all.setD_discount(rs.getString("d_discount"));
				all.setDailyincome(rs.getString("dailyincome"));
				alls.add(all);
			}
			request.setAttribute("alls", alls);
			//setAttribute(String name, Object name)，將物件(資訊)存入request中，關係到你關聯的jsp:usebean裡面的id宣告甚麼
			rs.close();
			preState.close();
			
//			response.getWriter().append("Served at: ").append(request.getContextPath());
			request.getRequestDispatcher("/tool/GetDataByPeriod.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

