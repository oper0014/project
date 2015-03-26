package pjs;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import test.action.MemberDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


public class StduentinfoAction implements SessionAware, Preparable,ModelDriven,SuperIbatis {
	private MemberDTO dto=null;
	private SqlMapClient sqlMapper;
	private Map sessionMap=null;
	
	public String execute() throws Exception{
		String id =(String) sessionMap.get("memId");
		dto=(MemberDTO) sqlMapper.queryForObject("test.student", id);
		//int check=(Integer)sqlMapper.queryForObject("test.pwCheck", dto);
		String result="success";
		return result;
	}
	@Override
	public void setSession(Map arg0) {
		this.sessionMap=arg0;	
	}
	public MemberDTO getDto(){
		return dto;
	}
	public Object getModel() {
		return dto;
	}
	
	public void prepare() throws Exception {
		dto=new MemberDTO();		//dto 
	}
	
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
		}
}
