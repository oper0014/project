<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form  method=post action="searchpro2.action" >
<input type="hidden" name="id" value="${dto.id }">
<table>
	<tr>
		<td>ID</td>
		<td>${dto.id }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${dto.name }</td>
	</tr>
	<tr>
		<td>학과</td>
		<td><input type=text name=major size=16 value="${dto.major }"></td>
	</tr>
	<tr>
		<td>학과2</td>
		<td><input type=text name=major2 size=16 value="${dto.major2 }"></td>
	</tr>
	<tr>
		<td>부전공</td>
		<td><input type=text name=minor size=16 value="${dto.minor }"></td>
	</tr>
	<tr>
		<td>학년</td>
		<td><input type=text name=grade size=16 value="${dto.grade }"></td>
	</tr>
	<tr>
		<td>재학</td>
		<td><input type=text name=state size=16 value="${dto.state }"></td>
	</tr>
</table>	
<input type="submit" value="수정" />
</from>
