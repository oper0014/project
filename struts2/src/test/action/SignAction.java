package test.action;

import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/*회원 가입 Test용*/
public class SignAction  implements Preparable,ModelDriven,SuperIbatis{//,MemberDAOinterface
	private MemberDTO dto=null;
	private SqlMapClient sqlMapper;
	public String execute() throws Exception{
		//int check=(Integer)sqlMapper.queryForObject("test.pwCheck", dto);
		sqlMapper.insert("test.joinmem", dto);
		String result ="success";
		return result;
	}
	@Override
	public Object getModel() {
		return dto;
	}
	@Override
	public void prepare() throws Exception {
		dto=new MemberDTO();		//dto를 제외하면 주입받는것들
	}
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
		}
}
