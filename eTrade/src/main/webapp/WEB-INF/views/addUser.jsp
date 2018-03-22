<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="partials/head.jsp"></jsp:include>
  <title>Add New Employee</title>
</head>
<body>
  <!-- container section start -->
  <section id="container" class="">
    <!--header start-->
    <jsp:include page="partials/header.jsp"></jsp:include>
    <!--header end-->
    <!--sidebar start-->
	<jsp:include page="partials/sidebar.jsp">
        <jsp:param name="selected" value="employee" />
    </jsp:include>
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa fa-bars"></i>
            <c:if test="${userToUpdate.firstName == null}">
                Add New User
               </c:if>
               <c:if test="${userToUpdate.firstName != null}">
                User Details
               </c:if>
            </h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="<spring:url value="/index"/>">Home</a></li>
               <li><i class="fa fa-bars"></i><a href="<spring:url value="/users"/>">Employees</a></li>
               <li><i class="fa fa-bars"></i>
               <c:if test="${userToUpdate.firstName == null}">
                Add New User
               </c:if>
               <c:if test="${userToUpdate.firstName != null}">
                User Details
               </c:if>
               </li>
            </ol>
          </div>
        </div>
        <!-- page start-->
        <div class="row">
        	<div class="col-lg-3"></div>
        	<div class="col-lg-6">
            <section class="panel">
              <header class="panel-heading">
              <c:if test="${userToUpdate.firstName == null}">
                Add New User
               </c:if>
               <c:if test="${userToUpdate.firstName != null}">
                User Details
               </c:if>
              </header>
              <div class="panel-body" style="padding: 30px;">
                <form:form  modelAttribute="newUser" class="form-horizontal">
                <form:errors path="*" cssClass="alert alert-danger" element="div"/>
                  <div class="form-group">
                    <label for="firstName">First Name</label>
                    <form:input id="firstName" path="firstName" type="text" class="form-control" placeholder="First Name" value="${userToUpdate.firstName}"/>
					<form:errors path="firstName" cssClass="text-danger"/>
                  </div>
                  <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <form:input id="lastName" path="lastName" type="text" class="form-control" placeholder="Last Name" value="${userToUpdate.lastName}"/>
					<form:errors path="lastName" cssClass="text-danger"/>
                  </div>
                  <div class="form-group">
                    <label for="email">Email</label>
                    <form:input id="email" path="email" type="text" class="form-control" placeholder="Email" value="${userToUpdate.email}"/>
					<form:errors path="email" cssClass="text-danger"/>
                  </div>
                  <div class="form-group">
                    <label for="userName">User Name</label>
                    <form:input id="userName" path="userCredentials.userName" type="text" class="form-control" placeholder="User Name" value="${userToUpdate.userCredentials.userName}"/>
					<form:errors path="userCredentials.userName" cssClass="text-danger"/>
                  </div>
                  <c:if test="${userToUpdate.firstName == null}">
                  <div class="form-group">
                  	<label for="password">Password</label>
                  	<form:password id="password" path="userCredentials.password"  class="form-control" value="${userToUpdate.userCredentials.password}"/>
					<form:errors path="userCredentials.password" cssClass="text-danger"/>
                  </div>
                  
                
                  <div class="form-group">
                  	<label for="confirmPassword">Confirm Password</label>
                  	<form:password id="confirmPassword"  path="userCredentials.verifyPassword"  class="form-control" value="${userToUpdate.userCredentials.password}"/>
					<form:errors path="userCredentials.verifyPassword" cssClass="text-danger"/>
                  </div>
                  <form:hidden  path="userCredentials.authority[0].authority"  value="ROLE_USER"/>
                  <form:hidden path="userCredentials.enabled" value="TRUE"  />
                  
                   <button type="submit" class="btn btn-primary">Save</button>
                   
                    </c:if>
                 
                </form:form>

              </div>
            </section>
          </div>
          <div class="col-lg-3"></div>
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
