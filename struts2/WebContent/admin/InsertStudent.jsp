<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ȸ�� ����</title>
</head>
<style type="text/css">
table {
	border-spacing: 0;
}

table td, table th {
	padding: 2px;
}
</style>
<body>
	<center>
		<p>
		<h2>ȸ������</h2>
		<p />
		<form method="post" action="/struts2/signPro.action">
			<table cellspacing="1">
				<tr>
					<td>�й��Է�</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>��й�ȣ</td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td>�̸�</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" name="major"></td>
				</tr>

				<tr>
					<td>������</td>
					<td><input type="text" name="minor"></td>
				</tr>

				<tr>
					<td>��������</td>
					<td><input type="text" name="major2"></td>
				</tr>

				<td>�ּ�</td>
				<td><input type="text" name="address"></td>
				</tr>

				<tr>
					<td>�г�</td>
					<td><input type="text" name="grade"></td>
				</tr>

				<tr>
					<td>����</td>
					<td><input type="text" name="gender"></td>
				</tr>
				<tr>
					<td>�̸���<br>(���ڸ�)</br></td>
					<td><input type="text" name="mail1"></td>
				</tr>

				<tr>
					<td>�̸��� <br>(���ڸ�)</br></td>
					<td><input type="text" name="mail2"></td>
				</tr>

				<tr>
					<td>���л��� <br>(1:���� 2:���� 3:������)</br></td>
					<td><input type="text" name="state"></td>
				</tr>

				<tr>
					<td>�����ڵ� <br>(1:�л� 2:������ 3:����)</br></td>
					<td><input type="text" name="section"></td>
				</tr>

				<tr>
					<td>phone (���ڸ�)</td>
					<td><input type="text" name="phonenumber1"></td>
				</tr>

				<tr>
					<td>phone (�߰��ڸ�)</td>
					<td><input type="text" name="phonenumber2"></td>
				</tr>

				<tr>
					<td>phone (���ڸ�)</td>
					<td><input type="text" name="phonenumber3"></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="������"></td>
					<td colspan="2"><input type="reset" value="�ʱ�ȭ"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>