<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="partials/head.jsp"></jsp:include>
  <title>Add New Client</title>
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
            <h3 class="page-header"><i class="fa fa fa-bars"></i>Add New Client</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="<spring:url value="/index"/>">Home</a></li>
              <li><i class="fa fa-bars"></i>Add New Client</li>
            </ol>
          </div>
        </div>
        <!-- page start-->
         <div class="row">
        	<div class="col-lg-3"></div>
        	<div class="col-lg-6">
            <section class="panel">
              <header class="panel-heading">
              	Add new client
              </header>
              <div class="panel-body" style="padding: 30px;">
			  <form:form  modelAttribute="newClient" class="form-horizontal"  >
			  <form:errors path="*" cssClass="alert alert-danger" element="div"/>

				<div class="form-group">
					<label for="name">Name</label>
					<form:input id="name" path="name" type="text" class="form-control"/>
					<form:errors path="name" cssClass="text-danger"/>
				</div>
 
				<div class="form-group">
					<label for="userName">User Name</label>
					<form:input id="userName" path="userCredentials.userName" type="text" class="form-control"/>
					<form:errors path="userCredentials.userName" cssClass="text-danger"/>
				</div>

				<div class="form-group">
					<label for="password">Password</label>
					<form:password id="password" path="userCredentials.password"  class="form-control"/>
					<form:errors path="userCredentials.password" cssClass="text-danger"/>
				</div>
				<div class="form-group">
					<label for="verifyPassword">Verify Password</label>
					<form:password id="verifyPassword"  path="userCredentials.verifyPassword"  class="form-control"/>
					<form:errors path="userCredentials.verifyPassword" cssClass="text-danger"/>
				</div>
 				<form:hidden path="userCredentials.enabled" value="TRUE"  />
				<div class="form-group">
					<input type="submit" id="btnAdd" class="btn btn-primary" value ="Save"/>
				</div>
	
		</form:form>
		
		</div>
		
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
		
