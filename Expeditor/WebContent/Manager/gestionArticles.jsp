<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="fr.eni_ecole.fr.jee.util.*"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni_ecole.fr.jee.bean.*"%>
<%
	List<Article> list = (List<Article>) request.getAttribute("listeArticle");
%>
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
		<table class="table table-hover">
			<thead>
				<tr>
					<th><%=ConstantIHM.NOMARTICLE%></th>
					<th><%=ConstantIHM.POIDS%></th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Article a : list) {
				%>
				<tr class="articleDispo">
					<td class="nomArticle"><%=a.getNom()%></td>
					<td class="poidsArticle"><%=a.getPoids()%></td>
					<td class="idArticle" style="visibility: hidden"><%=a.getId()%></td>
				<tr>
					<%
						}
					%>
				
			</tbody>
		</table>


		<br>
		<div class="row">
			<div class="col-md-9 col-md-offset-2">
				<form class="form-inline" action="" method="post">
					<div class="form-group">
						<label for="nom"><%=ConstantIHM.NOM%></label> <input type="text"
							class="form-control" id="nom" name="nom">
					</div>
					<div class="form-group">
						<label for="poids"><%=ConstantIHM.POIDS%></label> <input
							type="text" class="form-control" id="poids" name="poids">
					</div>
					<div class="checkbox">
						<label> <input name="maj" id="maj" type="checkbox">  MAJ ?
						</label>
					</div>
					<input type="text" class="form-control" id=id name="id"
						style="display: none">

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
	<script type="text/javascript">
		$(document).ready(function() {
			$("tr").click(function() {
				//Init
				var nom = "";
				var poids = 0;
				var id = 0;
				//Récup
				nom = $(this).find(".nomArticle").text();
				poids = $(this).find(".poidsArticle").text();
				id = $(this).find(".idArticle").text();
				//Set
				$("#nom").val(nom);
				$("#poids").val(poids);
				$("#id").val(id);
				$("#maj").val(true);
			});
		});
	</script>
</body>
</html>