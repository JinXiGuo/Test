package file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeleteFile
{
	public static void main(String[] args)
	{
		String name=new SimpleDateFormat("yyyy_MM_dd").format(new Date());// new Date()为获取当前系统时间
		File file=new File("d:/t/"+name+".txt");
		System.out.println(file.getPath());
		System.out.println(file.exists());
	}
}
