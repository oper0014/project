<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  
 <script>
	alert("요일,시간이 겹칩니다 ");
	window.location='/struts2/request_insert2.action?grade=${grade}&year=${year}&ssection=${ssection}&term=${term}'
</script>