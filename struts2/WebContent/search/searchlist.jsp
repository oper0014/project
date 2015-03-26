<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
	<script src="//code.jquery.com/jquery-1.11.0.js"></script>
    <script>
      $( document ).ready( function() {
        $( '.check-all' ).click( function() {
          $( '.ab' ).prop( 'checked', this.checked );
        } );
      } );
    </script>
</head>
<h2>학생검색</h2>
<form method="post" action="adminmenu.action">
	<!-- majorlist.action -->
	<input type="hidden" name="flag" value="7">
	<select	name="major">
		<option>All</option>
		<c:forEach items="${list}" var="result"><!-- 학과 -->
			<option value="${result.majorname}">${result.majorname}</option>
		</c:forEach>
	</select>
	<select name="grade"><!-- 학년 -->
		<option value="All">All</option>			
		<option value="1학년">1학년</option>
		<option value="2학년">2학년</option>
		<option value="3학년">3학년</option>
		<option value="4학년">4학년</option>
	</select>
	<select name="gender"><!-- 성별 -->
		<option value="0">All</option>		
		<option value="1">남자</option>
		<option value="2">여자</option>
	</select>
	<select name="state"><!-- 휴학상태 -->
		<option value="1">재학</option>
		<option value="2">일반휴학</option>
		<option value="3">군휴학</option>
	</select> 
	<input type="submit" value="검색" />
</form>
<p>
<input type="checkbox" name="all" class="check-all"> <label>Check ALL</label>
<form method="post" action="adminmenu.action">
<input type="hidden" name="flag" value="7">
<input type="hidden" name="flag2" value="1">
<input type="hidden" name="major" value="${dto.major }">
<input type="hidden" name="grade" value="${dto.grade }">
<input type="hidden" name="gender" value="${dto.gender }">
<input type="hidden" name="state" value="${dto.state }">

<table width="800">
	<tr>
		<td width="70">순서</td>
		<td width="70"><strong>학번</strong></td>
			<td width="70">이름</td>
			<td width="180">학과</td>
			<td width="70">학년</td>
			<td width="70">성별</td>
			<td width="70">재학</td>
			<td width="200">전화번호</td>
			<td width="70">체크박스</td>
			
	</tr>
	<c:forEach items="${list2}" var="result" varStatus="status">
		<tr>
			<td width="70">${status.count}</td>
			<td width="70"><a href="stsrtpro.action?flag=50&id=${result.id}">${result.id}</a></td>
			<td width="70">${result.name}</td>
			<td width="180">${result.major}</td>
			<td width="70">${result.grade}</td>
			<td width="70">
			<c:if test="${result.gender==1}">남성</c:if>
			<c:if test="${result.gender==2}">여성</c:if>
			</td>
			<td width="70">
			<c:if test="${result.state==1}">재학</c:if>
			<c:if test="${result.state==2}">휴학</c:if>
			<c:if test="${result.state==3}">군휴학</c:if>
			</td>
			<td width="200">${result.phonenumber1}-${result.phonenumber2}-${result.phonenumber3}</td>
			<td width="70"><input type="checkbox" name="chk_info" value="${result.id}" class="ab"></td>
		</tr>
	</c:forEach>
</table>
<input type="submit" name="grade_selected" value="학년업" />
<input type="submit" name="state_selected1" value="휴학처리" />
<input type="submit" name="state_selected2" value="복학처리" />
</form>