package admin.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import test.action.MemberDTO;
import test.interceptor.SuperIbatis;

public class ProMajorSearchAction implements SuperIbatis{

	private String major = null;
	private String result = "success";
	private SqlMapClient sqlMapper = null;
	private List<MemberDTO> list = new ArrayList<MemberDTO>();
	
	public String execute(){
		try{
			
			System.out.print(major);
			list = sqlMapper.queryForList("pro.selectProMajor", major);
			
		}catch(SQLException e){
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
	public String getMajor(){
		return major;
	}
	public void setMajor(String major){
		this.major = major;
	}

}
