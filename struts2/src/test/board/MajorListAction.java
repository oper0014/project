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
	private int currentPage = 1;	//���� ������
	private int totalCount; 		// �� �Խù��� ��
	private int blockCount = 10;	// �� ��������  �Խù��� ��
	private int blockPage = 5; 	// �� ȭ�鿡 ������ ������ ��
	private String pagingHtml; 	//����¡�� ������ HTML
	private pagingAction page; 	// ����¡ Ŭ����
	public String execute(){
		try {
			list = sqlMapper.queryForList("board.selectMajorAll");
			System.out.println("selectMajornum:"+selectMajornum);
			
			String id = (String) sessionMap.get("memId");//���ǿ��� id ������
			
			String selectMajorname = (String)sqlMapper.queryForObject("board.selectMajorName",selectMajornum);
			System.out.println("sssss"+selectMajorname);
			list2 = sqlMapper.queryForList("board.selectFileBoardAll",selectMajorname);
			System.out.println("size2:"+list2.size());
			totalCount = list2.size(); // ��ü �� ������ ���Ѵ�.
			page = new pagingAction(currentPage, totalCount, blockCount, blockPage); // pagingAction ��ü ����.
			pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

			// ���� ���������� ������ ������ ���� ��ȣ ����.
			int lastCount = totalCount;

			// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1 ��ȣ�� ����.
			if (page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;

			// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
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
