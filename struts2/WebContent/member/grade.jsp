<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <h1> �л�������ȸ </h1>
        <h3>1�г� 1�б� ���� ��ȸ</h3>
  <style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>
<table style="width:100%" >
  <tr>
    <th>�̼�����</th>
    <th>�����ڵ�</th>		
    <th>����</th>
    <th>����</th>
    <th>���</th>    
  </tr>
  <c:forEach items="${list}" var="result">
  <tr>
    <td>${result.ssection}</td>
    <td>${result.gnumber}</td>		
    <td>${result.sname}</td>
    <td>${result.average}</td>
    <td>${result.grade}</td>
  </tr>
</c:forEach>
 
</table>