package com.codewithharman.chatapp.dao;

import static com.codewithharman.chatapp.utils.ConfigReader.getValue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//change class to interface , due to save memory 
//as if we make CommonDAO be class then using objects it consume more memory
// interface can have static members
public interface CommonDAO {
	// creating a function
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		// when we connect it to db then we need a driver , driver is provided by mysql
		// mvnrepostory.com
		// Now loading a class
		// Step 1 : load a Driver
		Class.forName(getValue("DRIVER"));
		// Step 2 : Making a connection & jdbc has only one class i.e DriverManager
		final String CONNECTION_STRING = getValue("CONNECTION_URL");
		final String USER_ID = getValue("USERID");
		final String PASSWORD = getValue("PASSWORD");

		Connection con = DriverManager.getConnection(CONNECTION_STRING, USER_ID, PASSWORD);
		if (con != null) { // connection created
			System.out.println("Connection Created...");
			// P-1 initial - testing....
			// con.close();
		}
		return con;

	}

	// // testing...
	// public static void main(String[] args) throws ClassNotFoundException,
	// SQLException {
	// CommonDAO commonDAO = new CommonDAO();
	// commonDAO.createConnection();
	// }
}
