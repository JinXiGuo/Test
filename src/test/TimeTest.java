package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��

		Calendar nowTime = Calendar.getInstance();
		nowTime.add(Calendar.HOUR, -15);
		System.out.println(df.format(nowTime.getTime()));

		System.out.println(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
	}
}
