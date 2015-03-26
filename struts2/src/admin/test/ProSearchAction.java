package admin.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import test.action.MemberDTO;
import test.interceptor.SuperIbatis;

public class ProSearchAction implements Preparable, SuperIbatis,ModelDriven{
	
	private SqlMapClient sqlMapper = null;
	private List<MemberDTO> list = new ArrayList<MemberDTO>();
	private String result ="success";
	private MemberDTO dto = new MemberDTO();
	
	public String execute(){				
		try{
			list = sqlMapper.queryForList("pro.selectPro");
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
