package test.board;

import test.databean.boardDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;

public class ModifyAction implements SuperIbatis{
	private SqlMapClient sqlMapper;
	private boardDTO paramClass; //파라미터를 저장할 객체
	private boardDTO resultClass; //쿼리 결과 값을 저장할 객체

	private int currentPage;	//현재 페이지
	private int no;
	private String subject;
	private String content;

	
	// 게시글 글 삭제
		public String execute() throws Exception {
			//파라미터와 리절트 객체 생성.
			paramClass = new boardDTO();
			resultClass = new boardDTO();

			// 수정할 항목 설정.
			paramClass.setNo(no);
			paramClass.setSubject(subject);
			paramClass.setContent(content);

			// 일단 항목만 수정한다.
			sqlMapper.update("board.updateArtBoard", paramClass);

			// 수정이 끝나면 view 페이지로 이동.
			//resultClass = (boardDTO) sqlMapper.queryForObject("selectOne", getNo());
			
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

