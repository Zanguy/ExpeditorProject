<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="fr.eni_ecole.fr.jee.util.*"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni_ecole.fr.jee.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=ConstantIHM.EXPEDITOR%> - <%=ConstantIHM.MANAGER_GESTIONEMPLOYE%></title>
<%@ include file="../part/importCSS.jspf"%>
</head>
<body>
	<%
		List<Utilisateur> list = (List<Utilisateur>) request.getAttribute("ListeUtilisateur");
	%>
	<%@ include file="../part/header.jspf"%>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><%=ConstantIHM.NOM%></th>
					<th><%=ConstantIHM.PRENOM%></th>
					<th><%=ConstantIHM.ROLE%></th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Utilisateur item : list) {
				%>
				<tr class="utilisateur" style="cursor: pointer;">
					<td class="nomUtilisateur"><%=item.getNom()%></td>
					<td class="prenomUtilisateur"><%=item.getPrenom()%></td>
					<td class="typeUtilisateur"><%=item.getTypeUtilisateur().getLibelle()%></td>
					<td class="idUtilisateur" style="visibility: hidden"><%=item.getId()%></td>
					<td class="loginUtilisateur" style="visibility: hidden"><%=item.getLogin()%></td>
					<td class="mdpUtilisateur" style="visibility: hidden"><%=item.getPassword()%></td>
				<tr>
					<%
						}
					%>
				
			</tbody>
		</table>


		<br>
		<form class="form-inline"
			action="<%=request.getContextPath()%>/utilisateur?action=enregistrerUtilisateur"
			method="post">
			<div class="row">
				<div class="col-md-11 col-md-offset-1">
					<div class="form-group">
						<label class="labelEmploye" for="nom"><%=ConstantIHM.NOM%></label>
						<input type="text" class="form-control" id="nom" name="nom">
					</div>
					<div class="form-group">
						<label class="labelEmploye" for="prenom"><%=ConstantIHM.PRENOM%></label>
						<input type="text" class="form-control" id="prenom" name="prenom">
					</div>
					<div class="form-group">
						<label class="labelEmploye" for="role"><%=ConstantIHM.ROLE%></label>
						<select name="role" id="role" class="form-control">
							<option value="<%=Constant.EMPLOYE%>"><%=Constant.EMPLOYE%></option>
							<option value="<%=Constant.MANAGER%>"><%=Constant.MANAGER%></option>
						</select>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-9 col-md-offset-1">
					<div class="form-group">
						<label class="labelEmploye" for="login"><%=ConstantIHM.LOGIN%></label>
						<input type="text" class="form-control" id="login" name="login">
					</div>
					<div class="form-group">
						<label class="labelEmploye" for="mdp"><%=ConstantIHM.MDP%></label>
						<input type="password" class="form-control" id="mdp" name="mdp">
					</div>
						<input type="text" class="form-control" id="id" name="id" style="display: none">
					<button type="submit" class="btn btn-primary pull-right"
						aria-label="Left Align">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						<%=ConstantIHM.ENREGISTRER%>
					</button>
				</div>
			</div>

		</form>
	</div>
	<%@ include file="../part/importJS.jspf"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".utilisateur").click(function() {
				//Init
				var nom = "";
				var prenom = "";
				var role = "";
				var login = "";
				var mdp = "";
				var id = 0;
				//Récup
				nom = $(this).find(".nomUtilisateur").text();
				prenom = $(this).find(".prenomUtilisateur").text();
				role = $(this).find(".typeUtilisateur").text();
				id = $(this).find(".idUtilisateur").text();
				login = $(this).find(".loginUtilisateur").text();
				mdp = $(this).find(".mdpUtilisateur").text();

				//Set
				$("#nom").val(nom);
				$("#prenom").val(prenom);
				$('#role option[value="'+role+'"]').prop('selected', true);
				$("#id").val(id);
				
				$("#login").val(login);
				$("#mdp").val(mdp);
			});

		});
	</script>
</body>
</html>