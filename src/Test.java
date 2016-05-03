import java.util.Enumeration;
import java.util.Vector;


public class Test 
{

	public static void main(String args[])
	{
		Vector<String> list=new Vector<>();
		list.add("hello");
		list.add("world");
		list.add("nihao");
		list.add("hello");
		
		for (Enumeration<String> iterator = list.elements(); iterator.hasMoreElements();) {
			String string = (String) iterator.nextElement();
			System.out.println(string);
		}
		
	}
}