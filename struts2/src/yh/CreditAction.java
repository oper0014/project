package yh;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import test.databean.gradeDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;

/*
 * 윤호 담당
 * 13번 이수학점 조회
 * */
public class CreditAction implements SuperIbatis, SessionAware{
	public static SqlMapClient sqlMapper;
	private gradeDTO dto = null;
	private List<gradeDTO> list = new ArrayList<gradeDTO>();
	private Map sessionMap;
	int a = 0;
	int sum = 0;
	

	public String execute()throws Exception{
		String id=(String) sessionMap.get("memId");
		System.out.println(id);
		list = (List)sqlMapper.queryForList("yh.grade_select",id);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++){
			a = list.get(i).getCredit();
			sum += a;
		}
		System.out.println(sum);
		String result ="success";
		return result;
	}

	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper =sqlMapper;
	}

	public gradeDTO getDto() {
		return dto;
	}

	public void setDto(gradeDTO dto) {
		this.dto = dto;
	}

	public List<gradeDTO> getList() {
		return list;
	}

	public void setList(List<gradeDTO> list) {
		this.list = list;
	}

	public void setSession(Map arg0) {
		this.sessionMap = arg0;
	}
	public int getSum(){
		return sum;
	}
	/*@Override
	public Object getModel() {

		return null;
	}

	@Override
	public void prepare() throws Exception {

	}*/
	
}
