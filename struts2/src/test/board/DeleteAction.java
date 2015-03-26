package test.board;
import test.databean.boardDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;

public class DeleteAction implements SuperIbatis{
	private SqlMapClient sqlMapper;
	private boardDTO paramClass; //�Ķ���͸� ������ ��ü
	private boardDTO resultClass; //���� ��� ���� ������ ��ü

	private int currentPage;	//���� ������
	private int no;
	
	// �Խñ� �� ����
		public String execute() throws Exception {
			
			try{	
			// ���� ���� ����.
			System.out.println("������ �� ��ȣ"+no);
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

