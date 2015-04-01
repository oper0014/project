<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table{
    width: 700px;
    height : 800px;
    border: 3px solid #bcbcbc;
    padding : 50;
    background : url("/struts2/admin/img/kh.png");
  }

</style>
</head>
<body>
<table align="center" background="/struts2/admin/img/kh.png">
	<tr>
		<td style = "padding:20"><center><h1>졸업 증명서</h1></center></td>
	</tr>
	<c:forEach var="dto" items="${list}">
	<tr >
		<td style = "padding-left : 50px">학번 : ${dto.id}</td> 
	</tr>
	
	<tr>
		<td style = "padding-left : 50px">성명 : ${dto.name}</td> 
	</tr>
	<tr>
		<td style = "padding-left : 50px">학과(부): ${dto.major}</td>
	</tr>
<c:if test="${dto.major2 != '' && dto.minor != ''}">
	<tr>
		<td style = "padding-left : 50px">부전공 : ${dto.major2} , ${dto.minor}</td>
	</tr>
</c:if>

<c:if test="${dto.major2 != '' && dto.minor == ''}">
	<tr>
		<td style = "padding-left : 50px">부전공 : ${dto.major2}</td>
	</tr>
</c:if>
	<tr>
		<td style = "padding-left : 50px">전공(학위): ${dto.major}</td>
	</tr>
		<tr>
		<td style = "padding-left : 50px">학위(등록)번호 : ${degree}</td>
	</tr>
</c:forEach>
	<tr>
		<td style = "padding-left : 50px">졸업년월일 : 
		<c:if test="${month > 8}">
		${year+1}년 2월 20일
		</c:if>
		<c:if test="${month <= 8}">
		${year}년 8월 10일
		</c:if>
		</td>
	</tr>

	<tr>
		<td><center>위의 사실을 증명합니다.</center> </td>
	</tr>
	<tr>
		<td style = "padding:20"><center>KH대학교 총장</center></td>
	</tr>
</table>
 <center><a href="http://localhost:8000/struts2/adminmenu.action?flag=6">[뒤로가기]</a></center>
</body>
</html>