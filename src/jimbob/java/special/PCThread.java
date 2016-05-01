package jimbob.java.special;

public class PCThread {
	public static void main(String[] args) {
		Info info = new Info();
		new Thread(new Producter(info)).start();
		new Thread(new Customer(info)).start();
	}
}
/**
 * 代表货物，判断里应写明什么时候需要等待执行，而不是if...else的形式
 * @author Administrator
 *
 */
class Info {
	private String title;
	private String content;
	private boolean flag = true;

	public synchronized void set(String title, String content) {
		if(this.flag==false){
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.title = title;
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.content = content;
		this.flag=false;
		super.notify();
	}

	public synchronized void get() {
		if(this.flag==true){
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.title + "-" + this.content);
		this.flag=true;
		super.notify();
	}
}

class Producter implements Runnable {
	private Info info;

	public Producter(Info info) {
		this.info = info;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				info.set("Info1", "Content1");
			} else {
				info.set("Info2", "Content2");
			}
		}

	}
}

class Customer implements Runnable {

	private Info info;

	public Customer(Info info) {
		this.info = info;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			this.info.get();
		}

	}

}
