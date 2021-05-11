package com.util.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookManager {

	public int addBook(Book b) {
		int nb = 0;

		try {
			DBInteraction.connect();
			nb = DBInteraction.edite("insert into books (name, categorie, author) values('" + b.getName() + "', '"
					+ b.getCategorie() + "','" + b.getAuthor() + "' )");
			DBInteraction.disconnect();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}
	
	public List<Book> allBooksByCategorie(String categorie) {
		List<Book> ab = new ArrayList<Book>();
		try {
			DBInteraction.connect();
			String sql = "select * from books where categorie ='"+categorie+"'";
			ResultSet rs = DBInteraction.select(sql);
			while (rs.next()) {
				Book b = new Book();
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
			b.setCategorie(rs.getString(3));
			b.setAuthor(rs.getString(4));
			ab.add(b);
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ab;
		
	}
	
	public List<Book> allBooksByAuthor(String author) {
		List<Book> ab = new ArrayList<Book>();
		try {
			DBInteraction.connect();
			String sql = "select * from books where author ='"+author+"'";
			ResultSet rs = DBInteraction.select(sql);
			while (rs.next()) {
				Book b = new Book();
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
			b.setCategorie(rs.getString(3));
			b.setAuthor(rs.getString(4));
			ab.add(b);
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ab;
		
	}
	
	public List<Book> allBooks() {
		List<Book> ab = new ArrayList<Book>();
		try {
			DBInteraction.connect();
			String sql = "select * from books ";
			ResultSet rs = DBInteraction.select(sql);
			while (rs.next()) {
				Book b = new Book();
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
			b.setCategorie(rs.getString(3));
			b.setAuthor(rs.getString(4));
			ab.add(b);
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ab;
		
	}
	
	public int deleteBook(int id) {
		int nb = 0;

		try {
			DBInteraction.connect();
			nb = DBInteraction.edite("delete from books where id=" + id);
			DBInteraction.disconnect();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}
	
	public int addBookFromStudent(int student_id ,int book_id) {
		int nb = 0;
		
		try {
			DBInteraction.connect();
			nb = DBInteraction.edite("update books set student_id = "+student_id+" where id=" + book_id);
			DBInteraction.disconnect();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}
	

	public List<Book> allStudentBooks(int id) {
		List<Book> ab = new ArrayList<Book>();
		try {
			DBInteraction.connect();
			String sql = "select * from books where student_id = "+id;
			ResultSet rs = DBInteraction.select(sql);
			while (rs.next()) {
				Book b = new Book();
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
			b.setCategorie(rs.getString(3));
			b.setAuthor(rs.getString(4));
			ab.add(b);
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ab;
		
	}
	
	public int returnBookToBiblio(int id) {
		int nb = 0;
		
		try {
			DBInteraction.connect();
			nb = DBInteraction.edite("update books set student_id = "+null+" where id=" + id);
			DBInteraction.disconnect();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}
	
	public List<Book> allBooksAvailable() {
		List<Book> ab = new ArrayList<Book>();
		try {
			DBInteraction.connect();
			String sql = "select * from books where student_id is "+ null;
			ResultSet rs = DBInteraction.select(sql);
			while (rs.next()) {
				Book b = new Book();
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
			b.setCategorie(rs.getString(3));
			b.setAuthor(rs.getString(4));
			ab.add(b);
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ab;
		
	}
	
	
}
