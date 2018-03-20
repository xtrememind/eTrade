<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <jsp:include page="partials/head.jsp"></jsp:include>
  <title>List of Users</title>
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
                              <span class="username">user</span>
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
        <jsp:param name="selected" value="employee" />
    </jsp:include>
    <!--sidebar end-->
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa fa-bars"></i> Employees</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
              <li><i class="fa fa-bars"></i>Employees</li>
            </ol>
          </div>
        </div>
        <!-- page start-->
        <div class="row">
            <div class="col-lg-12">
                <a class="btn btn-success" href="/employees/new">
                    <i class="fa fa-plus-circle"></i>
                    New employee
                </a>
            </div>
        </div>

        <div class="row">
          <div class="col-lg-12">
            <section class="panel">
             
              <table class="table table-striped table-advance table-hover">
                <tbody>
              
                  <tr>
                    <th><i class="icon_profile"></i> First Name</th>
                    <th><i class="icon_calendar"> </i> </th>
                    <th><i class="icon_mail_alt"></i> Last Name</th>
                    <th><i class="icon_pin_alt"></i> email</th>
                    <th><i class="icon_mobile"></i> Rank</th>
                    <th><i class="icon_cogs"></i> Action</th>
                  </tr>
                    <c:forEach items="${users}" var="user">
                  <tr>
                    <td>${user.firstName}</td>
                    <td> 2007-12-01</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.ranking}</td>
                    <td>
                      <div class="btn-group">
                        <a class="btn btn-primary" href="#"><i class="icon_plus_alt2"></i></a>
                        <a class="btn btn-success" href="#"><i class="icon_check_alt2"></i></a>
                        <a class="btn btn-danger" href="#"><i class="icon_close_alt2"></i></a>
                      </div>
                    </td>
                  </tr>
                  </c:forEach>
                 
                   
     
                </tbody>
              </table>
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
