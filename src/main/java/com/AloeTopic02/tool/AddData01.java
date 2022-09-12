package com.AloeTopic02.tool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AloeTopic02.bean.DeliveryDataBean01;

//import com.homework.bean.EmpBean;

@WebServlet("/AddData01")
public class AddData01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "jdbc:sqlserver://localhost:1433;databaseName = DeliveryRunner;trustServerCertificate = true";
		int dd_id = Integer.parseInt(request.getParameter("dd_id"));
		int users_id =  Integer.parseInt(request.getParameter("users_id"));
		int d_pid =  Integer.parseInt(request.getParameter("d_pid"));
		float worktime = Float.parseFloat(request.getParameter("worktime"));
		String insertday = request.getParameter("insertdate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date insertdate = null;
		try {
			insertdate = (Date) sdf.parse(insertday);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Integer d_count = Integer.parseInt(request.getParameter("d_count"));
		Integer d_discount = Integer.parseInt(request.getParameter("d_discount"));
		float dailyincome = Float.parseFloat(request.getParameter("dailyincome"));

		try {

			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(url, "sa", "passw0rd");
			String sql =  "insert into DeliveryData (users_id, d_pid, insertdate, worktime, d_count, d_discount, dailyincome)\r\n"
					+ "values(1, ?, ?, ?, ?, ?, ?);";
			//先把使用者寫死在這邊
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, d_pid);
			stmt.setDate(2, insertdate);
			stmt.setFloat(3, worktime);
			stmt.setInt(4, d_count);
			stmt.setInt(5, d_discount);
			stmt.setFloat(6, dailyincome);

			DeliveryDataBean01 ddb = new DeliveryDataBean01();
			
			ddb.setD_pid(d_pid);
			ddb.setWorktime(worktime);
			ddb.setInsertdate(insertdate);
			ddb.setD_count(d_count);
			ddb.setD_discount(d_discount);
			ddb.setDailyincome(dailyincome);
			
			request.setAttribute("ddb", ddb);

			stmt.executeUpdate();
			stmt.close();
			request.getRequestDispatcher("/tool/InsertedData.jsp").forward(request, response);
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
