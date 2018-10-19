package demo;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Reverse {
	public static void main(String[] args) {
		checkReverseInt(0);
		 
	}

	public static void checkReverseInt() {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		while (sc.hasNext()) {
			int num = sc.nextInt();
			System.out.println(reverseInt(num));
		}
	}
	
	public static void checkReverseInt(int n) {
		long bfzy = ((long)Integer.MAX_VALUE-Integer.MIN_VALUE)/100;
		int count = 1;
		int bfb = 1;
		for(int i=Integer.MIN_VALUE;i<Integer.MAX_VALUE;i++) {
			
			int rtn = reverseInt(i);
			int rtn2 = reverseInt(rtn);
			if(rtn!=0 && (rtn2!=i && i%rtn2!=0) ) {
				
				System.out.println(i);
				System.out.println(rtn2);
				break;
			}
			if(count++ == bfzy) {
				System.out.println(bfb++ +"%");
				count = 1;
			}
			
		}
		System.out.println("The end");
	}
	/**
	 * 给定一个带符号位的int型整数，将其数字反转后输出。 如果反转后的数字溢出，则返回0 分析：
	 * 1.如果最后一位是0，比如：10100，那么反转后的值为101 2.如果输入的数位1000000003，那么反转后将会溢出（int型范围为
	 * -2的31次方到2的31次方减一，即-2147483648 到 2147483647 ）
	 */
	public static int reverseInt(int num) {
		int result = 0;
		
		while (num != 0) {
			int a = result;
			result = a * 10 + num % 10;
			if(result/10 != a) {
				return 0;
			}
			num = num / 10;
		}
		return result;
	}
}
