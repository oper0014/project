<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!--  �׼ǿ��� ���ǰ��� �޾ƿ��� �۾����ְ���, -->
 

 	<table width="800" align="center" bgcolor="#FFFF99" border >
 		<tr>
 		 <c:if test="${sessionScope.memId==null}">
 			<td align="center"> <b> <a href="login.action">�α���</b> </td>
 		 </c:if>
 		 
 	 
 			<td align="center"> <b> <a href="request_insert.action">������û �Է�</b> </td>
 	 
 		</tr>
 	</table>
 
  