<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>예비군편입신고서</h2>
<br />
<form action="/struts2/armyform.action">
	<!-- armypro에서 신고사항 작성 -->
	<c:if test="${dto2.askdate==null}">
		<input type="submit" value="신고하기" />
	</c:if>
</form>
<br />
<!--  
학과: 학년: 학번:<br/>
성명: 생년월일: <br/>
<br/>
-->
<table width="1000">
	<tr>
		<td>신청일자</td>
		<td>입영일</td>
		<td>전역일</td>
		<td>군번</td>
		<td>처리상태</td>
		<td>처리일자</td>
	</tr>
	<tr>
		<td>${dto2.askdate}</td>
		<td>${dto2.join}</td>
		<td>${dto2.discharge}</td>
		<td>${dto2.armynumber}</td>

		<td>
		<c:if test="${dto2.state==null}">
    	${dto2.state}
    	</c:if> 
    	<c:if test="${dto2.state==0}">
    	미처리
   	 	</c:if> 
   	 	<c:if test="${dto2.state==1}">
    	처리
    	</c:if>
    	</td>

		<td>${dto2.reg_date}</td>
	</tr>
</table>
<br />

<form action="/struts2/armydel.action">
	<!-- armypro에서 신고사항 삭제 -->
	<c:if test="${dto2.askdate!=null}">
		<input type="submit" value="신청취소" />
	</c:if>
</form>