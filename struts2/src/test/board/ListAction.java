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
 * ���� �Խ��� ����Ʈ
 * �ۼ��� : ������
 * */

public class ListAction implements SuperIbatis,SessionAware {
	
	private SqlMapClient sqlMapper;
	private List<boardDTO> list = new ArrayList<boardDTO>();;	 
	private Map sessionMap=null;
	private int currentPage = 1;	//���� ������
	private int totalCount; 		// �� �Խù��� ��
	private int blockCount = 10;	// �� ��������  �Խù��� ��
	private int blockPage = 5; 	// �� ȭ�鿡 ������ ������ ��
	private String pagingHtml; 	//����¡�� ������ HTML
	private pagingAction page; 	// ����¡ Ŭ����
	private String major;
	
	public String getMajor() {
		return major;
	}

	// �Խ��� LIST �׼�
	public String execute() throws Exception {

		String id = (String) sessionMap.get("memId");//���ǿ��� id ������
		major =(String)sqlMapper.queryForObject("board.selectBoardmajor",id);
		System.out.println("�����Խ��� id:"+id+" major:"+major);
		// ��� ���� ������ list�� �ִ´�.
		list = sqlMapper.queryForList("board.selectBoardAll",major);

		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage); // pagingAction ��ü ����.
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;

		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1 ��ȣ�� ����.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
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

