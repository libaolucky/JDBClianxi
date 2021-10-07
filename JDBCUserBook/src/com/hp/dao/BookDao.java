package com.hp.dao;

import java.util.ArrayList;

import com.hp.entity.Book;

public interface BookDao {
	//查询所有图书信息
	ArrayList<Book> selectAllBook();
	//删除一本图书 ||根据id删除
	int deleteBook(int id);
	//修改一本图书信息
	int updateBook(Book book);
	//添加一本图书
	int addBook(Book book);
}
