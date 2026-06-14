package com.database;

import java.sql.SQLException;

public class DemoRunner {
	public static void main(String[] args) throws SQLException {
		
		for(int i=1; i<=1000; i++) {
		DatabaseManager.createConnection();
		DatabaseManager.createConnection();
		DatabaseManager.createConnection();
		DatabaseManager.createConnection();
	}

}
}