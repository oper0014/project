<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
 <body>
	<%@include file="request_top.jsp" %> 
 	<table width="800" align="center" heigth="200">
 		<c:if test="${sessionScope.memId!=null }">
 			<tr>
 				<td align="center"> ${sessionScope.memId}님 접속하셨습니다 </td>
 			</tr>
 		</c:if> 
 		
 		<c:if test="${sessionScope.memId==null }">
 			<tr>
 				<td align="center">로그인 후  사용하세요</td>
 			</tr>
 		</c:if>   		
 	</table>
 </body>
</html>