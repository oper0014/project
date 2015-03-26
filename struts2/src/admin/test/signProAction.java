package admin.test;

import java.util.Map;

import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
public class signProAction implements Preparable,ModelDriven,SuperIbatis {
private adminDTO dto=null;

private SqlMapClient sqlMapper;
public String execute()throws Exception  {
  System.out.println("ID: "+dto.getId());
  System.out.println("name:"+dto.getName());

sqlMapper.insert("admin.insertStudent",dto); //error SQLMap
String result="success";
 return result;
} 

public void setIbatis(SqlMapClient sqlMapper) {
  this.sqlMapper=sqlMapper;
	}

public Object getModel() { // return DTO
	return dto;
}
public void prepare() throws Exception { 
	 dto=new adminDTO();
	
}

}