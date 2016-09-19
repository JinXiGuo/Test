import java.lang.reflect.Method;

public class Reflex<T> {

	public  void read(T t) {
		Class cls = t.getClass();
		System.out.println("类名："+cls.getName());
		Method[] methods = cls.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println("方法名"+i+":"+methods[i].getName());
		}
	}
}
