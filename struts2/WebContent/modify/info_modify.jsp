<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<title>정보수정</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript">
    
    function checkIt() {
    	  var userinput = eval("document.userinput");
        
        if(!userinput.pw.value ) {
            alert("비밀번호를 입력하세요");
            return false;
        }
        if(userinput.pw.value != userinput.pw2.value)
        {
            alert("비밀번호를 동일하게 입력하세요");
            return false;
        }
         
       
        if(!userinput.nikname.value) {
            alert("사용자 이름을 입력하세요");
            return false;
        }
        if(!userinput.jumin1.value  || !userinput.jumin2.value )
        {
            alert("주민등록번호를 입력하세요");
            return false;
        }
    }

 
</script>

 
 
<form method="post" action="/struts2/info_modifyPro.action" name="userinput" onSubmit="return checkIt()">
  <table width="600" border="1" cellspacing="0" cellpadding="3" align="left" bgcolor= "#FFFF99"  >
    
    <tr> 
    <td colspan="2" height="39" align="center">
       <font size="+1" ><b>정보수정</b></font></td>
   </tr>
    
    
    <tr> 
      <td width="200"> <b>아이디와 비밀번호</b> </td>
      <td width="400">&nbsp;</td>
    </tr>  



    <tr>  
      <td width="200"> 학번</td>
     	<td  width="400">${dto.id}
     		 <input type="hidden" name="id" value="${dto.id}">  </td>
    </tr>
   
   
    <tr> 
      <td width="200"> 비밀번호</td>
      <td width="400"> 
        <input type="password" name="pw" size="15" maxlength="12">
      </td>
    </tr>
      
      
      
      
    <tr>  
      <td width="200">비밀번호 확인</td>
      <td width="400"> 
        <input type="password" name="pw2" size="15" maxlength="12">
      </td>
    </tr>
    
    
    
    <tr> 
      <td width="200"> <b>개인정보 입력</b></td>
      <td width="400">&nbsp;</td>
    </tr>  
    
    
    <tr> 
      <td width="200">이름</td>
     	<td  width="400"> 
        	${dto.name}  <input type="hidden" name="name" value="${dto.name}"></td>
      </td>
    </tr>
    
 
    
    <tr> 
      <td width="200">전공</td>
      <td width="400"> 
         ${dto.major}  <input type="hidden" name="major" value="${dto.major}"></td>
   </tr>
   
   
    <tr>
       	<td width="200">복수전공</td>  
       	<td width="400">  
       	${dto.major2}    <input type="hidden" name="major2" value="${dto.major2}"></td>
	</tr>
	
	<tr>
	     <td width="200">부전공 </td>
	     <td width="400">
	       ${dto.minor}    <input type="hidden" name="minor" value="${dto.minor}"></td>
     </tr>
    
    <tr> 
      <td width="200">학년</td>
      <td width="400"> 
      	${dto.grade}  <input type="hidden" name="grade" value="${dto.grade}">
       </td>
    </tr>
   
   
   
    
    
    <tr> 
      <td width="200">성별</td>
      <td width="400"> 
        <c:if test="${dto.gender==1}">
        <input type="hidden" name="gender" value="여자" size="40" maxlength="30">여자
        </c:if>
        <c:if test="${dto.gender==2}">
            <input type="hidden" name="gender" value="남자" size="40" maxlength="30">남자
        </c:if>
      </td>
    </tr>
    
 
    
     <tr> 
      <td width="200">상태(관리자용)</td>
      <td width="400"> 
     	<select name="state">
     	<c:if test="${dto.state==1}">
	   		 <option value="1" selected>휴학</option>
	   		 <option value="2" >재학</option>
	   		 <option value="3">졸업</option>
	   	</c:if>
	   	<c:if test="${dto.state==2}">
	   		<option value="1" >휴학</option>
	   		<option value="2" selected>재학</option>
	   		<option value="3">졸업</option>
	   	</c:if>
	   	<c:if test="${dto.state==3}">
	   	 	<option value="1" >휴학</option>
	   	 	<option value="2" >재학</option>
	   		<option value="3" selected>졸업</option>
	   	</c:if>
	   	</select>
	   </td>
    </tr>
   
    
 
    
    
    <tr> 
      <td width="200">핸드폰번호</td>
      <td width="400"> 
     
      	<input type="text" name="phonenumber1" size="3" maxlength="4" value="${dto.phonenumber1}">
    	-<input type="text" name="phonenumber2" size="3" maxlength="4" value="${dto.phonenumber2}">
          -<input type="text" name="phonenumber3" size="3" maxlength="4" value="${dto.phonenumber3}">
          
       </td>
    </tr> 
 
    
    <tr> 
      <td width="200">주소</td>
      <td width="400"> 
       	    <input type="text" name="address" size="15" maxlength="20" value="${dto.address}">
       </td>
    </tr>
    
    
    <tr> 
      <td width="200">메일</td>
      <td width="400"> 
          <input type="text" name="mail1" size="15" maxlength="20" value="${dto.mail1}">@ 
          <input type="text" name="mail2" size="15" maxlength="20" value="${dto.mail2}"> 
          </td>
    </tr>
    
 
    
    <tr> 
      <td colspan="2" align="center"> 
          <input type="submit" name="confirm" value="수 정" >
          <input type="reset" name="reset" value="다시입력">
          <input type="button" value="수정안함" onclick="javascript:window.location='main.jsp'">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
