package com.hp.util;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
public static void main(String[] args) throws SQLException {
	DBHelper db=new DBHelper();
	System.out.println(db.getConn());
}
}
