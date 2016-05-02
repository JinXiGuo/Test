package jimbob.java.io;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * socket 服务端
 * @author 34773
 *
 */
public class SocketServerDemo {
	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(9999);
		System.out.println("等待客户端连接...");
		Socket client=server.accept();
		PrintStream ps=new PrintStream(client.getOutputStream());
		ps.println("hello world");
		ps.close();
		client.close();
		server.close();
	}
}

