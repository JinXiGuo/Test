package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex
{
	public static void main(String[] args)
	{
		Pattern pattern = Pattern.compile("������ʽ");
		Matcher matcher = pattern.matcher("������ʽ Hello World,������ʽ Hello World");
		//�滻��һ���������������
		System.out.println(matcher.replaceFirst("Java"));
	}
}
