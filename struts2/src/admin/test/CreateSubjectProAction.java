package admin.test;

import java.util.ArrayList;
import java.util.List;

import test.databean.CreateSubjectDTO;
import test.databean.SubjectDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/*
 * °­ÁÂ°³¼³
 * */
public class CreateSubjectProAction implements SuperIbatis,Preparable,ModelDriven{
	private SqlMapClient sqlMapper;
	private CreateSubjectDTO dto;
	public String execute() throws Exception{
	
		System.out.println("DTO");
		System.out.println("getGrade:"+dto.getGrade());
		System.out.println("getSsection:"+dto.getSsection());
		System.out.println("getTerm:"+dto.getTerm());
		System.out.println("getYear:"+dto.getYear());
		sqlMapper.insert("admin.insertSubject", dto);
		
		String result ="success";
		return result;
	}
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
	}
	@Override
	public Object getModel() {
		return dto;
	}
	@Override
	public void prepare() throws Exception {
		dto=new CreateSubjectDTO();		//dtoï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï¸ï¿½ ï¿½ï¿½ï¿½Ô¹Þ´Â°Íµï¿½
	}
}
