<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>정보란</title>
<link href="style.css" rel="stylesheet" type="text/css">
<table width="600" border="1" cellspacing="0" cellpadding="3" align="center">
    
    <tr> 
    <td colspan="2" height="39" align="center" >
       <font size="+1" ><b>학생정보조회</b></font></td>
   </tr>
    
    
    <tr> 
      <td width="200"> <b>학번</b> </td>
    
      <td width="400"> <h3>${sessionScope.memId}</h3> </td> 
    </tr>  
 <tr>  
      <td width="200"> 이름</td>
      <td width="400"> <h3>${dto.name}</h3> 
      </td>
    </tr>
   
   <tr> 
      <td width="200"><b>학과</b></td>
      <td width="400">${dto.major}</td>
    </tr>  
    
    
    <tr> 
      <td width="200">복수전공</td>
      <td width="400">${dto.major2}</td>
    </tr>
    
 <tr> 
      <td width="200">부전공</td>
      <td width="400">${dto.minor} </td>
    </tr>
    
    <tr> 
      <td width="200">학년</td>
      <td width="400">${dto.grade}</td>
    </tr>
   
    
    <tr> 
      <td width="200">성별</td>
      <td width="400">${dto.gender }</td>
        </tr>
    
    
     <tr> 
      <td width="200">상태</td>
      <td width="400">${dto.state }</td>
    </tr>
   
    
    <tr> 
      <td width="200">휴대폰  </td>
      <td width="400">${dto.phonenumber1}-${dto.phonenumber2 }-${dto.phonenumber3}  </td>
    </tr> 
 
    
    <tr> 
      <td width="200">주소</td>
      <td width="400">${dto.address} </td>
    </tr>
    
    
    <tr> 
      <td width="200">메일</td>
      <td width="400">${dto.mail1}@${dto.mail2}</td>
    </tr>
   </table>
</body>
</html>