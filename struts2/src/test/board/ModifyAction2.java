package test.board;

import test.databean.FileboardDTO;
import test.interceptor.SuperIbatis;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


import com.ibatis.sqlmap.client.SqlMapClient;

public class ModifyAction2  implements SuperIbatis{
	private SqlMapClient sqlMapper;
	private FileboardDTO paramClass; //파라미터를 저장할 객체
	private FileboardDTO resultClass; //쿼리 결과 값을 저장할 객체
	private String old_file;
	private int currentPage;	//현재 페이지
	private int no;
	private String subject;
	private String content;

	private File upload; //파일 객체
	private String uploadContentType; //컨텐츠 타입
	private String uploadFileName; //파일 이름
	private String fileUploadPath = "D:\\Java\\upload\\"; //업로드 경로.
	
	// 게시글 글 삭제
		public String execute() throws Exception {
			//파라미터와 리절트 객체 생성.
			paramClass = new FileboardDTO();
			resultClass = new FileboardDTO();

			// 수정할 항목 설정.
			paramClass.setNo(no);
			paramClass.setSubject(subject);
			paramClass.setContent(content);

			// 일단 항목만 수정한다.
			sqlMapper.update("board.updateFileBoard", paramClass);

			// 수정할 파일이 업로드 되었다면 파일을 업로드하고 DB의 file 항목을 수정함.
			if (getUpload() != null) {
				
				//실제 서버에 저장될 파일 이름과 확장자 설정.
				String file_name = "file_" + getNo();
			           String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
				
				//이전 파일 삭제
				File deleteFile = new File(fileUploadPath + getOld_file());
				deleteFile.delete();
				
				//새 파일 업로드
				File destFile = new File(fileUploadPath + file_name + "." + file_ext);
				FileUtils.copyFile(getUpload(), destFile);
				
				//파일 정보 파라미터 설정.
				paramClass.setFile_orgname(getUploadFileName());
				paramClass.setFile_savname(file_name + "." + file_ext);
				
				//파일 정보 업데이트.
				sqlMapper.update("board.updateFile", paramClass);
			}

			// 수정이 끝나면 view 페이지로 이동.
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

