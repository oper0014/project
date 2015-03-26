package test.databean;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MyscheduleDTO {

	private int id;
	private String proname;
	private String subnum;
	

	private String sname;//怨쇰ぉ紐�
	//private List<String> stime = new ArrayList<String>();//媛뺤쓽�떆媛�
	String[] stime;
	private String sclass;//媛뺤쓽�떎
	private int scredit;//�씤�젙�븰�젏
	private String ssection;//�씠�닔援щ텇
	private String majorname;//�쟾怨�
	private String majornum;
	private String sday;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getSubnum() {
		return subnum;
	}
	public void setSubnum(String subnum) {
		this.subnum = subnum;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String[] getStime() {
		return stime;
	}
	public void setStime(String stime) {
		//this.stime = stime;
		this.stime = new String(stime).split(",");
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public int getScredit() {
		return scredit;
	}
	public void setScredit(int scredit) {
		this.scredit = scredit;
	}
	public String getSsection() {
		return ssection;
	}
	public void setSsection(String ssection) {
		this.ssection = ssection;
	}
	public String getMajorname() {
		return majorname;
	}
	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public String getMajornum() {
		return majornum;
	}
	public void setMajornum(String majornum) {
		this.majornum = majornum;
	}
	public String getSday() {
		return sday;
	}
	public void setSday(String sday) {
		this.sday = sday;
	}

	
	
}
