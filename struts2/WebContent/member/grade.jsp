<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <h1> 학생성적조회 </h1>
        <h3>1학년 1학기 성적 조회</h3>
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
    <th>이수구분</th>
    <th>과목코드</th>		
    <th>과목</th>
    <th>학점</th>
    <th>등급</th>    
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