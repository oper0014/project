package test.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class LogoutAction implements SessionAware {/*로그아웃 액션*/	
	private Map sessionMap=null;
	private String id;
	public void setId(String id){
		this.id=id;	
	}
	public String getId(){
		return id;	
	}
	public String execute(){

		sessionMap.remove("memId", id);//로그인 정보 삭제
		String result ="success";
		return result;
	}
	@Override
	public void setSession(Map arg0) {
		this.sessionMap=arg0;
		
	}
}
