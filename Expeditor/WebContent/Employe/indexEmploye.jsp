<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="fr.eni_ecole.fr.jee.util.*"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni_ecole.fr.jee.bean.*"%>
<%
	Commande c = (Commande) request.getAttribute("commande");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=ConstantIHM.EXPEDITOR%> - <%=ConstantIHM.MANAGER_EMPLOYE%></title>
<%@ include file="../part/importCSS.jspf"%>
</head>
<body>

	<%@ include file="../part/header.jspf"%>

	<div class="container">
		<div>
			<p class="lead"><%=ConstantIHM.MANAGER_COMMANDE%>
				:
				<%=c.getNumCommande()%>
			</p>
			<hr>
			<div class="row">
				<div class="col-md-6"><%=ConstantIHM.MANAGER_CLIENT%>
					:
					<%=c.getNom()%>
				</div>
				<div class="col-md-6"><%=ConstantIHM.EMPLOYE_DATECOMMANDE%>
					<%=c.getDateCreation()%>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6"><%=ConstantIHM.EMPLOYE_ADRESSE%>
					:
					<%=c.getAdresse()%>
				</div>
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
					<%
						int i = 0;
						List<LigneCommande> list = c.getLesLigneCommandes();
									for (LigneCommande l : list) {
					%>
					<tr>
						<td><%=l.getArticle().getNom()%></td>
						<td><%=l.getArticle().getPoids()%></td>
						<td><%=l.getQte()%></td>
						<td><input type="text" class="form-control" id="qte<%= i %>" placeholder="Entrer la Quantité"></td>
					</tr>

					<%
						}
					%>
				</tbody>
			</table>

			<br>

			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="form-group">
						<label for="poidsTotal"><%=ConstantIHM.POIDSTOTAL%> :</label> <input
							type="text" class="form-control" id="poidTotal" placeholder="0"
							readonly><strong> <%=ConstantIHM.KG%></strong>
					</div>
				</div>
			</div>
			<br>
			<button type="submit" class="btn btn-primary pull-right" disabled><%=ConstantIHM.ENREGISTRER%></button>

		</form>
	</div>
	<%@ include file="../part/importJS.jspf"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$("p").keyup(function() {
				$(this).hide();
			});
		});
	</script>

</body>
</html>