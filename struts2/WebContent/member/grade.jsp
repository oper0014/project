<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <h1> �л�������ȸ </h1>
        <h3>1�г� 1�б� ���� ��ȸ</h3>
  <style>
table {
	
	border: 2px solid #000;
	
	color: #555;
	background: #fff;
}

td, th {
	border: 1px dotted #bbb;
	padding: .5em;
}

caption {
	padding: 0 0 .5em 0;
	text-align: center;
	font-size: 1.4em;
	font-weight: bold;
	text-transform: uppercase;
	color: #333;
	background: transparent;
	
	
}

/* =links
----------------------------------------------- */
table a {
	padding: 1px;
	text-decoration: none;
	font-weight: bold;
	background: transparent;
}

table a:link {
	border-bottom: 1px dashed #ddd;
	color: #000;
}

table a:visited {
	border-bottom: 1px dashed #ccc;
	text-decoration: line-through;
	color: #808080;
}

table a:hover {
	border-bottom: 1px dashed #bbb;
	color: #666;
}

/* =head =foot
----------------------------------------------- */
thead th, tfoot th {
	border: 2px solid #000;
	text-align: center;
	font-size: 1.2em;
	font-weight: bold;
	color: #333;
	background: transparent;
}

tfoot td {
	border: 2px solid #000;
}

/* =body
----------------------------------------------- */

</style>
<table  align="center" width = "500px" >
  <tr>
     <th>�̸�</th>
    <th>�����</th>		
    <th>��������</th>
  </tr>
  <c:forEach items="${list}" var="result">
  <tr>
    <td>${result.name}</td>		
    <td>${result.subnum}</td>
    <td>${result.score}</td>
  </tr>
</c:forEach>
</table>

<hr width=99% size=1>
<table cellpadding=1 cellspacing=0 width=95% bordercolor=#ffffff bordercolorlight=darkblue bgcolor=#6164D9>
<tr bgcolor=darkblue>
<td align=center nowrap width=30%><FONT color=lightblue><FONT color=white>�⵵</FONT>/<FONT color=white>�г�</FONT>/<FONT color=white>�б�</FONT></FONT></td>
<td align=center nowrap width=10%><FONT color=white>��û<br>�����</FONT></td>
<td align=center nowrap width=10%><FONT color=white>��û<br>����</FONT></td>
<td align=center nowrap width=10%><FONT color=white>����<br>��</FONT></td>
<td align=center nowrap width=10%><FONT color=white>����<br>���</FONT></td>
<td align=center nowrap width=10%><FONT color=white>�����<br>����</FONT></td>
</tr>
<tr bgcolor=#E6E6FA><form>
<td align=center>2015 / 1 / 1</td>
<td align=right>${size}&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td align=right>${scoreSum}&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td align=right>--&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td align=right>--&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td align=left>&nbsp;&nbsp;&nbsp;&nbsp;--</td>

<tr bgcolor=#E6E6FA><form>
</table>
 
