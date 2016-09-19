/**
 * 冒泡排序
 * @author Administrator
 *
 */
public class Bubblineg {

	public static void main(String args[]) {
		int arr[] = { 2, 4, 6, 7, 1, 9, 3, 8, 5 };
		int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}