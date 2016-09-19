import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpUtil
{
	
	public static boolean uploadFile(String url, int port, String username, String password, String path, String filename, InputStream input)
	{
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try
		{
			int reply;
			ftp.connect(url, port);// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply))
			{
				ftp.disconnect();
				return success;
			}
			ftp.changeWorkingDirectory(path);
			ftp.storeFile(filename, input);

			input.close();
			ftp.logout();
			success = true;
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (ftp.isConnected())
			{
				try
				{
					ftp.disconnect();
				} catch (IOException ioe)
				{
				}
			}
		}
		return success;
	}
	
	public static void main(String[] args)
	{
		try
		{
			InputStream in = new FileInputStream(new File("D:/FRPN79789.jpg"));
			boolean flag= uploadFile("120.25.65.178", 21, "boss", "123456", "/BB/attachment/", "test.jpg", in);
			System.out.println(flag);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
