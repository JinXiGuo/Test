package builder;

import java.util.ArrayList;
import java.util.List;

//工厂模式关注的是创建单个产品，而建造者模式则关注创建符合对象，多个部分。因此，是选择工厂模式还是建造者模式，依实际情况而定。
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
