<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="partials/head.jsp"></jsp:include>
  <title>Add New Order</title>
</head>
<body>
  <!-- container section start -->
  <section id="container" class="">
    <!--header start-->
    <jsp:include page="partials/header.jsp"></jsp:include>
    <!--header end-->
    <!--sidebar start-->
	<jsp:include page="partials/sidebar.jsp">
        <jsp:param name="selected" value="order" />
    </jsp:include>
    <!--sidebar end-->
     <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa fa-bars"></i>Add New Order</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="<spring:url value="/index"/>">Home</a></li>
              <li><i class="fa fa-bars"></i>Add New Order</li>
            </ol>
          </div>
        </div>
        <!-- page start-->
         <div class="row">
        	<div class="col-lg-3"></div>
        	<div class="col-lg-6">
            <section class="panel">
              <header class="panel-heading">
              	Add new order
              </header>
              <div class="panel-body" style="padding: 30px;">
 		<form:form  modelAttribute="newOrder" class="form-horizontal" >
		
				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
 				
				<div class="form-group">
					<label for="stock">Stock</label>
			        <form:select id="stock" path="stock.id" items="${stocks}" class="form-control" />
				</div>

				<div class="form-group">
					<label for="buyerClient">Buyer</label>
			        <form:select id="buyerClient" path="buyerClient.id" items="${clients}" class="form-control" />
				</div>

				<div class="form-group">
					<label for="sellerClient">Seller</label>
			        <form:select id="sellerClient" path="sellerClient.id" items="${clients}" class="form-control" />
				</div>

  				<div class="form-group">
					<label for="quantity">Quantity</label>
					<form:input id="quantity" path="quantity" type="text" class="form-control"/>
					<form:errors path="quantity" cssClass="text-danger"/>
				</div>

  				<div class="form-group">
					<label for="price">Price</label>
					<form:input id="price" path="price" type="text" class="form-control"/>
					<form:errors path="price" cssClass="text-danger"/>
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
		
		
