package test;

public class Switch
{
	public String getTitle(String code)
	{
		String result = "";
		switch (code)
		{
		case "1":
			result = "����嵥";
			break;
		case "2":
			result = "������";
			break;
		case "3":
			result = "���²ɹ�����嵥";
			break;
		case "4":
			result = "���²ɹ�������";
			break;
		case "5":
			result = "�϶��������ɹ��嵥";
			break;
		case "6":
			result = "�϶��������ɹ�������";
			break;
		case "7":
			result = "�ȴ����Ƶ���嵥";
			break;
		case "8":
			result = "�ȴ����Ƶ�����";
			break;
		}
		return result;
	}
}
