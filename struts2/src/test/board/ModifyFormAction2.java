package test.board;

public class ModifyFormAction2 {
	private int currentPage;	//���� ������
	private int no;
	public String execute() throws Exception {

		return "success";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
