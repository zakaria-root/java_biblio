package com.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInteraction {

	private static Connection con;
	private static Statement st;
	private static String url = "jdbc:mysql://localhost/Biblio";

	public static void connect() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, "root", "1234");
		st = con.createStatement();
	}

	public static int edite(String sql) {
		int nb = 0;
		try {
			nb = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;

	}

	public static ResultSet select(String sql) {
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}

	public static void disconnect() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
