package jimbob.java.io;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * socket 服务端
 * @author 34773
 *
 */
class ServerThread implements Runnable {
	private Socket client;

	public ServerThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			System.out.println("连接成功！");
			Scanner scanner = new Scanner(client.getInputStream());
			PrintStream out = new PrintStream(client.getOutputStream());
			boolean flag=true;
			while (flag) {
				if (scanner.hasNext()) {
					String str = scanner.next().trim();
					System.out.println("-->" + str);
					if (str.equalsIgnoreCase("exit")) {
						out.println("退出成功！");
						break;
					} else {
						out.println(str);
					}
				}
			}
			scanner.close();
			out.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

public class SocketServerDemo {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		boolean flag=true;
		while(flag){
			System.out.println("等待客户端连接...");
			Socket client=server.accept();
			new Thread(new ServerThread(client)).start();
		}
		server.close();
	}
}
