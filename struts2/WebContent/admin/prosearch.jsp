<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ���</title>
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
	<h2>���� ���� ����</h2>

	<form action="adminmenu.action" method="post">
		<input type="hidden" name="flag" value="30">
		���� : <select name="major">
			<option value="">���� ����</option>
			<option value="�̵�����Ʈ����">�̵�����Ʈ����</option>
			<option value="��ǻ�Ͱ���">��ǻ�Ͱ���</option>
			<option value="�����">�����</option>
			<option value="ȭ�а�">ȭ�а�</option>
			<option value="�Ƿ��а�">�Ƿ��а�</option>
		</select> <input type="submit" value="�˻�" />
	</form>
	<table width="600px">
		<tr>
			<td>���� �̸�</td>
			<td>�а�</td>
			<td>E-mail</td>
			<td>��ȭ��ȣ</td>
			<td>���� ����</td>
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
					������
				</c:if>	
				<c:if test="${dto.state == 2}">
					������
				</c:if>
				<c:if test="${dto.state !=2 && dto.state !=1}">
					��������
				</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>