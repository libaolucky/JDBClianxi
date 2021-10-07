package com.hp.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
	//创建文件对象，为了保存小配置文件信息
	private static Properties prop = new Properties();
	static{
		InputStream in = null;
		try {
			//读取小配置文件信息
			in = DBHelper.class.getResourceAsStream("/mysql_jdbc.properties");
			//加载到文件对象中
			prop.load(in);
			//1.加载驱动
			Class.forName(prop.getProperty("driver"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//2.获取链接
	public static Connection getConn() throws SQLException{
		Connection conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
		return conn;
	}
	
	   //3.关闭资源
	public static void close(ResultSet rs,PreparedStatement pstm,Connection conn) throws SQLException{
		if(rs!=null) rs.close();
		if(pstm!=null) pstm.close();
		if(conn!=null) conn.close();
	}
	
	public static void close(PreparedStatement pstm,Connection conn) throws SQLException{
		if(pstm!=null) pstm.close();
		if(conn!=null) conn.close();
	}
}
