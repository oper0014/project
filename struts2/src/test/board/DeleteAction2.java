package test.board;

import java.io.File;

import test.databean.FileboardDTO;
import test.interceptor.SuperIbatis;



import com.ibatis.sqlmap.client.SqlMapClient;

public class DeleteAction2 implements SuperIbatis{
	private SqlMapClient sqlMapper;
	private FileboardDTO paramClass; //파라미터를 저장할 객체
	private FileboardDTO resultClass; //쿼리 결과 값을 저장할 객체

	private String fileUploadPath = "D:\\Java\\upload\\";
	private int currentPage;	//현재 페이지
	private int no;
	
	// 게시글 글 삭제
		public String execute() throws Exception {
			
			//파라미터와 리절트 객체 생성.
			paramClass = new FileboardDTO();
			resultClass = new FileboardDTO();
			
			// 해당 번호의 글을 가져온다.
			resultClass = (FileboardDTO) sqlMapper.queryForObject("board.selectOne2", getNo());

			//서버 파일 삭제
			File deleteFile = new File(fileUploadPath + resultClass.getFile_savname());
			deleteFile.delete();

			// 삭제할 항목 설정.
			paramClass.setNo(getNo());
					
			// 삭제 쿼리 수행.
			sqlMapper.update("board.deleteFileBoard", no);
			

			return "success";
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
		@Override
		public void setIbatis(SqlMapClient sqlMapper) {
			this.sqlMapper=sqlMapper;
		}
}

