package com.AloeTopic02.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.AloeTopic02.bean.D_platformBean;
import com.AloeTopic02.bean.DeliveryDataBean01;
import com.AloeTopic02.bean.MemberBean;

public class DeliveryDao {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	Connection conn;

	public void createConnection() throws Exception {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:sqlserver://localhost:1433;databaseName = DeliveryRunner;trustServerCertificate = true";

		this.conn = DriverManager.getConnection(url, "sa", "passw0rd");

		boolean status = !conn.isClosed();

		if (status) {
			System.out.println("連線開啟");
		}
	}

	public void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();
			System.out.println("關閉連線");
		}
	}

////	現在開始寫member表格區
	// "insert into member(m_account, m_password, nickname)values( ?, ?, ?);"
	public void addMember(MemberBean m) throws SQLException {
		String sql = "insert into member(m_account, m_password, nickname)\r\n" + "values( ?, ?, ?);";
		PreparedStatement preState = conn.prepareStatement(sql);

		preState.setString(1, m.getM_account());
		preState.setString(2, m.getM_password());
		preState.setString(3, m.getNickname());

		preState.executeUpdate();
		preState.close();
		System.out.println("新增資料完成");
	}

//	"delete DeliveryData 
//	from member a 
//	inner join DeliveryData b 
//	on a.m_id = b.users_id where m_account = 'String';
//	go
//	delete member where m_account = 'CancanSha';"

	public void delMember(String m_account) throws SQLException {
		String sql = "delete DeliveryData \r\n" + "from member a \r\n" + "inner join DeliveryData b \r\n"
				+ "on a.m_id = b.users_id where m_account = ?;\r\n" + "go\r\n" + "delete member where m_account = ?;";
		PreparedStatement preState = conn.prepareStatement(sql);

		preState.setString(1, m_account);
		int row = preState.executeUpdate();
		System.out.println("已刪除" + row + "筆資料");

		preState.close();

	}

//	--修改會員資料，要先取得這筆資料的ID，方便鎖住ID讓使用者修改其他資料
//	select m_id from member where m_account=?;
//	update member set m_account=?, m_password=?, nickname=? where m_id=?;
	
	

//	--查詢會員資料，應該是要用在後台
//	select m_account, nickname from member where m_account=? or nickname=?;
	
//	--查詢會員總表
//	select* from member;
	public List<MemberBean> findMember() throws SQLException{
		String sql = "select* from member;";
		PreparedStatement preState = conn.prepareStatement(sql);
		ResultSet rs = preState.executeQuery();
		
		List<MemberBean> list = new ArrayList<MemberBean>();
		
		while(rs.next()) {
			MemberBean mb = new MemberBean();
			mb.setM_id(rs.getInt("m_id"));
			mb.setM_account(rs.getString("m_account"));
			mb.setM_password(rs.getString("m_password"));
			mb.setNickname(rs.getString("nickname"));
			
			list.add(mb);
			
		}
		rs.close();
		
		preState.close();
		
		return list;
	}
	

////	現在開始寫D_platform表格區

//	--新增平台名稱
//	insert into D_platform
//	values('String');

	public void addD_platform(D_platformBean d) throws SQLException {

		String sql = "insert into D_platform values(?);";
		PreparedStatement preState = conn.prepareStatement(sql);

		preState.setString(1, d.getP_name());

		preState.executeUpdate();
		preState.close();
		System.out.println("新增資料完成");

	}

//
//	--刪除平台名稱，應該是後台功能
//	delete D_platform where p_name=?;

	public void delD_platform(String p_name) throws SQLException {
		String sql = "delete D_platform where p_name=?";
		PreparedStatement preState = conn.prepareStatement(sql);

		preState.setString(1, p_name);
		int row = preState.executeUpdate();
		System.out.println("已刪除" + row + "筆資料");

		preState.close();

	}

//
//	--修改平台名稱，應該也是後台功能
//	update D_platform set p_name=? where p_id=?;

//
//	--查詢平台ID
//	select p_id from D_platform where p_name = ?;
	
	public D_platformBean findD_platformID(String p_name) throws SQLException {
		String sql = "select p_id from D_platform where p_name = ?;";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, p_name);
		
		ResultSet rs = preState.executeQuery();
		
		if(rs.next()) {
			D_platformBean dpb1 =  new D_platformBean();
			dpb1.setP_id(rs.getInt("p_id"));
			dpb1.setP_name(rs.getString("p_name"));
			
			
			rs.close();
			preState.close();
			return dpb1;
			
			
		}else {
			rs.close();
			preState.close();
			return null;
		}
		
		
		
	}

//	--叫出完整平台表格
//	select * from D_platform;

	public List<D_platformBean> findD_platform() throws SQLException {
		String sql = "select * from D_platform";
		PreparedStatement preState = conn.prepareStatement(sql);
		
		ResultSet rs = preState.executeQuery();

		List<D_platformBean> list = new ArrayList<D_platformBean>();

		while (rs.next()) {
			D_platformBean db = new D_platformBean();
			db.setP_id(rs.getInt("p_id"));
			db.setP_name(rs.getString("p_name"));

			list.add(db);

		}
		rs.close();
		preState.close();

		return list;
	}

//// DeliveryData

//	--1.新增跑單紀錄
//	insert into DeliveryData (users_id, d_pid, insertdate, worktime, d_count, d_discount, dailyincome)
//	values('int', 'int', 'date', 'float', 'int', 'int', 'float');

	public void addDeliveryData(DeliveryDataBean01 ddb) throws SQLException {
		String sql = "insert into DeliveryData (users_id, d_pid, insertdate, worktime, d_count, d_discount, dailyincome)\r\n"
				+ "values(?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement preState = conn.prepareStatement(sql);

		preState.setInt(1, ddb.getUsers_id());
		preState.setInt(1, ddb.getD_pid());
		preState.setDate(1, ddb.getInsertdate());
		preState.setFloat(1, ddb.getWorktime());
		preState.setInt(1, ddb.getD_count());
		preState.setInt(1, ddb.getD_discount());
		preState.setFloat(1, ddb.getDailyincome());

		preState.executeUpdate();
		preState.close();
		System.out.println("新增資料完成");

	}

//	
//	--查詢跑單紀錄總表
//	select*from DeliveryData where users_id=? and d_pid=?;
	
	public List<DeliveryDataBean01> findAllDeliveryData(int user_id, int d_pid) throws SQLException{
		String sql = "select*from DeliveryData where users_id=? and d_pid=?;";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, user_id);
		preState.setInt(2, d_pid);
		
		
		ResultSet rs = preState.executeQuery();
		
		List<DeliveryDataBean01> list = new ArrayList<DeliveryDataBean01>();
		
		while (rs.next()) {
			DeliveryDataBean01 ddb1 = new DeliveryDataBean01();
			ddb1.setDd_id(rs.getInt("dd_id"));
			ddb1.setUsers_id(rs.getInt("users_id"));
			ddb1.setD_pid(rs.getInt("d_pid"));
			ddb1.setWorktime(rs.getFloat("worktime"));
			ddb1.setInsertdate(rs.getDate("insertdate"));
			ddb1.setD_count(rs.getInt("d_count"));
			ddb1.setD_discount(rs.getInt("d_discount"));
			
			list.add(ddb1);
		}
		rs.close();
		preState.close();
		
		
		return list;
	}
	
	

//
//	--查詢期間跑單紀錄
//	select*from DeliveryData where [insertdate] BETWEEN '2022-01-01' AND '2022-01-04' and users_id=1 and d_pid=1;
	
	public List<DeliveryDataBean01> findWeeklyDData(DeliveryDataBean01 ddb) throws SQLException{

		String sql = "select*from DeliveryData where [insertdate] BETWEEN ? AND ? and users_id= ? and d_pid= ?;";
		PreparedStatement preState = conn.prepareStatement(sql);
		
		preState.setDate(1, ddb.getInsertdate());
		preState.setDate(2, ddb.getInsertdate());
		preState.setInt(3, ddb.getUsers_id());
		preState.setInt(4, ddb.getD_pid());
		
		
		
		ResultSet rs = preState.executeQuery();
		
		List<DeliveryDataBean01> list = new ArrayList<DeliveryDataBean01>();
		
		while (rs.next()) {
			DeliveryDataBean01 ddb1 = new DeliveryDataBean01();
			ddb1.setDd_id(rs.getInt("dd_id"));
			ddb1.setUsers_id(rs.getInt("users_id"));
			ddb1.setD_pid(rs.getInt("d_pid"));
			ddb1.setWorktime(rs.getFloat("worktime"));
			ddb1.setInsertdate(rs.getDate("insertdate"));
			ddb1.setD_count(rs.getInt("d_count"));
			ddb1.setD_discount(rs.getInt("d_discount"));
			
			list.add(ddb1);
		}
		rs.close();
		preState.close();
		
		
		return list;
	}
	
	
//
//	--查詢期間每小時均單量
//	--計算方式：日期A與日期B之間的單量+拒單量(也就是總單量)/期間工作時數加總
//	select convert(decimal(5,2),(sum(d_count)+sum(d_discount))/sum(worktime)) as '均單量' from DeliveryData where [insertdate] BETWEEN '2022-01-01' AND '2022-01-04' and users_id=1 and d_pid=1;
//
//	--查詢期間時薪
//	select convert(decimal(5,2), sum(dailyincome)/sum(worktime)) as '時薪' from DeliveryData where [insertdate] BETWEEN '2022-01-01' AND '2022-01-04' and users_id=1 and d_pid=1;
//
//	--查詢期間總金額
//	select sum(dailyincome) as '期間總收入' from DeliveryData where [insertdate] BETWEEN '2022-01-01' AND '2022-01-04' and users_id=1 and d_pid=1;

//	--刪除跑單紀錄-利用日期與平台搜索並刪除
//	delete DeliveryData where  users_id=1 and insertdate='2022-01-01' and d_pid=1;
	
	

//
//	--供使用者刪除整個平台的資料
//	delete DeliveryData where users_id=4 and d_pid=2;
	
	
	
//
//	--修改跑單紀錄
//	update DeliveryData set  worktime=3.5   where users_id=1 and insertdate='2022-01-02' and d_pid=2;

}
