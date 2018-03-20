<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <jsp:include page="partials/head.jsp"></jsp:include>
  <title>Orders</title>
</head>

<body>
  <!-- container section start -->
  <section id="container" class="">
       <!--header start-->

       <header class="header dark-bg">
        <div class="toggle-nav">
          <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
        </div>
  
        <!--logo start-->
        <a href="index.html" class="logo">Best <span class="lite">Trade</span></a>
        <!--logo end-->
  
        <div class="top-nav notification-row">
          <!-- notificatoin dropdown start-->
          <ul class="nav pull-right top-menu">
            <!-- user login dropdown start-->
            <li class="dropdown">
              <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                              <span class="profile-ava">
                                  <img alt="" src="img/man.png">
                              </span>
                              <span class="username">Jenifer Smith</span>
                              <b class="caret"></b>
                          </a>
              <ul class="dropdown-menu extended logout">
                <div class="log-arrow-up"></div>
                <li class="eborder-top">
                  <a href="#"><i class="icon_profile"></i> My Profile</a>
                </li>
                <li>
                  <a href="login.html"><i class="icon_key_alt"></i> Log Out</a>
                </li>
              </ul>
            </li>
            <!-- user login dropdown end -->
          </ul>
          <!-- notificatoin dropdown end-->
        </div>
      </header>
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
            <h3 class="page-header"><i class="fa fa fa-bars"></i> Orders</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
              <li><i class="fa fa-bars"></i>Orders</li>
            </ol>
          </div>
        </div>
        <!-- page start-->
       
        <!-- page end-->
      </section>
    </section>
    <!--main content end-->
  </section>
  <!-- container section end -->
  <!-- javascripts -->
<jsp:include page="partials/foot.jsp"></jsp:include>


</body>

</html>
