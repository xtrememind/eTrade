   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
          <li class="${param.selected == 'home' ? 'active' : '' }">
            <a class="" href='<spring:url value="index"/>'>
                          <i class="icon_house_alt"></i>
                          <span>Dashboard</span>
                      </a>
          </li>
          <li class="${param.selected == 'employee' ? 'active' : '' }">
          <a class="" href='<spring:url value="users"/>'>
                          <i class="icon_briefcase"></i>
                          <span>Employees</span>
                      </a>
          </li>
          <li class="${param.selected == 'customer' ? 'active' : '' }">
            <a class="" href='<spring:url value="customers"/>'>
                  <i class="icon_group"></i>
                  <span>Customers</span>
            </a>
          </li>
          <li class="${param.selected == 'order' ? 'active' : '' }">
            <a class="" href='<spring:url value="orders"/>'>
                  <i class="icon_group"></i>
                  <span>Orders</span>
            </a>
          </li>
          <li class="${param.selected == 'stock' ? 'active' : '' }">
            <a class="" href='<spring:url value="stocks"/>'>
                  <i class="icon_cart_alt"></i>
                  <span>Stocks</span>
            </a>
          </li>
          <li class="${param.selected == 'account' ? 'active' : '' }">
            <a class="" href='<spring:url value="accounts"/>'>
                  <i class="icon_currency_alt"></i>
                  <span>Accounts</span>
            </a>
          </li>
         

        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>