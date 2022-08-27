package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

	private static String dbUrl="jdbc:mysql://101.35.160.252:3306/perfectresume?userSSL=true&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
	private static String dbUsername="perfectresume";
	private static String dbPassword="123456";
	private static String jdbcdriverName="com.mysql.cj.jdbc.Driver";
	
	//鑾峰彇鏁版嵁搴撹繛鎺�
	public Connection getcon(){
		Connection con = null;
		try {
			Class.forName(jdbcdriverName);
			con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	//鍏抽棴鏁版嵁搴撹繛鎺�
	public static void close (Connection connection ,Statement 
		    statement , ResultSet resultSet) {
				try {
					if(connection!=null)connection.close();
					if(statement!=null)statement.close();
					if(resultSet!=null)resultSet.close();
				} catch (SQLException e) {
					System.out.println("鏁版嵁搴撳叧闂紓甯�");
					e.printStackTrace();
				}
			}
	//娴嬭瘯
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getcon();
			System.out.println("鏁版嵁搴撹繛鎺ユ垚鍔�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
