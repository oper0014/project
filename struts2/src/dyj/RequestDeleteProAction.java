package dyj;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import test.databean.RequestDTO;
import test.interceptor.SuperIbatis;

public class RequestDeleteProAction implements SessionAware, SuperIbatis, Preparable, ModelDriven{
	String result="deleteok";
	RequestDTO requestdto=null;
	public static SqlMapClient sqlMapper;
	private Map sessionMap;
	
	private String ssection;
	private String grade;
	private String term;
	private String year;
	
	
	public String getSsection() {	return ssection; }
	public void setSsection(String ssection) { this.ssection = ssection;}
	public String getGrade() {return grade;}
	public void setGrade(String grade) {	this.grade = grade;}
	public String getTerm() { 	return term; }
	public void setTerm(String term) { 	this.term = term; }
	public String getYear() { 	return year; }
	public void setYear(String year) { this.year = year; }




	public String execute(){
		try {
			sqlMapper.delete("yj.deleteSubject",requestdto);
			sqlMapper.update("yj.updateCountDown",requestdto);
		} catch (SQLException e) {
		 
			e.printStackTrace();
		}
		return result;
	}
	 
	
	
	
	public Object getModel() {
	 	return requestdto;
	}
	
	public void prepare() throws Exception {
		requestdto=new RequestDTO();
		
	}
	public void setIbatis(SqlMapClient sqlMapper) {
	 
		this.sqlMapper=sqlMapper;
	}
	 public void setSession(Map arg0) {
	 	this.sessionMap=arg0;
	}
	
	
}
