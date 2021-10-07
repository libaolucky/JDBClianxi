package com.hp.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.hp.dao.AdminDao;
import com.hp.dao.AdminDaoImpl;
import com.hp.dao.BookDao;
import com.hp.dao.BookDaoImpl;
import com.hp.entity.Admin;
import com.hp.entity.Book;

public class View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminDao dao = new AdminDaoImpl();
		
		System.out.println("--------欢迎来到xxx系统--------");
		System.out.println("请选择 1.登录 2.注册");
		int select = sc.nextInt();
		if(select==1){
			//用户选择了登录
			//请输入用户名
			System.out.println("请输入用户名");
			String username = sc.next();
			//请输入密码
			System.out.println("请输入密码");
			String password = sc.next();
			//调用登录的方法 从数据库中查找 返回一个对象
			Admin admin = dao.login(username, password);
			if(admin!=null){
				//用户存在
				System.out.println("欢迎你，登录成功");
				//登录成功后进入该系统 可以进行一下操作
				BookDao bookdao = new BookDaoImpl();
				while(true){
					System.out.println("请选择 1.查询所有信息 2.删除 3.修改  4.添加 5.退出");
					int a = sc.nextInt();
					if(a==1){
						//用户选择了查询 调用查询所用到的方法
						ArrayList<Book> books = bookdao.selectAllBook();
						for (Book book : books) {
							System.out.println(book);
						}
					}else if(a==2){
						//用户选择了删除
						System.out.println("请输入要删除的书的id");
						int id = sc.nextInt();
						int i = bookdao.deleteBook(id);
						if(i>0){
							System.out.println("删除成功");
						}else{
							System.out.println("删除失败");
						}
					}else if(a==3){
						//用户选择了修改
						System.out.println("请输入要修改的书的id");
						int id = sc.nextInt();
						System.out.println("请输入修改后的书名");
						String bname = sc.next();
						System.out.println("请输入要修改后的价钱");
						double bprice = sc.nextDouble();
						System.out.println("请输入要修改后的作者");
						String bauthor = sc.next();
						Book book = new Book(id,bname,bprice,bauthor);
						int i = bookdao.updateBook(book);
						if(i>0){
							System.out.println("修改成功");
						}else{
							System.out.println("修改失败");
						}
					}else if(a==4){
						//用户选择了添加
						System.out.println("请输入要添加的书名");
						String bname = sc.next();
						System.out.println("请输入要添加的书的价钱");
						double bprice = sc.nextDouble();
						System.out.println("请输入要添加的书的作者");
						String bauthor = sc.next();
						Book book = new Book(bname,bprice,bauthor);
						int i = bookdao.addBook(book);
						if(i>0){
							System.out.println("添加成功");
						}else{
							System.out.println("添加失败");
						}
					}else if(a==5){
						//用户选择了退出
						break;
					}else{
						//用户没有输入1-5之间的数字
						System.out.println("输入范围有误，请输入1-5之间的数字");
					}
				}
			}else{
				//用户不存在
				System.out.println("你输入的用户名密码有误");
			}
		}else if(select==2){
			//用户选择了注册
			System.out.println("请设置用户名");
			String username = sc.next();
			System.out.println("请设置密码");
			String password = sc.next();
			//创建一个对象 接收用户输入的信息 将这个对象添加至数据库中 调用注册方法
			Admin admin = new Admin(username,password);
			int i = dao.regist(admin);
			if(i>0){
				//数据库有返回消息
				System.out.println("注册成功");
			}else{
				//数据库无返回消息
				System.out.println("注册失败");
			}
		}else{
			//没有输入1和2
			System.out.println("输入数字有误，请输入1或者2");
		}

	}
}
