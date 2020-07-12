package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.*;
import java.util.*;


public class SqlBorrow {
	public String borrow(Connection conn, String BookId, String UsrId) throws SQLException {
		// 查询是否存在对应的图书信息
		List<Book> books = new ArrayList<Book>();
  	    SqlSearchBook book = new SqlSearchBook();
  		books = book.select(conn, BookId);
  		// 查询是否存在对应的读者信息
  	    User Usr = new User();
	    SqlSearchUsr usr = new SqlSearchUsr(); 
		Usr = usr.select(conn, UsrId);
		
  	    if(books.size()  == 1 && Usr.getUsrId() != null) {
  	    	if(books.get(0).getBookTotal() > 0) {
  	    		boolean resive_result = false;
  	  	    	resive_result = revise(conn, BookId, UsrId);
  	  	    	if(resive_result == true) {
  	  	    		return Usr.getUsrName();
  	  	    	}else {
  	  	    		return null;
  	  	    	}
  	    	}else {
  	    		return null;
  	    	}
  	    }else {
  	    	return null;
  	    }
		
	}
	public boolean revise(Connection conn, String BookId, String UsrId) throws SQLException {
		// 时间获取
		Date d=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String recordid = sdf.format(d);
		java.sql.Date date=new java.sql.Date(d.getTime());
		
		PreparedStatement preparedStatement_0 = null;
		PreparedStatement preparedStatement_1 = null;
		PreparedStatement preparedStatement_2 = null;

        // 修改library.book表
        String sql_0 = "update library.book  set BookTotal = BookTotal - 1  where BookId = ?";
        preparedStatement_0 = conn.prepareStatement(sql_0);
		preparedStatement_0.setString(1, BookId);
		preparedStatement_0.execute(); 
        
		// 修改library.usr表 
        String sql_1 = "update library.usr  set UsrBorrow = UsrBorrow + 1  where UsrId = ?";
        preparedStatement_1 = conn.prepareStatement(sql_1);
		preparedStatement_1.setString(1, UsrId);
		preparedStatement_1.execute(); 
		
		// 插入数据到library.record表
        String sql_2 = "insert into library.record(RecordId, UsrId, BookId, BorrowTime) values(?,?,?,?)";
        preparedStatement_2 = conn.prepareStatement(sql_2);
		preparedStatement_2.setString(1, recordid);
		preparedStatement_2.setString(2, UsrId);
		preparedStatement_2.setString(3, BookId);
		preparedStatement_2.setDate(4, date);
		preparedStatement_2.execute(); 
		
		return true;
	}
	
//	public static void main(String[] args) throws SQLException {
//		Connection conn = null;
//		SqlConnect sqlconnect = new SqlConnect();
//		conn = sqlconnect.connect();
//		
//		SqlBorrow borrow = new SqlBorrow();
//		borrow.borrow(conn, "10000", "10000");
//	}

}
