<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
  
<fmt:requestEncoding value="EUC-KR"/>
 
 
 
 <form action="/struts2/request_insert2.action">
 <tr> 
      <td width="400"> 
     	<select name="year">
     		 <option selected>�⵵ </option>
     	 	 <option value="2015" >2015</option>
	   		 <option value="2014" >2014</option>
	   		 <option value="2013">2013</option>
	     </select>�⵵
	   </td>
	   
	   <td width="400">
	   		<select name="term">
	   		 	 <option selected>�б� </option>
     	 		  <option value="1" >1</option>
	   		  <option value="2" >2</option>
	   	  </select>�б�
	   </td>
	   
	   <td width="400">
	   	  <select name="grade">
	   	  	 <option  selected>�г�</option>
     		  <option value="1" >1</option>
	   		  <option value="2" >2</option>
	   		  <option value="3" >3</option>
	   		  <option value="4" >4</option>
	   		</select>�г�
	   </td>
	   
	   <td width="400">
	   		<select name="ssection">
	   		   <option selected>����</option>
     	 	 <option value="1" selected>����</option>
	   		  <option value="2" >����</option>
	   	  </select>
	   </td>
	    
	    <td>
	    	<input type="submit" value="��ȸ">
	   	</td>
	    <td>
	    	<input type = "button" value = "�޴��ΰ���"
			onClick="javascript:window.location='/struts2/menu.action?flag=0'">
	    </td>
 	</tr> 
  </form>
 
 
 

<table border = "1px" width = "900px" align = "center">
	<tr>
		<td>�����ȣ</td>
		<td>�����</td>
		<td>���ǿ���</td>
		<td>���ǽð�</td>
		<td>���ǽ�</td>
		<td>��������</td>
		<td>�����ڵ�</td>
	    <td>�����̸�</td>
	    <td>�������籸��</td>
	    <td>/�ο�</td>
	    
		 
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
 	 
		<td><input type = "button" value = "��û"
			onClick="javascript:window.location='/struts2/request_insertPro.action?subnum=${subject.snumber}&rsubject=${subject.sname}&score=${subject.scredit}&name=${subject.sname}&id=${id}&rnum=${subject.snumber}&stime=${subject.stime}&sday=${subject.sday}&ssection=${dto.ssection}&year=${dto.year}&grade=${dto.grade}&term=${dto.term}'"></td>
	</tr>
	</c:forEach>
</table>
 
 
 
 
 



 
<br><br>
������û���

<table  border = "1px" width = "900px" align = "center" >
	<tr>
		<td>�����ȣ</td>
		<td>�����</td>
		<td>����</td>
		<td>���ǽð�</td>
		<td>���ǽ�</td>
		<td>��������</td>
	    <td>�����̸�</td>
	    <td>�������籸��</td>
	   
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
	  	
		<td><input type = "button" value ="��������"
			onClick="javascript:window.location='/struts2/request_deletePro.action?id=${id}&subnum=${requestok.subnum}&year=${dto.year}&grade=${dto.grade}&term=${dto.term}&ssection=${dto.ssection}'"></td>
		
	</tr>
	</c:forEach>
</table>
 