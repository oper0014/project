package dyj;

/*
 * 도예진 담당
 * 9번 개인정보 변경
 * */

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import test.action.MemberDTO;
import test.interceptor.SuperIbatis;

public class InfoModifyAction implements SuperIbatis, SessionAware,
		ModelDriven, Preparable {
	private Map sessionMap;
	private MemberDTO dto;
	private SqlMapClient sqlMapper;

	public String execute() {

		try {
			String id = (String) sessionMap.get("memId");
			System.out.println(id);
			dto = (MemberDTO) sqlMapper.queryForObject("test.info_select", id);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "success";
	}

	public MemberDTO getDto() {
		return dto;
	}

	@Override
	public void prepare() throws Exception {
		dto = new MemberDTO();

	}

	@Override
	public Object getModel() {
		return dto;
	}

	@Override
	public void setSession(Map arg0) {
		this.sessionMap = arg0;
	}

	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;
	}

}
