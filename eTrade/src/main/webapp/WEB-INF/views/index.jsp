<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <jsp:include page="partials/head.jsp"></jsp:include>
  <title>Dashboard</title>
</head>

<body>
  <!-- container section start -->
  <section id="container" class="">
    <!--header start-->

    
    <!--header end-->
		<jsp:include page="partials/header.jsp"></jsp:include>
    <!--sidebar start-->
	<jsp:include page="partials/sidebar.jsp">
        <jsp:param name="selected" value="home" />
    </jsp:include>
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa fa-bars"></i> Dashboard</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
              <li><i class="fa fa-bars"></i>Dashboard</li>
            </ol>
          </div>
        </div>
        <!-- page start-->
        <div class="row">
          <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
            <div class="info-box green-bg">
              <i class="fa fa-users"></i>
              <div class="count">${numberOfCustomers }</div>
              <div class="title">Customers</div>
            </div>
          </div>

          <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
            <div class="info-box blue-bg">
              <i class="fa fa-shopping-cart"></i>
              <div class="count">${numberOfStocks }</div>
              <div class="title">Stocks</div>
            </div>
          </div>

          <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
            <div class="info-box red-bg">
              <i class="fa fa-exchange"></i>
              <div class="count">${numberOfOrders }</div>
              <div class="title">Orders</div>
            </div>
          </div>

          <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
            <div class="info-box yellow-bg">
              <i class="fa fa-briefcase"></i>
              <div class="count">${numberOfUsers }</div>
              <div class="title">Traders</div>
            </div>
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
