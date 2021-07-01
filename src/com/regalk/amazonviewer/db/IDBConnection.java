package com.regalk.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.regalk.amazonviewer.db.DataBase.*;

public interface IDBConnection {
	
	default Connection connectToDB() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB, USER, PASSWORD);
			if (connection != null) {
				System.out.println("Connection stable");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return connection;
		}
	}
}
