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
text-align: left;
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
text-align: left;
font-size: 1.2em;
font-weight: bold;
color: #333;
background: transparent;}

tfoot td {border: 2px solid #000;}

/* =body
----------------------------------------------- */

tbody th, tbody td {vertical-align: top;
text-align: left;}

tbody th {white-space: nowrap;}

.odd {background: #fcfcfc;}

tbody tr:hover {background: #fafafa;}

</style>

<script language="JavaScript">  
	function AlertBox(){
        alert("신청이 완료되었습니다.");
        document.location.reload();
     return false;
	}
</script>
<h2>복학/휴학 신청</h2>
<table border = "1px" width = "500">
	<tr>
		<td>학번</td><td>${dto.id}</td>
	</tr>
	<tr>
		<td>이름</td><td>${dto.name} </td>
	</tr>
	<tr>
		<td>전공</td><td>${dto.major} </td>
	</tr>	
	<tr>	
		<td>부전공</td><td>${dto.major2} </td>
	</tr>
	<tr>	
		<td>주소</td><td>${dto.address} </td>
	</tr>
	<tr>	
		<td>전화번호</td><td>${dto.phonenumber1}-${dto.phonenumber2}-${dto.phonenumber3}</td>
	</tr>
	<tr>	
		<td>학년</td>		<td>${dto.grade} </td>
	</tr>
	<tr>	
		<td>성별</td><td>${dto.gender} </td>
	</tr>
	<tr>	
		<td>e-mail</td><td>${dto.mail1}@${dto.mail2} </td>
	</tr>
	<tr>	
		<td>학적상태</td>
		
		<td>
		<c:if test="${dto.state=='1'}">
		재학중
		</c:if>
		<c:if test="${dto.state=='2'}">
		휴학중 
		</c:if>
		<c:if test="${dto.state=='3'}">
		군휴학중 
		</c:if>
		<c:if test="${dto.state=='4'}">
		졸업
		</c:if>
		<c:if test="${dto.state=='5'}">
		휴학대기중
		</c:if>
		<c:if test="${dto.state=='6'}">
		복학대기중
		</c:if>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type = "button" value = "신청" onclick="location.href='http://localhost:8000/struts2/gobackSubmit.action'"/>
		
		</td>
	</tr>
</table>

