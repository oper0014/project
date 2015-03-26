package test.interceptor;

import test.action.MemberDAO;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/*지금 사용 안함*/
public class MemberDAOInterceptor  implements Interceptor{//DAO 객체 주입(DI)

	private MemberDAO dao =null;	
	public void destroy() {		
	}
	@Override
	public void init() {
		// 웹서버 실행시 최초 1회 동작
		dao = new MemberDAO();
	}
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Object obj = arg0.getAction();
		if(obj instanceof MemberDAOinterface){// instanceof : 상속이나 구현 관계가 맺어져있으면 true(다형성이 된다.)
			MemberDAOinterface inter=(MemberDAOinterface)obj;//다형성 이용
			inter.setMemberDAO(dao);	
		}
		return arg0.invoke();
	}

}