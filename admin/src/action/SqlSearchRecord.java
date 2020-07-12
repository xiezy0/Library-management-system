package action;

import java.sql.*;

public class SqlSearchRecord {
	public Record select(Connection conn, String UsrID, String BookID) throws SQLException {
	    // 定义变量和sql语句
		Record record=new Record();
		PreparedStatement preparedStatement=null;
        ResultSet rs=null;
		String selectrecord = "select *  from library.record  where UsrId = ? and BookId = ?";
		
		// 传入变量和加载sql语句 
		preparedStatement = conn.prepareStatement(selectrecord);
		preparedStatement.setString(1, UsrID);
		preparedStatement.setString(2, BookID);
		rs=preparedStatement.executeQuery(); 

		while(rs.next()) {
			record.setRecordId(rs.getString("RecordId"));
			record.setUsrId(rs.getString("UsrId"));
			record.setBookId(rs.getString("BookId"));
			record.setBorrowTime(rs.getDate("BorrowTime"));
		}
		return record;
	}
	
	public Record select0(Connection conn,String bookId) throws SQLException {
		Record record=new Record();
		PreparedStatement preparedStatement=null;
        ResultSet rs=null;
		String selectrecord = "select *  from library.record  where BookId = ?";
		
		// 传入变量和加载sql语句 
		preparedStatement = conn.prepareStatement(selectrecord);
		preparedStatement.setString(1, bookId);
		rs=preparedStatement.executeQuery(); 

		while(rs.next()) {
			record.setRecordId(rs.getString("RecordId"));
			record.setUsrId(rs.getString("UsrId"));
			record.setBookId(rs.getString("BookId"));
			record.setBorrowTime(rs.getDate("BorrowTime"));
		}
		return record;
	}

}
