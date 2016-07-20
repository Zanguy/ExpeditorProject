<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="fr.eni_ecole.fr.jee.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=ConstantIHM.EXPEDITOR %> - <%=ConstantIHM.MANAGER_EMPLOYE %></title>
<%@ include file="../part/importCSS.jspf"%>
</head>
<body>
	<%@ include file="../part/header.jspf"%>

	<div class="container">
		<div>
			<p class="lead"><%=ConstantIHM.MANAGER_COMMANDE %> : NC 30</p>
			<hr>
			<div class="row">
				<div class="col-md-6"><%=ConstantIHM.MANAGER_CLIENT %> : NTP</div>
				<div class="col-md-6"><%=ConstantIHM.EMPLOYE_DATECOMMANDE %> 12/04/2014 22:30:00</div>
			</div>
			<div class="row">
				<div class="col-md-6"><%=ConstantIHM.EMPLOYE_ADRESSE %> : 89 avenue charles de gaules -
					4400 NANTES</div>
			</div>
			<hr>

		</div>
		<br>
		<form class="form-inline" action="" method="post">
			<table class="table table-hover">
				<thead>
					<tr>
						<th><%=ConstantIHM.NOMARTICLE%></th>
						<th><%=ConstantIHM.POIDS%></th>
						<th><%=ConstantIHM.QTEDEMANDE%></th>
						<th><%=ConstantIHM.QTEREMPLIE%></th>
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
						<label for="poidsTotal"><%=ConstantIHM.POIDSTOTAL%> :</label> <input type="text"
							class="form-control" id="poidTotal" placeholder="0" readonly><strong>
							<%=ConstantIHM.KG%></strong>
					</div>
				</div>
			</div>
			<br>
			<button type="submit" class="btn btn-primary pull-right" disabled><%=ConstantIHM.ENREGISTRER%></button>

		</form>
	</div>
	<%@ include file="../part/importJS.jspf"%>

</body>
</html>