<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="EUC-KR" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>��й�ȣ Ȯ��</title>
	<link rel="stylesheet" href="/struts2/board/common/css/css.css" type="text/css">
</head>
  
  <body>
  
  	<h2>��й�ȣ Ȯ��</h2>
  	
  	<form action="checkAction2.action" method="post">
  	<s:hidden name="no" value="%{no}" />
  	<s:hidden name="currentPage" value="%{currentPage}" />
  		
  	<table width="250" border="0" cellspacing="0" cellpadding="0">
      
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>
      </tr>
			
      <tr>
        <td width="100" bgcolor="#F4F4F4">  ��й�ȣ �Է�</td>
        <td width="150" bgcolor="#FFFFFF">
          &nbsp;&nbsp;<s:textfield name="password" theme="simple" cssStyle="width:100px" maxlength="20"/>
          &nbsp;&nbsp;<input name="submit" type="submit" value="Ȯ��" class="inputb">
        </td>
      </tr>
      
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>
      </tr>
      
    </table>
  
  </form>
 </body>
</html>
