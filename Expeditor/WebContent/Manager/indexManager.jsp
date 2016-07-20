<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expeditor - Manager</title>
<%@ include file="../part/importCSS.jspf"%>
</head>
<body>
	<%@ include file="../part/header.jspf"%>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Commande</th>
					<th>Client</th>
					<th>Date</th>
					<th>Etat</th>
					<th>Employe</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
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
					<td></td>
				<tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				<tr>
			</tbody>
		</table>

		<br>

		<h2 class="center-text">Statistiques</h2>

		<br>
		<div id="stats">
			<div class="row">
				<div class="col-sm-3 col-sm-offset-4">
					<p>Mathieu Fort</p>
				</div>
				<div class="col-sm-3">
					<p>
						<span class="nbCommande"> 0 </span> commande(s)
					</p>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3 col-sm-offset-4">
					<p>Mathieu Fort</p>
				</div>
				<div class="col-sm-3">
					<p>
						<span class="nbCommande"> 0 </span> commande(s)
					</p>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3 col-sm-offset-4">
					<p>Paul Adrien Douteau Sala</p>
				</div>
				<div class="col-sm-3">
					<p>
						<span class="nbCommande"> 0 </span> commande(s)
					</p>
				</div>
			</div>
		</div>
		<br>
		<h2 class="center-text">Commandes Restantes</h2>
		<br>
		<p class="center-text"> <span id="nbCmdErrone"> 0 </span> commande(s) erronée(s), <span id="nbCmdEnAttente"> 11 </span> commande(s) en attente</p>


	</div>
	<%@ include file="../part/importJS.jspf"%>
</body>
</html>