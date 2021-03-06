package jimbob.java.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCPClient  {
	private Socket s;

	SocketTCPClient(Socket s) {
		this.s = s;
	}

	public static void main(String[] args) {
		client();
	}

	public static void client() {
		try {
			Socket s = new Socket(InetAddress.getByName("localhost"), 8000);// 端口号要一致。

			OutputStream os = s.getOutputStream();
			os.write("Hello World!".getBytes());

			InputStream is = s.getInputStream();
			byte[] buf = new byte[100];
			int len = is.read(buf);
			System.out.println(new String(buf, 0, len));

			os.close();
			is.close();
			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}