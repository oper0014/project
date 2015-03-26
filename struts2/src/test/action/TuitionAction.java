package test.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.sqlmap.client.SqlMapClient;

import test.interceptor.SuperIbatis;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


/*
 * 서동우 작성
 * 3번 학생등록금 납부 조회
 * */
public class TuitionAction implements Preparable,SessionAware,ModelDriven,SuperIbatis{
	private SqlMapClient sqlMapper;
	private TuitionDTO dto=null;
	private Map sessionMap=null;
	public String execute(){	
		String id=(String) sessionMap.get("memId");
		System.out.println("새션 아이디:"+id);
	
		
		try {
			dto = (TuitionDTO) sqlMapper.queryForObject("test.selectTuition", id);
			System.out.println(dto.getId()+"money:"+dto.getMoney());
		} catch (SQLException e) {e.printStackTrace();}
		
		String result ="success";
		return result;
	}
	public TuitionDTO getDto() {
		return dto;
	}
	@Override
	public Object getModel() {
		return dto;
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
	public void prepare() throws Exception {
		dto=new TuitionDTO();
	
	}
}