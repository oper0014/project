package dyj;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import test.databean.ReqSubJoinDTO;
import test.databean.RequestDTO;

import test.databean.StuSubJoinDTO;
import test.databean.SubjectDTO;
import test.interceptor.SuperIbatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class RequestInsertProAction implements ModelDriven, SessionAware, SuperIbatis, Preparable {
	public static SqlMapClient sqlMapper;
	private Map sessionMap;
 
	
	private List<String> list_Substime = new ArrayList<String>();
	private List<String> list_Subsday = new ArrayList<String>();
	private List<String> list_Reqstime = new ArrayList<String>();
	private List<String> list_Reqsday = new ArrayList<String>();
 

	private RequestDTO dto;
	private String id;
	private int count;
	
	
	private String ssection;
	private String grade;
	private String term;
	private String year;

	public void setSsection(String ssection) {	this.ssection = ssection; }
	public void setGrade(String grade) {	this.grade = grade; }
	public void setTerm(String term) {this.term = term;}
	public void setYear(String year) {	this.year = year; }
	public String getSsection() {	return ssection; }
	public String getGrade() {	return grade;}
	public String getTerm() {return term;}
	public String getYear() {	return year;}


	public String execute() {
		id = (String) sessionMap.get("memId");
		String result="request_ok";	
		try {

			int max = (int) sqlMapper.queryForObject("yj.selectmax", dto); // 해당과목(snumber)최대인원수
			count = (int) sqlMapper.queryForObject("yj.selectCount", dto);
			int check = (int) sqlMapper.queryForObject("yj.selectIdSubject",dto); // 수강신청하는아이디에 수강신청하고자하는과목이 있는지 체크

			list_Substime = sqlMapper .queryForList("yj.selectSubjectStime", dto);
			list_Subsday = sqlMapper.queryForList("yj.selectSubjectSday", dto);

			list_Reqstime = sqlMapper.queryForList("yj.selectRequestStime", id);
			list_Reqsday = sqlMapper.queryForList("yj.selectRequestSday", id);

			int flag = 0;
			int flag2=0;
			String[] str = null;
			String[] str2 = null;


						for (String s : list_Substime) {
							str = s.split(",");
						 
							
							for (String s2 : str) {
							//	list_split.add(s2);
								 System.out.println("=================");
								for (String ss : list_Reqstime) {
									str2 = ss.split(",");
									for (String s3 : str2) {
								//		list_split2.add(s3);
										System.out.println("subject : "+s2);
										System.out.println("request : " + s3);

										if (!s2.equals(s3) ) {
											System.out.println("시간안겹쳐");
											
									 

										} else {
											System.out.println("시간겹쳐");
											flag = 1; 
										}
									}
								}
							}
						}
						System.out.println("시간 flag = "+flag);

					for (String sss : list_Subsday) {

					  
							for (String ssss : list_Reqsday) {
								System.out.println("과목 : " + sss);
								System.out.println("신청 : " + ssss);
								if (!sss.equals(ssss)) {//요일이안겹치면
								
									System.out.println("요일안겹쳐");	
						
						
								} else { //요일이겹치면
									System.out.println("요일겹쳐");
									flag2=1;
								}
							}
						}
						
					System.out.println("과목 flag = "+flag2);
						
						
						
			if (count < max) {
				if (check == 0) {
					if ((flag == 0 && flag2==0) || (flag==1 && flag2==0) || (flag==0 && flag2==1) ) {
						sqlMapper.insert("yj.request", dto); //수강신청
						sqlMapper.update("yj.updateCountUp", dto); //인원증가 
						 
					} else {
						result="request_override"; //시간과 요일이 겹칩니다
					}
				} else {
					result="request_already"; // 이미 수강신청한과목입니다
				}

			} else {
				result="request_fail"; // 인원이꽉찼습니다
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}

 
	@Override
	public void prepare() throws Exception {
		dto = new RequestDTO();

	}

	@Override
	public void setIbatis(SqlMapClient sqlMapper) {
		this.sqlMapper = sqlMapper;

	}

	@Override
	public void setSession(Map arg0) {
		this.sessionMap = arg0;

	}

	@Override
	public Object getModel() {
		return dto;
	}

}
