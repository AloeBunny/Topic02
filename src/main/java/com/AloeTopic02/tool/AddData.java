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

import com.AloeTopic02.bean.DeliveryDataBean;

//import com.homework.bean.EmpBean;

@WebServlet("/AddData")
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "jdbc:sqlserver://localhost:1433;databaseName = DeliveryRunner;trustServerCertificate = true";
		String d_pid = String.valueOf(request.getParameter("d_pid"));
		String insertdate = String.valueOf(request.getParameter("insertdate"));
		String worktime = (request.getParameter("worktime"));
		String d_count =(request.getParameter("d_count"));
		String d_discount = (request.getParameter("d_discount"));
		String dailyincome = request.getParameter("dailyincome");
		try {

			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(url, "sa", "passw0rd");
			String sql =  "insert into DeliveryData (users_id, d_pid, insertdate, worktime, d_count, d_discount, dailyincome)\r\n"
					+ "values(1, ?, ?, ?, ?, ?, ?);";
			//先把使用者寫死在這邊
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, d_pid);
			stmt.setString(2, insertdate);
			stmt.setString(3, worktime);
			stmt.setString(4, d_count);
			stmt.setString(5, d_discount);
			stmt.setString(6, dailyincome);

			DeliveryDataBean ddb = new DeliveryDataBean();
			
			ddb.setD_pid(d_pid);
			ddb.setInsertdate(insertdate);
			ddb.setWorktime(worktime);
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
