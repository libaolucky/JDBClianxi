package com.hp.dao;

import com.hp.entity.Admin;

public interface AdminDao {
	//µÇÂ¼
	Admin login(String username,String password);
	//×¢²á
	int regist(Admin admin);
}
