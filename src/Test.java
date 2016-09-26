public class Test {
	public static void main(String[] args) {
		String s = "7*7***5";
		String[] s1 = s.split("\\*\\*+");
		System.out.println(s1.length);
		for (int i = 0; i < s1.length; i++)
			System.out.println("|"+s1[i]+"|");
		
	}
}
