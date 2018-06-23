package com.monty.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.monty.db.Db;
import com.monty.domain.User;

public class Userservice {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public boolean checkUser(User user) throws SQLException {
		
		conn=Db.get_connection();
		try {
			ps=conn.prepareStatement("select * from user where id=? and password=?");
			ps.setInt(1, user.getId());
			ps.setString(2, user.getPassword());
			rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps.close();
		rs.close();
		conn.close();
		return false;
	}
	//按照分页获取数据
	public ArrayList<User> fenye(int pagenow,int pagesize) {
		//从数据库中取出用户信息，并显示
				ArrayList<User> a=new ArrayList<>();
				Connection conn=Db.get_connection();
				PreparedStatement ps=null;
				ResultSet rs=null;
				//分页
				int pagecount=1;
				int rowcount=1;
				try {
					//获得rowcount
					ps=conn.prepareStatement("select count(*) from user");
					rs=ps.executeQuery();
					rs.next();
					rowcount=rs.getInt(1);
					pagecount=rowcount%pagesize==0?rowcount/pagesize:rowcount/pagesize+1;
					ps=conn.prepareStatement("select * from user limit "+(pagenow-1)*pagesize+","+pagesize);
					rs=ps.executeQuery();
					while(rs.next()) {
						User u=new User();
						u.setId(rs.getInt(1));
						u.setName(rs.getString(2));
						u.setEmail(rs.getString(3));
						u.setGrade(rs.getInt(4));
						u.setPassword(rs.getString(5));
						a.add(u);
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						rs.close();
						ps.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
					
		return a;
	}
	public int get_pagecount(int pagenow,int pagesize) {
		Connection conn=Db.get_connection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		//分页
		int pagecount=1;
		int rowcount=1;
		try {
			//获得rowcount
			ps=conn.prepareStatement("select count(*) from user");
			rs=ps.executeQuery();
			rs.next();
			rowcount=rs.getInt(1);
			pagecount=rowcount%pagesize==0?rowcount/pagesize:rowcount/pagesize+1;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return pagecount;
	}
	//删除用户
	public boolean deleteuser(int id) {
		Connection conn=Db.get_connection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("delete from user where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
