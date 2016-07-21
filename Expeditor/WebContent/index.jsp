<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="fr.eni_ecole.fr.jee.util.*"%>
<%
	String erreur = (String) request.getSession().getAttribute("erreurLogin");
	request.getSession().setAttribute("erreurLogin", "null");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=ConstantIHM.EXPEDITOR%></title>

<%@ include file="../part/importCSS.jspf"%>

</head>
<body>
	<div class="container">

		<%if(!"null".equals(erreur) && erreur != null){ %>
		<div class="alert alert-danger col-md-4 col-md-offset-4 center-text" role="alert"><%=erreur %></div>
		<%} %>
		<div style="margin-top: 5%" class="row">


			<div class="col-md-4 col-md-offset-4">
				<h3><%=ConstantIHM.CONNEXION%></h3>
			</div>
		</div>

		<form action="<%=request.getContextPath()%>/connexion" method="post">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="input-group center-block">
						<input name="login" type="text" class="form-control"
							placeholder="<%=ConstantIHM.LOGIN%>"
							aria-describedby="basic-addon1">
					</div>
				</div>
			</div>

			<br>

			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="input-group center-block">
						<input name="password" type="text"
							class="form-control center-block"
							placeholder="<%=ConstantIHM.MDP%>"
							aria-describedby="basic-addon1">
					</div>
				</div>
			</div>

			<br>

			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<button type="submit" class="btn btn-primary btn-block">Connexion</button>
				</div>
			</div>
		</form>
	</div>

	<%@ include file="../part/importJS.jspf"%>
</body>
</html>