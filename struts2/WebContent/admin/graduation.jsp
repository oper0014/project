<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table{
    width: 700px;
    height : 800px;
    border: 3px solid #bcbcbc;
    padding : 50;
    background : url("/struts2/admin/img/kh.png");
  }

</style>
</head>
<body>
<table align="center" background="/struts2/admin/img/kh.png">
	<tr>
		<td style = "padding:20"><center><h1>���� ����</h1></center></td>
	</tr>
	<c:forEach var="dto" items="${list}">
	<tr >
		<td style = "padding-left : 50px">�й� : ${dto.id}</td> 
	</tr>
	
	<tr>
		<td style = "padding-left : 50px">���� : ${dto.name}</td> 
	</tr>
	<tr>
		<td style = "padding-left : 50px">�а�(��): ${dto.major}</td>
	</tr>
<c:if test="${dto.major2 != '' && dto.minor != ''}">
	<tr>
		<td style = "padding-left : 50px">������ : ${dto.major2} , ${dto.minor}</td>
	</tr>
</c:if>

<c:if test="${dto.major2 != '' && dto.minor == ''}">
	<tr>
		<td style = "padding-left : 50px">������ : ${dto.major2}</td>
	</tr>
</c:if>
	<tr>
		<td style = "padding-left : 50px">����(����): ${dto.major}</td>
	</tr>
		<tr>
		<td style = "padding-left : 50px">����(���)��ȣ : ${degree}</td>
	</tr>
</c:forEach>
	<tr>
		<td style = "padding-left : 50px">��������� : 
		<c:if test="${month > 8}">
		${year+1}�� 2�� 20��
		</c:if>
		<c:if test="${month <= 8}">
		${year}�� 8�� 10��
		</c:if>
		</td>
	</tr>

	<tr>
		<td><center>���� ����� �����մϴ�.</center> </td>
	</tr>
	<tr>
		<td style = "padding:20"><center>KH���б� ����</center></td>
	</tr>
</table>
 <center><a href="http://localhost:8000/struts2/adminmenu.action?flag=6">[�ڷΰ���]</a></center>
</body>
</html>