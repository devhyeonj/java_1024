<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link href="<c:url value='/resources/css/summernote-bs4.min.css'></c:url>" rel="stylesheet">
<script src="<c:url value='/resources/js/summernote-bs4.min.js'></c:url>"></script>

<div class="container">
	<h1>게시글 확인</h1>
	<div class="form-group">
		<label>제목</label>
		<div class="form-control">${board.bo_title}</div>
	</div>
	<div class="form-group">
		<label>게시판</label>
		<div class="form-control">${board.bo_bt_num}</div>
	</div>
	<div class="form-group">
		<label>작성자</label>
		<div class="form-control">${board.bo_me_id}</div>
	</div>
	<div class="form-group">
		<label>작성일</label>
		<div class="form-control">${board.bo_register_date_str}</div>
	</div>
	<c:if test="${board.bo_update_date != null}">
		<div class="form-group">
			<label>수정일</label>
			<div class="form-control">${board.bo_update_date_str}</div>
		</div>
	</c:if>
	<div class="form-group">
		<label>조회수</label>
		<div class="form-control">${board.bo_views}</div>
	</div>
	<div class="form-group">
		<label>내용</label>
		<div class="form-control" style="min-height:400px">${board.bo_content}</div>
	</div>
	
		

</div>