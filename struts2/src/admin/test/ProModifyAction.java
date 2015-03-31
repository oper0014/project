package admin.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import test.action.MemberDTO;
import test.interceptor.SuperIbatis;

public class ProModifyAction implements SuperIbatis{

	private String result = "success";
	private SqlMapClient sqlMapper = null;
	private MemberDTO dto = new MemberDTO();
	private String id = null;
	
	public String execute(){			
		
		try {
			
			dto = (MemberDTO)sqlMapper.queryForObject("pro.selectOne", id);
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
	

	public MemberDTO getDto(){
		return dto;
	}

	public void setId(String id){
		this.id = id;
				
	}

}
