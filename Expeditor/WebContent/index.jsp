<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

	<div style="margin-top : 15%" class="row">
	
		<div class="col-md-4 col-md-offset-4">
	  		<h3>Connexion</h3>
  		</div>
	</div>

	<div class="row">
	  <div class="col-md-4 col-md-offset-4">
		  <div class="input-group center-block">
			  <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
		  </div>
	  </div>
	</div>
	
	<br>
	
	<div class="row">
	  <div class="col-md-4 col-md-offset-4">
		<div class="input-group center-block">
		   <input type="text" class="form-control center-block" placeholder="Password" aria-describedby="basic-addon1">
		</div>
	  </div>
	</div>
	
	<br>
	
	<div class="row">
	  <div class="col-md-4 col-md-offset-4">
		   <a href="<%=request.getContextPath()%>/connexion" type="button" class="btn btn-primary btn-block">Connexion</a>
	  </div>
	</div>
</div>



	
	
	
	
	
	
	
	
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>