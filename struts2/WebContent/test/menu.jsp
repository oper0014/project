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
		<a href="/struts2/menu.action?flag=0">공지사항</a><br />
		<a href="/struts2/menu.action?flag=1">학생정보</a><br /> <a
			href="/struts2/menu.action?flag=2">학생성적조회</a><br /> <a
			href="/struts2/menu.action?flag=3">학생등록금 납부</a><br /> <a
			href="/struts2/menu.action?flag=4">복학신청(휴학신청)</a><br /> <a
			href="/struts2/menu.action?flag=5">예비군편입신고서</a><br /> <a
			href="/struts2/menu.action?flag=6">전체시간표</a><br /> <a
			href="/struts2/menu.action?flag=7">시간표 조회</a><br /> <a
			href="/struts2/menu.action?flag=8">수강신청</a><br /> <a
			href="/struts2/menu.action?flag=9">개인정보 변경</a><br /> <a
			href="/struts2/menu.action?flag=11">강의계획서</a><br /> <a
			href="/struts2/menu.action?flag=12">강의만족도</a><br /> <a
			href="/struts2/menu.action?flag=13">이수학점 조회</a><br /> <a
			href="/struts2/menu.action?flag=14">계절학기</a><br /><a
			href="/struts2/menu.action?flag=15">학과 자료실</a><br />
	</div>

	<div id="section">
		<!--페이지   -->
		<c:if test="${flag==0 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="artboard" executeResult="true" />
		</c:if>
		<c:if test="${flag==1 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="stduentinfo" executeResult="true" />
		</c:if>
		<c:if test="${flag==2 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="grade" executeResult="true" />
		</c:if>
		<c:if test="${flag==3 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="tuition" executeResult="true" />
		</c:if>
		<c:if test="${flag==4 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="goback" executeResult="true" />
		</c:if>
		<c:if test="${flag==5 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="army" executeResult="true" />
		</c:if>
		<c:if test="${flag==6 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="totalschedule" executeResult="true" />
		</c:if>
		<c:if test="${flag==7 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="myschedule" executeResult="true" />
		</c:if>
		<c:if test="${flag==8 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="request" executeResult="true" />
		</c:if>
		<c:if test="${flag==9 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="info_modify" executeResult="true" />
		</c:if>
		<c:if test="${flag==11 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="class_plan" executeResult="true" />
		</c:if>
		<c:if test="${flag==12 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="class_satis" executeResult="true" />
		</c:if>
		<c:if test="${flag==13 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="credit" executeResult="true" />
		</c:if>
		<c:if test="${flag==15 }">
			<!-- 해당 메뉴 이동 -->
			<s:action name="majorlist" executeResult="true" />
		</c:if>
		<c:if test="${flag==50 }">
			<!-- 학과 자료실 뷰 -->
			<s:action name="viewAction2" executeResult="true" />
		</c:if>
		<c:if test="${flag==51 }">
			<!-- 학과 자료실 수정폼으로 -->
			<s:action name="modifyForm2" executeResult="true" />
		</c:if>
		<c:if test="${flag==52 }">
			<!-- 학과 자료실 삭제로 -->
			<s:action name="deleteAction2" executeResult="true" />
		</c:if>
	</div>
	<!--하단   -->
	<div id="footer">Copyright KH Academy B Class Team:6</div>

</body>
</html>
