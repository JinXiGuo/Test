package jimbob.java.base;

/**
 * 数组转置
 * 
 * @author Administrator
 */
public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int middle = arr.length / 2;

		for (int i = 0; i < middle; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
}
