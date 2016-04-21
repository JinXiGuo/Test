package test;


public class Gbk2Utf8
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		String s = "鍙戦�"; 
		String ss = new String(s.getBytes("gbk"), "UTF-8");		
		System.out.println(ss);
	}

}
