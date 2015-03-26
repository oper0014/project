package yh;

import java.util.ArrayList;
import java.util.List;

import test.databean.SubjectDTO;
import test.databean.class_planDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable; 

public class ProgramAction implements Preparable,ModelDriven,SuperIbatis {	//윤호 - 해당과목 조회

	private class_planDTO dto=null;
	private List<SubjectDTO> list = new ArrayList<SubjectDTO>();
	private List<class_planDTO> sub_list = new ArrayList<class_planDTO>();
	private SqlMapClient sqlMapper;
	
	public String execute()throws Exception{
		System.out.println(dto.getSnumber());
	
		sub_list = (List)sqlMapper.queryForList("yh.class_plan_select", dto.getSnumber());
		System.out.println(sub_list.size());
		System.out.println(sub_list.get(0).getSnumber());
		list = (List)sqlMapper.queryForList("yh.selectSub", dto.getSnumber());
		return "success";
	}


	public List<SubjectDTO> getList() {
		return list;
	}


	public void setList(List<SubjectDTO> list) {
		this.list = list;
	}


	public Object getModel() {
		return dto;
	}

	public void prepare() throws Exception {
		dto=new class_planDTO();
	}

	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
		}

	public List<class_planDTO> getSub_list() {
		return sub_list;
	}


	public void setSub_list(List<class_planDTO> sub_list) {
		this.sub_list = sub_list;
	}


	public SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public void setSqlMapper(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;
	}


	public class_planDTO getDto() {
		return dto;
	}


	public void setDto(class_planDTO dto) {
		this.dto = dto;
	}
	
}