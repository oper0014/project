<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<form action="adminmenu.action" method="post">
<input type="hidden" name="snumber" value="${dto.snumber}">
<input type="hidden" name="flag" value="12">
<input type="hidden" name="flag2" value="1"><!-- 수정  -->
과목번호:: ${dto.snumber}
<br />
과목명 <input type="text" name="sname" value="${dto.sname}" size="12">
<br />
교실 <input type="text" name="sclass" value="${dto.sclass}" size="12">
<br />
학점 <input type="text" name="scredit" value="${dto.scredit}" size="12">
<br />
교수ID <input type="text" name="proid" value="${dto.proid}" size="12">
<br />
이수구분 <input type="text" name="ssection" value="${dto.ssection}" size="12">
<br />
연도 <input type="text" name="year" value="${dto.year}" size="12">
<br />
학기 <input type="text" name="term" value="${dto.term}" size="12">
<br />
학년 <input type="text" name="grade" value="${dto.grade}" size="12">
<br />
수강최대인원 <input type="text" name="max" value="${dto.max}" size="12">
<br />
요일 <input type="text" name="sday" value="${dto.sday}" size="12">
<br />
시간 <input type="text" name="stime" value="${dto.stime}" size="12">
<br />
<input type="submit" value="수정" />
</form>
<form action="adminmenu.action">
<input type="hidden" name="snumber" value="${dto.snumber}">
<input type="hidden" name="flag" value="12">
<input type="hidden" name="flag2" value="2"><!-- 삭제  -->
<input type="submit" value="삭제" />
</form>