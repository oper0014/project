<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
 <h1>2015�г� 1�г� 1�б� ���� �Է� </h1>
 <form action="/struts2/gradePro.action">
	<table cellspacing="1" method="post">
	
	<td>��������</td>	 <select name="ssection">
	                 <option value=""></option>
		             <option value="�����ʼ�">�����ʼ�</option>
		             <option value="��������">��������</option>
		             <option value="���缱��">���缱��</option>
		             </select>
		   
		    <tr>
			<td>�й�</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>�����ڵ�</td>
			<td><input type="text" name="gnumber"></td>
		</tr>
		
		<tr>
			<td>����</td>
			<td><input type="text" name="sname"></td>
		</tr>
		<tr>
		<tr>
			<td>����</td>
			<td><input type="text" name="credit"></td>
		</tr>
		<tr>
			<td>����</td>
			<td><input type="text" name="average"></td>
		</tr>

		<td>����</td>
		<td><input type="text" name="grade"></td>
		</tr>

		<tr>
			<td colspan="2"><input type="submit" value="������"></td>
		</tr>
	</table>
</form>