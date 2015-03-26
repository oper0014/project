package test.board;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import test.databean.FileboardDTO;
import test.databean.MajorDTO;
import test.databean.boardDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;

public class MajorListAction implements SuperIbatis,SessionAware{
	private SqlMapClient sqlMapper;
	private List<MajorDTO> list = new ArrayList<MajorDTO>();
	private int selectMajornum;
	
	private List<FileboardDTO> list2 = new ArrayList<FileboardDTO>();
	private Map sessionMap=null;
	private int currentPage = 1;	//현재 페이지
	private int totalCount; 		// 총 게시물의 수
	private int blockCount = 10;	// 한 페이지의  게시물의 수
	private int blockPage = 5; 	// 한 화면에 보여줄 페이지 수
	private String pagingHtml; 	//페이징을 구현한 HTML
	private pagingAction page; 	// 페이징 클래스
	public String execute(){
		try {
			list = sqlMapper.queryForList("board.selectMajorAll");
			System.out.println("selectMajornum:"+selectMajornum);
			
			String id = (String) sessionMap.get("memId");//세션에서 id 가져옴
			
			String selectMajorname = (String)sqlMapper.queryForObject("board.selectMajorName",selectMajornum);
			System.out.println("sssss"+selectMajorname);
			list2 = sqlMapper.queryForList("board.selectFileBoardAll",selectMajorname);
			System.out.println("size2:"+list2.size());
			totalCount = list2.size(); // 전체 글 갯수를 구한다.
			page = new pagingAction(currentPage, totalCount, blockCount, blockPage); // pagingAction 객체 생성.
			pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.

			// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
			int lastCount = totalCount;

			// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1 번호로 설정.
			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;

			// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
			list2 = list2.subList(page.getStartCount(), lastCount);
			
			
		} catch (SQLException e) {e.printStackTrace();}
		
		return "success";
	}
	public List<MajorDTO> getList() {
		return list;
	}
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
	}
	public int getSelectMajornum() {
		return selectMajornum;
	}
	public void setSelectMajornum(int selectMajornum) {
		this.selectMajornum = selectMajornum;
	}
	
	public List<FileboardDTO> getList2() {
		return list2;
	}

	public void setList2(List<FileboardDTO> list2) {
		this.list2 = list2;
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
	public void setSession(Map arg0) {
		this.sessionMap=arg0;	
	}
	

}
