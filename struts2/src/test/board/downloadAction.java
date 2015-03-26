package test.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import com.ibatis.sqlmap.client.SqlMapClient;

import test.databean.FileboardDTO;
import test.interceptor.SuperIbatis;

public class downloadAction implements SuperIbatis {
	private SqlMapClient sqlMapper;
	private FileboardDTO paramClass = new FileboardDTO(); // 파라미터를 저장할 객체
	private FileboardDTO resultClass = new FileboardDTO(); // 쿼리 결과 값을 저장할 객체

	private int currentPage;
	private int no;

	private String fileUploadPath = "D:\\Java\\upload\\";

	private InputStream inputStream;
	private String contentDisposition;
	private long contentLength;

	// 상세보기
	public String execute() throws Exception {

		// 해당 번호의 파일 정보를 가져온다.
		System.out.println("다운로드::::" + no);
		resultClass = (FileboardDTO) sqlMapper.queryForObject(
				"board.selectOneFile", no);
		System.out.println("00000");
		// 파일 경로와 파일명을 file 객체에 넣는다.
		File fileInfo = new File(fileUploadPath + resultClass.getFile_savname());

		// 다운로드 파일 정보 설정.
		setContentLength(fileInfo.length());
		setContentDisposition("attachment;filename="
				+ URLEncoder.encode(resultClass.getFile_orgname(), "EUC-KR"));
		setInputStream(new FileInputStream(fileUploadPath
				+ resultClass.getFile_savname()));

		return "success";
	}


	public FileboardDTO getParamClass() {
		return paramClass;
	}

	public void setParamClass(FileboardDTO paramClass) {
		this.paramClass = paramClass;
	}

	public FileboardDTO getResultClass() {
		return resultClass;
	}

	public void setResultClass(FileboardDTO resultClass) {
		this.resultClass = resultClass;
	}
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
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
