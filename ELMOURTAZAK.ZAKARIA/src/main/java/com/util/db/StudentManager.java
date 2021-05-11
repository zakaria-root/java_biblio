package com.util.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class StudentManager {
	
	public int addStudent(Student s) {
		int nb = 0;

		try {
			DBInteraction.connect();
			nb = DBInteraction.edite("insert into students (login, password, role) values('" + s.getLogin() + "', '"
					+ s.getPassword() + "','" + s.getRole() + "' )");
			DBInteraction.disconnect();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}
	
	public Student authentification(String log, String pass)
	{
		Student s=null;
		try {
			DBInteraction.connect();
			ResultSet rs = DBInteraction.select("select * from students where login='"+log+"' and password='"+pass+"'");
			if(rs.next())
			{
				s=new Student();
				s.setId(rs.getInt(1));
				s.setLogin(rs.getString(2));
				s.setPassword(rs.getString(3));
				s.setRole(rs.getString(4));
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return s;
		
	}
	
	public List<Student> allStudent() {
		List<Student> ab = new ArrayList<Student>();
		try {
			DBInteraction.connect();
			String sql = "select * from students ";
			ResultSet rs = DBInteraction.select(sql);
			while (rs.next()) {
				Student b = new Student();
			b.setId(rs.getInt(1));
			b.setLogin(rs.getString(2));
			b.setPassword(rs.getString(3));
			b.setRole(rs.getString(4));
			ab.add(b);
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ab;
		
	}

	
	public int deleteStudent(int id) {
		int nb = 0;

		try {
			DBInteraction.connect();
			nb = DBInteraction.edite("delete from students where id=" + id);
			DBInteraction.disconnect();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}
	
}
