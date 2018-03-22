<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="partials/head.jsp"></jsp:include>
  <title>Accounts</title>
</head>
<body>
  <!-- container section start -->
  <section id="container" class="">
    <!--header start-->
    <jsp:include page="partials/header.jsp"></jsp:include>
    <!--header end-->
    <!--sidebar start-->
	<jsp:include page="partials/sidebar.jsp">
        <jsp:param name="selected" value="account" />
    </jsp:include>
    <!--sidebar end-->
     <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa fa-bars"></i>Accounts</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="<spring:url value="/index"/>">Home</a></li>
              <li><i class="fa fa-bars"></i>Accounts</li>
            </ol>
          </div>
        </div>
        <!-- page start-->
         <div class="row">
        	<div class="col-lg-3"></div>
        	<div class="col-lg-6">
            <section class="panel">
              <header class="panel-heading">
              	Accounts
              </header>
              <div class="panel-body" style="padding: 30px;">
				<div class="form-group">
					<label for="customers">Customers</label>
					<select id="customerId" class="form-control">
						<option value="0" >Select a Customer</option>
						<c:forEach items="${customers}" var="customer">
							<option value="${customer.id}" balance="${customer.cashAccount.balance }" >${customer.name}</option>
						</c:forEach>
					</select>
				</div>

				<div id="resultStock"></div>
					
				
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
 
 <script>
 $(document).ready(function() { 
	 $('#customerId').on('change', function() {
		  if(this.value=="0"){
			  $("#resultStock").html("");
		  }else{
			  $.ajax({
			        url: "/eTrade/accounts/ajaxDetails/"+$('#customerId').val(),
			        success: function(result) {
			        	var balance = $('option:selected').attr('balance');
						var showBalance = '<div class="form-group"><label for="balance">Balance</label><input type="text" value="'+balance+'" readonly class="form-control" /></div>'
						
			        	var showPortBal = '<div class="form-group"><table class="table table-striped table-advance table-hover"><tbody>'+
			              
		                  '<tr><th><i></i>Stock Name</th><th><i>Stock code</i></th></tr>'
			        	   result.forEach(function(portBalance){
			        		   showPortBal+="<tr><td>"+portBalance.stock.name+"</td><td>"+portBalance.stock.code+"</td></tr>";
			        		});
			        	showPortBal+='</tbody></table></div>';
			        	$("#resultStock").html(showBalance+showPortBal);
			        }
			  	
			    });
			 
		  }
		})
 });
 </script>

</body>
</html>
