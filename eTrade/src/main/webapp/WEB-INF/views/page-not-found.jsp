<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<% response.setStatus(404); %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <jsp:include page="partials/head.jsp"></jsp:include>
    <title>404 error</title>
  </head>
  <body>
  <div class="page-404">
    <p class="text-404">404</p>

    <h2>Aww Snap!</h2>
    <p>Something went wrong or that page doesn’t exist yet. <br><a href='<spring:url value="/index"/>'>Return Home</a></p>
  </div>
  </body>
</html>
