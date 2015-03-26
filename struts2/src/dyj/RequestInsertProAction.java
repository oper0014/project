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

			int max = (int) sqlMapper.queryForObject("yj.selectmax", dto); // �ش����(snumber)�ִ��ο���
			count = (int) sqlMapper.queryForObject("yj.selectCount", dto);
			int check = (int) sqlMapper.queryForObject("yj.selectIdSubject",dto); // ������û�ϴ¾��̵� ������û�ϰ����ϴ°����� �ִ��� üũ

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
											System.out.println("�ð��Ȱ���");
											
									 

										} else {
											System.out.println("�ð�����");
											flag = 1; 
										}
									}
								}
							}
						}
						System.out.println("�ð� flag = "+flag);

					for (String sss : list_Subsday) {

					  
							for (String ssss : list_Reqsday) {
								System.out.println("���� : " + sss);
								System.out.println("��û : " + ssss);
								if (!sss.equals(ssss)) {//�����̾Ȱ�ġ��
								
									System.out.println("���ϾȰ���");	
						
						
								} else { //�����̰�ġ��
									System.out.println("���ϰ���");
									flag2=1;
								}
							}
						}
						
					System.out.println("���� flag = "+flag2);
						
						
						
			if (count < max) {
				if (check == 0) {
					if ((flag == 0 && flag2==0) || (flag==1 && flag2==0) || (flag==0 && flag2==1) ) {
						sqlMapper.insert("yj.request", dto); //������û
						sqlMapper.update("yj.updateCountUp", dto); //�ο����� 
						 
					} else {
						result="request_override"; //�ð��� ������ ��Ĩ�ϴ�
					}
				} else {
					result="request_already"; // �̹� ������û�Ѱ����Դϴ�
				}

			} else {
				result="request_fail"; // �ο��̲�á���ϴ�
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
