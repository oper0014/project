package ogh;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.sqlmap.client.SqlMapClient;

import test.action.MemberDTO;
import test.interceptor.SuperIbatis;

public class GobackSubmitAction implements SessionAware, SuperIbatis{
	private Map sessionMap = null;

	public static SqlMapClient sqlMapper;
	//private MemberDTO dto = null;

	public String execute(){
		try{
			
			String id=(String) sessionMap.get("memId");
			sqlMapper.update("test.goback_submit", id);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "submit";
	}
	
	public void setSession(Map arg0) {
		this.sessionMap=arg0;
	}
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		// TODO Auto-generated method stub
		this.sqlMapper = sqlMapper;

	}

}
