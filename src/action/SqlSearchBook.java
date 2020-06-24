package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlSearchBook {
	public List<Book> select(Connection conn, String Bookinfo) throws SQLException {
		if(Bookinfo.compareTo("*") == 0) {
			return select_all(conn, Bookinfo);
		}else {
			return select_appoint(conn, Bookinfo);
		}
		
	}
	
	public List<Book> select_appoint(Connection conn, String Bookinfo) throws SQLException {
		Book book = null;
		List<Book> books = new ArrayList<Book>();
		
		PreparedStatement preparedStatement_0 = null;
		PreparedStatement preparedStatement_1 = null;
        ResultSet rs_0 = null;
        ResultSet rs_1 = null;
        
		String sql_0 = "select *  from library.book  where BookName = ?";
		preparedStatement_0 = conn.prepareStatement(sql_0);
		preparedStatement_0.setString(1, Bookinfo);
		rs_0 = preparedStatement_0.executeQuery(); 
		
		String sql_1 = "select *  from library.book  where BookId = ?";
		preparedStatement_1 = conn.prepareStatement(sql_1);
		preparedStatement_1.setString(1, Bookinfo);
		rs_1 = preparedStatement_1.executeQuery();  
		
		while(rs_0.next()) {
			book=new Book();
			book.setBookId(rs_0.getString("BookId"));
			book.setBookName(rs_0.getString("BookName"));
			book.setBookWriter(rs_0.getString("BookWriter"));
			book.setBookPublisher(rs_0.getString("BookPublisher"));
			book.setBookPublishYear(rs_0.getString("BookPublishYear"));
			book.setBookTotal(rs_0.getInt("BookTotal"));
			book.setBookBorrowed(rs_0.getInt("BookBorrowed"));
			books.add(book);
		}
		
		while(rs_1.next()) {
			book=new Book();
			book.setBookId(rs_1.getString("BookId"));
			book.setBookName(rs_1.getString("BookName"));
			book.setBookWriter(rs_1.getString("BookWriter"));
			book.setBookPublisher(rs_1.getString("BookPublisher"));
			book.setBookPublishYear(rs_1.getString("BookPublishYear"));
			book.setBookTotal(rs_1.getInt("BookTotal"));
			book.setBookBorrowed(rs_1.getInt("BookBorrowed"));
			books.add(book);
		}
		
		return books;
	}
	
	public List<Book> select_all(Connection conn, String Bookinfo) throws SQLException {
		Book book = null;
		List<Book> books = new ArrayList<Book>();
		
		PreparedStatement preparedStatement_0 = null;
		ResultSet rs_0 = null;
		String sql_0 = "select *  from library.book";
		preparedStatement_0 = conn.prepareStatement(sql_0);
		rs_0 = preparedStatement_0.executeQuery();
		
		while(rs_0.next()) {
			book=new Book();
			book.setBookId(rs_0.getString("BookId"));
			book.setBookName(rs_0.getString("BookName"));
			book.setBookWriter(rs_0.getString("BookWriter"));
			book.setBookPublisher(rs_0.getString("BookPublisher"));
			book.setBookPublishYear(rs_0.getString("BookPublishYear"));
			book.setBookTotal(rs_0.getInt("BookTotal"));
			book.setBookBorrowed(rs_0.getInt("BookBorrowed"));
			books.add(book);
		}
		
		
		return books;
	}
	
	
//	public static void main(String[] args)  throws SQLException  {
//		  Connection conn = null;
//		  SqlConnect sqlconnect = new SqlConnect();
//		  conn = sqlconnect.connect();
//		  
//		  SqlSearchBook book = new SqlSearchBook();
//		  book.select(conn, "*");
//	}

}
