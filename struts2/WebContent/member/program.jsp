<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>���� ��ȹ��</h2>
<c:forEach var = "plan" items = "${sub_list }">
<table border = "10" align = "center" width = 800>
	<tr>
		<td width="100">�����</td><td>${plan.sname }</td><td>���ǽǸ�</td><td>${plan.sclass}</td>
	</tr>
	
	<tr>
		<td width=200>��米��</td><td>${plan.proid }</td><td>���ǽð�</td><td>${plan.stime }</td>
	</tr>
	
	<tr>
		<td width=5>����ó</td><td>${plan.phonenumber1 } - ${plan.phonenumber2 } - ${plan.phonenumber3 }</td><td>E-mail</td><td>${plan.mail1 }${plan.mail2 }</td>
	</tr>
</table>

<table border = "1" align = "center" width = "800">
	<tr>
		<td>���ǰ��� �� ����</td><td></td>
		<td>�������</td><td>${plan.curriculum }</td>
		<td>���� ����</td><td>${plan.book }</td>
</table>

<table border = "1" align = "center" width = "800">
	<tr>
		<td>����</td><td>�������� �� ���� ����</td>
	</tr>
	
	<tr>
		<td>1��</td><td>${plan.d_contents }</td>
	</tr>
	
	<tr>
		<td>2��</td><td></td>
	</tr>
	
	<tr>
		<td>3��</td><td></td>
	</tr>
	
	<tr>
		<td>4��</td><td></td>
	</tr>
	
	<tr>
		<td>5��</td><td></td>
	</tr>
	
	<tr>
		<td>6��</td><td></td>
	</tr>
	
	<tr>
		<td>7��</td><td></td>
	</tr>
	
	<tr>
		<td>8��</td><td></td>
	</tr>
	
	<tr>
		<td>9��</td><td></td>
	</tr>
	
	<tr>
		<td>10��</td><td></td>
	</tr>
	
	<tr>
		<td>11��</td><td></td>
	</tr>
</table>
</c:forEach>