package action;

import java.sql.*;

public class SqlSearchUsr {
	
	public User select(Connection conn, String UsrID) throws SQLException {
	    // 定义变量和sql语句
		User user=new User();
		PreparedStatement preparedStatement=null;
        ResultSet rs=null;
		String selectAdmin = "select UsrId,UsrName,UsrBorrow,UsrBadRecord  from library.usr  where UsrId = ?";
		
		// 传入变量和加载sql语句 
		preparedStatement = conn.prepareStatement(selectAdmin);
		preparedStatement.setString(1, UsrID);
		rs=preparedStatement.executeQuery();         

		while(rs.next()) {
			user.setUsrId(rs.getString("UsrId"));
			user.setUsrName(rs.getString("UsrName"));
			user.setUsrBorrow(rs.getInt("UsrBorrow"));
			user.setUsrBadRecord(rs.getInt("UsrBadRecord"));
		}
		return user;
	}
	
//	public static void main(String[] args)  throws SQLException  {
//		  Connection conn = null;
//		  SqlConnect sqlconnect = new SqlConnect();
//		  conn = sqlconnect.connect();
//		  
//		  SqlSearchUsr usr = new SqlSearchUsr();
//		  usr.select(conn, "10000");
//	}
}
