<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title> ${pageinfo}BeYou </title>

<meta name=viewport content="width=device-width , intial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
           <div class="navbar-header"> 
               <a class="navbar-brand" href="#"> BeYou </a>
           </div>
      <c:if test="${!sessionScope.loggedIn}">
           <ul class="nav navbar-nav"> 
             <li> <a href="<c:url value="/Home" />"> HOME </a></li>
             <li> <a href="<c:url value="/Login" />"> LOGIN  </a></li>
             <li> <a href="<c:url value="/Register" />"> REGISTER </a></li>
             <li> <a href="<c:url value="/AboutUs" />"> ABOUT US </a></li>
             <li> <a href="<c:url value="/ContactUs" />"> Contact US </a></li>
             </ul>
           </c:if>
           <c:if test="${sessionScope.loggedIn}">
           		<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
           			<ul class=" nav navbar-nav">
             			<li> <a href="<c:url value="/Product" />"> MANAGE PRODUCT </a></li>
            			 <li> <a href="<c:url value="/Category" />"> MANAGE CATEGORY </a></li>
             			<li> <a href="<c:url value="/ProductDisplay" />"> PRODUCT CATALOG </a></li>
             			<li> <a href="<c:url value="/cart" />">Cart</a></li>
           					</ul>
           						</c:if>
           		<c:if test="${sessionScope.role=='ROLE_USER'}">
           			<ul class="nav navbar-nav">
           			
           			<li> <a href="<c:url value="/userhome" />"> Home </a></li>
             			<li> <a href="<c:url value="/ProductDisplay" />"> PRODUCT CATALOG </a></li>
             					<li> <a href="<c:url value="/cart" />">Cart</a></li>
           					</ul>
           						</c:if>
           </c:if>						
           
         </div> 
         <c:if test="${sessionScope.loggedIn}">
<div class="nav navbar-nav navbar-right" style="float:left;width:100%">

<font color="white" face="calibri" size="2">Welcome: ${sessionScope.username}</font>
<a href="<c:url value="/perform_logout"/>" class="btn btn-danger" style="float:right; margin-right:15px;">Logout</a> 
</div>
</c:if>
     </nav>         
 </div> 
  


</body>

</html>