package com.monty.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.monty.db.Db;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=Db.get_connection();
		java.sql.PreparedStatement pw1=null;
		ResultSet rs=null;
		try {
			pw1=conn.prepareStatement("select * from user where id=? and password=?");
			pw1.setInt(1, 1);
			pw1.setString(2, "1997");
			rs=pw1.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next()) {
				System.out.println(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			pw1.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
