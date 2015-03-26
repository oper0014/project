package dyj;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/*
 * 도예진 담당
 * 8번 수강신청
 * */
public class RequestAction implements SessionAware {
	private Map sessionMap = null;
 
	public String execute(){	
		 sessionMap.get("memId");
		String result ="success";
		return result;
	}

	@Override
	public void setSession(Map arg0) {
		this.sessionMap=arg0;
	}

}
