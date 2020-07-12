package action;

public class User {
	private String UsrId;
	private String UsrName;
	private int UsrBorrow;
	private int UsrBadRecord;
	
	public void setUsrId(String id) {
		this.UsrId = id;
	}
	public String getUsrId() {
		return UsrId;
	}
	
	public void setUsrName(String name) {
		this.UsrName = name;
	}
	public String getUsrName() {
		return UsrName;
	}
	
	public void setUsrBorrow(int borrow) {
		this.UsrBorrow = borrow;
	}
	public int getUsrBorrow() {
		return UsrBorrow;
	}
	
	public void setUsrBadRecord(int badrecord) {
		this.UsrBadRecord = badrecord;
	}
	public int getUsrBadRecord() {
		return UsrBadRecord;
	}

}
