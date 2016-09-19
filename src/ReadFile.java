import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReadFile
{
	public static void main(String[] args)
	{
		String path = "D:/webserver_gouwu_adm/webapps/ROOT/excel";
		File file = new File(path);
		File[] tempList = file.listFiles();
		System.out.println("该目录下对象个数：" + tempList.length);
		Calendar cal = Calendar.getInstance(); 
		long time ;
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd H:m:s");
		
		for (int i = 0; i < tempList.length; i++)
		{
			if (tempList[i].isFile()&&tempList[i].getName().endsWith(".xls"))
			{
				tempList[i].renameTo(new File("D:/webserver_gouwu_adm/webapps/ROOT/excel/1.xls"));
				time = tempList[i].lastModified();
				cal.setTimeInMillis(time); 
				System.out.print(tempList[i].getName()+"\t"+format.format(cal.getTime())+"\t");
				System.out.println(tempList[i].length()/1024+"M");
			}
		}
	}
}
