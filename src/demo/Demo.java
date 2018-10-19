package demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Demo {

	public static void main(String[] args) {
		// System.out.println(numAdd("","-1324.555"));
		// paralleStreamTest();
		// treeSet();
		// mathTest();
		//TestStringBuffer3();
		//copyFile2();
		int num = 2<<3;
		System.out.println(num);
		
	}

	/**
	 * 测试字符流
	 */
	public static void copyFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("d:/JavaTest/file.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("d:/JavaTest/file2.txt"));
			
			String str = br.readLine();
			while(str != null) {
				bw.write(str);
				bw.newLine();
				str = br.readLine();
			}
			br.close();
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}
	public static void copyFile2() {
		File fi = new File("d:/JavaTest/file.txt");
		File fo = new File("d:/JavaTest/file3.txt");
		
		//读写中文时要使用 GBK字符集，否则会出现乱码
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(fi),"GBK");
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fo),"GBK");
			
			BufferedReader br = new BufferedReader(isr);
			BufferedWriter bw = new BufferedWriter(osw);
			String str = null;
			while((str=br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			
			br.close();
			bw.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Copy Successed");
	}
	/**
	 * 测试创建数组
	 */

	public static void createArray() {
		float[] f1[] = new float[6][6];
		// float f2[][] = new float[][];
		// float [6][]f3 = new float[6][6];
		float[][] f4 = new float[6][];

	}

	/**
	 * 测试Stringbuffer
	 */
	public static void TestStringBuffer() {
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		TestStringBuffer2(a, b);
		System.out.println(a + "." + b);
	}

	public static void TestStringBuffer2(StringBuffer x, StringBuffer y) {
		x.append(y);
		y = x;
	}

	public static void TestStringBuffer3() {
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		a = b;
		System.out.println(a + "." + b);
	}

	private static String numAdd(String num1, String num2) {
		double sum = 0.0;
		try {
			sum = Double.valueOf(num1) + Double.valueOf(num2);
		} catch (Exception e) {

		}

		return sum + "";
	}

	public static void paralleStreamTest() {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		Lock lock = new ReentrantLock();
		IntStream.range(0, 1000000).forEach(list1::add);
		IntStream.range(0, 1000000).parallel().forEach(list2::add);
		IntStream.range(0, 1000000).parallel().forEach(i -> {
			lock.lock();
			try {
				list3.add(i);
			} finally {
				lock.unlock();
			}
		});
		System.out.println("串行执行的大小：" + list1.size());
		System.out.println("并行执行的大小：" + list2.size());
		System.out.println("加锁并行执行的大小：" + list3.size());
	}

	public static void treeSet() {
		Set set = new TreeSet();
		Random rd = new Random();
		while (set.size() < 10) {
			set.add(rd.nextInt(10));
		}

		Iterator it = set.iterator();
		for (Object obj : set) {
			System.out.print(obj + ",");
		}
	}

	public static void mathTest() {
		System.out.println(Math.round(13.5));
		System.out.println(Math.round(-13.5));
	}

}
