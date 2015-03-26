package test.board;
import com.ibatis.sqlmap.client.SqlMapClient;

import java.util.*;

import org.apache.struts2.interceptor.SessionAware;

import test.databean.boardDTO;
import test.interceptor.SuperIbatis;
/*
 * ���� �Խ��� �Է�
 * �ۼ��� : ������
 * */
public class WriteAction implements SuperIbatis,SessionAware{

	private Map sessionMap=null;
	private SqlMapClient sqlMapper; 
	private boardDTO paramClass; //�Ķ���͸� ������ ��ü
	private boardDTO resultClass; //���� ��� ���� ������ ��ü
	private int currentPage; //���� ������
	private int no;
	private String subject;
	//private String id;
	private String content;
	//private String major;

	Calendar today = Calendar.getInstance(); //���� ��¥ ���ϱ�.

	public String form() throws Exception {
		//��� ��.
		return "success";
	}
	// �Խ��� WRITE �׼�
	public String execute() throws Exception {

		//�Ķ���Ϳ� ����Ʈ ��ü ����.
		paramClass = new boardDTO();
		resultClass = new boardDTO();
		
		String id = (String) sessionMap.get("memId");//���ǿ��� id ������
		int section=(int)sqlMapper.queryForObject("board.selectSection",id);
		if (section==1) {
			System.out.println("�л�");
			return "error";
		}
		String major =(String)sqlMapper.queryForObject("board.selectBoardmajor",id);
		System.out.println("�����Խ��� id:"+id+" major:"+major);

		// ����� �׸� ����.
		paramClass.setSubject(getSubject());
		paramClass.setId(id);
		paramClass.setMajor(major);
		paramClass.setContent(getContent());
		paramClass.setRegdate(today.getTime());

		// ��� ���� ����.
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

