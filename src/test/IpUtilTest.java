package test;

public class IpUtilTest
{
	public static final String getFormatIp(String userIP)
	{
		String[] userIPArr = userIP.split("\\.");
		userIP = "";
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
		return userIP;
	}
	
	public static void main(String[] args)
	{
		System.out.println(getFormatIp("127.0.0.0"));
	}
}
