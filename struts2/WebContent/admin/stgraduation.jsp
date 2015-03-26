<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

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

<h2>���� ó��</h2>
<h3>���� ���� �л�</h3>
<table width = "800px">
	<tr>
		<td>�й�</td>
		<td>�̸�</td>
		<td>����</td>
		<td>������</td>
		<td>������</td>
		<td>�г�</td>
		<td>��������</td>
		<td>���̼�����</td>
		<td></td>
	</tr>
<c:forEach var="dto" items="${list}">
	<tr>
		<td>${dto.id}</td>
		<td>${dto.name}</td>
		<td>${dto.major}</td>
		<td>${dto.major2}</td>
		<td>${dto.minor}</td>
		<td>${dto.grade }</td>
		<td>
		<c:if test="${dto.state=='1'}">
		������
		</c:if>
		<c:if test="${dto.state=='2'}">
		������ 
		</c:if>
		</td>
		<td><center>${dto.total}</center></td>
		<td>
		<c:if test="${dto.total >= '140'&& dto.state != 4 }">
 			 <input type="button" value="���� ó��" OnClick="location.href='/struts2/graduation.action?id=${dto.id}'">
		</c:if>	
		<c:if test="${dto.total<'140'}">
			���� �Ұ�
		</c:if>
		</td>
	</tr>
</c:forEach>
</table>


