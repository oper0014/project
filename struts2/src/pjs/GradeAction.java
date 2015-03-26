package pjs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import test.databean.gradeDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


public class GradeAction implements SessionAware,Preparable,ModelDriven,SuperIbatis {
	private ArrayList<gradeDTO> list = new ArrayList<gradeDTO>();
	private gradeDTO dto=null;
	private SqlMapClient sqlMapper;
	private Map sessionMap=null;
	String result="success";

	public String execute()throws Exception{
		String id =(String) sessionMap.get("memId");
		list=(ArrayList<gradeDTO>) sqlMapper.queryForList("gradeSQL.select_grade",id);
		return result;
	}
	
	public ArrayList<gradeDTO> getList(){ 
		return list;
	}

	public void setIbatis(SqlMapClient sqlMapper) {
	
		this.sqlMapper=sqlMapper;
	}
	
	public Object getModel() {
		
		return list;
	}

	@Override
	public void prepare() throws Exception {
	
	    list=new ArrayList<gradeDTO>();
	}

	@Override
	public void setSession(Map arg0) {
		
		this.sessionMap=arg0;	
	}

	
	
}
