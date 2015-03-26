<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
 <h1>2015학년 1학년 1학기 성적 입력 </h1>
 <form action="/struts2/gradePro.action">
	<table cellspacing="1" method="post">
	
	<td>전공선택</td>	 <select name="ssection">
	                 <option value=""></option>
		             <option value="전공필수">전공필수</option>
		             <option value="전공선택">전공선택</option>
		             <option value="교양선택">교양선택</option>
		             </select>
		   
		    <tr>
			<td>학번</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>전공코드</td>
			<td><input type="text" name="gnumber"></td>
		</tr>
		
		<tr>
			<td>과목</td>
			<td><input type="text" name="sname"></td>
		</tr>
		<tr>
		<tr>
			<td>학점</td>
			<td><input type="text" name="credit"></td>
		</tr>
		<tr>
			<td>평점</td>
			<td><input type="text" name="average"></td>
		</tr>

		<td>점수</td>
		<td><input type="text" name="grade"></td>
		</tr>

		<tr>
			<td colspan="2"><input type="submit" value="보내기"></td>
		</tr>
	</table>
</form>