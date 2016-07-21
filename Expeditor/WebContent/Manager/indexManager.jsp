<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="fr.eni_ecole.fr.jee.util.*"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni_ecole.fr.jee.bean.*"%>

<%
	//List<Commande> list =  request.getAttribute("commande");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=ConstantIHM.EXPEDITOR%> - <%=ConstantIHM.MANAGER%></title>
<%@ include file="../part/importCSS.jspf"%>
</head>
<body>
	<%@ include file="../part/header.jspf"%>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><%=ConstantIHM.MANAGER_COMMANDE%></th>
					<th><%=ConstantIHM.MANAGER_CLIENT%></th>
					<th><%=ConstantIHM.MANAGER_DATE%></th>
					<th><%=ConstantIHM.MANAGER_ETAT%></th>
					<th><%=ConstantIHM.MANAGER_EMPLOYE%></th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Commande> list = (List<Commande>) request
							.getAttribute("ListeCommande");
					for (Commande c : list) {
				%>
				<tr>
					<td class="commande"> <%= c.getNumCommande() %></td>
					<td class="client"><%= c.getNom() %></td>
					<td class="date"><%= c.getDateCreation() %></td>
					<td class="etat"><%= c.getEtatCommande() %></td>
					<td class="employe"><%= c.getUtilisateur() %></td>
				<tr>

					<%
						}
					%>
				
			</tbody>
		</table>

		<br>

		<h2 class="center-text"><%=ConstantIHM.MANAGER_STATISTIQUES%></h2>

		<br>
		<div id="stats">
			<div class="row">
				<div class="col-sm-3 col-sm-offset-4">
					<p class="userStats">Mathieu Fort</p>
				</div>
				<div class="col-sm-3">
					<p>
						<span class="nbCommandeUser"> 0 </span>
						<%=ConstantIHM.MANAGER_NBCOMMANDES%>
					</p>
				</div>
			</div>
		</div>
		<br>
		<h2 class="center-text"><%=ConstantIHM.MANAGER_COMMANDEREST%></h2>
		<br>
		<p class="center-text">
			<span id="nbCmdErrone"> 0 </span>
			<%=ConstantIHM.MANAGER_NBCOMMANDES%>
			<%=ConstantIHM.MANAGER_ERRONEE%>
			, <span id="nbCmdEnAttente"> 11 </span>
			<%=ConstantIHM.MANAGER_NBCOMMANDES%>
			<%=ConstantIHM.MANAGER_ENATTENTE%>
		</p>


	</div>
	<%@ include file="../part/importJS.jspf"%>
</body>
</html>