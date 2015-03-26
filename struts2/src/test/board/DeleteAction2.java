package test.board;

import java.io.File;

import test.databean.FileboardDTO;
import test.interceptor.SuperIbatis;



import com.ibatis.sqlmap.client.SqlMapClient;

public class DeleteAction2 implements SuperIbatis{
	private SqlMapClient sqlMapper;
	private FileboardDTO paramClass; //�Ķ���͸� ������ ��ü
	private FileboardDTO resultClass; //���� ��� ���� ������ ��ü

	private String fileUploadPath = "D:\\Java\\upload\\";
	private int currentPage;	//���� ������
	private int no;
	
	// �Խñ� �� ����
		public String execute() throws Exception {
			
			//�Ķ���Ϳ� ����Ʈ ��ü ����.
			paramClass = new FileboardDTO();
			resultClass = new FileboardDTO();
			
			// �ش� ��ȣ�� ���� �����´�.
			resultClass = (FileboardDTO) sqlMapper.queryForObject("board.selectOne2", getNo());

			//���� ���� ����
			File deleteFile = new File(fileUploadPath + resultClass.getFile_savname());
			deleteFile.delete();

			// ������ �׸� ����.
			paramClass.setNo(getNo());
					
			// ���� ���� ����.
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

