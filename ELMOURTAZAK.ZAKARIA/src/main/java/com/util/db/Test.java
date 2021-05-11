package com.util.db;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		int nb =0;
		BookManager bm = new BookManager();
		Student s= new Student();
		Book b= new Book("php", "server side language", "sami");
		nb = bm.addBook(b);
		System.out.println(nb + " inserted ...");
		
	}
}
