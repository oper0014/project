package test.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/*�α��� ó�� �׼�*/	
public class MainAction implements SessionAware,Preparable,ModelDriven,SuperIbatis{//,MemberDAOinterface
	//private MemberDAO dao =null;
	private MemberDTO dto=null;
	private Map sessionMap=null;
	private SqlMapClient sqlMapper;
	public String execute() throws Exception{
		System.out.println("pw"+dto.getPw());
		int check=(Integer)sqlMapper.queryForObject("test.pwCheck", dto);
		
		String result ="success";
		if(check==1){
			sessionMap.put("memId", dto.getId());//���� �߰�
			//sessionMap.put("memPw", dto.getPw());
			
			try{
				int manager;
				manager=(int)sqlMapper.queryForObject("board.selectSection",dto.getId());
			if (manager!=1) {
				System.out.println("관리자모드");
				return "admin";
			}
			}catch(Exception e){}
			
			
		}else{
			result="login";
		}
		return result;
	}
	/*
	@Override
	public void setMemberDAO(MemberDAO dao) {
		this.dao=dao;
	}*/
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
	@Override
	public void setSession(Map arg0) {
		this.sessionMap=arg0;	
	}
}
