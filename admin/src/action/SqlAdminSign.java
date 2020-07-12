package action;

import java.sql.*;

public class SqlAdminSign {
	
	public boolean select(Connection conn, String admin, String keywords) throws SQLException {
	    // 定义变量和sql语句
		PreparedStatement preparedStatement=null;
        ResultSet rs=null;
		String selectAdmin = "select *  from library.admin  where AdminId = ? and AdminKeyword = ?";
		
		// 传入变量和加载sql语句 
		preparedStatement = conn.prepareStatement(selectAdmin);
		preparedStatement.setString(1, admin);
		preparedStatement.setString(2, keywords);
		rs=preparedStatement.executeQuery();

		while(rs.next()) {
			return true;
		}
		
		return false;
	}
	
}
