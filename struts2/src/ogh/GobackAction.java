package ogh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import test.action.MemberDTO;
import test.interceptor.SuperIbatis;

/*
 * 복학신청action
 * */
public class GobackAction implements SuperIbatis,  SessionAware,Preparable, ModelDriven{
	
	private Map sessionMap = null;
	private SqlMapClient sqlMapper = null;
	private MemberDTO dto = null;
	private List<MemberDTO> list = new ArrayList<MemberDTO>();
	private String result ="success";
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		// TODO Auto-generated method stub
		this.sqlMapper = sqlMapper;
	}

	public String execute(){	
		try{
			String id=(String) sessionMap.get("memId");
			//System.out.println("memId"+id);
			dto = (MemberDTO)sqlMapper.queryForObject("test.info_goback", id);
			//System.out.println("dto"+dto.getAddress());
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result; 
	}
	public MemberDTO getDto(){
		return dto;
	}

	@Override
	public void prepare() throws Exception {
		dto=new MemberDTO();
	}
	
	public void setSession(Map arg0) {
		this.sessionMap=arg0;
	}
	
	@Override
	public Object getModel() {
		 return dto;
	}
}
