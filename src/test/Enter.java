package test;

public class Enter
{
	public static void main(String[] args)
	{
		String str="hello\nworld";
		str=str.replaceAll("\n", ",");
		
		System.out.println(str);
	}
}
