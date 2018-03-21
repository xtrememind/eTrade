 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Users</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>One of our People</h1>
				<p>An important contributor  to our Community!!!</p>
			</div>
   			
 							<div class="pull-left"> <h3>${SpecialBlurb}</h3> </div>
 				<a href="<spring:url value="/clients/add" />" class="btn btn-danger btn-mini pull-right">Add a new one</a>	
 				<br>
 		 	
		</div>
	</section>

	<section class="container">
		<div class="row">
 				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
 						<div class="caption">
							<h3>First Name - ${client.name}</h3>
							<h3>Balance -  ${client.cashAccount.balance}</h3>
							<p>UserName - ${client.userCredentials.userName}</p>
 
						</div>
					</div>
				</div>
		</div>
	</section>
</body>
</html>
