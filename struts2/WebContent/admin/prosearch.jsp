<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>교수 목록</title>
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

</head>
<body>
	<h2>교수 정보 보기</h2>

	<form action="adminmenu.action" method="post">
		<input type="hidden" name="flag" value="30">
		전공 : <select name="major">
			<option value="">전공 선택</option>
			<option value="미디어소프트웨어">미디어소프트웨어</option>
			<option value="컴퓨터공학">컴퓨터공학</option>
			<option value="영어교육">영어교육</option>
			<option value="화학과">화학과</option>
			<option value="의류학과">의류학과</option>
		</select> <input type="submit" value="검색" />
	</form>
	<table width="600px">
		<tr>
			<td>교수 이름</td>
			<td>학과</td>
			<td>E-mail</td>
			<td>전화번호</td>
			<td>재직 상태</td>
		</tr>
		<c:forEach var="dto" items="${list}">

			<tr>
				<td><a href = "adminmenu.action?id=${dto.id}&flag=31">${dto.name}</a>
				</td>
				<td>${dto.major }</td>
				<td>${dto.mail1}@${dto.mail2}</td> 
				<td>${dto.phonenumber1}- ${dto.phonenumber2} -
					${dto.phonenumber3}</td>
				<td>
				<c:if test="${dto.state == 1}">
					재직중
				</c:if>	
				<c:if test="${dto.state == 2}">
					휴직중
				</c:if>
				<c:if test="${dto.state !=2 && dto.state !=1}">
					정보없음
				</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>