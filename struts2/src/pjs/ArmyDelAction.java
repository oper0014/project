package pjs;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;


/*
 * 서동우
 * 군 입영 사항 취소 요청
 * */
public class ArmyDelAction implements SessionAware,SuperIbatis{
	private SqlMapClient sqlMapper;
	private Map sessionMap=null;
	public String execute(){	
		String id=(String) sessionMap.get("memId");
		System.out.println("군 입영삭제에서 새션 아이디:"+id);

		try {
			// 삭제 쿼리 수행.
			sqlMapper.update("test.delArmy", id);
		} catch (Exception e) {e.printStackTrace();}
		
		String result ="success";
		return result;
	}
	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper=sqlMapper;
	}
	@Override
	public void setSession(Map arg0) {
		this.sessionMap=arg0;	
	}
}
