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
<h1>시간이 중복 됩니다. 5초뒤에 페이지 이동 합니다.</h1>
</body>
</html>