package com.hp.dao;

import com.hp.entity.Admin;

public interface AdminDao {
	//��¼
	Admin login(String username,String password);
	//ע��
	int regist(Admin admin);
}
