package test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CodeTest
{

	public static void main(String[] args) throws UnsupportedEncodingException
	{
		// TODO Auto-generated method stub
/*		String str=URLEncoder.encode("hello sʲɪrˈɡʲej loˈpatə", "UTF-8");
		System.out.println(str);
		str=URLDecoder.decode(str,"utf-8");
		System.out.println(str);*/
		String str=URLDecoder.decode("鏈変綘鏇村ソ","gb2312");
		System.out.println(str);
		str=URLDecoder.decode("Gonz??lez Islas","utf-8");
		System.out.println(str);
		
		str=URLDecoder.decode("浣犲ソ","gbk");
		System.out.println(str);
	}

}
