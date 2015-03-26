package test.board;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import test.databean.boardDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
/*
 * 수정 삭제를 위한 입력창
 * 작성자 : 서동우
 * */
public class CheckAction implements SuperIbatis,SessionAware{
	private SqlMapClient sqlMapper;
	private Map sessionMap=null;
	//private boardDTO paramClass; //파라미터를 저장할 객체
	//private boardDTO resultClass; //쿼리 결과 값을 저장할 객체
	private String password;
	private int currentPage;	//현재 페이지
	private int no;
	
	// 비밀번호 체크 액션
	public String execute() {
		String id = (String) sessionMap.get("memId");
		try {
			String id2;
				id2 = (String) sqlMapper.queryForObject("board.selectId",no);
				if(id.equals(id2)){
					System.out.println("자기아이디다");
				}else{return "error";}
			} catch (SQLException e1) {return "error";}
		try {
			//System.out.println("currentPage"+currentPage);
			//System.out.println("no"+no);
			//System.out.println("id"+id);
			//관리자 인지 체크
			int section=(int)sqlMapper.queryForObject("board.selectSection",id);
			System.out.println("section"+section);
			//비밀번호 비교
			if (section==2) {
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
