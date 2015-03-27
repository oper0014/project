<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	
	<p>
	<h2>강좌 개설</h2><hr><br />
	<form action="adminmenu.action" method="post">
	<input type="hidden" name="flag" value="11">
	<tabele width="800">
	<tr>
	<td width="200">강좌명 <input type="text" name="sname"  size="12"></td>
	<td width="200">교수ID <input type="text" name="proid" size="9"></td>
	<td width="200">
	<select name="scredit">	
		<option value="1">1학점</option>
		<option value="2">2학점</option>
		<option value="3">3학점</option>
		<option value="4">4학점</option>
	</select>
	</td>
	<td width="200">수강인원 <input type="number" name="max" size="4"></td>
	</tr>
	<tr>
	<td width="200"> <select name="year">	
		<option value="2015">2015</option>
		<option value="2016">2016</option>
	</select>
	</td>
	<td width="200">
	<select name="term">	
		<option value="1">1학기</option>
		<option value="2">2학기</option>
	</select>
	</td>
	<td width="200">
	<select name="grade">	
		<option value="1">1학년</option>
		<option value="2">2학년</option>
		<option value="3">3학년</option>
		<option value="4">4학년</option>
	</select>
	</td>
	<td width="200">
	<select name="sday">	
		<option value="뭘">월</option>
		<option value="화">화</option>
		<option value="수">수</option>
		<option value="목">목</option>
		<option value="금">금</option>
	</select>
	</td>
	</tr>
	<tr>
	<td width="200">시간 <input type="text" name="stime" size="12"></td>
	<td width="200">교실
	<select name="sclass">	
	<c:forEach items="${list3}" var="result3">
	<option value="${result3.croom}">${result3.croom} =정원=${result3.cmax} </option>
	</c:forEach>
	</select>
	</td>
	<td width="200">이수코드 <input type="text" name="ssection" size="5"></td>
	<td width="200">과목코드 <input type="text" name="snumber" size="12"></td>
	</tr>
	</tabele>
	<input type="submit" value="개설" />
	</form>
	</p>
	<p>
	<hr>
	<h2>과목검색</h2>
	<form method="post" action="adminmenu.action">
	<!-- majorlist.action -->
	<input type="hidden" name="flag" value="5">
	<select	name="year">
		<option value="2015">2015</option>
		<option value="2014">2014</option>
	</select>
	<select name="term"><!-- 학기 -->
		<option value="All">All</option>			
		<option value="1">1학기</option>
		<option value="2">2학기</option>
	</select>
	<!--  
	<select name="ssection">
		<option value="0">All</option>		
		<option value="1">교양</option>
		<option value="2">전공</option>
	</select>
	-->
	<select name="grade"><!--학년 -->
		<option value="All">전학년</option>
		<option value="1">1학년</option>
		<option value="2">2학년</option>
		<option value="3">3학년</option>
		<option value="4">4학년</option>
	</select> 
	<input type="submit" value="검색" />
</form>
</p>
<hr>
<table width="1050">
	<tr>
		<td width="70">순서</td>
		<td width="140">과목명</td>
		<td width="70">교실</td>
		<td width="70">학점</td>
		<td width="70">교수ID</td>
		<td width="70">교수명</td>
		<td width="70">이수구분</td>
		<td width="70">연도</td>
		<td width="70">학기</td>
		<td width="70">학년</td>
		<td width="70">수강최대인원</td>
		<td width="70">수강신청인원</td>
		<td width="70">요일</td>
		<td width="70">시간</td>
	</tr>
	<c:forEach items="${list}" var="result" varStatus="status">
		<tr>
			<td width="70">${status.count}</td>
			<td width="140"><a href="adminmenu.action?flag=12&snumber=${result.snumber}&flag2=0">${result.sname}</a></td>
			<td width="70">${result.sclass}</td>
			<td width="70">${result.scredit}</td>
			<td width="70">${result.proid}</td>
			<td width="70">
			<c:forEach items="${list2}" var="result2">
			<c:if test="${result.proid==result2.id}">
			${result2.name}
			</c:if>
			</c:forEach>
			</td>
			<td width="70">>${result.ssection}</td>
			<td width="70">${result.year}</td>
			<td width="70">${result.term}</td>
			<td width="70">${result.grade}</td>
			<td width="70">${result.max}</td>
			<td width="70">${result.count}</td>
			<td width="70">${result.sday}</td>
			<td width="70">${result.stime}</td>
		</tr>
	</c:forEach>
</table>



