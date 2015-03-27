<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<script src="//code.jquery.com/jquery-1.11.0.js"></script>
    <script>
      $( document ).ready( function() {
        $( '.check-all' ).click( function() {
          $( '.ab' ).prop( 'checked', this.checked );
        } );
      } );
    </script>
</head>
<h2>Class Room Editor</h2>
<form method="post" action="adminmenu.action">
<input type="hidden" name="flag" value="20">
<input type="hidden" name="flag2" value="1">
이름<input type="text" name="croom" ><br />
정원<input type="text" name="cmax" ><br />
<input type="submit" value="생성" />
</form>
<hr>
<br />
<input type="checkbox" name="all" class="check-all"> <label>Check ALL</label>
<form method="post" action="adminmenu.action">
<input type="hidden" name="flag" value="20">
<input type="hidden" name="flag2" value="0">
<table width="360">
	<tr>
		<td width="80"><strong>번호</strong></td>
			<td width="200">강의실 이름</td>
			<td width="80">정원</td>
			<td width="80">체크박스</td>	
	</tr>
	<c:forEach items="${list}" var="result" varStatus="status">
		<tr>
			<td width="80">${status.count}</td>
			<td width="200">${result.croom}</td>
			<td width="80">${result.cmax}</td>
			<td width="80"><input type="checkbox" name="chk_info" value="${result.cnum}" class="ab"></td>
		</tr>
	</c:forEach>
</table>
<input type="submit" name="class_selected" value="delete" />
</form>