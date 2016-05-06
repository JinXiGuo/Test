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
		//��1��ʼ
		stmt.setString(1, "");
		//ִ��sql���
		int len=stmt.executeUpdate();
		//Ӱ������
		System.out.println(len);
		//ģ����ѯ
		sql="select * from table where name like ?";
		stmt=conn.prepareStatement(sql);
		ResultSet set = stmt.executeQuery();
		String keyword="";
		stmt.setString(1, "%"+keyword+"%");
		while(set.next()){
			//��1��ʼ��ʹ��������
			System.out.println(set.getString(0));
		}
		
		//�����������
		sql="";
		stmt=conn.prepareStatement(sql);
		//ʹ�����ȡ���Զ��ύ
		conn.setAutoCommit(false);
		stmt.setString(1, "");
		stmt.addBatch("");
		
		stmt.setString(1, "");
		stmt.addBatch("");
		
		int[] result = stmt.executeBatch();
		System.out.println(Arrays.toString(result));
		//û�д����ύ
		conn.commit();
		//�����쳣�ع�
		conn.rollback();
		
		set.close();
		stmt.close();
		conn.close();
	}
}
