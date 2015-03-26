<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<form action="modifyAction.action" method="post" enctype="multipart/form-data">
<input type="hidden" name="no" value="${no}">
<input type="hidden" name="currentPage" value="${currentPage}">
	제목:<input type="text" name=subject /> <br/>
	내용:<textarea cols="50" rows="10" name="content"></textarea><br/>
	
	<input type="submit" value="수정" />
</form>