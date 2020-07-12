package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlSearchBook2 {
	public Book select(Connection conn, String BookId) throws SQLException {
	    // 定义变量和sql语句
		Book book=new Book();
		PreparedStatement preparedStatement=null;
        ResultSet rs=null;
		String str_0 = "select *  from library.book  where BookId = ?";
		
		// 传入变量和加载sql语句 
		preparedStatement = conn.prepareStatement(str_0);
		preparedStatement.setString(1, BookId);
		rs=preparedStatement.executeQuery();         

		while(rs.next()) {
			book.setBookId(rs.getString("BookId"));
			book.setBookName(rs.getString("BookName"));
			book.setBookWriter(rs.getString("BookWriter"));
			book.setBookPublisher(rs.getString("BookPublisher"));
			book.setBookPublishYear(rs.getString("BookPublishYear"));
			book.setBookTotal(rs.getInt("BookTotal"));
			book.setBookBorrowed(rs.getInt("BookBorrowed"));
		}
		return book;
	}
}
