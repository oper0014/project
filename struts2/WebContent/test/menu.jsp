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
		<a href="/struts2/menu.action?flag=0">��������</a><br />
		<a href="/struts2/menu.action?flag=1">�л�����</a><br /> <a
			href="/struts2/menu.action?flag=2">�л�������ȸ</a><br /> <a
			href="/struts2/menu.action?flag=3">�л���ϱ� ����</a><br /> <a
			href="/struts2/menu.action?flag=4">���н�û(���н�û)</a><br /> <a
			href="/struts2/menu.action?flag=5">�������ԽŰ�</a><br /> <a
			href="/struts2/menu.action?flag=6">��ü�ð�ǥ</a><br /> <a
			href="/struts2/menu.action?flag=7">�ð�ǥ ��ȸ</a><br /> <a
			href="/struts2/menu.action?flag=8">������û</a><br /> <a
			href="/struts2/menu.action?flag=9">�������� ����</a><br /> <a
			href="/struts2/menu.action?flag=11">���ǰ�ȹ��</a><br /> <a
			href="/struts2/menu.action?flag=12">���Ǹ�����</a><br /> <a
			href="/struts2/menu.action?flag=13">�̼����� ��ȸ</a><br /> <a
			href="/struts2/menu.action?flag=14">�����б�</a><br /><a
			href="/struts2/menu.action?flag=15">�а� �ڷ��</a><br />
	</div>

	<div id="section">
		<!--������   -->
		<c:if test="${flag==0 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="artboard" executeResult="true" />
		</c:if>
		<c:if test="${flag==1 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="stduentinfo" executeResult="true" />
		</c:if>
		<c:if test="${flag==2 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="grade" executeResult="true" />
		</c:if>
		<c:if test="${flag==3 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="tuition" executeResult="true" />
		</c:if>
		<c:if test="${flag==4 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="goback" executeResult="true" />
		</c:if>
		<c:if test="${flag==5 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="army" executeResult="true" />
		</c:if>
		<c:if test="${flag==6 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="totalschedule" executeResult="true" />
		</c:if>
		<c:if test="${flag==7 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="myschedule" executeResult="true" />
		</c:if>
		<c:if test="${flag==8 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="request" executeResult="true" />
		</c:if>
		<c:if test="${flag==9 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="info_modify" executeResult="true" />
		</c:if>
		<c:if test="${flag==11 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="class_plan" executeResult="true" />
		</c:if>
		<c:if test="${flag==12 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="class_satis" executeResult="true" />
		</c:if>
		<c:if test="${flag==13 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="credit" executeResult="true" />
		</c:if>
		<c:if test="${flag==15 }">
			<!-- �ش� �޴� �̵� -->
			<s:action name="majorlist" executeResult="true" />
		</c:if>
		<c:if test="${flag==50 }">
			<!-- �а� �ڷ�� �� -->
			<s:action name="viewAction2" executeResult="true" />
		</c:if>
		<c:if test="${flag==51 }">
			<!-- �а� �ڷ�� ���������� -->
			<s:action name="modifyForm2" executeResult="true" />
		</c:if>
		<c:if test="${flag==52 }">
			<!-- �а� �ڷ�� ������ -->
			<s:action name="deleteAction2" executeResult="true" />
		</c:if>
	</div>
	<!--�ϴ�   -->
	<div id="footer">Copyright KH Academy B Class Team:6</div>

</body>
</html>
