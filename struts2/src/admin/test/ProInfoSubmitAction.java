package admin.test;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import test.action.MemberDTO;
import test.interceptor.SuperIbatis;

public class ProInfoSubmitAction implements SuperIbatis,ModelDriven,Preparable{

	private String result = "success";
	private SqlMapClient sqlMapper = null;
	private MemberDTO dto = new MemberDTO();
	
	public String execute(){
		
		System.out.println("교수 수정"+dto.getId());
		try {
			sqlMapper.update("pro.proUpdate", dto);
			//System.out.println(dto.getId());
			
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

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return dto;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		dto = new MemberDTO();
	}

	
	
}
