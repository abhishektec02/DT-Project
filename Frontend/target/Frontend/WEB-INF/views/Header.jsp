<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${pageinfo}-FashionWorld</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
</script>

</head>
<body>

<div class="container">
<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="#">Fashion World</a>
</div>
        <c:if test="${!sessionScope.loggedIn}">
<ul class="nav navbar-nav">
<li><a href="Home">Home</a></li>
<li><a href="<c:url value="/Login"/>">Login</a></li>
<li><a href="<c:url value="/AboutUs"/>"/>Register</a></li>
<li><a href="<c:url value="/ContactUs"/>"/>Contact Us</a></li>
<li><a href="<c:url value="/AboutUs"/>"/>About US</a></li>
           </ul>
           </c:if>
            <c:if test="${sessionScope.loggedIn}">
            <c:if test="${sessionScope.role=='ROLE_ADMIN'}">
            <ul  class="nav navbar-nav">
<li><a href="<c:url value="/Category"/>">Manage Category</a></li>
<li><a href="<c:url value="/Product"/>">Manage Product</a></li>
<li><a href="<c:url value="/ProductDisplay"/>">Product Catalog</a></li>
 </c:if>
 <c:if test="${sessionScope.role=='ROLE_USER'}">
            <ul  class="nav navbar-nav">  
<li><a href="<c:url value="/UserHome"/>">Home</a></li>
<li><a href="<c:url value="/ProductDisplay"/>">Product Catalog</a></li>
</ul>
 </c:if>
 </c:if>
</div>
            <c:if test="${sessionScope.loggedIn}">
<div class="nav vavbar-nav navbar-center">
<font color="white" face="calibri" size="2">Walcome : ${sessionScope.username}</font>
<a href="<c:url value="/perform_logout"/>" class="btn btn-danger">Logout</a>
</div>
</c:if>
</nav>
</div>
