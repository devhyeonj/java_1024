<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
 
<html>
<head>
<title>스프링</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'></c:url>">
	<script src="<c:url value='/spring/resources/js/jquery.min.js'></c:url>"></script>
	<script src="<c:url value='/spring/resources/js/popper.min.js'></c:url>"></script>
	<script src="<c:url value='/spring/resources/js/bootstrap.bundle.min.js'></c:url>"></script>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <div class="container" style="min-height:calc(100vh - 240px)">        
        <tiles:insertAttribute name="body" />
    </div>                                                  
    <tiles:insertAttribute name="footer" />
</body>
</html>
