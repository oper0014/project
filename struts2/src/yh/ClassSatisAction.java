package yh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import test.databean.SurveyDTO;
import test.databean.gradeDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;


/*
 * 윤호 담당
 * 12번 강의만족도
 * */
public class ClassSatisAction implements SuperIbatis, SessionAware{
	public static SqlMapClient sqlMapper;
	private SurveyDTO dto;
	private Map sessionMap;
	private List<SurveyDTO> list = new ArrayList<SurveyDTO>();
	
	public String execute() throws SQLException{	
		list = (List)sqlMapper.queryForList("yh.survey_select");
		System.out.println(sessionMap.get("memId"));
		
		String result ="success";
		return result;
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

	public void setSession(Map arg0) {
		this.sessionMap = arg0;
	}


	public List<SurveyDTO> getList() {
		return list;
	}


	public void setList(List<SurveyDTO> list) {
		this.list = list;
	}
	
}
