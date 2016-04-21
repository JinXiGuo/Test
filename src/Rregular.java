import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rregular
{
	public static void main(String[] args)
	{
		// test1();
		String str = "[����],abcdefg,[abc]";
		// \[([^\]]+)\] [^\]]+
		String patternStr = "\\[([^\\]]+)\\]";
		Pattern p = Pattern.compile(patternStr);
		Matcher m = p.matcher(str);
		System.out.println(m);
		while (m.find())
		{
			System.out.println(m.group(0));
		}

		//test2();
	}

	static void test1()
	{
		String[] dataArr =
		{ "moon", "mon", "moon", "mono" };
		for (String str : dataArr)
		{
			String patternStr = "o+";
			Pattern p = Pattern.compile(patternStr);
			Matcher m = p.matcher(str);
			// System.out.println(m);
			// System.out.println(m.find()+"--------");
			while (m.find())
			{
				System.out.println(m.group(0));
			}
		}
	}

	static void test2()
	{
		// TODO Auto-generated method stub
		String str = "Hello,World! in Java.";
		Pattern pattern = Pattern.compile("W(or)(ld!)");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find())
		{
			System.out.println("Group 0:" + matcher.group(0));// �õ���0�顪������ƥ��
			System.out.println("Group 1:" + matcher.group(1));// �õ���һ��ƥ�䡪����(or)ƥ���
			System.out.println("Group 2:" + matcher.group(2));// �õ��ڶ���ƥ�䡪����(ld!)ƥ��ģ���Ҳ�����ӱ��ʽ
			System.out.println("Start 0:" + matcher.start(0) + " End 0:" + matcher.end(0));// ��ƥ�������
			System.out.println("Start 1:" + matcher.start(1) + " End 1:" + matcher.end(1));// ��һ��ƥ�������
			System.out.println("Start 2:" + matcher.start(2) + " End 2:" + matcher.end(2));// �ڶ���ƥ�������
			System.out.println(str.substring(matcher.start(0), matcher.end(1)));// ����ƥ�俪ʼ��������1��ƥ��Ľ�������֮���Ӵ�����Wor
		}
	}
}
