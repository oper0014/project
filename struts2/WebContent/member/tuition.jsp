<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>µî·Ï±Ý ³³ºÎ</h2>
<br />
ÇÐ¹ø :${sessionScope.memId}
<br />
2015³â ${dto.term }
<br />
³³ºÎ ±Ý¾×:${dto.money }
<br />
<c:if test="${dto.checkmoney==0 }">
	<!-- ¹Ì³³ºÎ -->
	¹Ì³³ºÎ
</c:if>
<c:if test="${dto.checkmoney==1 }">
	<!-- ¹Ì³³ºÎ -->
	³³ºÎ
</c:if>

<br />
<br />
<br />
³³ºÎ°èÁÂ:1123123123
<br />
