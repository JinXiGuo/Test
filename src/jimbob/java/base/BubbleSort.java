package jimbob.java.base;

/**
 * 冒泡排序
 * 
 * @author Administrator
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr=new int[]{1,2,3,4,5,2};
		int count=sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("总执行次数："+count);
	}
	
	public static int sort(int[] arr){
		int count=0;
		boolean isExchanged=false;
		for (int i = 0; i < arr.length-1; i++) {
			isExchanged=false;
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					isExchanged=true;
				}
				count++;
			}
			if(isExchanged!=true)
				break;
		}
		return count;
	}
}
