<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
<h2>�л��˻�</h2>
<form method="post" action="adminmenu.action">
	<!-- majorlist.action -->
	<input type="hidden" name="flag" value="7">
	<select	name="major">
		<option>All</option>
		<c:forEach items="${list}" var="result"><!-- �а� -->
			<option value="${result.majorname}">${result.majorname}</option>
		</c:forEach>
	</select>
	<select name="grade"><!-- �г� -->
		<option value="All">All</option>			
		<option value="1�г�">1�г�</option>
		<option value="2�г�">2�г�</option>
		<option value="3�г�">3�г�</option>
		<option value="4�г�">4�г�</option>
	</select>
	<select name="gender"><!-- ���� -->
		<option value="0">All</option>		
		<option value="1">����</option>
		<option value="2">����</option>
	</select>
	<select name="state"><!-- ���л��� -->
		<option value="1">����</option>
		<option value="2">�Ϲ�����</option>
		<option value="3">������</option>
	</select> 
	<input type="submit" value="�˻�" />
</form>
<p>
<input type="checkbox" name="all" class="check-all"> <label>Check ALL</label>
<form method="post" action="adminmenu.action">
<input type="hidden" name="flag" value="7">
<input type="hidden" name="flag2" value="1">
<input type="hidden" name="major" value="${dto.major }">
<input type="hidden" name="grade" value="${dto.grade }">
<input type="hidden" name="gender" value="${dto.gender }">
<input type="hidden" name="state" value="${dto.state }">

<table width="800">
	<tr>
		<td width="70">����</td>
		<td width="70"><strong>�й�</strong></td>
			<td width="70">�̸�</td>
			<td width="180">�а�</td>
			<td width="70">�г�</td>
			<td width="70">����</td>
			<td width="70">����</td>
			<td width="200">��ȭ��ȣ</td>
			<td width="70">üũ�ڽ�</td>
			
	</tr>
	<c:forEach items="${list2}" var="result" varStatus="status">
		<tr>
			<td width="70">${status.count}</td>
			<td width="70"><a href="stsrtpro.action?flag=50&id=${result.id}">${result.id}</a></td>
			<td width="70">${result.name}</td>
			<td width="180">${result.major}</td>
			<td width="70">${result.grade}</td>
			<td width="70">
			<c:if test="${result.gender==1}">����</c:if>
			<c:if test="${result.gender==2}">����</c:if>
			</td>
			<td width="70">
			<c:if test="${result.state==1}">����</c:if>
			<c:if test="${result.state==2}">����</c:if>
			<c:if test="${result.state==3}">������</c:if>
			</td>
			<td width="200">${result.phonenumber1}-${result.phonenumber2}-${result.phonenumber3}</td>
			<td width="70"><input type="checkbox" name="chk_info" value="${result.id}" class="ab"></td>
		</tr>
	</c:forEach>
</table>
<input type="submit" name="grade_selected" value="�г��" />
<input type="submit" name="state_selected1" value="����ó��" />
<input type="submit" name="state_selected2" value="����ó��" />
</form>