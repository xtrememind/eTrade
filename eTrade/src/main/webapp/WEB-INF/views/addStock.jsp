<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Stocks</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Stocks</h1>
				<p>Add stocks</p>
			</div>
 		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newStock" class="form-horizontal" >
			<fieldset>
				<legend>Add new stock</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
 
				<div class="form-group">
					<label class="control-label col-lg-2" for="name"><spring:message code="addStock.form.name.label"/></label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
						<form:errors path="name" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="code"><spring:message code="addStock.form.code.label"/></label>
					<div class="col-lg-10">
						<form:textarea id="code" path="code" rows = "2"/>
					</div>
				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
