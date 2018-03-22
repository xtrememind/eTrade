<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <jsp:include page="partials/head.jsp"></jsp:include>
  <title>List of Clients</title>
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
            <h3 class="page-header"><i class="fa fa fa-bars"></i> Clients</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="<spring:url value="/index"/>">Home</a></li>
              <li><i class="fa fa-bars"></i>Clients</li>
            </ol>
          </div>
        </div>
        <!-- page start-->
        <div class="row">
            <div class="col-lg-12">
                <a class="btn btn-success" href="<spring:url value="/clients/add" />" >
                    <i class="fa fa-plus-circle"></i>
                    New Client
                </a>
            </div>
        </div>

        <div class="row">
          <div class="col-lg-12">
            <section class="panel">
             
              <table class="table table-striped table-advance table-hover">
                <tbody>
              
                  <tr>
                    <th><i class="icon_profile"></i> Name</th>
                    <th><i class="icon_calendar"> </i> </th>
                    <th><i class="icon_pin_alt"></i> Balance</th>
                    <th><i class="icon_mobile"></i> userName</th>
                    <th><i class="icon_cogs"></i> Action</th>
                  </tr>
                    <c:forEach items="${clients}" var="client">
                  <tr>
                    <td>${client.name}</td>
                    <td> 2007-12-01</td>
                    <td>${client.cashAccount.balance}</td>
                    <td>${client.userCredentials.userName}</td>
                    <td>
                      <div class="btn-group">
             
               <a href="<spring:url value="/cashTransactions/add/${client.id}" />" class="btn btn-primary  btn-mini  "> <i class="icon_plus_alt2"></i> </a>
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
