package test.board;

public class CheckFormAction2 {
	private int currentPage;	//���� ������
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

