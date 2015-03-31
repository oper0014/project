<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
<body>
	<h3>교수 정보 변경</h3>
	<form action = "proInfoSubmit.action" method="post" >
	<input type="hidden" name="id" value="${dto.id}">
		<table width="600px">
		<tr>
			<td colspan = "2">
				<c:if test="${dto.state == 1}">
					재직중
				</c:if>	
				<c:if test="${dto.state == 2}">
					휴직중
				</c:if>
				<c:if test="${dto.state !=2 && dto.state !=1}">
					정보없음
				</c:if>
				&nbsp;&nbsp;
				<input type ="button" value = "변경" name = "pro_state" onclick="location.href='http://localhost:8000/struts2/prostate.action?id=${dto.id}'"/>
			</td>
		</tr>
		<tr>
			<td>교수 코드</td>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type = "text" size = "20" maxlength = "20" name = "name" value = "${dto.name}"></td>
		</tr>
		<tr>
			<td>전공 학과</td>
			<td><input type = "text" size = "20" maxlength = "20" name = "major" value = "${dto.major}"></td>
		</tr>
		<tr>
			<td>E-mail</td>
			<td><input type = "text" size = "10" maxlength = "15" name = "mail1" value = "${dto.mail1}">@
				<input type = "text" size = "10" maxlength = "15" name = "mail2" value = "${dto.mail2}"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type = "text" size = "5" maxlength = "8" name = "phonenumber1" value = "${dto.phonenumber1}">
			-<input type = "text" size = "5" maxlength = "8" name = "phonenumber2" value = "${dto.phonenumber2}">
			-<input type = "text" size = "5" maxlength = "8" name = "phonenumber3" value = "${dto.phonenumber3}"></td>
		</tr>
		<tr>
			<td colspan = "2">
			<input type ="button" value = "취소" onclick="location.href='http://localhost:8000/struts2/adminmenu.action?flag=8'"/>
			&nbsp;
			<input type = "submit" value = "정보 변경"/>
			</td>
		</tr>
	</table>
	</form>
</body>