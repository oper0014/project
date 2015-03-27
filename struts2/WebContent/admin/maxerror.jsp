<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<!--  STYLE FILE INCLUDE -->
<script language="JavaScript">
function next()
{
	history.go(-1)();
	//location = "index.jsp";
}
</script>

<body onLoad="setTimeout('next()', 5000)">
<h1>정원보다 많이 입력하셥습니다. 5초뒤에 페이지 이동 합니다.</h1>
</body>
</html>