package admin.test;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import test.databean.gradeDTO;
import test.interceptor.SuperIbatis;


public class gradeProAction implements  SuperIbatis,Preparable,ModelDriven {
	private gradeDTO dto=null;
	private SqlMapClient sqlMapper;
  
	public String execute()throws Exception{
		System.out.print("성적학번: "+dto.getId());
		sqlMapper.insert("gradeSQL.insert_grade",dto);
		String result="success"; 
	  return  result;
  }
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return dto;
	}

	@Override
	public void prepare() throws Exception {
		dto =new gradeDTO();
		
	}

	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
	}

}
