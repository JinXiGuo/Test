package jimbob.java.io;

import java.io.File;

public class FileDemo {
	public static void main(String[] args) throws Exception {
		File file = new File("c:");
		print(file);

	}

	public static void print(File file) {
		if (file.isDirectory()) {
			File[] list = file.listFiles();
			if(list!=null){
				for (int i = 0; i < list.length; i++) {
					print(list[i]);
				}
			}
		}
		System.out.println(file);
	}
}
