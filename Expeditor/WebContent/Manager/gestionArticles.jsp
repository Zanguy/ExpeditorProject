<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="fr.eni_ecole.fr.jee.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=ConstantIHM.EXPEDITOR%> - <%=ConstantIHM.MANAGER_GESTIONARTICLE%></title>
<%@ include file="../part/importCSS.jspf"%>
</head>
<body>
	<%@ include file="../part/header.jspf"%>
	<div class="container">
		<table class="table table-stripped">
			<thead>
				<tr>
					<th><%=ConstantIHM.NOMARTICLE%></th>
					<th><%=ConstantIHM.POIDS%></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
				<tr>
				<tr>
					<td></td>
					<td></td>
				<tr>
				<tr>
					<td></td>
					<td></td>
				<tr>
			</tbody>
		</table>


		<br>
		<div class="row">
			<div class="col-md-7 col-md-offset-3">
				<form class="form-inline" action="" method="post">
					<div class="form-group">
						<label for="nom"><%=ConstantIHM.NOM%></label> <input type="text"
							class="form-control" id="nom" name="nom">
					</div>
					<div class="form-group">
						<label for="poids"><%=ConstantIHM.POIDS%></label> <input type="text"
							class="form-control" id="poids" name="poids">
					</div>
					<button type="submit" class="btn btn-primary"
						aria-label="Left Align" disabled>
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						<%=ConstantIHM.ENREGISTRER%>
					</button>
				</form>
			</div>
		</div>
	</div>

	<%@ include file="../part/importJS.jspf"%>
</body>
</html>