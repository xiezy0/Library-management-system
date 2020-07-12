package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlUsrSign {

	public String select(Connection conn, String usrInfo, String keywords) throws SQLException {
	    // 定义变量和sql语句
		PreparedStatement preparedStatement_0=null;
		PreparedStatement preparedStatement_1=null;
        ResultSet rs_0 = null;
        ResultSet rs_1 = null;
        
		String str_0 = "select *  from library.usr  where UsrId = ? and UsrKeyword = ?";
		String str_1 = "select *  from library.usr  where UsrName = ? and UsrKeyword = ?";
		
		preparedStatement_0 = conn.prepareStatement(str_0);
		preparedStatement_0.setString(1, usrInfo);
		preparedStatement_0.setString(2, keywords);
		rs_0=preparedStatement_0.executeQuery();
		
		preparedStatement_1 = conn.prepareStatement(str_1);
		preparedStatement_1.setString(1, usrInfo);
		preparedStatement_1.setString(2, keywords);
		rs_1=preparedStatement_1.executeQuery();

		while(rs_0.next()) {
			return rs_0.getString("UsrId");
		}
		while(rs_1.next()) {
			return rs_1.getString("UsrId");
		}
		
		return null;
	}

}
