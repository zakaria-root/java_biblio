package com.util.db;

public class Book {

	int id;
	String name;
	String categorie;
	String author;

	public Book() {
	}

	public Book(String name, String categorie, String author) {
		super();
		this.name = name;
		this.categorie = categorie;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", categorie=" + categorie + ", author=" + author + "]";
	}

}
