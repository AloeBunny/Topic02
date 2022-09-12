package com.AloeTopic02.tool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AloeTopic02.bean.DeliveryDataBean;

@WebServlet("/Update")
public class Update extends HttpServlet {
	/* �s���ܼư� */
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url = "jdbc:sqlserver://localhost:1433;databaseName = DeliveryRunner;trustServerCertificate = true";
	private static final String sql = "update DeliveryData set d_pid=?, insertdate=?, worktime=?,  d_count=?, d_discount=? , dailyincome=? where dd_id=?";

	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* 區域變數區，抓取前面網頁修改時輸入的參數 */
		String d_pidNew = (request.getParameter("d_pidNew"));
		String insertdateNew = request.getParameter("insertdateNew");
		String worktimeNew = (request.getParameter("worktimeNew"));
		String d_countNew = (request.getParameter("d_countNew"));
		String d_discountNew = (request.getParameter("d_discountNew"));
		String dailyincomeNew = request.getParameter("dailyincomeNew");
		String dd_idNew = request.getParameter("dd_idNew");

		try {

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(url, "sa", "passw0rd");

			PreparedStatement stmt = conn.prepareStatement(sql);

			/* 依序填入資料，記得要照問號出現的順序，否則會像我一樣卡半個晚上 */
			stmt.setString(1, d_pidNew);
			stmt.setString(2, insertdateNew);
			stmt.setString(3, worktimeNew);
			stmt.setString(4, d_countNew);
			stmt.setString(5, d_discountNew);
			stmt.setString(6, dailyincomeNew);
			stmt.setInt(7, Integer.parseInt(dd_idNew));
			stmt.executeUpdate();

			/* 用javabern產生實例存放單筆資料 */
			DeliveryDataBean ddNew = new DeliveryDataBean();

			ddNew.setD_pid(d_pidNew);
			ddNew.setInsertdate(insertdateNew);
			ddNew.setWorktime(worktimeNew);
			ddNew.setD_count(d_countNew);
			ddNew.setD_discount(d_discountNew);
			ddNew.setDailyincome(dailyincomeNew);
			

			request.setAttribute("ddNew", ddNew);

			/* 記得，將request用Dispatcher交給下一個程式RUN下去 */
			request.getRequestDispatcher("/tool/Update.jsp").forward(request, response);
			stmt.close();

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
