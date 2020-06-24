package action;

public class Book {
	private String BookId;
	private String BookName;
	private String BookWriter;
	private String BookPublisher;
	private String BookPublishYear;
	private int BookTotal;
	private int BookBorrowed;
	
	public void setBookId(String id) {
		this.BookId = id;
	}
	public String getBookId() {
		return BookId;
	}
	
	public void setBookName(String name) {
		this.BookName = name;
	}
	public String getBookName() {
		return BookName;
	}
	
	public void setBookWriter(String writer) {
		this.BookWriter = writer;
	}
	public String getBookWriter() {
		return BookWriter;
	}
	
	public void setBookPublisher(String publisher) {
		this.BookPublisher = publisher;
	}
	public String getBookPublisher() {
		return BookPublisher;
	}
	
	public void setBookPublishYear(String publisheryear) {
		this.BookPublishYear = publisheryear;
	}
	public String getBookPublishYear() {
		return BookPublishYear;
	}
	
	public void setBookTotal(int total) {
		this.BookTotal = total;
	}
	public int getBookTotal() {
		return BookTotal;
	}
	
	public void setBookBorrowed(int borrowed) {
		this.BookBorrowed = borrowed;
	}
	public int getBookBorrowed() {
		return BookBorrowed;
	}

}
