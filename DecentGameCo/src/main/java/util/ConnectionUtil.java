package util;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ConnectionUtil {

	public static Connection getConnection(String filename) throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
	}
	
}


