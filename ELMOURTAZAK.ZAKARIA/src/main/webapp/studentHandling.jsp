<%@page import="java.util.List"%>
<%@page import="com.util.db.StudentManager"%>
<%@page import="com.util.db.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.js"></script>
</head>
<body>

	

	<!-- decalration -->
	<%
	Student s = (Student) session.getAttribute("student");
	StudentManager sm = new StudentManager();
	%>
	


	
	<!-- la suppresion des etudinats -->
	<%
	if (request.getParameter("op") != null) {
		if (request.getParameter("op").equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			sm.deleteStudent(id);
		}
	}
	%>
	
	<!-- nav bare  -->
	<jsp:include page="navBar.jsp"></jsp:include>
		<%
		if (request.getParameter("res") != null) {
		if (request.getParameter("res").equals("succ")) {
		%>
		<li class="list-group-item list-group-item-success">l'Etudiant
			est ajouter avec succee ...</li>
		<%
		}}
		%>

	<!-- la list des livres de bibliotheque -->
	<%
	List<Student> as = sm.allStudent();
	%>

	<div class="Container m-5 ">
		
		
		<h4>
			Salut Mr
			<%=s.getLogin().toUpperCase()%>
		</h4>
		<p>vous etes dans la page de gestion des etudiants</p>
		<div class="row ">
			<div class="col-4"></div>
			<div class="col-4 offset-4 ">
				<div class="row">
					<div class="col-4 col-4 offset-7">

						<a href="createAccount.jsp" class="btn btn-outline-success px-5 py-2 m-2">Ajouter</a>
					</div>
				</div>
			</div>
			<hr>
			<di class="container">
			<div class="row col-12">
					<%
			for (Student s1 : as) {
				
			/* eliminer la possibilité de la suppresion d'administrateur  */
				String st = "enabled";
				if(s != null){
					if(s1.getId() == s.getId()){
						st = "disabled";
					}	
				}
				
			%>
			<div class="col-4 mt-4">
				<div class="card">
					<div class="card-header">
						<div class="row justify-content-between">
							<div class="col-4">
								<h5><%=s1.getLogin().toUpperCase()%></h5>
							</div>
							<div class="col-5">
								<a href="?op=delete&id=<%=s1.getId()%>"
									class="btn btn-danger px-4 py-2 <%= st%>">Supprimer</a>
							</div>
						</div>

					</div>
					<div class="card-body">

						<p class="card-text ">
							<b>Id : </b><%=s1.getId()%>
						</p>
						<p class="card-text ">
							<b>Role : </b><%=s1.getRole()%>
						</p>
						<p class="card-text ">
							<small>Passwoord : <%=s1.getPassword()%>
							</small>
						</p>

					</div>
				</div>
			</div>
			<%
			}
			%>
			</div>
			</di>
		
		</div>
	</div>
	
	
</body>
</html>