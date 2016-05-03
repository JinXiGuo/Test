package jimbob.java.io;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClientDemo {
	public static void main(String[] args) throws Exception {
		Socket client = new Socket("localhost", 9999);
		// ���շ�������Ϣ
		Scanner sc = new Scanner(client.getInputStream());
		// �����û�����
		Scanner in = new Scanner(System.in);
		// �������������Ϣ����
		PrintStream out = new PrintStream(client.getOutputStream());
		// ���÷ָ���
		sc.useDelimiter("\n");
		in.useDelimiter("\n");
		while (true) {
			System.out.println("������Ҫ���͵�����");
			if (in.hasNext()) {
				String str = in.next().trim();
				out.println(str);
				if (str.equalsIgnoreCase("exit")) {
					System.out.println("�ͻ����˳��ɹ�");
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
