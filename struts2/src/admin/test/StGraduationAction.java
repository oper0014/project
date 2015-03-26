package admin.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import test.action.MemberDTO;
import test.interceptor.SuperIbatis;

public class StGraduationAction implements SuperIbatis{
	
	private SqlMapClient sqlMapper = null;
	private String result ="success";
	private List<MemberDTO> list = new ArrayList<MemberDTO>();

	
	public String execute(){		
		
		try {
			list = sqlMapper.queryForList("graduate.selectGra");
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
	
	
	
}
