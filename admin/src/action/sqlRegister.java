package action;

import java.sql.*;

public class sqlRegister {
	public String register(Connection conn, String usrName, String keywords) throws SQLException{
		PreparedStatement preparedStatement_0=null;
		PreparedStatement preparedStatement_1=null;
        ResultSet rs_0 = null;
        ResultSet rs_1 = null;
        int value = 0;
        int number = 10000;
        
		String str_0 = "select *  from library.usr  where UsrName = ? and UsrKeyword = ?";
		String str_1 = "select count(*)  from library.usr";
		
		preparedStatement_0 = conn.prepareStatement(str_0);
		preparedStatement_0.setString(1, usrName);
		preparedStatement_0.setString(2, keywords);
		rs_0=preparedStatement_0.executeQuery();
		
		preparedStatement_1 = conn.prepareStatement(str_1);
		rs_1=preparedStatement_1.executeQuery();
		
		while(rs_0.next()) {
			value++;
		}
		while(rs_1.next()) {
			number += rs_1.getInt(1);
		}
		
		if(value == 0) {
			if(reverse(conn, usrName, keywords, Integer.toString(number)) == false) {
				return Integer.toString(number);
			}else {
				return null;
			}
		}else {
			return null;
		}
		
	}
	
	public boolean reverse(Connection conn, String usrName, String usrKeywords, String usrId) throws SQLException {
		PreparedStatement preparedStatement_0=null;
		String str_0 = "insert  into library.usr(UsrId,UsrKeyword,UsrName,UsrBorrow,UsrBadRecord)  values(?,?,?,0,0)";
		preparedStatement_0 = conn.prepareStatement(str_0);
		preparedStatement_0.setString(1, usrId);
		preparedStatement_0.setString(2, usrKeywords);
		preparedStatement_0.setString(3, usrName);
		
		return preparedStatement_0.execute();
	}
	
//	public static void main(String[] args)  throws SQLException  {
//		  Connection conn = null;
//		  sqlConnect sqlconnect = new sqlConnect();
//		  conn = sqlconnect.connect();
//		  
//		  sqlRegister usr = new sqlRegister();
//		  usr.register(conn, null,"111111");
//	}
//	
	

}
