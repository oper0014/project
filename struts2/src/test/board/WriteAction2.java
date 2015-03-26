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
	private FileboardDTO paramClass; //파라미터를 저장할 객체
	private FileboardDTO resultClass; //쿼리 결과 값을 저장할 객체

	private int currentPage; //현재 페이지

	private int no;
	private String subject;
	private String content;
	private String file_orgName; //업로드 파일의 원래 이름
	private String file_savName; //서버에 저장할 업로드 파일의 이름. 고유 번호로 구분한다.
	Calendar today = Calendar.getInstance(); //오늘 날짜 구하기.

	private File upload; //파일 객체
	private String uploadContentType; //컨텐츠 타입
	private String uploadFileName; //파일 이름
	private String fileUploadPath = "D:\\Java\\upload\\"; //업로드 경로.

	public String form() throws Exception {
		//등록 폼.
		System.out.println("form");
		return "success";
	}

	// 게시판 WRITE 액션
	public String execute() throws Exception {
		System.out.println("executessssss");
		String id = (String) sessionMap.get("memId");//세션에서 id 가져옴
		int section;
		try{
		section=(int)sqlMapper.queryForObject("board.selectSection",id);}
		catch(Exception e){section=1;}
		if (section==1) {
			System.out.println("학생");
			return "error";
		}
		String major =(String)sqlMapper.queryForObject("board.selectBoardmajor",id);
		
		//파라미터와 리절트 객체 생성.
		paramClass = new FileboardDTO();
		resultClass = new FileboardDTO();

		// 등록할 항목 설정.
		paramClass.setSubject(getSubject());
		paramClass.setId(id);
		paramClass.setMajor(major);
		paramClass.setContent(getContent());
		paramClass.setRegdate(today.getTime());
		
		// 등록 쿼리 수행.
		sqlMapper.insert("board.insertartBoard2", paramClass);
		
		// 첨부파일을 선택했다면 파일을 업로드한다.
		if (getUpload() != null) {
			
			//등록한 글 번호 가져오기.
			resultClass = (FileboardDTO) sqlMapper.queryForObject("board.selectLastNo");
			
			//실제 서버에 저장될 파일 이름과 확장자 설정.
			String file_name = "file_" + resultClass.getNo();
			String file_ext = getUploadFileName().substring(
					getUploadFileName().lastIndexOf('.') + 1,
					getUploadFileName().length());
			
			//서버에 파일 저장.
			File destFile = new File(fileUploadPath + file_name + "."
					+ file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			//파일 정보 파라미터 설정.
			paramClass.setNo(resultClass.getNo());
			paramClass.setFile_orgname(getUploadFileName());		//원래 파일 이름
			paramClass.setFile_savname(file_name + "." + file_ext);	//서버에 저장한 파일 이름
			
			//파일 정보 업데이트.
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
