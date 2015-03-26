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
 * ���� �Խ��� ��
 * �ۼ��� : ������
 * */
public class viewAction implements SuperIbatis {
	private SqlMapClient sqlMapper;

	private boardDTO paramClass = new boardDTO(); //�Ķ���͸� ������ ��ü
	private boardDTO resultClass = new boardDTO(); //���� ��� ���� ������ ��ü

	private int currentPage;
	private int no;


	// �󼼺���
	public String execute() throws Exception {

		// �ش� ���� ��ȸ�� +1.
		sqlMapper.update("board.updateReadHit",no);
		// �ش� ��ȣ�� ���� �����´�.
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

