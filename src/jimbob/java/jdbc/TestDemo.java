package jimbob.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestDemo {

	private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
	private static final String DBURL="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER="scott";
	private static final String PASSWORD="tiger";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName(DRIVER);
		Connection conn=DriverManager.getConnection(DBURL,USER,PASSWORD);
		String colum="ename";
		String sql="select count(empno) from emp where "+colum+" like ?";
		
		PreparedStatement  stmt=conn.prepareStatement(sql);
	
		String keyword="1";
		stmt.setString(1, "%"+keyword+"%");
		ResultSet set = stmt.executeQuery();
		while(set.next()){
			//从1开始或使用列名称
			System.out.println(set.getString(1));
		}
		
		set.close();
		stmt.close();
		conn.close();
	}

}
