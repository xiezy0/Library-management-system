package action;

import java.util.*;

public class Record {
	private String RecordId;
	private String UsrId;
	private String BookId;
	private Date BorrowTime;
	
	public void setRecordId(String recordid) {
		this.RecordId = recordid;
	}
	public String getRecordId() {
		return RecordId;
	}
	
	public void setUsrId(String usrid) {
		this.UsrId = usrid;
	}
	public String getUsrId() {
		return UsrId;
	}
	
	public void setBookId(String bookid) {
		this.BookId = bookid;
	}
	public String getBookId() {
		return BookId;
	}
	
	public void setBorrowTime(Date borrowtime) {
		this.BorrowTime = borrowtime;
	}
	public Date getBorrowTime() {
		return BorrowTime;
	}
	
	

}