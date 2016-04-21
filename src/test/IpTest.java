package test;

public class IpTest
{
	public static void main(String[] args)
	{
		//对IP地址进行格式化[15位]
		String userIP="94.71.90.25";
		String[] userIPArr = userIP.split("\\.");
		userIP="";
		for (int i = 0; i < 4; i++)
		{
			if (i > 0)
				userIP += ".";
			switch (userIPArr[i].length())
			{
				case 1:
					userIP += "00" + userIPArr[i];
					break;
				case 2:
					userIP += "0" + userIPArr[i];
					break;
				case 3:
					userIP += userIPArr[i];
					break;
			}
			
		}
		System.out.println(userIP);
	
	}
}
