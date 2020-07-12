package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlDeleteBook {
	public String delete(Connection conn, String bookId) throws SQLException {
		// ��ѯ���ļ�¼�Ƿ���ڶ�Ӧ��ͼ����Ϣ
		Record record=new Record();
		SqlSearchRecord record_book = new SqlSearchRecord();
		record = record_book.select0(conn, bookId);
		
		// ��ѯ�Ƿ���ڶ�Ӧ��ͼ����Ϣ
		List<Book> books = new ArrayList<Book>();
		SqlSearchBook book = new SqlSearchBook();
		books = book.select(conn, bookId);
		
		if(record.getBookId() == null && books.size() == 1) {
			if(revise(conn,bookId)) {
				return bookId;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	public boolean revise(Connection conn, String bookId) throws SQLException {
		PreparedStatement preparedStatement_0 = null;
		
		// ɾ��library.record������
        String sql_0 = "delete  from library.book  where BookId = ?";
        preparedStatement_0 = conn.prepareStatement(sql_0);
		preparedStatement_0.setString(1, bookId);
		preparedStatement_0.execute(); 
		
		return true;
	}
	
//	public static void main(String[] args) throws SQLException {
//		Connection conn = null;
//		SqlConnect sqlconnect = new SqlConnect();
//		conn = sqlconnect.connect();
//	
//		SqlDeleteBook delect = new SqlDeleteBook();
//		delect.delete(conn, "121-3-2-4");
//	}

}
