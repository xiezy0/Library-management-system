package action;

import java.sql.*;

public class SqlConnect {
	public Connection connect() {
		 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		 String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Library";
		 String userName="sa";
		 String userPwd="123456";
		 try{
			 Class.forName(driverName);
			 System.out.println("加载驱动成功！");
		 }catch(Exception e){
			 e.printStackTrace();
			 System.out.println("加载驱动失败！");
			 Connection dbConn = null;
			 return dbConn;
		 }
		 
		 try{
			 Connection dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
			 System.out.println("连接数据库成功！");
			 return dbConn;
		 }catch(Exception e){
			 System.out.print("SQL Server连接失败！");
			 Connection dbConn = null;
			 return dbConn;
		 }
    }
	 
}


