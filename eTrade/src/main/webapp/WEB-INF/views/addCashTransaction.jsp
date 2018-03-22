<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="partials/head.jsp"></jsp:include>
  <title>Add Cash Transaction</title>
</head>
<body>
  <!-- container section start -->
  <section id="container" class="">
    <!--header start-->
    <jsp:include page="partials/header.jsp"></jsp:include>
    <!--header end-->
    <!--sidebar start-->
	<jsp:include page="partials/sidebar.jsp">
        <jsp:param name="selected" value="customer" />
    </jsp:include>
    <!--sidebar end-->
     <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa fa-bars"></i>Add Cash Transaction</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="<spring:url value="/index"/>">Home</a></li>
              <li><i class="fa fa-bars"></i><a href="<spring:url value="/clients"/>">Customers</a></li>
              <li><i class="fa fa-bars"></i>Add Cash Transaction</li>
            </ol>
          </div>
        </div>
        <!-- page start-->
         <div class="row">
        	<div class="col-lg-3"></div>
        	<div class="col-lg-6">
            <section class="panel">
              <header class="panel-heading">
              	Add cash transaction
              </header>
              <div class="panel-body" style="padding: 30px;">
		<form:form  modelAttribute="newCashTransaction" class="form-horizontal">
				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label for="date">Date</label>
					<form:input id="date" path="date" type="Date" class="form-control"/>
					<form:errors path="date" cssClass="text-danger"/>
				</div>

				<div class="form-group">
					<label for="amount">Amount</label>
						<form:input id="amount" path="amount" type="text" class="form-control"/>
						<form:errors path="amount" cssClass="text-danger"/>
				</div>
				
				<div class="form-group">
					<label for="balance">Balance</label>
					<form:input id="balance" path="balance" value="${client.cashAccount.balance}" readonly="true" type="text" class="form-control"/>
					<form:errors path="cashAccount.balance" cssClass="text-danger"/>
				</div>

				<div class="form-group">
					<label for="description">Description</label>
					<form:textarea id="description" path="description" type="text" class="form-control"/>
					<form:errors path="description" cssClass="text-danger"/>
				</div>
				
				<div class="form-group">
					<label for="cashAccount">Account</label>
					<form:input id="cashAccount" path="cashAccount.id" type="text" value="${client.cashAccount.id}" readonly="true" class="form-control"/>
					<form:errors path="cashAccount" cssClass="text-danger"/>	
				</div>
				<div class="form-group">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Save"/>
				</div>
		</form:form>
			
		</section>
		</div>
		</div>
        <!-- page end-->
      </section>
    </section>
    <!--main content end-->
  </section>
  <!-- container section end -->
 <jsp:include page="partials/foot.jsp"></jsp:include>

</body>
</html>
