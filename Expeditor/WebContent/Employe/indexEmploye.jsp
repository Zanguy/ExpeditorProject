<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employe</title>
<%@ include file="../part/importCSS.jspf"%>
</head>
<body>
	<%@ include file="../part/header.jspf"%>

	<div class="container">
		<div>
			<p class="lead">Commande : NC 30</p>
			<hr>
			<div class="row">
				<div class="col-md-6">Client : NTP</div>
				<div class="col-md-6">Date Commande 12/04/2014 22:30:00</div>
			</div>
			<div class="row">
				<div class="col-md-6">Adresse : 89 avenue charles de gaules -
					4400 NANTES</div>
			</div>
			<hr>

		</div>
		<br>
		<form class="form-inline" action="" method="post">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Nom de l'article</th>
						<th>Poids</th>
						<th>Qté demandé</th>
						<th>Qté remplie</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					<tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					<tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					<tr>
				</tbody>
			</table>

			<br>

			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="form-group">
						<label for="poidsTotal">Poids Total :</label> <input type="text"
							class="form-control" id="poidTotal" placeholder="0" disabled><strong>
							Kg</strong>
					</div>
				</div>
			</div>
			<br>
			<button type="submit" class="btn btn-primary pull-right">Enregistrer</button>

		</form>
	</div>
	<%@ include file="../part/importJS.jspf"%>

</body>
</html>