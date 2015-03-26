<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!--  액션에서 세션값을 받아오는 작업해주고난뒤, -->
 

 	<table width="800" align="center" bgcolor="#FFFF99" border >
 		<tr>
 		 <c:if test="${sessionScope.memId==null}">
 			<td align="center"> <b> <a href="login.action">로그인</b> </td>
 		 </c:if>
 		 
 	 
 			<td align="center"> <b> <a href="request_insert.action">수강신청 입력</b> </td>
 			<td align="center"> <b> <a href="request_delete.action">수강신청 삭제</b> </td>
 			<td align="center"> <b> <a href="request_select.action">수강신청 조회</b> </td>
 		</tr>
 	</table>
 
  