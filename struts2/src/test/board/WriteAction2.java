package test.board;

import java.io.File;
import java.util.Calendar;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;

import test.databean.FileboardDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;

public class WriteAction2 implements SuperIbatis,SessionAware{
	private SqlMapClient sqlMapper; 
	private Map sessionMap=null;
	private FileboardDTO paramClass; //�Ķ���͸� ������ ��ü
	private FileboardDTO resultClass; //���� ��� ���� ������ ��ü

	private int currentPage; //���� ������

	private int no;
	private String subject;
	private String content;
	private String file_orgName; //���ε� ������ ���� �̸�
	private String file_savName; //������ ������ ���ε� ������ �̸�. ���� ��ȣ�� �����Ѵ�.
	Calendar today = Calendar.getInstance(); //���� ��¥ ���ϱ�.

	private File upload; //���� ��ü
	private String uploadContentType; //������ Ÿ��
	private String uploadFileName; //���� �̸�
	private String fileUploadPath = "D:\\Java\\upload\\"; //���ε� ���.

	public String form() throws Exception {
		//��� ��.
		System.out.println("form");
		return "success";
	}

	// �Խ��� WRITE �׼�
	public String execute() throws Exception {
		System.out.println("executessssss");
		String id = (String) sessionMap.get("memId");//���ǿ��� id ������
		int section;
		try{
		section=(int)sqlMapper.queryForObject("board.selectSection",id);}
		catch(Exception e){section=1;}
		if (section==1) {
			System.out.println("�л�");
			return "error";
		}
		String major =(String)sqlMapper.queryForObject("board.selectBoardmajor",id);
		
		//�Ķ���Ϳ� ����Ʈ ��ü ����.
		paramClass = new FileboardDTO();
		resultClass = new FileboardDTO();

		// ����� �׸� ����.
		paramClass.setSubject(getSubject());
		paramClass.setId(id);
		paramClass.setMajor(major);
		paramClass.setContent(getContent());
		paramClass.setRegdate(today.getTime());
		
		// ��� ���� ����.
		sqlMapper.insert("board.insertartBoard2", paramClass);
		
		// ÷�������� �����ߴٸ� ������ ���ε��Ѵ�.
		if (getUpload() != null) {
			
			//����� �� ��ȣ ��������.
			resultClass = (FileboardDTO) sqlMapper.queryForObject("board.selectLastNo");
			
			//���� ������ ����� ���� �̸��� Ȯ���� ����.
			String file_name = "file_" + resultClass.getNo();
			String file_ext = getUploadFileName().substring(
					getUploadFileName().lastIndexOf('.') + 1,
					getUploadFileName().length());
			
			//������ ���� ����.
			File destFile = new File(fileUploadPath + file_name + "."
					+ file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			//���� ���� �Ķ���� ����.
			paramClass.setNo(resultClass.getNo());
			paramClass.setFile_orgname(getUploadFileName());		//���� ���� �̸�
			paramClass.setFile_savname(file_name + "." + file_ext);	//������ ������ ���� �̸�
			
			//���� ���� ������Ʈ.
			sqlMapper.update("board.updateFile", paramClass);
		}

		return "success";
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public FileboardDTO getParamClass() {
		return paramClass;
	}

	public void setParamClass(FileboardDTO paramClass) {
		this.paramClass = paramClass;
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

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getFile_orgName() {
		return file_orgName;
	}

	public void setFile_orgName(String file_orgName) {
		this.file_orgName = file_orgName;
	}

	public String getFile_savName() {
		return file_savName;
	}

	public void setFile_savName(String file_savName) {
		this.file_savName = file_savName;
	}

	public FileboardDTO getResultClass() {
		return resultClass;
	}

	public void setResultClass(FileboardDTO resultClass) {
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
	@Override
	public void setSession(Map arg0) {
		this.sessionMap=arg0;	
	}

}
