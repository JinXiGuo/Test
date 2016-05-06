package jimbob.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
	private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
	private static final String DBURL="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER="scott";
	private static final String PASSWORD="tiger";
			
	public static void main(String[] args) throws Exception {
		
		Class.forName(DRIVER);
		Connection conn=DriverManager.getConnection(DBURL,USER,PASSWORD);
		Statement stmt=conn.createStatement();
		
		String sql="";
		//执行sql语句
		int len=stmt.executeUpdate(sql);
		//影响行数
		System.out.println(len);
		
		ResultSet set = stmt.executeQuery(sql);
		while(set.next()){
			//从1开始或使用列名称
			System.out.println(set.getString(0));
		}
		set.close();
		stmt.close();
		conn.close();
	}
}
