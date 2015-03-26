package dyj;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import test.databean.RequestDTO;
import test.databean.StuSubJoinDTO;
import test.databean.SubjectDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class RequestInsert2Action implements SuperIbatis, Preparable, ModelDriven,SessionAware{
	public static  SqlMapClient sqlMapper;
	private Map sessionMap;
	
	private SubjectDTO subjectDto;
	private List<SubjectDTO> list_Subject = new ArrayList<SubjectDTO>();
	private List<StuSubJoinDTO> list_RequestOk= new ArrayList<StuSubJoinDTO>();
	private String id;

	public String execute(){
		id=(String) sessionMap.get("memId");
		try {
			
			list_Subject=sqlMapper.queryForList("yj.yearselect",subjectDto); //조회버튼눌렀을때 과목
			list_RequestOk=sqlMapper.queryForList("yj.requestlist",id); //수강신청내역
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return "success";
	}
	
	public String getId(){
		return id;
	}
	
	
	//request_insert.jsp 에서 넘어오는 year, ssection, term , grade를 다시  request_insert.jsp에서 쓰기위함
	public SubjectDTO getDto() { 
		return subjectDto;
	}
	
	//수강신청내역
	public List<StuSubJoinDTO> getListRequestOk(){ 
		return list_RequestOk;
	}
	
	//과목조회
	public List<SubjectDTO> getListSubject(){
		return list_Subject;
	}
	
	
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		 this.sqlMapper=sqlMapper;
		
	}

 
	@Override
	public void setSession(Map arg0) {
		this.sessionMap=arg0;
		
	}

	
	@Override
	public Object getModel() {
		 
		return subjectDto;
	}

	@Override
	public void prepare() throws Exception {
		subjectDto=new SubjectDTO();
		
	}

	
}
