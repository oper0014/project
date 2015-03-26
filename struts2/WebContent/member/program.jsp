<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>강의 계획서</h2>
<c:forEach var = "plan" items = "${sub_list }">
<table border = "10" align = "center" width = 800>
	<tr>
		<td width="100">과목명</td><td>${plan.sname }</td><td>강의실명</td><td>${plan.sclass}</td>
	</tr>
	
	<tr>
		<td width=200>담당교수</td><td>${plan.proid }</td><td>강의시간</td><td>${plan.stime }</td>
	</tr>
	
	<tr>
		<td width=5>연락처</td><td>${plan.phonenumber1 } - ${plan.phonenumber2 } - ${plan.phonenumber3 }</td><td>E-mail</td><td>${plan.mail1 }${plan.mail2 }</td>
	</tr>
</table>

<table border = "1" align = "center" width = "800">
	<tr>
		<td>강의개요 및 목적</td><td></td>
		<td>수업방법</td><td>${plan.curriculum }</td>
		<td>수업 교재</td><td>${plan.book }</td>
</table>

<table border = "1" align = "center" width = "800">
	<tr>
		<td>주차</td><td>강의주제 및 세부 내용</td>
	</tr>
	
	<tr>
		<td>1주</td><td>${plan.d_contents }</td>
	</tr>
	
	<tr>
		<td>2주</td><td></td>
	</tr>
	
	<tr>
		<td>3주</td><td></td>
	</tr>
	
	<tr>
		<td>4주</td><td></td>
	</tr>
	
	<tr>
		<td>5주</td><td></td>
	</tr>
	
	<tr>
		<td>6주</td><td></td>
	</tr>
	
	<tr>
		<td>7주</td><td></td>
	</tr>
	
	<tr>
		<td>8주</td><td></td>
	</tr>
	
	<tr>
		<td>9주</td><td></td>
	</tr>
	
	<tr>
		<td>10주</td><td></td>
	</tr>
	
	<tr>
		<td>11주</td><td></td>
	</tr>
</table>
</c:forEach>