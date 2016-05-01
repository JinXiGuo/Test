package jimbob.java.special;

import java.util.Arrays;

public class ArrayDemo {
	public static void main(String[] args) {
		int[] data=new int[]{1,15,5,9,4,2,8,3,58,36,2};
		Arrays.sort(data);
		for (int i : data) {
			System.out.println(i);
		}
		//二分查找
		System.out.println(Arrays.binarySearch(data, 15));
		int[] data1=new int[]{1,2,3};
		int[] data2=new int[]{1,2,3};
		//比较两个数组是否相等
		System.out.println(Arrays.equals(data1, data2));
		
		int[] data3=new int[10];
		Arrays.fill(data3, 3);
		System.out.println(Arrays.toString(data3));
	}
}
