package com.weikun.dao;

import com.weikun.db.DB;
import com.weikun.vo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDAOImpl implements IUserDAO {

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		String sql="select id from user where username=? and password=?";
		boolean flag=false;
		Connection conn=DB.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());			
			rs=pstmt.executeQuery();
			if(rs.next()){
				flag=true;
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
			DB.closeConnection();
		}	
		
		
		return flag;
	}

	@Override
	public List<User> query() {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<User>();
		Connection conn=DB.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from user order by id desc";
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setId(rs.getInt("id"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));				
				user.setBirth(rs.getString("birth"));				
				list.add(user);				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
			DB.closeConnection();
		}
		return list;
	}

	@Override
	public boolean del(User user) {
		// TODO Auto-generated method stub
		
		
		Connection conn=DB.getConnection();
		PreparedStatement pstmt=null;
		boolean flag=false;
		try {
			String sql="delete from user where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			flag=pstmt.executeUpdate()>0?true:false;
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
			DB.closeConnection();
		}
		return flag;
	}

}
