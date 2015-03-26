package test.board;

import test.databean.FileboardDTO;
import test.interceptor.SuperIbatis;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


import com.ibatis.sqlmap.client.SqlMapClient;

public class ModifyAction2  implements SuperIbatis{
	private SqlMapClient sqlMapper;
	private FileboardDTO paramClass; //�Ķ���͸� ������ ��ü
	private FileboardDTO resultClass; //���� ��� ���� ������ ��ü
	private String old_file;
	private int currentPage;	//���� ������
	private int no;
	private String subject;
	private String content;

	private File upload; //���� ��ü
	private String uploadContentType; //������ Ÿ��
	private String uploadFileName; //���� �̸�
	private String fileUploadPath = "D:\\Java\\upload\\"; //���ε� ���.
	
	// �Խñ� �� ����
		public String execute() throws Exception {
			//�Ķ���Ϳ� ����Ʈ ��ü ����.
			paramClass = new FileboardDTO();
			resultClass = new FileboardDTO();

			// ������ �׸� ����.
			paramClass.setNo(no);
			paramClass.setSubject(subject);
			paramClass.setContent(content);

			// �ϴ� �׸� �����Ѵ�.
			sqlMapper.update("board.updateFileBoard", paramClass);

			// ������ ������ ���ε� �Ǿ��ٸ� ������ ���ε��ϰ� DB�� file �׸��� ������.
			if (getUpload() != null) {
				
				//���� ������ ����� ���� �̸��� Ȯ���� ����.
				String file_name = "file_" + getNo();
			           String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
				
				//���� ���� ����
				File deleteFile = new File(fileUploadPath + getOld_file());
				deleteFile.delete();
				
				//�� ���� ���ε�
				File destFile = new File(fileUploadPath + file_name + "." + file_ext);
				FileUtils.copyFile(getUpload(), destFile);
				
				//���� ���� �Ķ���� ����.
				paramClass.setFile_orgname(getUploadFileName());
				paramClass.setFile_savname(file_name + "." + file_ext);
				
				//���� ���� ������Ʈ.
				sqlMapper.update("board.updateFile", paramClass);
			}

			// ������ ������ view �������� �̵�.
			//resultClass = (FileboardDTO) sqlMapper.queryForObject("selectOne", getNo());

			return "success";
			
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


		public FileboardDTO getParamClass() {
			return paramClass;
		}

		public void setParamClass(FileboardDTO paramClass) {
			this.paramClass = paramClass;
		}

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
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
		public String getOld_file() {
			return old_file;
		}

		public void setOld_file(String old_file) {
			this.old_file = old_file;
		}
		@Override
		public void setIbatis(SqlMapClient sqlMapper) {
			this.sqlMapper=sqlMapper;
		}
}

