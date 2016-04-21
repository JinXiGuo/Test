package factory;

public class SmsMailFactory implements Provider
{
	@Override  
    public Sender produce(){  
        return new SmsSender();  
    }  
}
