package jimbob.java.io;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClientDemo {
	public static void main(String[] args) throws Exception {
		Socket client = new Socket("localhost", 9999);
		// 接收服务器信息
		Scanner sc = new Scanner(client.getInputStream());
		// 接受用户输入
		Scanner in = new Scanner(System.in);
		// 向服务器发送信息的流
		PrintStream out = new PrintStream(client.getOutputStream());
		// 设置分隔符
		sc.useDelimiter("\n");
		in.useDelimiter("\n");
		while (true) {
			System.out.println("请输入要发送的数据");
			if (in.hasNext()) {
				String str = in.next().trim();
				out.println(str);
				if (str.equalsIgnoreCase("exit")) {
					System.out.println("客户端退出成功");
					break;
				}
				if (sc.hasNext()) {
					System.out.println("-->" + sc.next());
				}
			}
		}
		in.close();
		out.close();
		sc.close();
		client.close();
	}
}
