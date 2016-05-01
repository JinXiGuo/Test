package jimbob.java.util;

public class RegexDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="1jkqjhw346erk65ljp[oispdl][wejh1";
		String regex="[^a-z]";
		System.out.println(str.replaceAll(regex, ""));
		
		String doubleStr="12.22";
		regex="[^0]\\d+(\\.\\d+)?";
		System.out.println(doubleStr.matches(regex));
		System.out.println(Double.parseDouble(doubleStr));
		
	}

}
