package jimbob.java.socket;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class SocketTCPServer extends Thread// 让类继承为线程类
{
	private Socket s;

	SocketTCPServer(Socket s) {
		this.s = s;
	}

	public static void main(String[] args) {
		server();
	}

	public void run()// 这个就是线程方法了
	{
		try {// 当然当不想直接发送数据，就会去创建一个带缓冲的流
			OutputStream os = s.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(os);
			// os.write("my name is xuneng!".getBytes());
			bos.write("my name is xuneng!".getBytes());

			InputStream is = s.getInputStream();
			byte[] buf = new byte[100];// 别忘了加new
			int len = is.read(buf);
			System.out.println(new String(buf, 0, len));

			bos.close();
			is.close();
			os.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void server()// 完成之后一定要记得关闭各种流于套接字
	{
		try {
			ServerSocket ss = new ServerSocket(8000);// 自定义的一个端口
			while (true)// 服务器端会老这样启动着。
			{
				System.out.println("the server is starting .......");
				Socket s = ss.accept(); // 一直等待着接收消息
				new SocketTCPServer(s).start();// 当接受到请求的时候，就返回一个套接字，创建一个线程
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}