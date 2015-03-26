<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<style>
/* Greyscale
Table Design by Scott Boyle, Two Plus Four
www.twoplusfour.co.uk
----------------------------------------------- */

table {border-collapse: collapse;
border: 2px solid #000;
font: normal 80%/140% arial, helvetica, sans-serif;
color: #555;
background: #fff;}

td, th {border: 1px dotted #bbb;
padding: .5em;}

caption {padding: 0 0 .5em 0;
text-align: center;
font-size: 1.4em;
font-weight: bold;
text-transform: uppercase;
color: #333;
background: transparent;}

/* =links
----------------------------------------------- */

table a {padding: 1px;
text-decoration: none;
font-weight: bold;
background: transparent;}

table a:link {border-bottom: 1px dashed #ddd;
color: #000;}

table a:visited {border-bottom: 1px dashed #ccc;
text-decoration: line-through;
color: #808080;}

table a:hover {border-bottom: 1px dashed #bbb;
color: #666;}

/* =head =foot
----------------------------------------------- */

thead th, tfoot th {border: 2px solid #000;
text-align: center;
font-size: 1.2em;
font-weight: bold;
color: #333;
background: transparent;}

tfoot td {border: 2px solid #000;}

/* =body
----------------------------------------------- */

tbody th, tbody td {vertical-align: top;
text-align: center;}

tbody th {white-space: nowrap;}

.odd {background: #fcfcfc;}

tbody tr:hover {background: #fafafa;}
</style>

<h2>전체 시간표 조회</h2>

	<form action="schedulesearch.action">
	전공 :
	<select name = "major">
		<option value = "">전공</option>
		<option value = "111">media software</option>
		<option value = "100">교양</option>
	</select>
	<input type = "submit" value = "검색" />
	<br />
	</form>
	
	<form action="schedulesearch.action">
	강의시간 : 
	<select name = "time">
		<option value = "">강의시간</option>
		<option value = "1">1교시</option>
		<option value = "2">2교시</option>
		<option value = "3">3교시</option>
		<option value = "4">4교시</option>
	</select>
	<input type = "submit" value = "검색" />
	</form>

	


<table border = "1px" width = "900px" align = "center">
	<tr>
		<td>과목코드</td>
		<td>과목명</td>
		<td>강의시간</td>
		<td>강의실</td>
		<td>학점</td>
		<td>교수</td>
		<td>전공구분</td>
	
	</tr>
	
	<c:forEach var = "dto" items = "${list}">
	<tr>
		<td>${dto.snumber}</td>
		<td>${dto.sname}</td>
		<td>${dto.stime}교시</td>
		<td>${dto.sclass}</td>
		<td>${dto.scredit}</td>
		<td>${dto.proname}</td>
		<td>
			<c:if test = "${(dto.ssection=='100')}">
			교양
			</c:if>
			<c:if test = "${!(dto.ssection=='100')}"> 
				${dto.majorname}
			</c:if>
		</td>
		
	</tr>
	</c:forEach>
</table>    