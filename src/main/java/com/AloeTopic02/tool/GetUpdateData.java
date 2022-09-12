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



@WebServlet("/GetUpdateData")
public class GetUpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String insertdate = request.getParameter("insertdate");
		String d_pid = request.getParameter("d_pid");
		String url = "jdbc:sqlserver://localhost:1433;databaseName = DeliveryRunner;trustServerCertificate = true";

		try {

			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(url, "sa", "passw0rd");
			String sql = "  select dd_id, d_pid, insertdate, worktime, d_count, d_discount, dailyincome from DeliveryData where insertdate = ? and d_pid = ? and users_id=1 ;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, insertdate);
			stmt.setString(2, d_pid);
			ResultSet rs = stmt.executeQuery();
			DeliveryDataBean ddb = new DeliveryDataBean();
			if (rs.next()) {
				ddb.setDd_id(rs.getString("dd_id"));
				ddb.setD_pid(rs.getString("d_pid"));
				ddb.setInsertdate(rs.getString("insertdate"));
				ddb.setWorktime(rs.getString("worktime"));
				ddb.setD_count(rs.getString("d_count"));
				ddb.setD_discount(rs.getString("d_discount"));
				ddb.setDailyincome(rs.getString("dailyincome"));
			}
			request.setAttribute("ddb", ddb);
			rs.close();
			stmt.close();
			request.getRequestDispatcher("/tool/UpdateData.jsp").forward(request, response);
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
