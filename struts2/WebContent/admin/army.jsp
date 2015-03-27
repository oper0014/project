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
<p>
<form action="adminmenu.action" method="post">
	<input type="hidden" name="flag" value="15">
	<input type="hidden" name="flag2" value="1">
	<select name="state">	
		<option value="0">脚没磊</option>
		<option value="1">脚没贸府</option>
	</select>
	<input type="submit" value="八祸" />
</form>
</p>

<hr>
<input type="checkbox" name="all" class="check-all"> <label>Check ALL</label>
<form action="adminmenu.action" method="post">
	<input type="hidden" name="flag" value="15">
	<input type="hidden" name="flag2" value="2">
<table width="725">
	<tr>
		<td width="150">脚没老磊</td>
		<td width="100">涝康老</td>
		<td width="100">傈开老</td>
		<td width="75">焙锅</td>
		<td width="75">贸府惑怕</td>
		<td width="150">贸府老磊</td>
		<td width="75">眉农冠胶</td>
	</tr>
	<c:forEach items="${list}" var="result" varStatus="status">
		<tr>
			<td width="150">${result.askdate}</td>
			<td width="100">${result.join}</td>
			<td width="100">${result.discharge}</td>
			<td width="75">${result.armynumber}</td>
			<td width="75">
			<c:if test="${result.state==0}">
			脚没磊
			</c:if>
			<c:if test="${result.state==1}">
			贸府肯丰
			</c:if>
			</td>
			<td width="150">>${result.reg_date}</td>
			<td width="75"><input type="checkbox" name="chk_info" value="${result.id}" class="ab"></td>
		</tr>
	</c:forEach>
</table>
<input type="submit" value="贸府" />
</form>