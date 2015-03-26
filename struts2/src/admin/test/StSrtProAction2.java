package admin.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.action.MemberDTO;
import test.databean.MajorDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


public class StSrtProAction2  implements SuperIbatis,Preparable,ModelDriven {
	private SqlMapClient sqlMapper;
	private String id ;
	private MemberDTO dto;
	public String execute(){	
		
		System.out.println("-------");
		System.out.println(":::ID:::"+dto.getAddress());
		System.out.println(dto.getId());
		System.out.println(dto.getMajor());
		try {
			sqlMapper.update("admin.st_update", dto);
		} catch (SQLException e) {
			System.out.println("eeeeee");
			e.printStackTrace();
		}
		
		String result ="success";
		return result;
	}
	@Override
	public Object getModel() {
		return dto;
	}
	@Override
	public void prepare() throws Exception {
		dto=new MemberDTO();		//dto�� �����ϸ� ���Թ޴°͵�
	}

	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
	}
}
