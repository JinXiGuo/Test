import java.io.File;
import java.util.Date;

public class MyDate
{
	public static void main(String[] args)
	{
		Date d1=new Date();
		Date d2=new Date();
		System.out.println(d1.getTime()-d2.getTime());
		File file=new File("c:/tomcat.txt");
		System.out.println(file.exists());
	}
}
