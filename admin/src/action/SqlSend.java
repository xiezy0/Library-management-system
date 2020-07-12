package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlSend {
	public String send(Connection conn, String UsrId, String BookId) throws SQLException {
		// ��ѯ�Ƿ��д˽��ļ�¼
		Record Record = new Record();
	    SqlSearchRecord record = new SqlSearchRecord(); 
	    Record = record.select(conn, UsrId, BookId);
		
	    // ��ѯ��Ӧ�Ķ�����Ϣ������Ӧ���ڷ���ֵ
  	    User Usr = new User();
	    SqlSearchUsr usr = new SqlSearchUsr(); 
		Usr = usr.select(conn, UsrId);
	    
		if(Record.getRecordId() != null) {
			revise(conn, Record);
			return Usr.getUsrName();
		}else {
			return null;
		}
		
	}
	
	public boolean revise(Connection conn, Record record) throws SQLException {
		PreparedStatement preparedStatement_0 = null;
		PreparedStatement preparedStatement_1 = null;
		PreparedStatement preparedStatement_2 = null;
		
		// �޸�library.book��
        String sql_0 = "update library.book  set BookTotal = BookTotal + 1  where BookId = ?";
        preparedStatement_0 = conn.prepareStatement(sql_0);
		preparedStatement_0.setString(1, record.getBookId());
		preparedStatement_0.execute(); 
        
		// �޸�library.usr�� 
        String sql_1 = "update library.usr  set UsrBorrow = UsrBorrow - 1  where UsrId = ?";
        preparedStatement_1 = conn.prepareStatement(sql_1);
		preparedStatement_1.setString(1, record.getUsrId());
		preparedStatement_1.execute(); 
		
		// ɾ��library.record������
        String sql_2 = "delete  from library.record  where RecordId = ?";
        preparedStatement_2 = conn.prepareStatement(sql_2);
		preparedStatement_2.setString(1, record.getRecordId());
		preparedStatement_2.execute(); 
		
		return true;
	}
	
	
//	public static void main(String[] args) throws SQLException {
//		Connection conn = null;
//		SqlConnect sqlconnect = new SqlConnect();
//		conn = sqlconnect.connect();
//		
//		SqlSend send = new SqlSend();
//		send.send(conn, "10000", "10000");
//	}

}
