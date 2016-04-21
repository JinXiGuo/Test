import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadURL
{
	public static void download(String urlString, String filename, String savePath) throws Exception
	{
		// ����URL
		URL url = new URL(urlString);
		// ������
		URLConnection con = url.openConnection();
		// ��������ʱΪ5s
		con.setConnectTimeout(5 * 1000);
		// ������
		InputStream is = con.getInputStream();

		// 1K�����ݻ���
		byte[] bs = new byte[1024];
		// ��ȡ�������ݳ���
		int len;
		// ������ļ���
		File sf = new File(savePath);
		if (!sf.exists())
		{
			sf.mkdirs();
		}
		OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
		// ��ʼ��ȡ
		while ((len = is.read(bs)) != -1)
		{
			os.write(bs, 0, len);
		}
		// ��ϣ��ر���������
		os.close();
		is.close();
	}

	public static void main(String[] args)
	{
		try
		{
			download("http://img.salesmanb2b.com/BB/attachment/pro2014/OMKC108375.jpg", "test.png", "d:/");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}