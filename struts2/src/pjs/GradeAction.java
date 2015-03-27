package pjs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import test.databean.RequestDTO;
import test.databean.gradeDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


public class GradeAction implements SessionAware,Preparable,ModelDriven,SuperIbatis {
	private ArrayList<RequestDTO> list = new ArrayList<RequestDTO>();
	private  RequestDTO dto=null;
	private SqlMapClient sqlMapper;
	private Map sessionMap=null;
	private String size;
	private String score;
	private int scoreSum=0;
	String result="success";
public String execute()throws Exception{
		String id =(String) sessionMap.get("memId");
		list=(ArrayList<RequestDTO>) sqlMapper.queryForList("yj.grade_request",id);
		System.out.print("아이디 :"+list.size());
		size=Integer.toString(list.size());
			
		int resultsum;
		for (int i = 0; i < list.size(); i++) {
			resultsum=Integer.parseInt(list.get(i).getScore());
			scoreSum+=resultsum;
		}
		
	return result;
	}
	
	public ArrayList<RequestDTO> getList(){ 
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
	
	    list=new ArrayList<RequestDTO>();
	}

	@Override
	public void setSession(Map arg0) {
		
		this.sessionMap=arg0;	
	}

	public String getSize() {
		return size;
	}

	public int getScoreSum() {
		return scoreSum;
	}

	
	
	
}
