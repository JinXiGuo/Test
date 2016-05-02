package jimbob.java.io;

import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if (sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
		System.out.println("«Î ‰»Î…˙»’");
		sc=new Scanner(System.in);
		if(sc.hasNext("\\d{4}-\\d{2}-\\d{2}")){
			System.out.println(sc.next("\\d{4}-\\d{2}-\\d{2}"));
		}else{
			System.out.println("error");
		}
		sc.close();
	}
}
