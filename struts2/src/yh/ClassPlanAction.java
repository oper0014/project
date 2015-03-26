package yh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import test.databean.SubjectDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ClassPlanAction implements Preparable,ModelDriven,SuperIbatis,SessionAware {
//윤호 - 해당과목 조회
 
	public static SqlMapClient sqlMapper_sub;
	private Map sessionMap;
	private SubjectDTO dto =null;
	private List<SubjectDTO> list = new ArrayList<SubjectDTO>();
	private List all_list = new ArrayList();
 
	public String execute()throws Exception{
		System.out.println(sessionMap.get("memId"));
		if(sessionMap.get("memId").equals("333")){
			return "insert";
		}
		list = (List) sqlMapper_sub.queryForList("yh.list",dto);
		all_list = (List)sqlMapper_sub.queryForList("yh.selectSub");
		return "success";
	}
	
	
	public List getAll_list() {
		return all_list;
	}


	public void setAll_list(List all_list) {
		this.all_list = all_list;
	}


	@Override
	public Object getModel() {
		return dto;
	}
	@Override
	public void prepare() throws Exception {
		dto=new SubjectDTO();
	}
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper_sub=sqlMapper;
		}
	public SubjectDTO getDto() {
		return dto;
	}
	public void setDto(SubjectDTO dto) {
		this.dto = dto;
	}
	public List<SubjectDTO> getList() throws SQLException {
		return list;
	}
	public void setList(List<SubjectDTO> list) {
		this.list = list;
	}



	public void setSession(Map arg0) {
		this.sessionMap = arg0;
	}
}
