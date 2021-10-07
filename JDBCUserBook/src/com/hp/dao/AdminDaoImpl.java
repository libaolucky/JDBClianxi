package com.hp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hp.entity.Admin;
import com.hp.util.DBHelper;

public class AdminDaoImpl implements AdminDao{

	//µÇÂ¼
	public Admin login(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Admin admin = null;
		try {
			conn = DBHelper.getConn();
			String sql = "select * from admin where username=? and password=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			while(rs.next()){
				admin = new Admin(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(rs, pstm, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return admin;
	}

	//×¢²á
	public int regist(Admin admin) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		int i = 0;
		try {
			conn = DBHelper.getConn();
			String sql = "insert into admin(username,password) values(?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, admin.getUsername());
			pstm.setString(2, admin.getPassword());
			i = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(pstm, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

}
