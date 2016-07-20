<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="fr.eni_ecole.fr.jee.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=ConstantIHM.EXPEDITOR%> - <%=ConstantIHM.MANAGER_GESTIONEMPLOYE%></title>
<%@ include file="../part/importCSS.jspf"%>
</head>
<body>
	<%@ include file="../part/header.jspf"%>
	<div class="container">
		<table class="table table-stripped">
			<thead>
				<tr>
					<th><%=ConstantIHM.NOM%></th>
					<th><%=ConstantIHM.PRENOM%></th>
					<th><%=ConstantIHM.ROLE%></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
				<tr>
			</tbody>
		</table>


		<br>
		<form class="form-inline" action="" method="post">
			<div class="row">
				<div class="col-md-11 col-md-offset-1">
					<div class="form-group">
						<label class="labelEmploye" for="nom"><%=ConstantIHM.NOM%></label> <input
							type="text" class="form-control" id="nom" name="nom">
					</div>
					<div class="form-group">
						<label class="labelEmploye" for="prenom"><%=ConstantIHM.PRENOM%></label> <input
							type="text" class="form-control" id="prenom" name="prenom">
					</div>
					<div class="form-group">
						<label class="labelEmploye" for="role"><%=ConstantIHM.ROLE%></label> <select
							name="role" id="role" class="form-control">
							<option><%=ConstantIHM.MANAGER_EMPLOYE%></option>
							<option><%=ConstantIHM.MANAGER%></option>
						</select>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-9 col-md-offset-1">
					<div class="form-group">
						<label class="labelEmploye" for="login"><%=ConstantIHM.LOGIN%></label> <input
							type="text" class="form-control" id="login" name="login">
					</div>
					<div class="form-group">
						<label class="labelEmploye" for="mdp"><%=ConstantIHM.MDP%></label> <input
							type="password" class="form-control" id="mdp" name="mdp">
					</div>
					<button type="submit" class="btn btn-primary pull-right"
						aria-label="Left Align" disabled>
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						<%=ConstantIHM.ENREGISTRER%>
					</button>
				</div>
			</div>

		</form>
	</div>

	<%@ include file="../part/importJS.jspf"%>
</body>
</html>