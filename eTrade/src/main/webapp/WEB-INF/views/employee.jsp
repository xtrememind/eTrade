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
                <a class="btn btn-success" href="<spring:url value="/users/add" />" >
                    <i class="fa fa-plus-circle"></i>
                    New employee
                </a>
            </div>
        </div>

        <div class="row">
          <div class="col-lg-12">
            <section class="panel">
             
              <table id="myTable" class="table table-striped table-advance table-hover" data-type="employee">
              <thead>
              </thead>
               <tr>
               <th><i class="icon_profile"></i> First Name</th>
                    <th><i class="icon_profile"></i> Last Name</th>
                    <th><i class="icon_mail_alt"></i> Email</th>
                    <th><i class="icon_cogs"></i> Action</th>
                </tr>
                <tbody>
                  </tr>
                    <c:forEach items="${users}" var="user">
                  <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>
                      <div class="btn-group">
                	  <a href="<spring:url value="/users/${user.id}" />" class="btn btn-primary  btn-mini  "> <i class="icon_pencil-edit"></i> </a>
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
<%-- <script src="<spring:url value="/resource/datatables/js/jquery.dataTables.min.js"/>"></script>  --%>
<%-- <script src="<spring:url value="/resource/datatables-plugins/dataTables.bootstrap.js"/>"></script>  --%>
<%-- <script src="<spring:url value="/resource/datatables-responsive/dataTables.responsive.js"/>"></script>  --%>
<%-- <script src="<spring:url value="/resource/dataTableCustomJs/myJsDataTable.js"/>"></script>  --%>

</body>

</html>
