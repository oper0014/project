package pjs;

import java.sql.Timestamp;

public class ArmyDTO {
	private String id;
	private Timestamp askdate;
	private String join;
	private String discharge;
	private int armynumber;
	private int state;
	private Timestamp reg_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getAskdate() {
		return askdate;
	}

	public void setAskdate(Timestamp askdate) {
		this.askdate = askdate;
	}

	public String getJoin() {
		return join;
	}

	public void setJoin(String join) {
		this.join = join;
	}

	public String getDischarge() {
		return discharge;
	}

	public void setDischarge(String discharge) {
		this.discharge = discharge;
	}

	public int getArmynumber() {
		return armynumber;
	}

	public void setArmynumber(int armynumber) {
		this.armynumber = armynumber;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
}
