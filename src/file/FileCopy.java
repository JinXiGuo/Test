package file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileCopy
{
	public static void main(String[] args) throws IOException
	{
		File from=new File("d:/t01.jpg");
		File to=new File("d:/t/t01.png");
		
		FileUtils.copyFile(from, to);
	}
}
