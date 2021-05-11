
<%@page import="com.util.db.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.util.db.BookManager"%>
<%@page import="com.util.db.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script src="js/bootstrap.js"></script>
</head>
<body>
	

	<!-- decalration -->
	<%
	Student s = (Student) session.getAttribute("student");
	BookManager bm = new BookManager();
	%>
	<!-- la suppresion des livres -->
	<%
	if (request.getParameter("op") != null) {
		if (request.getParameter("op").equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			bm.deleteBook(id);
		}
	}
	%>
	<!-- nav bare  -->
	<jsp:include page="navBar.jsp"></jsp:include>
		<%
		if (request.getParameter("res") != null) {
		if (request.getParameter("res").equals("succ")) {
		%>
		<li class="list-group-item list-group-item-success">Livre
			est ajouter avec succee ...</li>
		<%
		}}
		%>

	<!-- la list des livres de bibliotheque -->
	<%
	List<Book> ab = bm.allBooks();
	%>

	<div class="Container m-5">
		
		
		<h4>
			Salut Mr
			<%=s.getLogin().toUpperCase()%>
		</h4>
		<p>vous etes dans la page de gestion des livres</p>
		<div class="row ">
			<div class="col-4"></div>
			<div class="col-4 offset-4 ">
				<div class="row">
					<div class="col-4 col-4 offset-8">

						<a href="addBook.jsp" class="btn btn-success px-5 py-2 m-2">Ajouter</a>
					</div>
				</div>
			</div>
			<hr>

			<%
			for (Book b : ab) {
			%>
			<div class="col-4 mt-4">
				<div class="card">
					<div class="card-header">
						<div class="row justify-content-between">
							<div class="col-4">
								<h5><%=b.getName().toUpperCase()%></h5>
							</div>
							<div class="col-4">
								<a href="?op=delete&id=<%=b.getId()%>"
									class="btn btn-danger px-4 py-2">Supprimer</a>
							</div>
						</div>

					</div>
					<div class="card-body">

						<p class="card-text ">
							<b>Categorie : </b><%=b.getCategorie()%>
						</p>
						<p class="card-text ">
							<small>Autheur : <%=b.getAuthor()%>
							</small>
						</p>

					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>

</body>
</html>