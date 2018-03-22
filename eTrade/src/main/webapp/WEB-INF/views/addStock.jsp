<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html lang="en">

<head>
  <jsp:include page="partials/head.jsp"></jsp:include>
  <title>Add New Stock</title>
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
            <h3 class="page-header"><i class="fa fa fa-bars"></i>Add New Stock</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="<spring:url value="/index"/>">Home</a></li>
              <li><i class="fa fa-bars"></i>Add New Stock</li>
            </ol>
          </div>
        </div>
        <!-- page start-->
        <div class="row">
        	<div class="col-lg-3"></div>
        	<div class="col-lg-6">
            <section class="panel">
              <header class="panel-heading">
              	Add new stock
              </header>
              <div class="panel-body" style="padding: 30px;">
              	<form:form  modelAttribute="newStock" class="form-horizontal" >
				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
 
 				<div class="form-group">
					<label for="code"><spring:message code="addStock.form.code.label"/></label>
					
						<form:input id="code" path="code" type="text" class="form-control"/>
						<form:errors path="code" cssClass="text-danger"/>
					
				</div>
				
				<div class="form-group">
					<label for="name"><spring:message code="addStock.form.name.label"/></label>
					
						<form:input id="name" path="name" type="text" class="form-control"/>
						<form:errors path="name" cssClass="text-danger"/>
					
				</div>

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
