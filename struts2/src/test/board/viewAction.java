package test.board;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.URLEncoder;

import test.databean.boardDTO;
import test.interceptor.SuperIbatis;
/*
 * 공지 게시판 뷰
 * 작성자 : 서동우
 * */
public class viewAction implements SuperIbatis {
	private SqlMapClient sqlMapper;

	private boardDTO paramClass = new boardDTO(); //파라미터를 저장할 객체
	private boardDTO resultClass = new boardDTO(); //쿼리 결과 값을 저장할 객체

	private int currentPage;
	private int no;


	// 상세보기
	public String execute() throws Exception {

		// 해당 글의 조회수 +1.
		sqlMapper.update("board.updateReadHit",no);
		// 해당 번호의 글을 가져온다.
		resultClass = (boardDTO) sqlMapper.queryForObject("board.selectOne", no);

		return "success";
	}

	public boardDTO getParamClass() {
		return paramClass;
	}

	public void setParamClass(boardDTO paramClass) {
		this.paramClass = paramClass;
	}

	public boardDTO getResultClass() {
		return resultClass;
	}

	public void setResultClass(boardDTO resultClass) {
		this.resultClass = resultClass;
	}
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

