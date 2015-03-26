<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<h2>예비군편입신고서 입력</h2>
<br />
<form action="/struts2/armypro.action">
	<!-- armypro에서 신고사항 작성 -->
	입영일 <input type="text" name="join" /> <br />
	 전역일 <input type="text" name="discharge" /> <br /> 
	 군번 <input type="text" name="armynumber" />
	<br /> <input type="submit" value="입력하기" />
</form>