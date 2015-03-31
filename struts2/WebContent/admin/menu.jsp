<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

<style>
#header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
}

#nav {
	line-height: 30px;
	background-color: #eeeeee;
	height: 700px;
	width: 100px;
	float: left;
	padding: 5px;
}

#section {
	width: 350px;
	float: left;
	padding: 10px;
}

#footer {
	background-color: black;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>
</head>

<body>
	<c:if test="${sessionScope.memId==null }">
		<!-- 새션이 삭제되면 login.action으로 자동 이동  -->
		<meta http-equiv="Refresh" content="0;url=/struts2/login.action">
	</c:if>

	<div id="header">
		<!--상단   -->
		<h2>
			환영 합니다.!! &nbsp;&nbsp;&nbsp; ID:${sessionScope.memId}&nbsp;&nbsp;<a
				href="/struts2/logout.action?id=${sessionScope.memId}">logout</a>
		</h2>
	</div>

	<div id="nav">
		<!--메뉴바   -->
		 <a
			href="/struts2/adminmenu.action?flag=2">회원가입</a><br /> <a
			href="/struts2/adminmenu.action?flag=3">성적입력</a><br /> <a
			href="/struts2/adminmenu.action?flag=5">강좌개설</a><br /> <a
			href="/struts2/adminmenu.action?flag=6">졸업처리</a><br /> <a
			href="/struts2/adminmenu.action?flag=7">학생검색</a><br /> <a
			href="/struts2/adminmenu.action?flag=8">교수목록</a><br />
			<a href="/struts2/adminmenu.action?flag=15">군입영 처리</a><br />
			<a href="/struts2/adminmenu.action?flag=20">강의실 편집</a><br />
	</div>

	<div id="section">
		<!--페이지   -->
		<c:if test="${flag==1 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="stduentinfo" executeResult="true" />
		</c:if>
		<c:if test="${flag==2 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="sign" executeResult="true" />
		</c:if>
		<c:if test="${flag==3 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="gradeform" executeResult="true" />
		</c:if>
		<c:if test="${flag==4 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="stregister" executeResult="true" />
		</c:if>
		<c:if test="${flag==5 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="createsubject" executeResult="true" />
		</c:if>
		<c:if test="${flag==6 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="stgraduation" executeResult="true" />
		</c:if>
		<c:if test="${flag==7 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="stsearch" executeResult="true" />
		</c:if>
		<c:if test="${flag==8 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="prosearch" executeResult="true" />
		</c:if>
		<c:if test="${flag==11 }">
			<!--강좌 만들기 -->
			<s:action name="createsubjectpro" executeResult="true" />
		</c:if>
		<c:if test="${flag==12 }">
			<!-- 강좌 편집 -->
			<s:action name="updatesubject" executeResult="true" />
		</c:if>
		<c:if test="${flag==15 }">
			<!-- 강좌 편집 -->
			<s:action name="armyadmin" executeResult="true" />
		</c:if>
		<c:if test="${flag==20 }">
			<!-- 강좌 편집 -->
			<s:action name="classroomadmin" executeResult="true" />
		</c:if>
		<c:if test="${flag==30 }">
			<!-- 교수 목록 -->
			<s:action name="promajorsearch" executeResult="true" />
		</c:if>
		<c:if test="${flag==31 }">
			<!-- 교수 정보 편집 -->
			<s:action name="promodify" executeResult="true" />
		</c:if>
		
		
	</div>
	<!--하단   -->
	<div id="footer">Copyright KH Academy B Class Team:6</div>

</body>
</html>
