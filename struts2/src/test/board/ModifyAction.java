package test.board;

import test.databean.boardDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;

public class ModifyAction implements SuperIbatis{
	private SqlMapClient sqlMapper;
	private boardDTO paramClass; //�Ķ���͸� ������ ��ü
	private boardDTO resultClass; //���� ��� ���� ������ ��ü

	private int currentPage;	//���� ������
	private int no;
	private String subject;
	private String content;

	
	// �Խñ� �� ����
		public String execute() throws Exception {
			//�Ķ���Ϳ� ����Ʈ ��ü ����.
			paramClass = new boardDTO();
			resultClass = new boardDTO();

			// ������ �׸� ����.
			paramClass.setNo(no);
			paramClass.setSubject(subject);
			paramClass.setContent(content);

			// �ϴ� �׸� �����Ѵ�.
			sqlMapper.update("board.updateArtBoard", paramClass);

			// ������ ������ view �������� �̵�.
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

