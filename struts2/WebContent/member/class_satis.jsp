<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<c:forEach var = "sur_list" items = "${list }">
	<c:if test = "${sessionScope.memId == sur_list.id }">
		<script>
			alert('�̹� ���� �򰡸� �Ϸ� �ϼ̽��ϴ�.');
			history.go(-1);
		</script>
	</c:if>
</c:forEach>
<form action = "class_satisPro.action">
<table border = "1" width = "500px">
<tr>
<td>������</td>
</tr>
<tr>
<td>�򰡳���</td><td>�ſ츸��</td><td>����</td><td>����</td><td>�Ҹ���</td><td>�ſ�Ҹ���</td>
</tr>
<tr>
	<td>1.test</td><td><input type = "radio" name = "s_set1" value ="5"/><td><input type = "radio" name = "s_set1" value ="4"/><td><input type = "radio" name = "s_set1" value ="3"/><td><input type = "radio" name = "s_set1" value ="2"/><td><input type = "radio" name = "s_set1" value ="1"/>
</td>
<tr>	
	<td>2.test2</td><td><input type = "radio" name = "s_set2" value ="5"/><td><input type = "radio" name = "s_set2" value ="4"/><td><input type = "radio" name = "s_set2" value ="3"/><td><input type = "radio" name = "s_set2" value ="2"/><td><input type = "radio" name = "s_set2" value ="1"/>
</tr>
<tr>	
	<td>3.test3</td><td><input type = "radio" name = "s_set3" value ="5"/><td><input type = "radio" name = "s_set3" value ="4"/><td><input type = "radio" name = "s_set3" value ="3"/><td><input type = "radio" name = "s_set3" value ="2"/><td><input type = "radio" name = "s_set3" value ="1"/>
</tr>

</table>


<tr>
<td>���ǻ���</td>
<td><input type = "text" name = "scontext" size = 100></td>
</tr>
<input type = "submit" value = "�Ϸ�">
</form>



