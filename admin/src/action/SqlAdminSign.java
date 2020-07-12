package action;

import java.sql.*;

public class SqlAdminSign {
	
	public boolean select(Connection conn, String admin, String keywords) throws SQLException {
	    // ���������sql���
		PreparedStatement preparedStatement=null;
        ResultSet rs=null;
		String selectAdmin = "select *  from library.admin  where AdminId = ? and AdminKeyword = ?";
		
		// ��������ͼ���sql��� 
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
