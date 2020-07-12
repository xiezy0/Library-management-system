package action;

import java.sql.*;

public class sqlSearchUsr {
	public User search(Connection conn,String usrId) throws SQLException {
		PreparedStatement preparedStatement_0=null;
		ResultSet rs_0 = null;
		User usr = new User();
		String str_0 = "select *  from library.usr  where UsrId = ? ";
		preparedStatement_0 = conn.prepareStatement(str_0);
		preparedStatement_0.setString(1, usrId);
		rs_0=preparedStatement_0.executeQuery();
		while(rs_0.next()) {
			usr.setUsrId(rs_0.getString("UsrId"));
			usr.setUsrName(rs_0.getString("UsrName"));
			usr.setUsrBorrow(rs_0.getInt("UsrBorrow"));
			usr.setUsrBadRecord(rs_0.getInt("UsrBadRecord"));
			return usr;
		}
		return null;
		
	}
}
