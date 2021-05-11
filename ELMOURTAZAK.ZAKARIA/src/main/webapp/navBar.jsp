

<%@page import="com.util.db.Student"%>

<!-- declaration -->
<%
	Student s= (Student)session.getAttribute("student");
%>

<!-- gestion d'admin -->
<%
String st = "disabled";
if(s != null){
	if(s.getRole().equalsIgnoreCase("admin")){
		st = "enabled";
	}	
}

%>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
  <a class="navbar-brand" href="auth.jsp">Biblio</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link " href="index.jsp">Accueil </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="myBooks.jsp">Mes livres</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link <%=st %>" href="booksHandling.jsp">Livres</a>
      </li>
       <li class="nav-item">
        <a class="nav-link <%=st %>" href="studentHandling.jsp">Etudiants</a>
      </li>
    </ul>
   
  </div>
  </div>
</nav>
