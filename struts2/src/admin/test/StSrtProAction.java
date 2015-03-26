package admin.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.action.MemberDTO;
import test.databean.MajorDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;


public class StSrtProAction  implements SuperIbatis {
	private SqlMapClient sqlMapper;
	private String id ;
	private MemberDTO dto;
	private List<MemberDTO> list2 = new ArrayList<MemberDTO>();
	public String execute() throws SQLException{	
		dto = (MemberDTO) sqlMapper.queryForObject("admin.stpro",id);
		String result ="success";
		return result;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public MemberDTO getDto() {
		return dto;
	}

	public void setList2(List<MemberDTO> list2) {
		this.list2 = list2;
	}

	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
	}
}
