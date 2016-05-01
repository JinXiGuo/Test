package jimbob.java.special;

import java.math.BigDecimal;

public class BigDecimalDemo {
	public static void main(String[] args) {
		System.out.println(doubleRound(19.7852287238654,2));
		System.out.println(doubleRound(-15.5,0));
		System.out.println(doubleRound(15.5,0));
	}

	/**
	 * 实现准确位数的四舍五入
	 * @param num
	 * @param scale
	 * @return
	 */
	private static double doubleRound(double num,int scale){
		BigDecimal bigA=new BigDecimal(num);
		BigDecimal bigB=new BigDecimal(1);
		return bigA.divide(bigB,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
