package ogh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import test.databean.TotalsubjectDTO;
import test.interceptor.SuperIbatis;

public class ScheduleSearchAction implements SuperIbatis{
	private String major = null;
	private int time;
	private SqlMapClient sqlMapper = null;
	private String result ="success";
	private List<TotalsubjectDTO> list = new ArrayList<TotalsubjectDTO>();

	public String execute(){
		try{
		if(major != null){
			list=sqlMapper.queryForList("subject.selectmajor",major);
		}else{
			list=sqlMapper.queryForList("subject.selecttime",time);

		}
		
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}


	
	
	
	
	public List getList(){
		return list;
	}

	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}

	
	public void setIbatis(SqlMapClient sqlMapper) {
		// TODO Auto-generated method stub
		this.sqlMapper = sqlMapper;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}


}
