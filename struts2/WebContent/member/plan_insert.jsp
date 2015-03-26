<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>강의 계획서</h2>

<table border = "10" align = "center" width = 800>
	<tr>
		<td width="100">과목명</td><td><input type = "text" name = "sname"></td><td>강의실명</td><td><input type = "text" name = "sclass"></td>
	</tr>
	
	<tr>
		<td width=200>담당교수</td><td><input type = "text" name = "proid"></td><td>강의시간</td><td><input type = "text" name = "stime"></td>
	</tr>
	
	<tr>
		<td width=5>연락처</td><td><input type = "text" name = "phonenumber1"> - <input type = "text" name = "phonenumber2"> - <input type = "text" name = "phonenumber3"></td>
		<td>E-mail</td><td><input type = "text" name = "mail1">@<input type = "text" name = "mail2"></td>
	</tr>
</table>

<table border = "1" align = "center" width = "800">
	<tr>
		<td>강의개요 및 목적</td><td><input type = "text"></td>
		<td>수업방법</td><td><input type = "text" name = "curriculum"></td>
		<td>수업 교재</td><td><input type = "text" name = "book"></td>
</table>

<table border = "1" align = "center" width = "800">
	<tr>
		<td>주차</td><td>강의주제 및 세부 내용</td>
	</tr>
	
	<tr>
		<td>1주</td><td><input type = "text" name = "d_contents"></td>
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
