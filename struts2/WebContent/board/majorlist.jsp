<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>
	<h2>자료실</h2>
	<form method="post" action="menu.action"><!-- majorlist.action -->
		<input type="hidden" name="flag" value="15">
		<select name="selectMajornum">
			<c:forEach items="${list}" var="result">
				<option value="${result.majornum}">${result.majorname}</option>
			</c:forEach>
		</select> <input type="submit" value="조회" />
	</form>
	<br />
	<p>
	<table>
		<tr>
			<td width="50"><strong>번호</strong></td>
			<td width="400"><strong>제목</strong></td>
        	<td width="70"><strong>글쓴이</strong></td>
        	<td width="120"><strong>날짜</strong></td>
			<td width="50"><strong>조회</strong></td>
		</tr>
		<c:forEach items="${list2}" var="result">
			<tr>
				<td width="50">${result.no}</td><!-- viewAction2.action -->
				<td width="400"><a href="menu.action?flag=50&currentPage=${currentPage}&no=${result.no}">${result.subject}</a></td>
        		<td width="70">${result.id}</td>
        		<td width="120"> <fmt:formatDate pattern="yyyy-MM-dd" value="${result.regdate}">${result.regdate}</fmt:formatDate> </td>
				<td width="50">${result.readhit}</td>
			</tr>
		</c:forEach>		
</table>
<p>
<input type="button" value="글쓰기" class="inputb" onClick="javascript:location.href='writeForm2.action?currentPage=<s:property value="currentPage" />';">
</body>
</html>




