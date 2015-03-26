package ogh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;



import test.databean.MyscheduleDTO;
import test.interceptor.SuperIbatis;

public class MyScheduleAction implements SuperIbatis,  SessionAware,Preparable, ModelDriven{
	
	private Map sessionMap = null;
	private SqlMapClient sqlMapper = null;
	private MyscheduleDTO dto = null;
	private List<MyscheduleDTO> list = new ArrayList<MyscheduleDTO>();
	private String result ="success";
	
	public String execute(){	
		try{
			
			String id=(String) sessionMap.get("memId");
			list = sqlMapper.queryForList("schedule.selectMy",id);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	public void setIbatis(SqlMapClient sqlMapper) {
		// TODO Auto-generated method stub
		this.sqlMapper = sqlMapper;
	}

	public List getList(){
		return list;
	}
	
	@Override
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		this.sessionMap=arg0;
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return dto;
	}


	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		dto=new MyscheduleDTO();

	}
}
