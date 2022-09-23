package com.AloeTopic02.tool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dd_id = request.getParameter("dd_id");
		String insertdate = request.getParameter("insertdate"); 

		try {

			/*連線囉*/
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/DeliveryRunner");
			conn = ds.getConnection();
			
			
			String sql = "select d_pid, insertdate, worktime, d_count, d_discount, dailyincome from DeliveryData where users_id = 1 and dd_id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,dd_id);
//			stmt.setString(2,insertdate);
			
			ResultSet rs = stmt.executeQuery();
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
			
			
			String sql2 = "delete from DeliveryData where users_id = 1 and dd_id = ?;";
			PreparedStatement stmt2 = conn.prepareStatement(sql2);
			stmt2.setString(1, dd_id);
//			stmt2.setString(2, insertdate);
			stmt2.executeUpdate();
			
			request.getRequestDispatcher("/tool/DeleteData.jsp").forward(request, response);


				stmt.close();

	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
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
