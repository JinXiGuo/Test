import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteExcelLog
{
	public static void main(String[] args)
	{
		method1("../1234.txt", "hello");
		//write("/123.txt", "hello");
	}

	public static void write(String path, String content)
	{
		try
		{
			File f = new File(path);

			if (!f.exists())
			{
				f.createNewFile();
			}

			FileWriter writer = new FileWriter(path, true);
			writer.write(content+"\n");
			writer.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void method1(String file, String conent) {     
        BufferedWriter out = null;     
        try {     
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));     
            out.write(conent+"\n");     
        } catch (Exception e) {     
            e.printStackTrace();     
        } finally {     
            try {     
                if(out != null){  
                    out.close();     
                }  
            } catch (IOException e) {     
                e.printStackTrace();     
            }     
        }     
    }     
}