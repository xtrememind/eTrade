<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Cash Transaction</h1>
				<p><p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newCashTransaction" class="form-horizontal"  >
			<fieldset>
				<legend>Add Transaction</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>

				<div class="form-group">
					<label class="control-label col-lg-2" for="date">Date</label>
					<div class="col-lg-10">
						<form:input id="date" path="date" type="Date" class="form:input-large"/>
						<form:errors path="date" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="amount">Amount</label>
					<div class="col-lg-10">
						<form:input id="amount" path="amount" type="text" class="form:input-large"/>
						<form:errors path="amount" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="balance">Balance</label>
					<div class="col-lg-10">
						<form:input id="balance" path="balance" value="${client.cashAccount.balance}" readonly="true" type="text" class="form:input-large"/>
						<form:errors path="cashAccount.balance" cssClass="text-danger"/>
					</div>
				</div>

				

 
				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Description</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="description" path="description" type="text" class="form:input-large"/>
							<form:errors path="description" cssClass="text-danger"/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Account</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="cashAccount" path="cashAccount.id" type="text" value="${client.cashAccount.id}" readonly="true" class="form:input-large"/>
							<form:errors path="cashAccount" cssClass="text-danger"/>
						</div>
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
