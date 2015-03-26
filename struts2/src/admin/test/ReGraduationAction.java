package admin.test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import test.action.MemberDTO;
import test.interceptor.SuperIbatis;

public class ReGraduationAction implements SuperIbatis{

	private String id = null;
	private SqlMapClient sqlMapper = null;
	private String result ="success";
	private List<MemberDTO> list = new ArrayList<MemberDTO>();
	long time = System.currentTimeMillis();
	SimpleDateFormat dayTime1 = new SimpleDateFormat("yyyy");
	String year = dayTime1.format(new Date(time));
	SimpleDateFormat dayTime2 = new SimpleDateFormat("MM");
	String month = dayTime2.format(new Date(time));
	
	public String execute(){		
		
		try {
			list = sqlMapper.queryForList("graduate.selectGraRe", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		// TODO Auto-generated method stub
		this.sqlMapper = sqlMapper;
	}
	
	public List getList(){
		return list;
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getYear(){
		return year;
	}
	
	public String getMonth(){
		return month;
	}
}
