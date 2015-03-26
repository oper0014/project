package test.action;

public class MenuAction{/*매뉴 액션*/	
	private String flag;//flag로 매뉴 페이지 지정
	public void setFlag(String flag){
		this.flag=flag;	
	}
	public String getFlag(){
		return flag;	
	}
	public String execute(){				
		String result ="success";
		return result;
	}
}


