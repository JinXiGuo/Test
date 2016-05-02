package jimbob.java.io;

import java.io.InputStream;

public class SystemIODemo {
	public static void main(String[] args) throws Exception{
		InputStream in = System.in;
		StringBuffer buffer=new StringBuffer();
		int temp=0;
		while((temp=in.read())!=-1){
			if(temp=='\n'){
				break;
			}
			buffer.append((char)temp);
		}
		
		System.out.println(buffer.toString());
	}
}
