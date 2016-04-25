package jimbob.java.special;

public class Test {
	public static void main(String[] args) {
		int result = add(1, 1, 100);
		System.out.println(result);
		
		Message<Integer> msg=new Message<>();
		msg.setMsg(11);
		fun(msg);
	}

	// 多个参数，属于数组的变形应用
	static int add(int... param) {
		int result = 0;
		for (int i : param) {
			result += i;
		}
		return result;
	}
	//static void fun(Message<? super String> msg)  只能设置String或其父类,方法参数上使用
	static void fun(Message<?> msg){
		System.out.println(msg.getMsg());
	}
}
//泛型
//class Message<T extends Number> 只能使用number或其子类,可用于声明和方法参数
class Message<T> {
	private T msg;

	public T getMsg() {
		return msg;
	}

	public void setMsg(T msg) {
		this.msg = msg;
	}
}