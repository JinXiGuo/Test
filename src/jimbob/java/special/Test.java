package jimbob.java.special;

public class Test {
	public static void main(String[] args) {
		int result = add(1, 1, 100);
		System.out.println(result);
		
		Message<Integer> msg=new Message<>();
		msg.setMsg(11);
		fun(msg);
	}

	// �����������������ı���Ӧ��
	static int add(int... param) {
		int result = 0;
		for (int i : param) {
			result += i;
		}
		return result;
	}
	//static void fun(Message<? super String> msg)  ֻ������String���丸��,����������ʹ��
	static void fun(Message<?> msg){
		System.out.println(msg.getMsg());
	}
}
//����
//class Message<T extends Number> ֻ��ʹ��number��������,�����������ͷ�������
class Message<T> {
	private T msg;

	public T getMsg() {
		return msg;
	}

	public void setMsg(T msg) {
		this.msg = msg;
	}
}