package test.board;
import test.databean.boardDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;

public class DeleteAction implements SuperIbatis{
	private SqlMapClient sqlMapper;
	private boardDTO paramClass; //파라미터를 저장할 객체
	private boardDTO resultClass; //쿼리 결과 값을 저장할 객체

	private int currentPage;	//현재 페이지
	private int no;
	
	// 게시글 글 삭제
		public String execute() throws Exception {
			
			try{	
			// 삭제 쿼리 수행.
			System.out.println("삭제할 글 번호"+no);
			sqlMapper.update("board.deleteArtBoard", no);
			}
			catch(Exception e){return "error";}

			return "success";
		}

		public boardDTO getParamClass() {
			return paramClass;
		}

		public void setParamClass(boardDTO paramClass) {
			this.paramClass = paramClass;
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

