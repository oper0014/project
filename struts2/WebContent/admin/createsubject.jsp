<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	
	<p>
	<h2>���� ����</h2><hr><br />
	<form action="adminmenu.action" method="post">
	<input type="hidden" name="flag" value="11">
	<tabele width="800">
	<tr>
	<td width="200">���¸� <input type="text" name="sname"  size="12"></td>
	<td width="200">����ID <input type="text" name="proid" size="9"></td>
	<td width="200">
	<select name="scredit">	
		<option value="1">1����</option>
		<option value="2">2����</option>
		<option value="3">3����</option>
		<option value="4">4����</option>
	</select>
	</td>
	<td width="200">�����ο� <input type="number" name="max" size="4"></td>
	</tr>
	<tr>
	<td width="200"> <select name="year">	
		<option value="2015">2015</option>
		<option value="2016">2016</option>
	</select>
	</td>
	<td width="200">
	<select name="term">	
		<option value="1">1�б�</option>
		<option value="2">2�б�</option>
	</select>
	</td>
	<td width="200">
	<select name="grade">	
		<option value="1">1�г�</option>
		<option value="2">2�г�</option>
		<option value="3">3�г�</option>
		<option value="4">4�г�</option>
	</select>
	</td>
	<td width="200">
	<select name="sday">	
		<option value="��">��</option>
		<option value="ȭ">ȭ</option>
		<option value="��">��</option>
		<option value="��">��</option>
		<option value="��">��</option>
	</select>
	</td>
	</tr>
	<tr>
	<td width="200">�ð� <input type="text" name="stime" size="12"></td>
	<td width="200">����
	<select name="sclass">	
	<c:forEach items="${list3}" var="result3">
	<option value="${result3.croom}">${result3.croom} =����=${result3.cmax} </option>
	</c:forEach>
	</select>
	</td>
	<td width="200">�̼��ڵ� <input type="text" name="ssection" size="5"></td>
	<td width="200">�����ڵ� <input type="text" name="snumber" size="12"></td>
	</tr>
	</tabele>
	<input type="submit" value="����" />
	</form>
	</p>
	<p>
	<hr>
	<h2>����˻�</h2>
	<form method="post" action="adminmenu.action">
	<!-- majorlist.action -->
	<input type="hidden" name="flag" value="5">
	<select	name="year">
		<option value="2015">2015</option>
		<option value="2014">2014</option>
	</select>
	<select name="term"><!-- �б� -->
		<option value="All">All</option>			
		<option value="1">1�б�</option>
		<option value="2">2�б�</option>
	</select>
	<!--  
	<select name="ssection">
		<option value="0">All</option>		
		<option value="1">����</option>
		<option value="2">����</option>
	</select>
	-->
	<select name="grade"><!--�г� -->
		<option value="All">���г�</option>
		<option value="1">1�г�</option>
		<option value="2">2�г�</option>
		<option value="3">3�г�</option>
		<option value="4">4�г�</option>
	</select> 
	<input type="submit" value="�˻�" />
</form>
</p>
<hr>
<table width="1050">
	<tr>
		<td width="70">����</td>
		<td width="140">�����</td>
		<td width="70">����</td>
		<td width="70">����</td>
		<td width="70">����ID</td>
		<td width="70">������</td>
		<td width="70">�̼�����</td>
		<td width="70">����</td>
		<td width="70">�б�</td>
		<td width="70">�г�</td>
		<td width="70">�����ִ��ο�</td>
		<td width="70">������û�ο�</td>
		<td width="70">����</td>
		<td width="70">�ð�</td>
	</tr>
	<c:forEach items="${list}" var="result" varStatus="status">
		<tr>
			<td width="70">${status.count}</td>
			<td width="140"><a href="adminmenu.action?flag=12&snumber=${result.snumber}&flag2=0">${result.sname}</a></td>
			<td width="70">${result.sclass}</td>
			<td width="70">${result.scredit}</td>
			<td width="70">${result.proid}</td>
			<td width="70">
			<c:forEach items="${list2}" var="result2">
			<c:if test="${result.proid==result2.id}">
			${result2.name}
			</c:if>
			</c:forEach>
			</td>
			<td width="70">>${result.ssection}</td>
			<td width="70">${result.year}</td>
			<td width="70">${result.term}</td>
			<td width="70">${result.grade}</td>
			<td width="70">${result.max}</td>
			<td width="70">${result.count}</td>
			<td width="70">${result.sday}</td>
			<td width="70">${result.stime}</td>
		</tr>
	</c:forEach>
</table>



