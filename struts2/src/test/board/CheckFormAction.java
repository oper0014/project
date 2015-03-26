package test.board;
/*
 * 수정 삭제를 위한 입력창
 * 작성자 : 서동우
 * */
public class CheckFormAction {
	private int currentPage;	//현재 페이지
	private int no;
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}	
	public String execute() {
		//System.out.println("CheckFormAction :currentPage:"+currentPage+":no:"+no);
		return "success";
	
	}
}
