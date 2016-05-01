package jimbob.java.special;


public class RunTimeDemo {
	public static void main(String[] args) throws Exception {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("maxMemory1:" + runtime.maxMemory() / 1024 / 1024);
		System.out.println("totalMemory1:" + runtime.totalMemory() / 1024 / 1024);
		System.out.println("freeMemory1:" + runtime.freeMemory() / 1024 / 1024);
		@SuppressWarnings("unused")
		String str = "";
		for (int i = 0; i < 1000; i++) {
			str += i;
		}
	
		System.out.println("maxMemory2:" + runtime.maxMemory() / 1024 / 1024);
		System.out.println("totalMemory2:" + runtime.totalMemory() / 1024 / 1024);
		System.out.println("freeMemory2:" + runtime.freeMemory() / 1024 / 1024);
		//ÊÍ·ÅÀ¬»ø¿Õ¼ä
		runtime.gc();
		System.out.println("maxMemory3:" + runtime.maxMemory() / 1024 / 1024);
		System.out.println("totalMemory3:" + runtime.totalMemory() / 1024 / 1024);
		System.out.println("freeMemory3:" + runtime.freeMemory() / 1024 / 1024);
		
		Process pro = runtime.exec("mspaint.exe");
		Thread.sleep(2000);
		pro.destroy();
	}
}
