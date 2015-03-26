package dyj;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import test.action.MemberDTO;
import test.interceptor.SuperIbatis;

public class InfoModifyProAction implements SuperIbatis, SessionAware, ModelDriven, Preparable {
	private Map sessionMap;
	private MemberDTO dto;
	private SqlMapClient sqlMapper;
	
	public String execute(){
		
		 
		 try {
			sqlMapper.update("test.info_update", dto);
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return "success";
	}

	@Override
	public void prepare() throws Exception {
		dto=new MemberDTO();
	
	}

	@Override
	public Object getModel() {
		 return dto;
	}

	@Override
	public void setSession(Map arg0) {
		this.sessionMap=arg0;
	}

	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
	}
	
	
}
