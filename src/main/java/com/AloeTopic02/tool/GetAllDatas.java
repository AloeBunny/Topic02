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

import com.AloeTopic02.bean.DeliveryDataBean;

@WebServlet("/GetAllDatas")
public class GetAllDatas extends HttpServlet {
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
			String sql = "select d_pid, insertdate, worktime, d_count, d_discount, dailyincome  from DeliveryData where users_id=1;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<DeliveryDataBean> ddbs =new ArrayList<>();
			DeliveryDataBean ddb = null;
//			EmpBean emp = new EmpBean();
			while(rs.next()) {
				ddb=new DeliveryDataBean();
				ddb.setD_pid(rs.getString("d_pid"));
				ddb.setInsertdate(rs.getString("insertdate"));
				ddb.setWorktime(rs.getString("worktime"));
				ddb.setD_count(rs.getString("d_count"));
				ddb.setD_discount(rs.getString("d_discount"));
				ddb.setDailyincome(rs.getString("dailyincome"));
				ddbs.add(ddb);
			}
			request.setAttribute("ddbs", ddbs);
			rs.close();
			stmt.close();
			
			request.getRequestDispatcher("/tool/GetAllDatas.jsp").forward(request, response);
	

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
