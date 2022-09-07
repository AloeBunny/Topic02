package com.AloeTopic02.tools;

import java.sql.SQLException;

import com.AloeTopic02.bean.MemberBean;

public class DeliveryActTest {

	public static void main(String[] args) {
		MemberBean m =new MemberBean("abcde","12345","whoknows");
		
		DeliveryDao dao = new DeliveryDao();
		
		try {
			dao.createConnection();
			dao.addMember(m);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dao.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
