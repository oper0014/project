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
	전공 :
	<select name="ssection" onChange ="test(this.form)" >
		<option value ="list" selected>목록</option>
		<option value="1">컴퓨터공학과</option>
		<option value="2">영문학과</option>
		<option value="3">수학</option>
		<option value="4">사회</option>
	</select>
</table>

<table border = "1px" width = "800px">
	<tr>
		<td width = "100">과목코드</td><td width = "100">과목이름</td><td width = "100">강의시간</td><td width = "100">강의실</td><td width = "100">인정학점</td><td width = "100">교수번호</td><td width = "100">구분</td><td width = "100">조회</td>
	</tr>
	<c:if test = "${ssection == null }">
	<c:forEach var = "all_list" items = "${all_list }">
	<tr>
		<td>${all_list.snumber}</td><td>${all_list.sname}</td><td>${all_list.stime}</td><td>${all_list.sclass}</td><td>${all_list.scredit}</td><td>${all_list.proid}</td><td>${all_list.ssection}</td>
		<td><input type = "button" value ="조회" Onclick="win()">
	</c:forEach>
	</c:if>
	
	<c:if test = "${ssection != null }">
	
	<c:forEach var = "list"  items = "${list}">
	<tr> 
		 <td>${list.snumber }</td> <td>${list.sname }</td> <td>${list.stime }</td> <td>${list.sclass }</td> <td>${list.scredit }</td> <td>${list.proid }</td> <td>${list.ssection }</td>
		<td><input type="button" value="조회" OnClick="javascript:window.location='/struts2/program.action?snumber=${list.snumber}'"></td>
	</tr>
	</c:forEach>
	</c:if>
	
		</form>
</table>