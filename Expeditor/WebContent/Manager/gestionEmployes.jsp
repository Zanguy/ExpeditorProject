<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expeditor - Gestion Employes</title>
<%@ include file="../part/importCSS.jspf"%>
</head>
<body>
	<%@ include file="../part/header.jspf"%>
	<div class="container">
		<table class="table table-stripped">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Rôle</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
				<tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
				<tr>
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
						<label class="labelEmploye" for="nom">Nom</label> <input type="text"
							class="form-control" id="nom" name="nom">
					</div>
					<div class="form-group">
						<label class="labelEmploye" for="prenom">Prénom</label> <input type="text"
							class="form-control" id="prenom" name="prenom">
					</div>
					<div class="form-group">
						<label class="labelEmploye" for="role">Rôle</label> <select name="role" id="role"
							class="form-control">
							<option>Employe</option>
							<option>Manager</option>
						</select>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-9 col-md-offset-1">
					<div class="form-group">
						<label class="labelEmploye" for="login">login</label> <input type="text"
							class="form-control" id="login" name="login">
					</div>
					<div class="form-group">
						<label class="labelEmploye" for="mdp">Mot de passe</label> <input type="password"
							class="form-control" id="mdp" name="mdp">
					</div>
					<button type="submit" class="btn btn-primary pull-right"
						aria-label="Left Align" disabled>
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						Enregistrer
					</button>
				</div>
			</div>

		</form>
	</div>

	<%@ include file="../part/importJS.jspf"%>
</body>
</html>