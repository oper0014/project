package test.board;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient; 
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
 




import java.util.*;

import org.apache.struts2.interceptor.SessionAware;

import test.databean.boardDTO;
import test.interceptor.SuperIbatis;
/*
 * 공지 게시판 리스트
 * 작성자 : 서동우
 * */

public class ListAction implements SuperIbatis,SessionAware {
	
	private SqlMapClient sqlMapper;
	private List<boardDTO> list = new ArrayList<boardDTO>();;	 
	private Map sessionMap=null;
	private int currentPage = 1;	//현재 페이지
	private int totalCount; 		// 총 게시물의 수
	private int blockCount = 10;	// 한 페이지의  게시물의 수
	private int blockPage = 5; 	// 한 화면에 보여줄 페이지 수
	private String pagingHtml; 	//페이징을 구현한 HTML
	private pagingAction page; 	// 페이징 클래스
	private String major;
	
	public String getMajor() {
		return major;
	}

	// 게시판 LIST 액션
	public String execute() throws Exception {

		String id = (String) sessionMap.get("memId");//세션에서 id 가져옴
		major =(String)sqlMapper.queryForObject("board.selectBoardmajor",id);
		System.out.println("공지게시판 id:"+id+" major:"+major);
		// 모든 글을 가져와 list에 넣는다.
		list = sqlMapper.queryForList("board.selectBoardAll",major);

		totalCount = list.size(); // 전체 글 갯수를 구한다.
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage); // pagingAction 객체 생성.
		pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.

		// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
		int lastCount = totalCount;

		// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1 번호로 설정.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
		list = list.subList(page.getStartCount(), lastCount);

		return "success";
	}
	
	public List<boardDTO> getList() {
		return list;
	}

	public void setList(List<boardDTO> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public pagingAction getPage() {
		return page;
	}

	public void setPage(pagingAction page) {
		this.page = page;
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

