package com.AloeTopic02.tool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AloeTopic02.bean.FullBean;

@WebServlet("/GetAllDatasJoinOn")
public class GetAllDatasJoinOn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url = "jdbc:sqlserver://localhost:1433;databaseName = DeliveryRunner;trustServerCertificate = true";
	private static final String ID = "sa";
	private static final String PASSWORD = "passw0rd";
	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		try {

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(url,ID ,PASSWORD );
			String sql = "select d_pid, p_name, insertdate, worktime, d_count, d_discount, dailyincome\r\n"
					+ "from D_platform dp\r\n"
					+ "join DeliveryData dd\r\n"
					+ "on dp.p_id = dd.d_pid\r\n"
					+ "where users_id=1;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			List<FullBean> alls = new ArrayList<>();

			FullBean all = null;

			while(rs.next()) {
				all = new FullBean();
				
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
			
			rs.close();
			stmt.close();
			
			request.getRequestDispatcher("/tool/GetAllDatasJoinOn.jsp").forward(request, response);
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
