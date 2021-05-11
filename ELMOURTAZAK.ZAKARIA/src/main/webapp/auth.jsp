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
<!-- nav bare  -->
	<jsp:include page="navBar.jsp"></jsp:include>
	<div class="Container">
		<div class="row justify-content-center ">
			<div class="col-4 mt-5">
				<%
				if (request.getParameter("res") != null) {
					if (request.getParameter("res").equals("err")) {
				%>
				<li class="list-group-item list-group-item-danger">Le login ou
					le mot de passe est incorect</li>

				<%
				} else if(request.getParameter("res").equals("succ")) {
				%>
				<li class="list-group-item list-group-item-success">l'Etudiant
					est cree avec succee ...</li>
				<%
				}
				}
				%>


				<form action="Connection" method="post">
					<div class="form-group  mt-3">
						<label for="log">Login</label> <input type="text"
							class="form-control" id="log" name="login" placeholder="login">
					</div>
					<div class="form-group mt-3">
						<label for="pass">Password</label> <input type="password"
							class="form-control" id="pass" name="password"
							placeholder="Password">
					</div>
					<div class="form-group mt-3">
						<button type="submit" class="btn btn-primary px-5">Log</button>
						<a href="createAccount.jsp" class="btn btn-primary px-5 ml-3">Create
							account</a>
					</div>


				</form>
			</div>
		</div>
	</div>




</body>
</html>