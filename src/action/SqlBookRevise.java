package action;

import java.sql.*;

public class SqlBookRevise {
	public String revise(Connection conn, String value, Book book, int number) throws SQLException {
		boolean result = false;
		switch(number) {
    		case 0: result = revise_BookId(conn, value, book);break;
    		case 1: result = revise_BookName(conn, value, book);break;
    		case 2: result = revise_BookWriter(conn, value, book);break;
    		case 3: result = revise_BookPublisher(conn, value, book);break;
    		case 4: result = revise_BookPublishYear(conn, value, book);break;
    		case 5: result = revise_BookTotal(conn, value, book);break;
        }
		if(result) {
			return book.getBookName();
		}else {
			return null;
		}
	}
	
	// 下面提供方法修改BookId
	public boolean revise_BookId(Connection conn, String value, Book book) throws SQLException {
		PreparedStatement preparedStatement_0 = null;
		// 修改library.book表
        String sql_0 = "update library.book  set BookId = ?  where BookId = ?";
        preparedStatement_0 = conn.prepareStatement(sql_0);
		preparedStatement_0.setString(1, value);
		preparedStatement_0.setString(2, book.getBookId());
		preparedStatement_0.execute();
		return true;
	}
	
    // 下面提供方法修改BookName
	public boolean revise_BookName(Connection conn, String value, Book book) throws SQLException {
		PreparedStatement preparedStatement_0 = null;
		// 修改library.book表
        String sql_0 = "update library.book  set BookName = ?  where BookId = ?";
        preparedStatement_0 = conn.prepareStatement(sql_0);
		preparedStatement_0.setString(1, value);
		preparedStatement_0.setString(2, book.getBookId());
		preparedStatement_0.execute();
		return true;
	}
	
	// 下面提供方法修改BookWriter
	public boolean revise_BookWriter(Connection conn, String value, Book book) throws SQLException {
		PreparedStatement preparedStatement_0 = null;
		// 修改library.book表
        String sql_0 = "update library.book  set BookWriter = ?  where BookId = ?";
        preparedStatement_0 = conn.prepareStatement(sql_0);
		preparedStatement_0.setString(1, value);
		preparedStatement_0.setString(2, book.getBookId());
		preparedStatement_0.execute();
		return true;
	}
	
	// 下面提供方法修改BookPublisher
	public boolean revise_BookPublisher(Connection conn, String value, Book book) throws SQLException {
		PreparedStatement preparedStatement_0 = null;
		// 修改library.book表
        String sql_0 = "update library.book  set BookPublisher = ?  where BookId = ?";
        preparedStatement_0 = conn.prepareStatement(sql_0);
		preparedStatement_0.setString(1, value);
		preparedStatement_0.setString(2, book.getBookId());
		preparedStatement_0.execute();
		return true;
	}
	
	// 下面提供方法修改BookPublishYear
	public boolean revise_BookPublishYear(Connection conn, String value, Book book) throws SQLException {
		PreparedStatement preparedStatement_0 = null;
		// 修改library.book表
        String sql_0 = "update library.book  set BookPublishYear = ?  where BookId = ?";
        preparedStatement_0 = conn.prepareStatement(sql_0);
		preparedStatement_0.setString(1, value);
		preparedStatement_0.setString(2, book.getBookId());
		preparedStatement_0.execute();
		return true;
	}
	
	// 下面提供方法修改BookTotal
	public boolean revise_BookTotal(Connection conn, String value, Book book) throws SQLException {
		PreparedStatement preparedStatement_0 = null;
		// 修改library.book表
        String sql_0 = "update library.book  set BookTotal = ?  where BookId = ?";
        preparedStatement_0 = conn.prepareStatement(sql_0);
		preparedStatement_0.setInt(1, Integer.parseInt(value));
		preparedStatement_0.setString(2, book.getBookId());
		preparedStatement_0.execute();
		return true;
	}
	
//	public static void main(String[] args) throws SQLException {
//		  // 初始化连接对象，当做context
//		  Connection conn = null;
//		  SqlConnect sqlconnect = new SqlConnect();
//		  conn = sqlconnect.connect();
//		  
//		  SqlSearchBook2 Book = new SqlSearchBook2();
//		  Book book = new Book();
//		  try {
//			  book = Book.select(conn, "101-3-3-3");
//		  }catch(SQLException n) {
//			  System.out.println("没有该图书的信息");
//		  }
//  	  
//		  SqlBookRevise test0 = new SqlBookRevise();
//		  test0.revise(conn, "我的快递员兄弟们", book, 1);
//	}

}
