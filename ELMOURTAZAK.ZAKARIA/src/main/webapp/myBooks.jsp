<%@page import="com.util.db.BookManager"%>
<%@page import="com.util.db.Book"%>
<%@page import="java.util.List"%>
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

<!-- declaration -->	
<%
Student s = (Student)session.getAttribute("student");
BookManager bm = new BookManager();
%>

<!-- gestion des roles -->
<%
if(request.getParameter("op")!=null)
{
	if(request.getParameter("op").equals("delete"))
	{
		int id = Integer.parseInt(request.getParameter("id"));
		bm.returnBookToBiblio(id);
	}	
}
%>

	
<!-- nave bare -->
	<jsp:include page="navBar.jsp"></jsp:include>
	
	<!-- la list des livres de bibliotheque -->
	<%
	int id = s.getId();
	List<Book> ab = bm.allStudentBooks(id);
	%>
	
	<div class="Container m-5">
		<h4>
			Salut Mr
			<%=s.getLogin().toUpperCase()%>
		</h4>
		<p>vous etes dans votre bibliotheque des livres</p>
		<div class="row ">
			<%
			for (Book b : ab) {
			%>
			<div class="col-4 mt-3">
				<div class="card">
					<div class="card-header">
						<div class="row justify-content-between">
							<div class="col-4">
								<h5><%=b.getName().toUpperCase()%></h5>
							</div>
							
							<div class="col-4">
								<a href="?op=delete&id=<%= b.getId()%>" class="btn btn-danger px-4 py-2">rendre</a>
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