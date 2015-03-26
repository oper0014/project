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
<h2>���� �ð�ǥ ��ȸ</h2>
<h3>�й� : ${session.memId}</h3>
<h4>�������</h4>
<table border="1px" width="900px" align="center">
	<tr>
		<td>�����ڵ�</td>
		<td>���Ǹ�</td>
		<td>���ǽð�</td>
		<td>���ǽ�</td>
		<td>����</td>
		<td>��米��</td>
		<td>��������</td>
	</tr>

	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.subnum}</td>
			<td>${dto.sname}</td>
			<td>${dto.sday}
		<c:forEach var="stime" items="${dto.stime}">
			${stime},
		</c:forEach>
			����
			</td>
			<td>${dto.sclass}</td>
			<td>${dto.scredit}</td>
			<td>${dto.proname}</td>
			<td>${dto.majorname}</td>
		</tr>
	</c:forEach>
</table>
<br />

<h4>�����ð�ǥ</h4>
<table width="900px" >
	<tr>
		<td></td>
		<td>������</td>
		<td>ȭ����</td>
		<td>������</td>
		<td>�����</td>
		<td>�ݿ���</td>
		<td>�����</td>
	</tr>

	<tr>
		<td>1����</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==1}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
			</c:if>
			</c:forEach></td>
			
		<td><c:forEach var="dto" items="${list}">
				<c:if test="${dto.sday=='ȭ'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==1}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
			</c:if>
			</c:forEach></td>
			
		<td><c:forEach var="dto" items="${list}">
				<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==1}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>		
				</c:if>
			</c:forEach></td>
			
		<td><c:forEach var="dto" items="${list}">
				<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==1}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
			
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==1}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
			
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
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
		<td>2����</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
			<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==2}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='ȭ'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==2}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==2}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
				<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==2}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
		<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==2}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==2}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
	</tr>

	<tr>
		<td>3����</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==3}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
				<c:if test="${dto.sday=='ȭ'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==3}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==3}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==3}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==3}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==3}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
	</tr>

	<tr>
		<td>4����</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==4}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='ȭ'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==4}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==4}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==4}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==4}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==4}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
	</tr>

	<tr>
		<td>5����</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==5}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='ȭ'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==5}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==5}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==5}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==5}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==5}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
	</tr>

	<tr>
		<td>6����</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==6}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='ȭ'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==6}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==6}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==6}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==6}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==6}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
	</tr>
	
	<tr>
		<td>7����</td>
		<td><c:forEach var="dto" items="${list}">
			<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==7}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='ȭ'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==7}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==7}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==7}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==7}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
		<td><c:forEach var="dto" items="${list}">
					<c:if test="${dto.sday=='��'}">
				<c:forEach var="stime" items="${dto.stime}">
				<c:if test="${stime==7}">
				${dto.sname} <br/> ${dto.sclass}
				</c:if>
				</c:forEach>
				</c:if>
			</c:forEach></td>
	</tr>

	
</table>



