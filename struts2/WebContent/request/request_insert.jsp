<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
  
<fmt:requestEncoding value="EUC-KR"/>
 
 
 
 <form action="/struts2/request_insert2.action">
 <tr> 
      <td width="400"> 
     	<select name="year">
     		 <option selected>년도 </option>
     	 	 <option value="2015" >2015</option>
	   		 <option value="2014" >2014</option>
	   		 <option value="2013">2013</option>
	     </select>년도
	   </td>
	   
	   <td width="400">
	   		<select name="term">
	   		 	 <option selected>학기 </option>
     	 		  <option value="1" >1</option>
	   		  <option value="2" >2</option>
	   	  </select>학기
	   </td>
	   
	   <td width="400">
	   	  <select name="grade">
	   	  	 <option  selected>학년</option>
     		  <option value="1" >1</option>
	   		  <option value="2" >2</option>
	   		  <option value="3" >3</option>
	   		  <option value="4" >4</option>
	   		</select>학년
	   </td>
	   
	   <td width="400">
	   		<select name="ssection">
	   		   <option selected>구분</option>
     	 	 <option value="1" selected>전공</option>
	   		  <option value="2" >교양</option>
	   	  </select>
	   </td>
	    
	    <td>
	    	<input type="submit" value="조회">
	   	</td>
	    <td>
	    	<input type = "button" value = "메뉴로가기"
			onClick="javascript:window.location='/struts2/menu.action?flag=0'">
	    </td>
 	</tr> 
  </form>
 
 
 

<table border = "1px" width = "900px" align = "center">
	<tr>
		<td>과목번호</td>
		<td>과목명</td>
		<td>강의요일</td>
		<td>강의시간</td>
		<td>강의실</td>
		<td>인정학점</td>
		<td>교수코드</td>
	    <td>교수이름</td>
	    <td>전공교양구분</td>
	    <td>/인원</td>
	    
		 
	</tr>
	
	<c:forEach var = "subject" items = "${ListSubject}">
	<tr>
		<td>${subject.snumber}</td>
		<td>${subject.sname}</td>
		<td>${subject.sday }</td>
		<td>${subject.stime}</td>
		<td>${subject.sclass}</td>
		<td>${subject.scredit}</td>
		<td>${subject.proid}</td>
	  	<td>${subject.name}</td>
	  	<td>${subject.ssection}</td>
	  	<td>${subject.count}/${subject.max}</td>
 	 
		<td><input type = "button" value = "신청"
			onClick="javascript:window.location='/struts2/request_insertPro.action?subnum=${subject.snumber}&rsubject=${subject.sname}&score=${subject.scredit}&name=${subject.sname}&id=${id}&rnum=${subject.snumber}&stime=${subject.stime}&sday=${subject.sday}&ssection=${dto.ssection}&year=${dto.year}&grade=${dto.grade}&term=${dto.term}'"></td>
	</tr>
	</c:forEach>
</table>
 
 
 
 
 



 
<br><br>
수강신청목록

<table  border = "1px" width = "900px" align = "center" >
	<tr>
		<td>과목번호</td>
		<td>과목명</td>
		<td>요일</td>
		<td>강의시간</td>
		<td>강의실</td>
		<td>인정학점</td>
	    <td>교수이름</td>
	    <td>전공교양구분</td>
	   
	</tr>
	
	<c:forEach var = "requestok" items = "${ListRequestOk}">
	<tr>
		<td>${requestok.subnum}</td>
		<td>${requestok.rsubject}</td>
		<td>${requestok.sday }</td>
		<td>${requestok.stime}</td>
		<td>${requestok.sclass}</td>
		<td>${requestok.score}</td>
	  	<td>${requestok.name}</td>
	  	<td>${requestok.ssection}</td>
	  	
		<td><input type = "button" value ="수강삭제"
			onClick="javascript:window.location='/struts2/request_deletePro.action?id=${id}&subnum=${requestok.subnum}&year=${dto.year}&grade=${dto.grade}&term=${dto.term}&ssection=${dto.ssection}'"></td>
		
	</tr>
	</c:forEach>
</table>
 