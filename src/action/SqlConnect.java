package action;

import java.sql.*;

public class SqlConnect {
	public Connection connect() {
		 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		 String dbURL="jdbc:sqlserver://127.0.0.1:1434;DatabaseName=Library";//testΪ������ݿ���
		 String userName="sa";//������ݿ��û���
		 String userPwd="123456";//�������
		 try{
			 Class.forName(driverName);
			 System.out.println("���������ɹ���");
		 }catch(Exception e){
			 e.printStackTrace();
			 System.out.println("��������ʧ�ܣ�");
			 Connection dbConn = null;
			 return dbConn;
		 }
		 
		 try{
			 Connection dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
			 System.out.println("�������ݿ�ɹ���");
			 return dbConn;
		 }catch(Exception e){
			 e.printStackTrace();
			 System.out.print("SQL Server����ʧ�ܣ�");
			 Connection dbConn = null;
			 return dbConn;
		 }
    }
	public static void main(String[] args){
		//SqlConnect sqlconnect = new SqlConnect();
		//sqlconnect.connect();
	}
	 
}


