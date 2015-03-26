package yh;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import test.action.MemberDTO;
import test.databean.SurveyDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ClassSatisProAction implements SuperIbatis, ModelDriven, Preparable, SessionAware{
	public static SqlMapClient sqlMapper;
	private Map sessionMap;
	private SurveyDTO dto = null;
	private String s_set1;
	private String s_set2;
	private String s_set3;

	
	
	public String execute(){

		String score = s_set1 + "," + s_set2 + "," + s_set3;
		String id = (String) sessionMap.get("memId");
		System.out.println(id);
		dto.setScore(score);
		dto.setId(id);
		try {
		sqlMapper.insert("yh.survey_insert",dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "success";
	}

	public void setSession(Map arg0) {
		this.sessionMap = arg0;
	}


	public void prepare() throws Exception {
		dto = new SurveyDTO();
	}


	public Object getModel() {

		return dto;
	}


	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;
	}


	public SurveyDTO getDto() {
		return dto;
	}


	public void setDto(SurveyDTO dto) {
		this.dto = dto;
	}

	public String getS_set1() {
		return s_set1;
	}

	public void setS_set1(String s_set1) {
		this.s_set1 = s_set1;
	}

	public String getS_set2() {
		return s_set2;
	}

	public void setS_set2(String s_set2) {
		this.s_set2 = s_set2;
	}

	public String getS_set3() {
		return s_set3;
	}

	public void setS_set3(String s_set3) {
		this.s_set3 = s_set3;
	}

}

