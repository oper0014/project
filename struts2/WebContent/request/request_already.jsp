<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 
 <script>
	alert("이미 수강신청한 과목입니다");
	window.location='/struts2/request_insert2.action?grade=${grade}&year=${year}&ssection=${ssection}&term=${term}'
</script>