package jimbob.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class JDBCDemoPro {
	private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
	private static final String DBURL="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER="scott";
	private static final String PASSWORD="tiger";
			
	public static void main(String[] args) throws Exception {
		
		Class.forName(DRIVER);
		Connection conn=DriverManager.getConnection(DBURL,USER,PASSWORD);
		String sql="";
		
		PreparedStatement  stmt=conn.prepareStatement(sql);
		//从1开始
		stmt.setString(1, "");
		//执行sql语句
		int len=stmt.executeUpdate();
		//影响行数
		System.out.println(len);
		//模糊查询
		sql="select * from table where name like ?";
		stmt=conn.prepareStatement(sql);
		ResultSet set = stmt.executeQuery();
		String keyword="";
		stmt.setString(1, "%"+keyword+"%");
		while(set.next()){
			//从1开始或使用列名称
			System.out.println(set.getString(0));
		}
		
		//批处理和事物
		sql="";
		stmt=conn.prepareStatement(sql);
		//使用事物，取消自动提交
		conn.setAutoCommit(false);
		stmt.setString(1, "");
		stmt.addBatch("");
		
		stmt.setString(1, "");
		stmt.addBatch("");
		
		int[] result = stmt.executeBatch();
		System.out.println(Arrays.toString(result));
		//没有错误提交
		conn.commit();
		//出现异常回滚
		conn.rollback();
		
		set.close();
		stmt.close();
		conn.close();
	}
}
