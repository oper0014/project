<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
/* Greyscale
Table Design by Scott Boyle, Two Plus Four
www.twoplusfour.co.uk
----------------------------------------------- */
table {
	border-collapse: collapse;
	border: 2px solid #000;
	font: normal 80%/140% arial, helvetica, sans-serif;
	color: #555;
	background: #fff;
}

td, th {
	border: 1px dotted #bbb;
	padding: .5em;
}

caption {
	padding: 0 0 .5em 0;
	text-align: center;
	font-size: 1.4em;
	font-weight: bold;
	text-transform: uppercase;
	color: #333;
	background: transparent;
	
	
}

/* =links
----------------------------------------------- */
table a {
	padding: 1px;
	text-decoration: none;
	font-weight: bold;
	background: transparent;
}

table a:link {
	border-bottom: 1px dashed #ddd;
	color: #000;
}

table a:visited {
	border-bottom: 1px dashed #ccc;
	text-decoration: line-through;
	color: #808080;
}

table a:hover {
	border-bottom: 1px dashed #bbb;
	color: #666;
}

/* =head =foot
----------------------------------------------- */
thead th, tfoot th {
	border: 2px solid #000;
	text-align: center;
	font-size: 1.2em;
	font-weight: bold;
	color: #333;
	background: transparent;
}

tfoot td {
	border: 2px solid #000;
}

/* =body
----------------------------------------------- */
tbody th, tbody td {
	vertical-align: top;
	text-align: center;
}

tbody th {
	white-space: nowrap;
}

.odd {
	background: #fcfcfc;
}

tbody tr:hover {
	background: #fafafa;
}
</style>
<h2>개인 시간표 조회</h2>
<h3>학번 : ${session.memId}</h3>
<h4>수강목록</h4>
<table border="1px" width="900px" align="center">
	<tr>
		<td>과목코드</td>
		<td>강의명</td>
		<td>강의시간</td>
		<td>강의실</td>
		<td>학점</td>
		<td>담당교수</td>
		<td>전공구분</td>
	</tr>

	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.subnum}</td>
			<td>${dto.sname}</td>
			<td>${dto.sday}
		<c:forEach var="stime" items="${dto.stime}">
			${stime},
		</c:forEach>
			교시
			</td>
			<td>${dto.sclass}</td>
			<td>${dto.scredit}</td>
			<td>${dto.proname}</td>
			<td>${dto.majorname}</td>
		</tr>
	</c:forEach>
</table>
<br />

<h4>수강시간표</h4>
<table width="900px" >
	<tr>
		<td></td>
		<td>월요일</td>
		<td>화요일</td>
		<td>수요일</td>
		<td>목요일</td>
		<td>금요일</td>
		<td>토요일</td>
	</tr>

	<tr>
		<td>1교시</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='월'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==1}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
			</c:if>
			</c:forEach></td>
			
		<td><c:forEach var="dto" items="${list}">
				<c:if test="${dto.sday=='화'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==1}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
			</c:if>
			</c:forEach></td>
			
		<td><c:forEach var="dto" items="${list}">
				<c:if test="${dto.sday=='수'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==1}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>		
				</c:if>
			</c:forEach></td>
			
		<td><c:forEach var="dto" items="${list}">
				<c:if test="${dto.sday=='목'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==1}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
			
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='금'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==1}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
			
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='토'}">
					<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==1}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach>
			</td>
	</tr>

	<tr>
		<td>2교시</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='월'}">
			<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==2}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='화'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==2}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='수'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==2}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
				<c:if test="${dto.sday=='목'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==2}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='금'}">
		<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==2}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='토'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==2}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
	</tr>

	<tr>
		<td>3교시</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='월'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==3}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
				<c:if test="${dto.sday=='화'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==3}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='수'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==3}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='목'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==3}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='금'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==3}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='토'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==3}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
	</tr>

	<tr>
		<td>4교시</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='월'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==4}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='화'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==4}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='수'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==4}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='목'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==4}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='금'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==4}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='토'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==4}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
	</tr>

	<tr>
		<td>5교시</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='월'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==5}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='화'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==5}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='수'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==5}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='목'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==5}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='금'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==5}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='토'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==5}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
	</tr>

	<tr>
		<td>6교시</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='월'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==6}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='화'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==6}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='수'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==6}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='목'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==6}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='금'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==6}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='토'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==6}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
	</tr>
	
	<tr>
		<td>7교시</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='월'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==7}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='화'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==7}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='수'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==7}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='목'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==7}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='금'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==7}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='토'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==7}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
	</tr>

	
</table>



