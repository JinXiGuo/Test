package test;

public class Switch
{
	public String getTitle(String code)
	{
		String result = "";
		switch (code)
		{
		case "1":
			result = "点货清单";
			break;
		case "2":
			result = "点货审核";
			break;
		case "3":
			result = "最新采购点货清单";
			break;
		case "4":
			result = "最新采购点货审核";
			break;
		case "5":
			result = "老订单继续采购清单";
			break;
		case "6":
			result = "老订单继续采购点货审核";
			break;
		case "7":
			result = "等待定制点货清单";
			break;
		case "8":
			result = "等待定制点货审核";
			break;
		}
		return result;
	}
}
