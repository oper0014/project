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

import test.databean.FileboardDTO;
import test.databean.boardDTO;
import test.interceptor.SuperIbatis;
/*
 * ���� �Խ��� ��
 * �ۼ��� : ������
 * */
public class viewAction2 implements SuperIbatis {
	private SqlMapClient sqlMapper;

	private FileboardDTO paramClass = new FileboardDTO(); //�Ķ���͸� ������ ��ü
	private FileboardDTO resultClass = new FileboardDTO(); //���� ��� ���� ������ ��ü

	private int currentPage;
	private int no;
	
	private String fileUploadPath = "D:\\Java\\upload\\";

	private InputStream inputStream;
	private String contentDisposition;
	private long contentLength;


	// �󼼺���
	public String execute() throws Exception {

		// �ش� ���� ��ȸ�� +1.
		sqlMapper.update("board.updateReadHit2",no);
		// �ش� ��ȣ�� ���� �����´�.
		resultClass = (FileboardDTO) sqlMapper.queryForObject("board.selectOneFile", no);
		System.out.println("test");
		System.out.println(resultClass.getId());
		System.out.println(resultClass.getMajor());
		System.out.println(resultClass.getFile_savname());

		return "success";
	}
	/*
	// ÷�� ���� �ٿ�ε�
		public String download() throws Exception {

			// �ش� ��ȣ�� ���� ������ �����´�.
			System.out.println("�ٿ�ε�::::"+no);
			resultClass = (FileboardDTO) sqlMapper.queryForObject("board.selectOneFile", no);
			System.out.println("00000");
			// ���� ��ο� ���ϸ��� file ��ü�� �ִ´�.
			File fileInfo = new File(fileUploadPath + resultClass.getFile_savname());

			// �ٿ�ε� ���� ���� ����.
			setContentLength(fileInfo.length());
			setContentDisposition("attachment;filename=" + URLEncoder.encode(resultClass.getFile_orgname(), "EUC-KR"));
			setInputStream(new FileInputStream(fileUploadPath + resultClass.getFile_savname()));

			return "success";
		}
	 */

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
