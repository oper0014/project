package test.board;
import com.ibatis.sqlmap.client.SqlMapClient;

import java.util.*;

import org.apache.struts2.interceptor.SessionAware;

import test.databean.boardDTO;
import test.interceptor.SuperIbatis;
/*
 * 공지 게시판 입력
 * 작성자 : 서동우
 * */
public class WriteAction implements SuperIbatis,SessionAware{

	private Map sessionMap=null;
	private SqlMapClient sqlMapper; 
	private boardDTO paramClass; //파라미터를 저장할 객체
	private boardDTO resultClass; //쿼리 결과 값을 저장할 객체
	private int currentPage; //현재 페이지
	private int no;
	private String subject;
	//private String id;
	private String content;
	//private String major;

	Calendar today = Calendar.getInstance(); //오늘 날짜 구하기.

	public String form() throws Exception {
		//등록 폼.
		return "success";
	}
	// 게시판 WRITE 액션
	public String execute() throws Exception {

		//파라미터와 리절트 객체 생성.
		paramClass = new boardDTO();
		resultClass = new boardDTO();
		
		String id = (String) sessionMap.get("memId");//세션에서 id 가져옴
		int section=(int)sqlMapper.queryForObject("board.selectSection",id);
		if (section==1) {
			System.out.println("학생");
			return "error";
		}
		String major =(String)sqlMapper.queryForObject("board.selectBoardmajor",id);
		System.out.println("공지게시판 id:"+id+" major:"+major);

		// 등록할 항목 설정.
		paramClass.setSubject(getSubject());
		paramClass.setId(id);
		paramClass.setMajor(major);
		paramClass.setContent(getContent());
		paramClass.setRegdate(today.getTime());

		// 등록 쿼리 수행.
		sqlMapper.insert("board.insertartBoard", paramClass);


		return "success";
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public boardDTO getParamClass() {
		return paramClass;
	}

	public void setParamClass(boardDTO paramClass) {
		this.paramClass = paramClass;
	}
	/*
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	*/
	@Override
	public void setSession(Map arg0) {
		this.sessionMap=arg0;	
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public boardDTO getResultClass() {
		return resultClass;
	}

	public void setResultClass(boardDTO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
	}
}

