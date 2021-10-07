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
	//�����ļ�����Ϊ�˱���С�����ļ���Ϣ
	private static Properties prop = new Properties();
	static{
		InputStream in = null;
		try {
			//��ȡС�����ļ���Ϣ
			in = DBHelper.class.getResourceAsStream("/mysql_jdbc.properties");
			//���ص��ļ�������
			prop.load(in);
			//1.��������
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
	
	//2.��ȡ����
	public static Connection getConn() throws SQLException{
		Connection conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
		return conn;
	}
	
	   //3.�ر���Դ
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
