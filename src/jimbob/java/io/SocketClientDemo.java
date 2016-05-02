package jimbob.java.io;

import java.net.Socket;
import java.util.Scanner;

public class SocketClientDemo {
	public static void main(String[] args) throws Exception{
		Socket client=new Socket("localhost", 9999);
		Scanner sc=new Scanner(client.getInputStream());
		//…Ë÷√∑÷∏Ù∑˚
		sc.useDelimiter("\n");
		if(sc.hasNext()){
			System.out.println(sc.next());
		}
		sc.close();
		client.close();
	}
}
