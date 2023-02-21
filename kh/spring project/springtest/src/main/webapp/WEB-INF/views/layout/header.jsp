<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
 
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<div class="container">
	  	<a class="navbar-brand" href="#" style="padding: 0">Navbar</a>
	  		<img height="40" alt="로고" src="<c:url value="/resources/img/bird.jpg"></c:url>">
	  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    	<span class="navbar-toggler-icon"></span>
	  	</button>
	  	<div class="collapse navbar-collapse" id="collapsibleNavbar">
	    	<ul class="navbar-nav">
	    	<c:if test="${user == null }">
		      	<li class="nav-item">
		        	<a class="nav-link" href="<c:url value='/signup'></c:url>">회원가입</a>
		      	</li>
		      	<li class="nav-item">
		      	
		        	<a class="nav-link" href="<c:url value='/login'></c:url>">로그인</a>
		      	</li>
		     </c:if>
		     <c:if test="${user != null }">
		      	<li class="nav-item">
		        	<a class="nav-link" href="<c:url value='/logout'></c:url>">로그아웃</a>
		      	</li> 
		      	<!-- a태그는 get -->
		      	<!-- post로 하고싶으면
		      	<form action="<c:url value='/logout'></c:url>" method= "post">
		      	 	<button class="nav-link" style="background:transparent;border:0">로그아웃</button>
		      	 form 태그는 주소입력이 아니라 폼태그를 무조건 눌러야지 로그아웃이 된다.-->
		     </c:if>   
	    	</ul>
		</div> 
	</div> 
</nav>