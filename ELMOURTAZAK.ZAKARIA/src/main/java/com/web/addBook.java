package com.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.db.Book;
import com.util.db.BookManager;

/**
 * Servlet implementation class addBook
 */
@WebServlet("/addBook")
public class addBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BookManager bm ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		bm =new BookManager();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String categorie = request.getParameter("categorie");
		String author = request.getParameter("author");

		Book b = null;
		if (!name.isEmpty() && !categorie.isEmpty() && !author.isEmpty()) {
			b = new Book(name, categorie, author);
			bm.addBook(b);
			response.sendRedirect("booksHandling.jsp?res=succ");
		} else {
			response.sendRedirect("addBook?res=err");
		}

		
	}

}
