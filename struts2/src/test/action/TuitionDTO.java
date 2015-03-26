package test.action;
/*
 * 서동우 작성
 * 등록금 납부 DTO
 * */
public class TuitionDTO {

    private String id;
    private int money;
    private int checkmoney;
    private String term;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getCheckmoney() {
		return checkmoney;
	}
	public void setCheckmoney(int checkmoney) {
		this.checkmoney = checkmoney;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
    
    
    
}
