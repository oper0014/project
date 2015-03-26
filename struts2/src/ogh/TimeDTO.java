package ogh;

public class TimeDTO {
	
	String classify = null;
	String subject = null;
	String professor = null;
	int scorecount = 0;
	String subtime = null;
	String subroom = null;
	String subnum = null;
	String major = null;
	int grade = 0;
	
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getScorecount() {
		return scorecount;
	}
	public void setScorecount(int scorecount) {
		this.scorecount = scorecount;
	}
	public String getSubtime() {
		return subtime;
	}
	public void setSubtime(String subtime) {
		this.subtime = subtime;
	}
	public String getSubroom() {
		return subroom;
	}
	public void setSubroom(String subroom) {
		this.subroom = subroom;
	}
	public String getSubnum() {
		return subnum;
	}
	public void setSubnum(String subnum) {
		this.subnum = subnum;
	}
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}

}
