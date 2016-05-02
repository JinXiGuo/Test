package jimbob.java.io;

import java.io.*;

public class IOStream {
	public static void main(String[] args) {
		System.out.println(copy(new File("d:/psb.jpg"),new File("e:/test/psd.jpg")));
	}

	public static boolean copy(File from, File to) {
		if (!from.exists())
			return false;
		if (!to.getParentFile().exists())
			to.getParentFile().mkdirs();
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(from);
			out = new FileOutputStream(to);
			byte[] temp = new byte[1024];
			while (in.read(temp) != -1) {
				out.write(temp);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
