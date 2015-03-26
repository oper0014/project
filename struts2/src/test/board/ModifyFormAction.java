package test.board;

import test.databean.boardDTO;

public class ModifyFormAction {
	private int currentPage;	//현재 페이지
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
