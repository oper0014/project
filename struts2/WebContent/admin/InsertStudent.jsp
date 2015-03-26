<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
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
		<h2>회원가입</h2>
		<p />
		<form method="post" action="/struts2/signPro.action">
			<table cellspacing="1">
				<tr>
					<td>학번입력</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>전공</td>
					<td><input type="text" name="major"></td>
				</tr>

				<tr>
					<td>부전공</td>
					<td><input type="text" name="minor"></td>
				</tr>

				<tr>
					<td>복수전공</td>
					<td><input type="text" name="major2"></td>
				</tr>

				<td>주소</td>
				<td><input type="text" name="address"></td>
				</tr>

				<tr>
					<td>학년</td>
					<td><input type="text" name="grade"></td>
				</tr>

				<tr>
					<td>성별</td>
					<td><input type="text" name="gender"></td>
				</tr>
				<tr>
					<td>이메일<br>(앞자리)</br></td>
					<td><input type="text" name="mail1"></td>
				</tr>

				<tr>
					<td>이메일 <br>(뒤자리)</br></td>
					<td><input type="text" name="mail2"></td>
				</tr>

				<tr>
					<td>휴학상태 <br>(1:재학 2:휴학 3:군휴학)</br></td>
					<td><input type="text" name="state"></td>
				</tr>

				<tr>
					<td>재학코드 <br>(1:학생 2:교직원 3:교수)</br></td>
					<td><input type="text" name="section"></td>
				</tr>

				<tr>
					<td>phone (앞자리)</td>
					<td><input type="text" name="phonenumber1"></td>
				</tr>

				<tr>
					<td>phone (중간자리)</td>
					<td><input type="text" name="phonenumber2"></td>
				</tr>

				<tr>
					<td>phone (뒤자리)</td>
					<td><input type="text" name="phonenumber3"></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="보내기"></td>
					<td colspan="2"><input type="reset" value="초기화"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>