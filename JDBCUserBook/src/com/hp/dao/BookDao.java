package com.hp.dao;

import java.util.ArrayList;

import com.hp.entity.Book;

public interface BookDao {
	//��ѯ����ͼ����Ϣ
	ArrayList<Book> selectAllBook();
	//ɾ��һ��ͼ�� ||����idɾ��
	int deleteBook(int id);
	//�޸�һ��ͼ����Ϣ
	int updateBook(Book book);
	//���һ��ͼ��
	int addBook(Book book);
}
