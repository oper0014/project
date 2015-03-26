package test.board;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;

public class CheckAction2  implements SuperIbatis,SessionAware{
	private SqlMapClient sqlMapper;
	private Map sessionMap=null;
	private String password;
	private int currentPage;	//���� ������
	private int no;
	
	// ��й�ȣ üũ �׼�
	public String execute() {
		String id = (String) sessionMap.get("memId");
		
		try {
		String id2;
			id2 = (String) sqlMapper.queryForObject("board.selectId2",no);
			if(id.equals(id2)){
				System.out.println("�ڱ���̵��");
			}else{return "error";}
		} catch (SQLException e1) {return "error";}
		
		// ��й�ȣ �Է°� �Ķ���� ����.
		//paramClass.setNo(no);
		try {
			int section;
			try {
				section=(int)sqlMapper.queryForObject("board.selectSection",id);
				System.out.println("section"+section);
			} catch (Exception e) {section=1;}
			//��й�ȣ ��
			if (section!=1) {
				String pw =(String)sqlMapper.queryForObject("board.selectPw",id);
				System.out.println("pw"+pw);
				if(pw.equals(password)){
					return "success";
				}else{
					return "error";
				}
			}
			else{return "error";}
			
		} catch (SQLException e) {return "error";}
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setPassword(String password) {
		this.password = password;
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
