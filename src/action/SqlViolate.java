package action;

import java.sql.*;

public class SqlViolate {
	public String violate(Connection conn, String UsrId, int number) throws SQLException {
		// 查询是否有对应的读者信息
  	    User Usr = new User();
	    SqlSearchUsr usr = new SqlSearchUsr(); 
		Usr = usr.select(conn, UsrId);
		
		if(Usr.getUsrId() != null) {
			if(revise(conn,UsrId,number) == true) {
				return Usr.getUsrName();
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	
	public boolean revise(Connection conn, String UsrId, int number) throws SQLException{
		PreparedStatement preparedStatement_0 = null;
		
		// 修改library.usr表 
        String sql_0 = "update library.usr  set UsrBadRecord = UsrBadRecord + ?  where UsrId = ?";
        preparedStatement_0 = conn.prepareStatement(sql_0);
		preparedStatement_0.setInt(1, number);
		preparedStatement_0.setString(2, UsrId);
		preparedStatement_0.execute();
		
		
		return true;
	}
//	public static void main(String[] args) throws SQLException {
//		Connection conn = null;
//		SqlConnect sqlconnect = new SqlConnect();
//		conn = sqlconnect.connect();
//		
//		SqlViolate violate = new SqlViolate();
//		violate.violate(conn, "10002", 2);
//	}
}
