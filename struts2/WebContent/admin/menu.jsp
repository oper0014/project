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
		<!-- ������ �����Ǹ� login.action���� �ڵ� �̵�  -->
		<meta http-equiv="Refresh" content="0;url=/struts2/login.action">
	</c:if>

	<div id="header">
		<!--���   -->
		<h2>
			ȯ�� �մϴ�.!! &nbsp;&nbsp;&nbsp; ID:${sessionScope.memId}&nbsp;&nbsp;<a
				href="/struts2/logout.action?id=${sessionScope.memId}">logout</a>
		</h2>
	</div>

	<div id="nav">
		<!--�޴���   -->
		 <a
			href="/struts2/adminmenu.action?flag=2">ȸ������</a><br /> <a
			href="/struts2/adminmenu.action?flag=3">�����Է�</a><br /> <a
			href="/struts2/adminmenu.action?flag=5">���°���</a><br /> <a
			href="/struts2/adminmenu.action?flag=6">����ó��</a><br /> <a
			href="/struts2/adminmenu.action?flag=7">�л��˻�</a><br /> <a
			href="/struts2/adminmenu.action?flag=8">�������</a><br />
			<a href="/struts2/adminmenu.action?flag=15">���Կ� ó��</a><br />
			<a href="/struts2/adminmenu.action?flag=20">���ǽ� ����</a><br />
	</div>

	<div id="section">
		<!--������   -->
		<c:if test="${flag==1 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="stduentinfo" executeResult="true" />
		</c:if>
		<c:if test="${flag==2 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="sign" executeResult="true" />
		</c:if>
		<c:if test="${flag==3 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="gradeform" executeResult="true" />
		</c:if>
		<c:if test="${flag==4 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="stregister" executeResult="true" />
		</c:if>
		<c:if test="${flag==5 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="createsubject" executeResult="true" />
		</c:if>
		<c:if test="${flag==6 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="stgraduation" executeResult="true" />
		</c:if>
		<c:if test="${flag==7 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="stsearch" executeResult="true" />
		</c:if>
		<c:if test="${flag==8 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="prosearch" executeResult="true" />
		</c:if>
		<c:if test="${flag==11 }">
			<!--���� ����� -->
			<s:action name="createsubjectpro" executeResult="true" />
		</c:if>
		<c:if test="${flag==12 }">
			<!-- ���� ���� -->
			<s:action name="updatesubject" executeResult="true" />
		</c:if>
		<c:if test="${flag==15 }">
			<!-- ���� ���� -->
			<s:action name="armyadmin" executeResult="true" />
		</c:if>
		<c:if test="${flag==20 }">
			<!-- ���� ���� -->
			<s:action name="classroomadmin" executeResult="true" />
		</c:if>
		<c:if test="${flag==30 }">
			<!-- ���� ��� -->
			<s:action name="promajorsearch" executeResult="true" />
		</c:if>
		<c:if test="${flag==31 }">
			<!-- ���� ���� ���� -->
			<s:action name="promodify" executeResult="true" />
		</c:if>
		
		
	</div>
	<!--�ϴ�   -->
	<div id="footer">Copyright KH Academy B Class Team:6</div>

</body>
</html>
