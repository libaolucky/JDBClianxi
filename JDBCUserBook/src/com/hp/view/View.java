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
		
		System.out.println("--------��ӭ����xxxϵͳ--------");
		System.out.println("��ѡ�� 1.��¼ 2.ע��");
		int select = sc.nextInt();
		if(select==1){
			//�û�ѡ���˵�¼
			//�������û���
			System.out.println("�������û���");
			String username = sc.next();
			//����������
			System.out.println("����������");
			String password = sc.next();
			//���õ�¼�ķ��� �����ݿ��в��� ����һ������
			Admin admin = dao.login(username, password);
			if(admin!=null){
				//�û�����
				System.out.println("��ӭ�㣬��¼�ɹ�");
				//��¼�ɹ�������ϵͳ ���Խ���һ�²���
				BookDao bookdao = new BookDaoImpl();
				while(true){
					System.out.println("��ѡ�� 1.��ѯ������Ϣ 2.ɾ�� 3.�޸�  4.��� 5.�˳�");
					int a = sc.nextInt();
					if(a==1){
						//�û�ѡ���˲�ѯ ���ò�ѯ���õ��ķ���
						ArrayList<Book> books = bookdao.selectAllBook();
						for (Book book : books) {
							System.out.println(book);
						}
					}else if(a==2){
						//�û�ѡ����ɾ��
						System.out.println("������Ҫɾ�������id");
						int id = sc.nextInt();
						int i = bookdao.deleteBook(id);
						if(i>0){
							System.out.println("ɾ���ɹ�");
						}else{
							System.out.println("ɾ��ʧ��");
						}
					}else if(a==3){
						//�û�ѡ�����޸�
						System.out.println("������Ҫ�޸ĵ����id");
						int id = sc.nextInt();
						System.out.println("�������޸ĺ������");
						String bname = sc.next();
						System.out.println("������Ҫ�޸ĺ�ļ�Ǯ");
						double bprice = sc.nextDouble();
						System.out.println("������Ҫ�޸ĺ������");
						String bauthor = sc.next();
						Book book = new Book(id,bname,bprice,bauthor);
						int i = bookdao.updateBook(book);
						if(i>0){
							System.out.println("�޸ĳɹ�");
						}else{
							System.out.println("�޸�ʧ��");
						}
					}else if(a==4){
						//�û�ѡ�������
						System.out.println("������Ҫ��ӵ�����");
						String bname = sc.next();
						System.out.println("������Ҫ��ӵ���ļ�Ǯ");
						double bprice = sc.nextDouble();
						System.out.println("������Ҫ��ӵ��������");
						String bauthor = sc.next();
						Book book = new Book(bname,bprice,bauthor);
						int i = bookdao.addBook(book);
						if(i>0){
							System.out.println("��ӳɹ�");
						}else{
							System.out.println("���ʧ��");
						}
					}else if(a==5){
						//�û�ѡ�����˳�
						break;
					}else{
						//�û�û������1-5֮�������
						System.out.println("���뷶Χ����������1-5֮�������");
					}
				}
			}else{
				//�û�������
				System.out.println("��������û�����������");
			}
		}else if(select==2){
			//�û�ѡ����ע��
			System.out.println("�������û���");
			String username = sc.next();
			System.out.println("����������");
			String password = sc.next();
			//����һ������ �����û��������Ϣ �����������������ݿ��� ����ע�᷽��
			Admin admin = new Admin(username,password);
			int i = dao.regist(admin);
			if(i>0){
				//���ݿ��з�����Ϣ
				System.out.println("ע��ɹ�");
			}else{
				//���ݿ��޷�����Ϣ
				System.out.println("ע��ʧ��");
			}
		}else{
			//û������1��2
			System.out.println("������������������1����2");
		}

	}
}
