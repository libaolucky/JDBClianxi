package com.hp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hp.entity.Admin;
import com.hp.entity.Book;
import com.hp.util.DBHelper;

public class BookDaoImpl implements BookDao{

	//查询所有图书
	public ArrayList<Book> selectAllBook() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Book book = null;
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			conn = DBHelper.getConn();
			String sql = "select * from book";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				book = new Book(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4)
						);
				list.add(book);
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
		return list;
	}

	//删除
	public int deleteBook(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		int i = 0;
		try {
			conn = DBHelper.getConn();
			String sql = "delete from book where id=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
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

	//修改
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		int i = 0;
		try {
			conn = DBHelper.getConn();
			String sql = "update book set bname=?,bprice=?,bauthor=? where id=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, book.getBname());
			pstm.setDouble(2, book.getBprice());
			pstm.setString(3, book.getBauthor());
			pstm.setInt(4, book.getId());
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

	//添加
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		int i = 0;
		try {
			conn = DBHelper.getConn();
			String sql = "insert into book(bname,bprice,bauthor) values(?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,book.getBname());
			pstm.setDouble(2,book.getBprice());
			pstm.setString(3,book.getBauthor());
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
