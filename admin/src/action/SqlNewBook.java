package action;

import java.sql.*;

public class SqlNewBook {
	public boolean newBook(Connection conn, String BookId,String BookName,String BookWriter,String BookPublisher,String BookPublishYear,int BookTotal) throws SQLException {
		PreparedStatement preparedStatement_0 = null;
		// 插入数据到library.record表
        String sql_0 = "insert into library.book(BookId,BookName,BookWriter,BookPublisher,BookPublishYear,BookTotal,BookBorrowed) values(?,?,?,?,?,?,'0')";
        preparedStatement_0 = conn.prepareStatement(sql_0);
		preparedStatement_0.setString(1, BookId);
		preparedStatement_0.setString(2, BookName);
		preparedStatement_0.setString(3, BookWriter);
		preparedStatement_0.setString(4, BookPublisher);
		preparedStatement_0.setString(5, BookPublishYear);
		preparedStatement_0.setInt(6, BookTotal);
		try {
			preparedStatement_0.execute();
			return true;
		}catch(SQLException e) {
			System.out.println("添加新图书失败");
			return false;
		}
		
	}
//	public static void main(String[] args) throws SQLException {
//		Connection conn = null;
//		SqlConnect sqlconnect = new SqlConnect();
//		conn = sqlconnect.connect();
//		
//		SqlNewBook newBook = new SqlNewBook();
//		newBook.newBook(conn, "121-3-2-4", "资本家的千层套路2","马云","阿里巴巴出版社","2019",80);
//	}

}
