<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script language="JavaScript">
	function test(form){
		window.location="class_plan.action?ssection="+form.ssection.value;
	}
	

</script>

<table>
<form method="post" action="inputPro.action" name="userinput" >
	���� :
	<select name="ssection" onChange ="test(this.form)" >
		<option value ="list" selected>���</option>
		<option value="1">��ǻ�Ͱ��а�</option>
		<option value="2">�����а�</option>
		<option value="3">����</option>
		<option value="4">��ȸ</option>
	</select>
</table>

<table border = "1px" width = "800px">
	<tr>
		<td width = "100">�����ڵ�</td><td width = "100">�����̸�</td><td width = "100">���ǽð�</td><td width = "100">���ǽ�</td><td width = "100">��������</td><td width = "100">������ȣ</td><td width = "100">����</td><td width = "100">��ȸ</td>
	</tr>
	<c:if test = "${ssection == null }">
	<c:forEach var = "all_list" items = "${all_list }">
	<tr>
		<td>${all_list.snumber}</td><td>${all_list.sname}</td><td>${all_list.stime}</td><td>${all_list.sclass}</td><td>${all_list.scredit}</td><td>${all_list.proid}</td><td>${all_list.ssection}</td>
		<td><input type = "button" value ="��ȸ" Onclick="win()">
	</c:forEach>
	</c:if>
	
	<c:if test = "${ssection != null }">
	
	<c:forEach var = "list"  items = "${list}">
	<tr> 
		 <td>${list.snumber }</td> <td>${list.sname }</td> <td>${list.stime }</td> <td>${list.sclass }</td> <td>${list.scredit }</td> <td>${list.proid }</td> <td>${list.ssection }</td>
		<td><input type="button" value="��ȸ" OnClick="javascript:window.location='/struts2/program.action?snumber=${list.snumber}'"></td>
	</tr>
	</c:forEach>
	</c:if>
	
		</form>
</table>