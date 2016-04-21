package builder;

import java.util.ArrayList;
import java.util.List;

//����ģʽ��ע���Ǵ���������Ʒ����������ģʽ���ע�������϶��󣬶�����֡���ˣ���ѡ�񹤳�ģʽ���ǽ�����ģʽ����ʵ�����������
public class Builder
{
	private List<Sender> list = new ArrayList<Sender>();

	public void produceMailSender(int count)
	{
		for (int i = 0; i < count; i++)
		{
			list.add(new MailSender());
		}
	}

	public void produceSmsSender(int count)
	{
		for (int i = 0; i < count; i++)
		{
			list.add(new SmsSender());
		}
	}
}
